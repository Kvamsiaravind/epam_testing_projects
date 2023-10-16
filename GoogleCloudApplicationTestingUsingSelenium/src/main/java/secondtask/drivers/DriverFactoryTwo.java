package secondtask.drivers;

import org.openqa.selenium.WebDriver;
import utilities.BrowsersForSecondTask;


public class DriverFactoryTwo {

    private DriverFactoryTwo() {
    }

    public static WebDriver getDriver(BrowsersForSecondTask browserName, boolean isCapabilities) {
        if (isCapabilities) {
            switch (browserName) {
                case CHROME:
                    return new MyChromeDriverWithCapabilities().setUpBrowser();

                case FIREFOX:
                    return new MyFirefoxDriverWithCapabilities().setUpBrowser();

                default:
                    throw new IllegalArgumentException(browserName + " browser not instantiated.");
            }
        } else {
            switch (browserName) {
                case CHROME:
                    return new MyChromeDriver().setUpBrowser();

                case FIREFOX:
                    return new MyFirefoxDriver().setUpBrowser();
                case EDGE:
                    return new MyEdgeDriver().setUpBrowser();

                default:
                    throw new IllegalArgumentException(browserName + " browser not instantiated.");
            }
        }
    }
}
