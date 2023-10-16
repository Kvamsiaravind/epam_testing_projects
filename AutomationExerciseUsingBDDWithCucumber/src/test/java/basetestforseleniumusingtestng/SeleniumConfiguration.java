package basetestforseleniumusingtestng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.drivers.BrowserLauncher;
import org.exceptions.InvalidBrowserException;
import org.pages.*;
import org.screenshots.Screenshots;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import static org.constants.Constants.BASE_URL;
import static org.drivers.BrowserLauncher.getBrowserDriver;
import static org.drivers.BrowserLauncher.quit;

import java.io.IOException;


public class SeleniumConfiguration extends Screenshots {

    protected static final Logger LOGGER = LogManager.getLogger(SeleniumConfiguration.class);

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected ResultPage resultPage;
    protected SignUpPage signUpPage;
    private DeleteAccountPage deleteAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException, InvalidBrowserException {
        driver = getBrowserDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        LOGGER.info("driver initialized");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        resultPage = new ResultPage(driver);
        signUpPage = new SignUpPage(driver);
        deleteAccountPage = new DeleteAccountPage(driver);

        homePage.clickOnSignUpButton();
    }

    @AfterMethod(alwaysRun = true)
    public void tearClose() {
        driver.close();
    }

    @AfterSuite
    public void tearQuit() throws IOException, InvalidBrowserException {
        BrowserLauncher.quit();
    }
}
