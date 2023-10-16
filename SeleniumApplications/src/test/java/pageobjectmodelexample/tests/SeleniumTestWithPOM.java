package pageobjectmodelexample.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Utility;
import pageobjectmodelexample.pages.SeleniumHomePage;

public class SeleniumTestWithPOM {
    protected WebDriver driver;
    private SeleniumHomePage seleniumHomePage;

    @BeforeTest
    public void setUp() {
        driver = Utility.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/");
        seleniumHomePage = new SeleniumHomePage(driver);
    }

    @Test
    public void testDocumentationFunctionality() {
        seleniumHomePage.navigateToDocPage();
        seleniumHomePage.navigateToDownloadsPage();
    }

    @AfterTest
    public void close(){
        driver.close();
    }

    @AfterSuite
    public void quit(){
        driver.quit();
    }
}
