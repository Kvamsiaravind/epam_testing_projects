package firsttask.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.BrowserDrivers;

public class MyFirefoxDriver implements BrowserDrivers {

    @Override
    public WebDriver setUpBrowser() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options=new FirefoxOptions();
        options.addArguments("--start-maximized");
        return new FirefoxDriver(options);
    }
}
