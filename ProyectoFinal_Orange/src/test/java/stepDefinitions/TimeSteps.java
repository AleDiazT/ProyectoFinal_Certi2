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

public class TimeSteps {
    TimePage timePage = new TimePage(DriverManager.getDriver().driver);

    @And("I click on the Customers button")
    public void clickPJButton() throws InterruptedException {
        timePage.clickOnCustomerButton();
        Thread.sleep(2000);
    }
    @And("I click on the Add customer button")
    public void clickADDCustomerButton() throws InterruptedException {
        timePage.clickOnAddButton();
        Thread.sleep(2000);
    }
    @And("Put the name {string} and description {string}")
    public void fillInfo(String name, String description) throws InterruptedException {
        timePage.fillInformation(name,description);
        Thread.sleep(2000);
    }

    @And("I click on save button")
    public void clicksaveButton() throws InterruptedException {
        timePage.saveButtonClick();
        Thread.sleep(5000);
    }

    @Then("the customer {string} should be displayed")
    public void verifyHomePageIsDisplayed(String customer) throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertTrue(timePage.isCustomerDisplayed(customer));
    }
}
