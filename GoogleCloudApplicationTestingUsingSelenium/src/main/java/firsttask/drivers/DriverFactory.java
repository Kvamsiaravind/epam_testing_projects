package firsttask.drivers;

import org.openqa.selenium.WebDriver;
import utilities.Browser;

public class DriverFactory {

    private DriverFactory() {

    }

    public static WebDriver getDriver(Browser driverName) {
        switch (driverName) {
            case CHROME:
                return new MyChromeDriver().setUpBrowser();

            case EDGE:
                return new MyEdgeDriver().setUpBrowser();

            case FIREFOX:
                return new MyFirefoxDriver().setUpBrowser();

            default:
                throw new IllegalArgumentException(driverName + " browser not instantiated.");
        }
    }
}
