package secondtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.Utilities.sendKeysIntoField;
import static utilities.Utilities.submitTheInput;


public class GoogleCloudHomePage {
    private WebDriver driver;

    public GoogleCloudHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchBox;

    public void searchCalculatorPage(String searchInput) {
        sendKeysIntoField(driver, searchBox, searchInput);
        submitTheInput(driver, searchBox);
    }

}
