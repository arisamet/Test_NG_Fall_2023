package tests.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class P04 {
    //1- https://www.qualitydemy.com/ anasayfasina gidin
//2- login linkine basin
// 3- Kullanici email'i olarak valid email girin
// 4- Kullanici sifresi olarak valid sifre girin
// 5- Login butonuna basarak login olun
// 6- Basarili olarak giris yapilabildigini test edin

    @Test
    public void qualityDemyTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliEmail"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qualitydemyPage.loginButonu.click();


        Driver.closeDriver();
    }
}