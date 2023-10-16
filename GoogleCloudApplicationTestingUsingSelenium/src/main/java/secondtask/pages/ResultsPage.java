package secondtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.Utilities.clickOnFields;

public class ResultsPage {
    private WebDriver driver;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Google Cloud Pricing Calculator")
    private WebElement calculatorPageLink;

    public void openPricingCalculatorByClick() {
        clickOnFields(driver, calculatorPageLink, 10);
    }
}