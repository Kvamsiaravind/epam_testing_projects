package cleancodetask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.Utility.clickOnFields;

public class StartPage {

    private static final String GITHUB_BASE_URL = "http://www.github.com";
    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(@href,'/login')]")
    private WebElement signInButton;

    public void open() {
        driver.get(GITHUB_BASE_URL);
    }

    public void invokeSignIn() {
        clickOnFields(driver, signInButton, 5);
    }
}
