package org.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.utilities.SelectBrowser;

public class MyChromeDriver implements SelectBrowser {

    private static final Logger LOGGER = LogManager.getLogger(MyChromeDriver.class);

    @Override
    public WebDriver setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        LOGGER.info("Chrome browser instantiated");
        return new ChromeDriver(options);
    }
}
