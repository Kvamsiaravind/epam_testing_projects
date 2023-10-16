package secondtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.Utilities.*;

public class GoogleCloudPricingCalculatorPage {
    protected WebDriver driver;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//iFrame[contains(@src,'products/calculator')]")
    private WebElement outerFrame;

    @FindBy(id = "myFrame")
    private WebElement innerFrame;

    @FindBy(xpath = "//md-tab-item//div[@class='tab-holder compute']")
    private WebElement computeEngineTab;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstancesFeild;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple' and @ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimate;

    public void switchToMainFrame() {
        driver.switchTo().frame(outerFrame).switchTo().frame(innerFrame);
    }

    public void clickComputeEngineTab() {
        clickOnFields(driver, computeEngineTab, 5);
    }

    public void sendNumberOfInstances(String numberOfInstances) {
        sendKeysIntoField(driver, numberOfInstancesFeild, numberOfInstances);
    }

    public void clickAddToEstimateButton() {
        checkElementToBeClickable(addToEstimate, driver, 5);
        clickOnFields(driver, addToEstimate, 5);
    }
}
