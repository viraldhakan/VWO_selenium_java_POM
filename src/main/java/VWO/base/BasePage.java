package VWO.base;


import VWO.driver.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected BasePage() {

    }

    protected void implicitwait() {
        DriverManagerTL.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void enterInput(By by, String key){
        DriverManagerTL.getDriver().findElement(by).sendKeys(key);

    }

    protected void clickElement(By by) {
        DriverManagerTL.getDriver().findElement(by).click();
    }

    protected WebElement getElement(By key){
       return DriverManagerTL.getDriver().findElement(key);
    }

    protected void presenceOfElement(final By elementLocation){
        new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    protected void visibilityOfElementLocated(final By elementLocation){
        new WebDriverWait(DriverManagerTL.getDriver(),Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    protected WebElement elementToBeClickable(final By elementIdentier) {
        WebElement element = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(elementIdentier));
        return element;
    }

}
