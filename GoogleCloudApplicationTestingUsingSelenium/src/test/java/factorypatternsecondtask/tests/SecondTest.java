package factorypatternsecondtask.tests;

import factorypatternsecondtask.basetest.CapabilityConfiguration;
import factorypatternsecondtask.listner.ListenersTestNG;
import org.testng.annotations.Listeners;
import secondtask.pages.GoogleCloudHomePage;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import secondtask.pages.GoogleCloudPricingCalculatorPage;
import secondtask.pages.ResultsPage;

@Listeners(ListenersTestNG.class)

public class SecondTest extends CapabilityConfiguration {

    private static final Logger logger = LogManager.getLogger(SecondTest.class);
    private ResultsPage resultsPage;

    @Test
    public void testSecondFactoryPattern() {
        driver.get("https://cloud.google.com/");
        logger.info("Google cloud Homepage opened");

        googleCloudHomePage = new GoogleCloudHomePage(driver);
        resultsPage = new ResultsPage(driver);
        googleCloudPricingCalculatorPage = new GoogleCloudPricingCalculatorPage(driver);

        googleCloudHomePage.searchCalculatorPage("Google Cloud Pricing Calculator");
        resultsPage.openPricingCalculatorByClick();
        googleCloudPricingCalculatorPage.switchToMainFrame();
        googleCloudPricingCalculatorPage.clickComputeEngineTab();
        googleCloudPricingCalculatorPage.sendNumberOfInstances("4");
        googleCloudPricingCalculatorPage.clickAddToEstimateButton();
    }
}
