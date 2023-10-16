package cleancodetask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static cleancodetask.tests.ConfigurationTest.PASSWORD;
import static cleancodetask.tests.ConfigurationTest.USERNAME;
import static utilities.Utility.clickOnFields;
import static utilities.Utility.sendKeysIntoField;

public class SignInPage {

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login_field")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement signInButton;

    private void sendUsername(String username) {
        sendKeysIntoField(driver, usernameField, username);
    }

    private void sendPassword(String password) {
        sendKeysIntoField(driver, passwordField, password);
    }

    private void clickOnSignIn() {
        clickOnFields(driver, signInButton, 5);
    }

    public void enterDetails() throws Exception {
        sendUsername(USERNAME);
        sendPassword(PASSWORD);
        if (isReadyToSignIn()) {
            clickOnSignIn();
        } else {
            throw new Exception();
        }
    }

    private boolean isReadyToSignIn() {
        return signInButton.isDisplayed() ? true : false;
    }
}
