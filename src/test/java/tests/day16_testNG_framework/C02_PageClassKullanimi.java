package tests.day16_testNG_framework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {
    @Test
    public void nutellaTest(){

        // Amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");

        // Nutella icin arama yapalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);


        // Arama sonuclarinin nutella icerdigini test edelim

        String expectedIcerik = "Nutella";
        String actualSonucYazisi= amazonPage.sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        // Driver'i kapatalim
        Driver.closeDriver();

    }
}
