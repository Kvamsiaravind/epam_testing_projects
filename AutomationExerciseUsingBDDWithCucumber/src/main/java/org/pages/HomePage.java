package org.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.utilities.Utility.clickOnFields;

public class HomePage {
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signUpButton;

    public void clickOnSignUpButton() {
        LOGGER.info("Clicked on signUp button..");
        clickOnFields(driver, signUpButton, 20);
    }
}
