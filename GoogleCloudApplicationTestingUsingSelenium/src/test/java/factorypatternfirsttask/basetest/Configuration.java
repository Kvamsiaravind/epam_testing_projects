package factorypatternfirsttask.basetest;

import firsttask.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.Browser;

public class Configuration {

    protected WebDriver driver;

    @BeforeTest
    public void setUpDriver() {
        driver = DriverFactory.getDriver(Browser.EDGE);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearCloseUp() {
        if (driver == null)
            driver.close();
    }

    @AfterSuite
    public void tearQuitUp() {
        driver.quit();
    }
}
