package dependencyinjection;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.java.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.exceptions.InvalidBrowserException;
import org.pages.SignUpPage;

import java.io.IOException;

import static org.drivers.BrowserLauncher.getBrowserDriver;

public class Hooks extends DependencyInjection {
    private static final Logger LOGGER = LogManager.getLogger(SignUpPage.class);
    private DependencyInjection dependencyInjection;

    public Hooks(DependencyInjection dependencyInjection) {
        this.dependencyInjection = dependencyInjection;
    }

    @Before
    public void setUp() throws InvalidBrowserException, IOException {
        LOGGER.info("Setting up driver");
        dependencyInjection.setDriver(getBrowserDriver());
        LOGGER.info("initiating instances for pages");
        dependencyInjection.initializePageObjects();
        LOGGER.info("maximizing the browser driver");
        dependencyInjection.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (dependencyInjection.getDriver() != null) {
            dependencyInjection.getDriver().quit();
        }
    }
}
