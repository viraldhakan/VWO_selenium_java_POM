package VWO.pages;

import VWO.base.BasePage;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {


    DashboardPage(){

    }

    By usernameDashboard = By.xpath("(//span[@class='Fw(semi-bold) ng-binding'])[1]");


    public String loggedInUserName(){
        presenceOfElement(usernameDashboard);
        return getElement(usernameDashboard).getText();
    }
}
