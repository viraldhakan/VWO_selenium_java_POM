package VWO.tests;

import VWO.driver.DriverManagerTL;
import VWO.pages.DashboardPage;
import VWO.pages.LoginPage;
import VWO.testbase.testBase;
import VWO.utils.PropertyReader;
import VWO.utils.ScreenshortListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ScreenshortListener.class)
public class LoginTest extends testBase {


    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify a the valid credential login successful")
    @Test(groups = {"P0","Positive"},priority = 2)
    public void testVWOLogin_Positive() throws Exception {

        DriverManagerTL.getDriver().get(PropertyReader.readkey("url"));
        DashboardPage dashboardPage = new LoginPage().LoginToVWO(false).afterLogin();
        String expectedResult = dashboardPage.loggedInUserName();
        Assertions.assertThat(expectedResult)
                .isNotBlank().isNotNull().contains(PropertyReader.readkey("expected_username"));
    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify a the invalid username or password")
    @Test(groups = {"P0","negative"}, priority = 1)
    public void testLogin_negative() throws Exception {
        DriverManagerTL.getDriver().get(PropertyReader.readkey("url"));
        String expectedResult = new LoginPage().LoginToVWO(true).error_message_text();
        takeScreenshort(DriverManagerTL.getDriver());
        Assertions.assertThat(expectedResult)
                .isNotNull().isNotBlank().contains(PropertyReader.readkey("expected_error"));


    }

}
