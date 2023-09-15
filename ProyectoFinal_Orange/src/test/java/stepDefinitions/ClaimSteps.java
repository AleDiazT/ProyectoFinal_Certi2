package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v85.runtime.model.StackTraceId;
import pages.*;
import utilities.DriverManager;

public class ClaimSteps {
    ClaimPage claimPage = new ClaimPage(DriverManager.getDriver().driver);

    @And("I click on the submit claim button")
    public void clickSubmitButton() throws InterruptedException {
        claimPage.clickOnsubmitClaim();
        Thread.sleep(2000);
    }

    @And("select event {string}")
    public void selectEventB(String event) throws InterruptedException {
        claimPage.selectEvent(event);
        Thread.sleep(2000);
    }
    @And("select currency {string}")
    public void selectCurrencyB(String currency) throws InterruptedException {
        claimPage.selectCurrency(currency);
        Thread.sleep(2000);
    }

    @And("Put the remarks {string}")
    public void fillRemark(String remark) throws InterruptedException {
        claimPage.setRemarks(remark);
        Thread.sleep(2000);
    }

    @And("click the create button")
    public void clickCreateB() throws InterruptedException {
        claimPage.clickCreate();
        Thread.sleep(5000);
    }

    @And("I click on the add expenses")
    public void clickaddE() throws InterruptedException {
        Thread.sleep(1000);
        claimPage.clickAddExpenses();
        Thread.sleep(2000);
    }

    @And("select {string} in the expense type")
    public void selectExpenseT(String typeE) throws InterruptedException {
        claimPage.selectExpenseType(typeE);
        Thread.sleep(2000);
    }

    @And("and the date of {string} of the current month")
    public void selectDateDay(String num) throws InterruptedException {
        claimPage.selectDate(num);
        Thread.sleep(2000);
    }

    @And("the ammount of {string}")
    public void putAmount(String num) throws InterruptedException {
        claimPage.setAmount(num);
        Thread.sleep(2000);
    }

    @And("click on the save button")
    public void clickSave() throws InterruptedException {
        claimPage.saveButtonClick();
        Thread.sleep(3000);
    }

    @And("click on submit")
    public void submit() throws InterruptedException {
        claimPage.submitButtonClick();
        Thread.sleep(2000);
    }

    @And("I click on My claims")
    public void myClaims() throws InterruptedException {
        claimPage.clickOnMyClaims();
        Thread.sleep(2000);
    }

    @Then("the claim with the description {string} should be displayed")
    public void verifyclaimIsDisplayed(String claim) throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertTrue(claimPage.isClaimDisplayed(claim));
    }

}
