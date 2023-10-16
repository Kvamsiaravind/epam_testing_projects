package smallusecase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.Utility;

public class VerifySwags {
    protected WebDriver driver;
    private static final String BASE_URL="https://www.saucedemo.com/";
    private SwagsHomePage swagsHomePage;

    @BeforeTest
    public void setUp(){
        driver= Utility.getDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @Test
    public void testVerifyLoginButton(){
        swagsHomePage=new SwagsHomePage(driver);
        swagsHomePage.enterUsername("gouse123");
        swagsHomePage.enterPassword();
        swagsHomePage.clickLoginButton();

    }
}
