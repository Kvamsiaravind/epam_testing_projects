package stepdefs;

import dependencyinjection.DependencyInjection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SignInSignOutStepDef extends DependencyInjection {

    private DependencyInjection dependencyInjection;

    public SignInSignOutStepDef(DependencyInjection dependencyInjection) {
        this.dependencyInjection = dependencyInjection;
    }


    @Given("User open base url {string}")
    public void userOpenBaseUrl(String baseUrl) {
        dependencyInjection.getDriver().get(baseUrl);
    }

    @When("User click on signUp or LogIn button in homepage")
    public void userClickOnSignUpOrLogInButtonInHomepage() {
        dependencyInjection.getHomePage().clickOnSignUpButton();
    }

    @When("User enter registered email {string} and correct password {string}")
    public void userEnterRegisteredEmailAndCorrectPassword(String email, String password) {
        dependencyInjection.getLoginPage().enterEmailIntoLogInEmailField(email);
        dependencyInjection.getLoginPage().enterPasswordIntoLogInPasswordField(password);
    }

    @And("User click on LogIn button")
    public void userClickOnLogInButton() {
        dependencyInjection.getLoginPage().clickOnLogInButton();
    }

    @Then("Verify the results page as {string}")
    public void verifyTheResultsPageAs(String expectedResult) {
        Assert.assertEquals(dependencyInjection.getResultPage().getLoggedInUserNameText(), expectedResult);
    }

    @When("User on result page by logged in to logIn page using valid credentials email {string} and password {string}")
    public void userOnResultPageByLoggedInToLogInPageUsingValidCredentialsEmailAndPassword(String email, String password) {

        dependencyInjection.getLoginPage().enterEmailIntoLogInEmailField(email);
        dependencyInjection.getLoginPage().enterPasswordIntoLogInPasswordField(password);
        dependencyInjection.getLoginPage().clickOnLogInButton();
    }

    @Then("verify the it is logIn page or not by asserting {string}")
    public void verifyTheItIsLogInPageOrNotByAsserting(String expectedResult) {
        String actualResult = dependencyInjection.getLoginPage().getSignUpText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @And("User click on logout button")
    public void userClickOnLogoutButton() {
        dependencyInjection.getResultPage().clickOnLogOutButton();
    }

    @When("User enter unregistered email {string} and password {string}")
    public void userEnterUnregisteredEmailAndPassword(String unRegisteredMail, String password) {
        dependencyInjection.getLoginPage().enterEmailIntoLogInEmailField(unRegisteredMail);
        dependencyInjection.getLoginPage().enterPasswordIntoLogInPasswordField(password);
    }

    @Then("Verify the result using {string}")
    public void verifyTheResultUsing(String expectedResult) {
        String actualResult = dependencyInjection.getLoginPage().getTextFromInvalidCredentials();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @When("User enter registered email {string} and wrong password {string}")
    public void userEnterRegisteredEmailAndWrongPassword(String registeredMail, String incorrectPassword) {
        dependencyInjection.getLoginPage().enterEmailIntoLogInEmailField(registeredMail);
        dependencyInjection.getLoginPage().enterPasswordIntoLogInPasswordField(incorrectPassword);
    }

    @When("User enter the mail {string}")
    public void userEnterTheMail(String email) {
        dependencyInjection.getLoginPage().enterEmailIntoLogInEmailField(email);
    }

    @Then("Verify the password field showing  {string}")
    public void verifyThePasswordFieldShowing(String expectedResult) {
        String actualResult = dependencyInjection.getLoginPage().getPleaseFillOutThePasswordField();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Then("Verify email field using {string}")
    public void verifyEmailFieldUsing(String expectedResult) {
        String actualResult = dependencyInjection.getLoginPage().getPleaseFillOutTheLogInNameField();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @When("User enter password {string}")
    public void userEnterPassword(String password) {
        dependencyInjection.getLoginPage().enterPasswordIntoLogInPasswordField(password);
    }

    @And("User click on delete account button")
    public void userClickOnDeleteAccountButton() {
        dependencyInjection.getResultPage().clickOnDeleteAccountButton();
    }

    @Then("Verify account deleted or not by asserting {string}")
    public void verifyAccountDeletedOrNotByAsserting(String expectedResult) {
        String actualResult = dependencyInjection.getDeleteAccountPage().getAccountDeletedText();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
