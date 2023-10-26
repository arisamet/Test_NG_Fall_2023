package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class P02BagimliTestler {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() {driver.quit();
    }

    @Test
    public void wise() {

        Driver.getDriver().get(ConfigReader.getProperty("wiseUrl"));
    }

    @Test(dependsOnMethods = "wise")
    public void amazon() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

    }

    @Test(dependsOnMethods = "amazon")
    public void google() {
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
    }

}



