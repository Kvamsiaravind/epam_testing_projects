package firsttask.drivers;

import utilities.BrowserDrivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyChromeDriver implements BrowserDrivers {

    @Override
    public WebDriver setUpBrowser() {
        WebDriverManager.chromedriver().browserVersion("114.0.5735.91").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(chromeOptions);
    }
}
