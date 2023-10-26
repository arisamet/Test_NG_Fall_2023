package tests.day15_testNG_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C02_dependsOnMethods {

    // 3 tane test methodu olusturun
    // 1- amazon test : Amazon anasayfaya gidip url'in amazon icerdigini test edelim
    // 2- test: NutellaTest : Nutella icin arama yapip arama sonuclarinin Nutella icerdigini test edelim
    //  3-ilkUrun Testi : Ilk urunu click yapip, urun isminin Nutella icerdigini test edin

/*
DependsOnMethods priority'den farklidir

DependsOnMethods hangi method'un once calisacagina karar vermez
sadece yazildigi test calismadan once baglandigi testin
alistigindan ve PASSED oldugundan emin olmak ister

 */

    @Test
    public void amazonTest(){
        Driver.getDriver().get("https://www.amazon.com");

        String expectedUrlIcerik = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }

    @Test (priority = -1, dependsOnMethods = "amazonTest")
    public void nutellaTest(){
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement sonucYaziElementi = Driver.getDriver().findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik = "Nutella";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));


    }

    @Test (dependsOnMethods = "nutellaTest")
    public void ilkUrunTesti(){
        Driver.getDriver().findElement(By.xpath("(//*[@class=‘a-section aok-relative s-image-square-aspect’])[1]")).click();

        WebElement urunIsimElementi = Driver.getDriver().findElement(By.xpath("//span[@id=‘productTitle’]"));

        String expectedIcerik = "Nutella";
        String actualUrunIsmi= urunIsimElementi.getText();

        Assert.assertTrue(actualUrunIsmi.contains(expectedIcerik));
        Driver.closeDriver();
    }


}
