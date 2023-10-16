package waitsforselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private static WebDriverWait explicitWait;

    public static void checkElementToBeClickable(WebElement webElement, WebDriver driver, int seconds) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        explicitWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitUntilFrameToBeAvailable(WebDriver driver, By id, int seconds) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
    }

    public static void waitUntilClick(WebDriver driver, WebElement element, int seconds) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitUntilVisible(WebDriver driver, By locator, int seconds) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        return element;
    }
}
