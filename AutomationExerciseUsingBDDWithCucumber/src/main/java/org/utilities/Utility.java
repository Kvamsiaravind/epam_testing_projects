package org.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utility {

    private Utility() {
    }

    private static WebDriverWait explicitWait;

    public static void clickOnFields(WebDriver driver, WebElement element, int timeout) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void sendKeysIntoField(WebDriver driver, WebElement element, String data) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(data);
    }

    public static String getTextFromElement(WebDriver driver, WebElement element) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}