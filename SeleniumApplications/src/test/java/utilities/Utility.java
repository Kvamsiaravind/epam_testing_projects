package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utility {

    private static WebDriverWait explicitWait;

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vamsi_Kuruva\\Documents\\chromedriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    public static void clickOnFields(WebDriver driver, WebElement element, int seconds) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public static void sendKeysIntoField(WebDriver driver, WebElement element, String numberOfInstances) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(numberOfInstances);
    }

    public static List<String> getDataFromWebElements(List<WebElement> elementList) {
        List<String> detailsOfEmployee = new ArrayList<>();
        for (int index = 0; index < elementList.size(); index++) {
            detailsOfEmployee.add(elementList.get(index).getText());
        }
        return detailsOfEmployee;
    }

    public static void sortEmployeeData(List<String> dataBeforeEmailSort, List<String> dataAfterEmailSort) {
        Collections.sort(dataBeforeEmailSort);
        Collections.sort(dataAfterEmailSort);
    }

    public static void clearTheContent(WebDriver driver, WebElement element, int seconds) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    public static void submitTheInput(WebDriver driver, WebElement element) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        element.submit();
    }

    public static boolean isInvalidUsername(String actualUsername, String username) {
        return actualUsername != null ? !actualUsername.equals(username) : username != null;
    }

    public static boolean isValidPassword(String actualPassword, String password) {
        return actualPassword != null ? actualPassword.equals(password) : password == null;
    }
}
