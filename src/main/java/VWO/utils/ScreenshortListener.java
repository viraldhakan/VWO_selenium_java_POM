package VWO.utils;

import VWO.driver.DriverManagerTL;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class ScreenshortListener implements ITestListener {

    public void OnTestFailure(ITestResult result){
        Allure.addAttachment(result.getName(), new ByteArrayInputStream
                (((TakesScreenshot) DriverManagerTL.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
