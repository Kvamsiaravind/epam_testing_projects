package secondtask.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.BrowserDrivers;

public class MyFirefoxDriverWithCapabilities implements BrowserDrivers {

    @Override
    public WebDriver setUpBrowser() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("acceptSslCerts", "true");
        capabilities.setCapability("privacy.trackingprotection.enabled", false);
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.addArguments("--incognito");
        firefoxOptions.merge(capabilities);
        return new FirefoxDriver(firefoxOptions);
    }
}
