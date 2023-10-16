package cleancodetask.tests;


import cleancodetask.pages.HomePage;
import cleancodetask.pages.StartPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.Utility;

public class ConfigurationTest {

    public static final String USERNAME = "testautomationuser";
    public static final String PASSWORD = "Time4Death!";

    protected WebDriver driver;
    protected StartPage startPage;
    protected HomePage homePage;

    @BeforeTest
    public void setUp() {
        driver = Utility.getDriver();
        driver.manage().window().maximize();
        startPage = new StartPage(driver);
        homePage = new HomePage(driver);
    }

    @AfterTest
    public void assertTheUsername() {
        //  TO DO this assert statement we need to verify homepage with the otp sended by the signin page.
        Assert.assertEquals(homePage.getLoggedInUserName(), USERNAME);
        driver.close();
    }

    @AfterSuite
    public void quit() {
        driver.quit();
    }
}
