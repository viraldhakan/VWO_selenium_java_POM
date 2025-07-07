package VWO.testbase;

import VWO.driver.DriverManagerTL;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;

public class testBase {

    @BeforeSuite
    protected void init(){
        DriverManagerTL.init();
    }

    @AfterSuite
    protected  void down(){
        DriverManagerTL.down();
    }

    protected void takeScreenshort(WebDriver driver){
        Allure.addAttachment("Screenshort",new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
