package stepdefs;

import dependencyinjection.DependencyInjection;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class RegistrationStepDef extends DependencyInjection {

    private DependencyInjection dependencyInjection;

    public RegistrationStepDef(DependencyInjection dependencyInjection) {
        this.dependencyInjection = dependencyInjection;
    }

    @Given("User open base url {string} and navigate to register page")
    public void userOpenBaseUrlAndNavigateToRegisterPage(String baseUrl) {
        dependencyInjection.getDriver().get(baseUrl);
    }

    @When("User click on signUp or LogIn button")
    public void userClickOnSignUpOrLogInButton() {
        dependencyInjection.getHomePage().clickOnSignUpButton();
    }

    @When("Enter the following data in their respective fields")
    public void enterTheFollowingDataInTheirRespectiveFields(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);

        dependencyInjection.getLoginPage().enterNameIntoNameField(map.get("Name"));
        dependencyInjection.getLoginPage().enterEmailIntoEmailField(map.get("Mail"));
        dependencyInjection.getLoginPage().clickOnSignUpButton();
        dependencyInjection.getSignUpPage().selectMrTitle();
        dependencyInjection.getSignUpPage().enterPassword(map.get("Password"));
        String date[] = map.get("DOB").split("-");
        dependencyInjection.getSignUpPage().selectDay(date[0]);
        dependencyInjection.getSignUpPage().selectMonth(date[1]);
        dependencyInjection.getSignUpPage().selectYears(date[2]);
        dependencyInjection.getSignUpPage().enterFirstname(map.get("Firstname"));
        dependencyInjection.getSignUpPage().enterLastname(map.get("Lastname"));
        dependencyInjection.getSignUpPage().enterCompanyName(map.get("CompanyName"));
        dependencyInjection.getSignUpPage().enterFirstAddress(map.get("PrimaryAddress"));
        dependencyInjection.getSignUpPage().enterSecondAddress(map.get("SecondaryAddress"));
        dependencyInjection.getSignUpPage().selectCountry(map.get("Country"));
        dependencyInjection.getSignUpPage().enterStateName(map.get("State"));
        dependencyInjection.getSignUpPage().enterCityName(map.get("City"));
        dependencyInjection.getSignUpPage().enterZipcode(map.get("Zipcode"));
        dependencyInjection.getSignUpPage().enterMobileNumber(map.get("MobileNumber"));
    }

    @And("Click on signUp button to create new account")
    public void clickOnSignUpButtonToCreateNewAccount() {
        dependencyInjection.getLoginPage().clickOnSignUpButton();
    }

    @And("User click on create new account")
    public void userClickOnCreateNewAccount() {
        dependencyInjection.getSignUpPage().clickOnCreateAccount();
    }

    @Then("User should be on the my account page")
    public void userShouldBeOnTheMyAccountPage() {
        String status = dependencyInjection.getSignUpPage().getAccountCreatedStatus();
        Assert.assertEquals(status, "ACCOUNT CREATED!");
    }

    @When("User enter name and email to register")
    public void userEnterNameAndEmailToRegister(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        dependencyInjection.getLoginPage().enterNameIntoNameField(map.get("Name"));
        dependencyInjection.getLoginPage().enterEmailIntoEmailField(map.get("Mail"));
    }

    @And("Click on signUp button")
    public void clickOnSignUpButton() {
        dependencyInjection.getLoginPage().clickOnSignUpButton();
    }

    @Then("Page should display {string}")
    public void pageShouldDisplay(String expectedResult) {
        String actualResult = dependencyInjection.getLoginPage().getEmailAlreadyExistText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @When("User enters valid email {string} and leaving name field empty")
    public void userEntersValidEmailAndLeavingNameFieldEmpty(String email) {
        dependencyInjection.getLoginPage().enterEmailIntoEmailField(email);
    }

    @Then("Verify name field displays {string}")
    public void verifyNameFieldDisplays(String expectedResult) {
        String actualResult = dependencyInjection.getLoginPage().getPleaseFillOutThisFieldForNameField();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @When("User enters name and invalid mail")
    public void userEntersNameAndInvalidMail(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        dependencyInjection.getLoginPage().enterNameIntoNameField(map.get("Name"));
        dependencyInjection.getLoginPage().enterEmailIntoEmailField(map.get("Email"));
    }

    @Then("Email field should display {string}")
    public void emailFieldShouldDisplay(String expectedResult) {
        String actualResult = dependencyInjection.getLoginPage().getPleaseEnterIncompleteEmail();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @When("User enters name {string} in name field")
    public void userEntersNameInNameField(String name) {
        dependencyInjection.getLoginPage().enterNameIntoNameField(name);
    }
}