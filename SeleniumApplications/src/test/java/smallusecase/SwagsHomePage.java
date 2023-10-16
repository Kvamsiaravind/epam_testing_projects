package smallusecase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.Utility.*;

public class SwagsHomePage {
    protected WebDriver driver;

    public SwagsHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameFeild;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordFeild;

    public void enterUsername(String usernameValue){
        sendKeysIntoField(driver,usernameFeild,usernameValue);
        clearTheContent(driver,usernameFeild,5);
    }

    public void enterPassword(){
        clearTheContent(driver,passwordFeild,5);
    }

    public void clickLoginButton(){
        clickOnFields(driver,loginButton,5);
    }
}
