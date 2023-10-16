package googlecloudtask.test;

import googlecloudtask.pages.GoogleCloudHomePage;
import googlecloudtask.pages.GoogleCloudPricingCalculatorHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import utilities.Utility;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConfigurationsTest {
    protected WebDriver driver;
    protected GoogleCloudHomePage googleCloudHomePage;
    protected GoogleCloudPricingCalculatorHomePage googleCloudPricingCalculatorHomePage;

    @BeforeTest
    public void setUp() {
        driver = Utility.getDriver();
        driver.manage().window().maximize();
        driver.get("https://cloud.google.com/");
        googleCloudHomePage = new GoogleCloudHomePage(driver);
        googleCloudPricingCalculatorHomePage = new GoogleCloudPricingCalculatorHomePage(driver);
    }

    @AfterTest
    public void verifyFields() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(googleCloudPricingCalculatorHomePage.getProvisioningModel(), "Provisioning model: Regular");
        softAssert.assertEquals(googleCloudPricingCalculatorHomePage.getInstanceType(), "Instance type: n1-standard-8\n" +
                "Sustained Use Discount applied (30%)");
        softAssert.assertEquals(googleCloudPricingCalculatorHomePage.getLocalSSD(), "Local SSD: 2x375 GiB");
        softAssert.assertEquals(googleCloudPricingCalculatorHomePage.getRegion(), "Region: Frankfurt");
        assertThat(googleCloudPricingCalculatorHomePage.getMonthlyRent(), equalTo("Estimated Component Cost: USD 1,288.70 per 1 month"));
        softAssert.assertAll();
        driver.close();
    }

    @AfterSuite
    public void tearUp() {
        driver.quit();
    }
}
