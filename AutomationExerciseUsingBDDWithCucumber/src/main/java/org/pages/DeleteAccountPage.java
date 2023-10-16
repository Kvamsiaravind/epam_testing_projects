package org.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.utilities.Utility.getTextFromElement;

public class DeleteAccountPage {
    private static final Logger LOGGER = LogManager.getLogger(DeleteAccountPage.class);
    private WebDriver driver;

    public DeleteAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@data-qa='account-deleted']")
    private WebElement accountDeletedText;

    public String getAccountDeletedText() {
        LOGGER.info("getting text which says account is deleted");
        return getTextFromElement(driver, accountDeletedText);
    }
}