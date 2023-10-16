package factorypatternsecondtask.basetest;

import base.Screenshots;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import secondtask.pages.GoogleCloudHomePage;
import secondtask.pages.GoogleCloudPricingCalculatorPage;
import utilities.BrowsersForSecondTask;

import static secondtask.drivers.DriverFactoryTwo.getDriver;

public class CapabilityConfiguration extends Screenshots {

    private static final Logger logger = LogManager.getLogger(CapabilityConfiguration.class);
    protected GoogleCloudHomePage googleCloudHomePage;
    protected GoogleCloudPricingCalculatorPage googleCloudPricingCalculatorPage;


    @BeforeTest
    public void setUpDriver() {
        driver = getDriver(BrowsersForSecondTask.EDGE, false);
        logger.info("Driver initialized.");
    }

    @AfterTest
    public void tearCloseUp() {
        if (driver == null)
            driver.close();
    }

    @AfterSuite
    public void tearQuitUp() {
        driver.quit();
    }
}
