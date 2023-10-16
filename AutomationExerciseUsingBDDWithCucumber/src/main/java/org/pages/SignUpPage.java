package org.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.utilities.Utility.*;

public class SignUpPage {
    private static final Logger LOGGER = LogManager.getLogger(SignUpPage.class);
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@value='Mr']")
    private WebElement mrTitle;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement daysDropdown;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement monthsDropdown;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement yearsDropdown;

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstnameField;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastnameField;

    @FindBy(xpath = "//input[@id='company']")
    private WebElement companyField;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement firstAddressField;

    @FindBy(xpath = "//input[@id='address2']")
    private WebElement secondAddressField;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement countryDropdown;

    @FindBy(id = "state")
    private WebElement stateField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "zipcode")
    private WebElement zipcodeField;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    private WebElement createAccountButton;

    @FindBy(xpath = "//b[contains(text(),'Account Created!')]")
    private WebElement accountCreatedText;

    public void selectMrTitle() {
        LOGGER.info("clicking on mrTitle radio box");
        clickOnFields(driver, mrTitle, 15);
    }

    public void enterPassword(String password) {
        LOGGER.info("entering password into password field");
        sendKeysIntoField(driver, passwordField, password);
    }

    public void selectDay(String day) {
        Select dayDropdown = new Select(daysDropdown);
        dayDropdown.selectByVisibleText(day);
        LOGGER.info("selected day from day dropdown");
    }

    public void selectMonth(String month) {
        Select monthDropdown = new Select(monthsDropdown);
        monthDropdown.selectByVisibleText(month);
        LOGGER.info("selected month from month dropdown");
    }

    public void selectYears(String year) {
        Select yearDropdown = new Select(yearsDropdown);
        yearDropdown.selectByVisibleText(year);
        LOGGER.info("selected year from year dropdown");
    }

    public void enterFirstname(String firstname) {
        LOGGER.info("entering firstname into field");
        sendKeysIntoField(driver, firstnameField, firstname);
    }

    public void enterLastname(String lastname) {
        LOGGER.info("entering lastname into field");
        sendKeysIntoField(driver, lastnameField, lastname);
    }

    public void enterCompanyName(String company) {
        LOGGER.info("entering company name into filed");
        sendKeysIntoField(driver, companyField, company);
    }

    public void enterFirstAddress(String firstAddress) {
        LOGGER.info("entering first address into field");
        sendKeysIntoField(driver, firstAddressField, firstAddress);
    }

    public void enterSecondAddress(String secondAddress) {
        LOGGER.info("entering second address into field");
        sendKeysIntoField(driver, secondAddressField, secondAddress);
    }

    public void selectCountry(String country) {
        Select countriesDropdown = new Select(countryDropdown);
        countriesDropdown.selectByVisibleText(country);
        LOGGER.info("selected country from country dropdown");
    }

    public void enterStateName(String stateName) {
        LOGGER.info("entering state name into field");
        sendKeysIntoField(driver, stateField, stateName);
    }

    public void enterCityName(String cityName) {
        LOGGER.info("entering city name into field");
        sendKeysIntoField(driver, cityField, cityName);
    }

    public void enterZipcode(String zipcode) {
        LOGGER.info("entering zipcode into field");
        sendKeysIntoField(driver, zipcodeField, zipcode);
    }

    public void enterMobileNumber(String mobileNumber) {
        LOGGER.info("entering mobile number into field");
        sendKeysIntoField(driver, mobileNumberField, mobileNumber);
    }

    public void clickOnCreateAccount() {
        LOGGER.info("clicking on create account button");
        clickOnFields(driver, createAccountButton, 5);
    }

    public String getAccountCreatedStatus() {
        LOGGER.info("returning account created text");
        return getTextFromElement(driver, accountCreatedText);
    }
}