package VWO.pages;

import VWO.base.BasePage;
import VWO.driver.DriverManagerTL;
import VWO.utils.PropertyReader;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public LoginPage(){
        super();
    }


    // Page Locator
    By username = By.id("login-username");
    By password = By.name("password");
    By signButton = By.id("js-login-btn");

    // Error Page Locator - here
    By error_message = By.id("js-notification-box-msg");


    public LoginPage LoginToVWO(boolean invalid) throws Exception {
        if (invalid) {
            enterInput(username, PropertyReader.readkey("invalid_username"));
        } else {
            enterInput(username, PropertyReader.readkey("username"));
        }
        enterInput(password, PropertyReader.readkey("password"));
        clickElement(signButton);
        return this;
    }

    public String error_message_text(){
        visibilityOfElementLocated(error_message);
        return DriverManagerTL.getDriver().findElement(error_message).getText();
    }

    public DashboardPage afterLogin(){
        return new DashboardPage();
    }
}
