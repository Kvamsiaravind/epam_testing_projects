package googlecloudtask.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static waitsforselenium.Waits.checkElementToBeClickable;
import static utilities.Utility.clickOnFields;
import static utilities.Utility.sendKeysIntoField;

public class GoogleCloudPricingCalculatorHomePage {
    protected WebDriver driver;

    public GoogleCloudPricingCalculatorHomePage(WebDriver driver) {
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

    @FindBy(xpath = "//div[@class='layout-column flex-gt-sm-90 flex-80']/md-input-container/md-select")
    private WebElement operatingSystemList;

    @FindBy(xpath = "//md-option[@value='free']")
    private WebElement operatingSystemType;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement vMClassList;

    @FindBy(xpath = "//md-option[@value='regular']")
    private WebElement vMClassType;

    @FindBy(xpath = "//md-select[@placeholder='Machine Family']")
    private WebElement generalPurposeList;

    @FindBy(xpath = "//md-option[@value='gp']")
    private WebElement generalPurposeType;

    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement seriesList;

    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement seriesType;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineList;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement machineType;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuTypeList;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement gpuType;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUsList;

    @FindBy(xpath = "//md-option[@value='1' and @ng-repeat='item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]']")
    private WebElement numberOfGPUs;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDList;

    @FindBy(xpath = "//md-option[@value='2' and @ng-repeat='item in listingCtrl.dynamicSsd.computeServer']")
    private WebElement localSSDValue;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//label[contains(text(),'Datacenter location')]//parent::md-input-container//md-select")
    private WebElement datacenterLocationList;

    @FindBy(xpath = "//md-option[@value='europe-west3' and @ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer']")
    private WebElement datacenterLocationType;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage' and @ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsageList;

    @FindBy(xpath = "//*[@id='select_option_131']")
    private WebElement committedUsageValue;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple' and @ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimate;

    @FindBy(xpath = "//div[contains(text(),'Provisioning model: Regular')]")
    private WebElement provisioningModel;

    @FindBy(xpath = "//div[contains(text(),'Instance type: n1-standard-8')]")
    private WebElement instanceType;

    @FindBy(xpath = "//div[contains(text(),'Local SSD: 2x375 GiB')]")
    private WebElement localSSDType;

    @FindBy(xpath = "//div[contains(text(),'Region: Frankfurt')]")
    private WebElement region;

    @FindBy(xpath = "//div[@class='md-list-item-text']/b")
    private WebElement monthlyRent;

    public void switchToMainFrame() {
        driver.switchTo().frame(outerFrame).switchTo().frame(innerFrame);
    }

    public void clickComputeEngineTab() {
        clickOnFields(driver, computeEngineTab, 5);
    }

    public void sendNumberOfInstances(String numberOfInstances) {
        sendKeysIntoField(driver, numberOfInstancesFeild, numberOfInstances);
    }

    public void selectOperatingSystem() {
        clickOnFields(driver, operatingSystemList, 5);
        clickOnFields(driver, operatingSystemType, 5);
    }

    public void selectVMClassType() {
        clickOnFields(driver, vMClassList, 5);
        clickOnFields(driver, vMClassType, 5);
    }

    public void selectGeneralPurpose() {
        clickOnFields(driver, generalPurposeList, 5);
        clickOnFields(driver, generalPurposeType, 5);
    }

    public void selectSeries() {
        clickOnFields(driver, seriesList, 5);
        clickOnFields(driver, seriesType, 5);
    }

    public void selectMachineType() {
        clickOnFields(driver, machineList, 5);
        clickOnFields(driver, machineType, 5);
    }

    public void selectAddGPUsCheckbox() {
        clickOnFields(driver, addGPUsCheckbox, 5);
    }

    public void selectGPUType() {
        clickOnFields(driver, gpuTypeList, 5);
        clickOnFields(driver, gpuType, 5);
    }

    public void selectNumberOfGPUs() {
        clickOnFields(driver, numberOfGPUsList, 5);
        clickOnFields(driver, numberOfGPUs, 5);
    }

    public void selectLocalSSD() {
        clickOnFields(driver, localSSDList, 5);
        clickOnFields(driver, localSSDValue, 5);
    }

    public void selectDatacenterLocationType() {
        clickOnFields(driver, datacenterLocationList, 5);
        clickOnFields(driver, datacenterLocationType, 5);
    }

    public void selectCommittedUsageValue() {
        clickOnFields(driver, committedUsageList, 5);
        clickOnFields(driver, committedUsageValue, 5);
    }

    public void clickAddToEstimateButton() {
        checkElementToBeClickable(addToEstimate, driver, 5);
        clickOnFields(driver, addToEstimate, 5);
    }

    public String getProvisioningModel() {
        return provisioningModel.getText();
    }

    public String getInstanceType() {
        return instanceType.getText();
    }

    public String getLocalSSD() {
        return localSSDType.getText();
    }

    public String getRegion() {
        return region.getText();
    }

    public String getMonthlyRent() {
        return monthlyRent.getText();
    }
}
