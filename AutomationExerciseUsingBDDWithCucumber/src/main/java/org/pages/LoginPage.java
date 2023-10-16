package org.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.constants.Constants.VALIDATION_MESSAGE;
import static org.utilities.Utility.*;

public class LoginPage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signUpButton;

    @FindBy(xpath = "//p[contains(text(),'Email Address already exist!')]")
    private WebElement emailAlreadyExistText;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement emailFieldForLogIn;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement passwordFieldForLogIn;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement logInButton;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signUpOrLogInButton;

    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    private WebElement invalidCredentialsText;

    public LoginPage enterNameIntoNameField(String name) {
        LOGGER.info("entered name into name field");
        sendKeysIntoField(driver, nameField, name);
        return this;
    }

    public void enterEmailIntoEmailField(String email) {
        LOGGER.info("entered email into email field");
        sendKeysIntoField(driver, emailField, email);
    }

    public void clickOnSignUpButton() {
        LOGGER.info("clicked on signUp button");
        clickOnFields(driver, signUpButton, 5);
    }

    public String getEmailAlreadyExistText() {
        LOGGER.info("getting email already exist text");
        return getTextFromElement(driver, emailAlreadyExistText);
    }

    public void enterEmailIntoLogInEmailField(String email) {
        LOGGER.info("entered email into login login email field");
        sendKeysIntoField(driver, emailFieldForLogIn, email);
    }

    public void enterPasswordIntoLogInPasswordField(String password) {
        LOGGER.info("entered password into login password field");
        sendKeysIntoField(driver, passwordFieldForLogIn, password);
    }

    public void clickOnLogInButton() {
        clickOnFields(driver, logInButton, 5);
        LOGGER.info("clicked on logIn button");
    }

    public String getSignUpText() {
        LOGGER.info("returning signUpOrLogInButton text");
        return getTextFromElement(driver, signUpOrLogInButton);
    }

    public String getTextFromInvalidCredentials() {
        LOGGER.info("returning invalid credentials text");
        return getTextFromElement(driver, invalidCredentialsText);
    }

    public String getPleaseFillOutThisFieldForNameField() {
        String messageAlert = nameField.getAttribute(VALIDATION_MESSAGE);
        LOGGER.info("returning please fill out this field text from name field");
        return messageAlert;
    }

    public String getPleaseEnterIncompleteEmail() {
        String messageAlert = emailField.getAttribute(VALIDATION_MESSAGE);
        LOGGER.info("returning please enter incomplete email");
        return messageAlert;
    }

    public String getPleaseFillOutThePasswordField() {
        String messageAlert = passwordFieldForLogIn.getAttribute(VALIDATION_MESSAGE);
        LOGGER.info("returning please fill out this field from password");
        return messageAlert;
    }

    public String getPleaseFillOutTheLogInNameField() {
        String messageAlert = emailFieldForLogIn.getAttribute(VALIDATION_MESSAGE);
        LOGGER.info("returning please fill out this field from login name field");
        return messageAlert;
    }
}
