package org.drivers;

import org.exceptions.InvalidBrowserException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.constants.Constants.FILE_NAME;


public class BrowserLauncher {

    private BrowserLauncher() {

    }

    public static WebDriver getBrowserDriver() throws InvalidBrowserException, IOException {
        switch (MyFileReader.readPropertiesFile(FILE_NAME).getProperty("browser")) {
            case "CHROME":
                return new MyChromeDriver().setUpBrowser();
            case "EDGE":
                return new MyEdgeDriver().setUpBrowser();
            default:
                throw new InvalidBrowserException("Please enter valid browser");
        }
    }

    public static void quit() throws IOException, InvalidBrowserException {
        getBrowserDriver().quit();
    }
}
