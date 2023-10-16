package googlecloudtask.test;

import googlecloudtask.pages.GoogleCloudHomePage;
import googlecloudtask.pages.GoogleCloudPricingCalculatorHomePage;
import googlecloudtask.pages.ResultsPage;
import org.testng.annotations.Test;

public class GoogleCloudTest extends ConfigurationsTest {
    private ResultsPage resultsPage;

    @Test
    public void testGoogleCloudPage() {
        googleCloudHomePage = new GoogleCloudHomePage(driver);
        resultsPage = new ResultsPage(driver);
        googleCloudPricingCalculatorHomePage = new GoogleCloudPricingCalculatorHomePage(driver);
        googleCloudHomePage.searchCalculatorPage("Google Cloud Pricing Calculator");
        resultsPage.openPricingCalculatorByClick();
        googleCloudPricingCalculatorHomePage.switchToMainFrame();
        googleCloudPricingCalculatorHomePage.clickComputeEngineTab();
        googleCloudPricingCalculatorHomePage.sendNumberOfInstances("4");
        googleCloudPricingCalculatorHomePage.selectOperatingSystem();
        googleCloudPricingCalculatorHomePage.selectVMClassType();
        googleCloudPricingCalculatorHomePage.selectGeneralPurpose();
        googleCloudPricingCalculatorHomePage.selectSeries();
        googleCloudPricingCalculatorHomePage.selectMachineType();
        googleCloudPricingCalculatorHomePage.selectAddGPUsCheckbox();
        googleCloudPricingCalculatorHomePage.selectGPUType();
        googleCloudPricingCalculatorHomePage.selectNumberOfGPUs();
        googleCloudPricingCalculatorHomePage.selectLocalSSD();
        googleCloudPricingCalculatorHomePage.selectDatacenterLocationType();
        googleCloudPricingCalculatorHomePage.selectCommittedUsageValue();
        googleCloudPricingCalculatorHomePage.clickAddToEstimateButton();
    }
}
