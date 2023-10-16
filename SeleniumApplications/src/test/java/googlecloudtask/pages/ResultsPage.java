package googlecloudtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.Utility.clickOnFields;
import static waitsforselenium.Waits.checkElementToBeClickable;

public class ResultsPage {
    private WebDriver driver;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Google Cloud Pricing Calculator")
    private WebElement calculatorPageLink;

    public void openPricingCalculatorByClick() {
        checkElementToBeClickable(calculatorPageLink, driver, 15);
        clickOnFields(driver, calculatorPageLink, 10);
    }
}
