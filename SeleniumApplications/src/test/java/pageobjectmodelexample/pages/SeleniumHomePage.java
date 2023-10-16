package pageobjectmodelexample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumHomePage {
    protected WebDriver driver;

    public SeleniumHomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By documentation = By.linkText("Documentation");
    private By downloads = By.linkText("Downloads");


    public DocumentationPage navigateToDocPage() {
        driver.findElement(documentation).click();
        return new DocumentationPage(driver);
    }

    public DownloadsPage navigateToDownloadsPage() {
        driver.findElement(downloads).click();
        return new DownloadsPage(driver);
    }
}
