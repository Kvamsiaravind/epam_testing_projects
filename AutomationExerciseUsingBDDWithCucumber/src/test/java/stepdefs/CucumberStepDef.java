package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.firsttask.Account;
import org.exceptions.DeficientBalanceException;
import org.firsttask.WithdrawCash;
import org.testng.Assert;

public class CucumberStepDef {

    private Account account;
    private WithdrawCash withdrawCash;
    private int requestAmount;

    @Given("I have a balance of ${int} in my account")
    public void iHaveABalanceOf$InMyAccount(int balance) {
        account = new Account(balance);
    }

    @When("I request ${int}")
    public void iRequest$(int amountToBeWithdrawn) {
        requestAmount = amountToBeWithdrawn;
    }

    @Then("${int} should be dispensed")
    public void shouldBeDispensed(int withdrawAmount) throws DeficientBalanceException {
        withdrawCash = new WithdrawCash(account);
        int expectedAmountToBeWithdrawn = withdrawAmount;
        int actualAmountBeWithdrawned = withdrawCash.getWithdrawnAmount(requestAmount);
        Assert.assertEquals(actualAmountBeWithdrawned, expectedAmountToBeWithdrawn);
    }
}