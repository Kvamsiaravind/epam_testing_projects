package seleniumtestusingtestng;

import basetestforseleniumusingtestng.SeleniumConfiguration;
import listners.ListenersTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersTestNG.class)
public class SeleniumRegistrationTest extends SeleniumConfiguration {

    @Test
    public void registrationUsingValidDetails() {
        LOGGER.info("Filling fields to create account");
        loginPage.enterNameIntoNameField("Gouse");
        loginPage.enterEmailIntoEmailField("ca3@gmail.com");
        loginPage.clickOnSignUpButton();
        signUpPage.selectMrTitle();
        signUpPage.enterPassword("Varun@1");
        signUpPage.selectDay("5");
        signUpPage.selectMonth("December");
        signUpPage.selectYears("2001");
        signUpPage.enterFirstname("Gousiya");
        signUpPage.enterLastname("Begum");
        signUpPage.enterCompanyName("epam");
        signUpPage.enterFirstAddress("Chabol Nandyal 518221");
        signUpPage.enterSecondAddress("Srinivas Nandyal 518321");
        signUpPage.selectCountry("India");
        signUpPage.enterStateName("Andhra Pradesh");
        signUpPage.enterCityName("Kurnool");
        signUpPage.enterZipcode("519228");
        signUpPage.enterMobileNumber("9889889889");
        signUpPage.clickOnCreateAccount();
        LOGGER.info("Account created successfully");

        Assert.assertEquals(signUpPage.getAccountCreatedStatus(), "ACCOUNT CREATED!");
    }

    @Test
    public void registerUsingAlreadyRegisteredMail() {
        LOGGER.info("Entering credentials");
        loginPage.enterNameIntoNameField("Gouse");
        loginPage.enterEmailIntoEmailField("car5@gmail.com");
        loginPage.clickOnSignUpButton();
        LOGGER.info("asserting the result");

        Assert.assertEquals(loginPage.getEmailAlreadyExistText(), "Email Address already exist!");
    }

    @Test
    public void registrationUsingValidMailAndMissingName() {
        LOGGER.info("entering only mail by missing field");
        loginPage.enterEmailIntoEmailField("car5@gmail.com");
        loginPage.clickOnSignUpButton();
        LOGGER.info("Asserting the result");

        Assert.assertEquals(loginPage.getPleaseFillOutThisFieldForNameField(), "Please fill out this field.");
    }

    @Test
    public void registrationUsingValidNameAndInvalidEmail() {
        LOGGER.info("Entering credentials");
        loginPage.enterNameIntoNameField("Gouse");
        loginPage.enterEmailIntoEmailField("Gouse@");
        loginPage.clickOnSignUpButton();
        LOGGER.info("Asserting the result");

        Assert.assertEquals(loginPage.getPleaseEnterIncompleteEmail(), "Please enter a part following '@'. 'Gouse@' is incomplete.");
    }

    @Test
    public void registrationUsingNameAndEmailField() {
        LOGGER.info("entering only name by missing field");
        loginPage.enterNameIntoNameField("Gouse");
        loginPage.clickOnSignUpButton();
        LOGGER.info("Asserting the result");

        Assert.assertEquals(loginPage.getPleaseEnterIncompleteEmail(), "Please fill out this field.");
    }
}