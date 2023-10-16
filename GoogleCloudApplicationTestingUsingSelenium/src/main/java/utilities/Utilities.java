package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilities {

    private static WebDriverWait explicitWait;

    private Utilities(){
    }

    public static void clickOnFields(WebDriver driver, WebElement element, int timeout) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public static void sendKeysIntoField(WebDriver driver, WebElement element, String numberOfInstances) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(numberOfInstances);
    }

    public static void submitTheInput(WebDriver driver, WebElement element) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        element.submit();
    }

    public static void waitUntilFrameToBeAvailable(WebDriver driver, By id, int seconds) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
    }

    public static void checkElementToBeClickable(WebElement webElement, WebDriver driver, int seconds) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        explicitWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
