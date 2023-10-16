package org.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.utilities.SelectBrowser;

public class MyEdgeDriver implements SelectBrowser {
    private static final Logger LOGGER = LogManager.getLogger(MyEdgeDriver.class);

    @Override
    public WebDriver setUpBrowser() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        LOGGER.info("Edge browser instantiated");
        return new EdgeDriver(options);
    }
}
