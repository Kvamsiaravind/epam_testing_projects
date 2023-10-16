package org.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.utilities.Utility.clickOnFields;
import static org.utilities.Utility.getTextFromElement;

public class ResultPage {
    private static final Logger LOGGER = LogManager.getLogger(ResultPage.class);
    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElement loggedInUserName;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logOutButton;

    @FindBy(xpath = "//a[@href='/delete_account']")
    private WebElement deleteAccountButton;

    public String getLoggedInUserNameText() {
        LOGGER.info("returning loggedIn username text after login");
        return getTextFromElement(driver, loggedInUserName);
    }

    public void clickOnLogOutButton() {
        LOGGER.info("clicking on logout button");
        clickOnFields(driver, logOutButton, 5);
    }

    public void clickOnDeleteAccountButton() {
        LOGGER.info("clicking on delete account button");
        clickOnFields(driver, deleteAccountButton, 10);
    }
}
