package dependencyinjection;

import org.openqa.selenium.WebDriver;
import org.pages.*;

public class DependencyInjection {

    protected WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private ResultPage resultPage;
    private SignUpPage signUpPage;
    private DeleteAccountPage deleteAccountPage;

    public HomePage getHomePage() {
        return homePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public ResultPage getResultPage() {
        return resultPage;
    }

    public SignUpPage getSignUpPage() {
        return signUpPage;
    }

    public DeleteAccountPage getDeleteAccountPage() {
        return deleteAccountPage;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void initializePageObjects() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        resultPage = new ResultPage(driver);
        deleteAccountPage = new DeleteAccountPage(driver);
    }
}