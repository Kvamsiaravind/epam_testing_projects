package secondtask.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.BrowserDrivers;

public class MyChromeDriverWithCapabilities implements BrowserDrivers {

    @Override
    public WebDriver setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Windows");
//        capabilities.setCapability("Version", "118.0.5993.70");
//        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        capabilities.setCapability("acceptSslCerts", "true");
//        capabilities.setBrowserName("Chrome");
//        chromeOptions.merge(capabilities);
//        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("--incognito");
        return new ChromeDriver(chromeOptions);
    }
}
