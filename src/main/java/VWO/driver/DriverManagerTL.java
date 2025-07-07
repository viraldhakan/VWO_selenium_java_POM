package VWO.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverManagerTL {


    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef) {
        driver.set(driverRef);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void unload() {
        driver.remove();
    }


    @BeforeMethod
    public static void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        setDriver(new ChromeDriver(options));
    }

    @AfterMethod
    public static void down() {
        if (getDriver() != null){
            getDriver().quit();
            unload();
        }
    }
}
