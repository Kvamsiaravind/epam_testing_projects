package seleniumtestusingtestng;

import basetestforseleniumusingtestng.SeleniumConfiguration;
import listners.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersTestNG.class)

public class SeleniumSignInOrSignOutTest extends SeleniumConfiguration {

    @Test
    public void successfullSignInUsingRegisteredMail() {
        loginPage.enterEmailIntoLogInEmailField("car3@gmail.com");
        loginPage.enterPasswordIntoLogInPasswordField("Varun@1");
        loginPage.clickOnLogInButton();

        Assert.assertEquals(resultPage.getLoggedInUserNameText(), "Logged in as Gouse");
    }

    @Test
    public void successfullSignOutAfterSignIn() {
        loginPage.enterEmailIntoLogInEmailField("car3@gmail.com");
        loginPage.enterPasswordIntoLogInPasswordField("Varun@1");
        loginPage.clickOnLogInButton();
        resultPage.clickOnLogOutButton();

        Assert.assertEquals(loginPage.getSignUpText(), "Signup / Login");
    }

    @Test
    public void signInUsingUnregisteredEmail() {
        loginPage.enterEmailIntoLogInEmailField("gouse.dr@gmail.com");
        loginPage.enterPasswordIntoLogInPasswordField("Gouse@123");
        loginPage.clickOnLogInButton();

        Assert.assertEquals(loginPage.getTextFromInvalidCredentials(), "Your email or password is incorrect!");
    }

    @Test
    public void signInUsingInvalidCredentials() {
        loginPage.enterEmailIntoLogInEmailField("car3@gmail.com");
        loginPage.enterPasswordIntoLogInPasswordField("Gouse@123");
        loginPage.clickOnLogInButton();

        Assert.assertEquals(loginPage.getTextFromInvalidCredentials(), "Your email or password is incorrect!");
    }

    @Test
    public void signInUsingEmailAndMissingPassword() {
        loginPage.enterEmailIntoLogInEmailField("car3@gmail.com");
        loginPage.clickOnLogInButton();

        Assert.assertEquals(loginPage.getPleaseFillOutThePasswordField(), "Please fill out this field.");
    }

    @Test
    public void signInUsingPasswordWithoutUsingEmail() {
        loginPage.enterPasswordIntoLogInPasswordField("Gouse@123");
        loginPage.clickOnLogInButton();

        Assert.assertEquals(loginPage.getPleaseFillOutTheLogInNameField(), "Please fill out this field.");
    }
}
