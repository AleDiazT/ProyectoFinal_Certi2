package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PimPage;
import utilities.DriverManager;

import java.util.List;

public class PIMSteps {
    PimPage pimPage = new PimPage(DriverManager.getDriver().driver);

    @When("I click on the Add Employee button")
    public void clickButton() throws InterruptedException {
        Thread.sleep(2000);
        pimPage.clickOnAddEmployee();
    }

    @And("fill the information with the following data")
    public void fillInformation(DataTable employeeInfo) throws JsonProcessingException, InterruptedException {
        Thread.sleep(2000);
        List<String> data = employeeInfo.transpose().asList(String.class);
        pimPage.setFirstName(data.get(0));
        pimPage.setMiddleName(data.get(1));
        pimPage.setLastName(data.get(2));
    }

    @When("I click on the save button")
    public void SaveButton() throws InterruptedException {
        pimPage.clickSaveButton();
        Thread.sleep(3000);
    }


    @When("I click on the Emplooyee list")
    public void clickListButton() throws InterruptedException {
        Thread.sleep(2000);
        pimPage.clickOnEmployeeList();
        Thread.sleep(2000);
    }

    @Then("Search the name {string}")
    public void verifyNameIsDisplayed(String name) throws InterruptedException {
        pimPage.setSearchEmployeeName(name);
        pimPage.clickSearchButton();
        Thread.sleep(2000);
    }

    @Then("Search the name again")
    public void verifyNameIsNotFound() throws InterruptedException {
        pimPage.clickSearchButton();
        Thread.sleep(2000);
    }

    @Then("the employee should be listed")
    public void verifyItemIsDisplayed(){
        Assertions.assertTrue(pimPage.isEmployeeFound());
    }

    @When("click the delete button")
    public void clickDeleteButton() throws InterruptedException {
        pimPage.clickdeleteButton();
        Thread.sleep(2000);
    }

    @And("Select the subunit {string}")
    public void selectSubU(String subunit) throws InterruptedException {
        pimPage.selectSubUnit(subunit);
        Thread.sleep(2000);
    }
    @Then("the search should return {string}")
    public void verifyEmployeeDelete(String message) throws InterruptedException {
        Assertions.assertTrue(pimPage.messageverification(message));
        Thread.sleep(2000);
    }

    @Then("the search should found the employee {string}")
    public void verifyEmployeeFound(String name) throws InterruptedException {
        Assertions.assertTrue(pimPage.isNameDisplayed(name));
        Thread.sleep(2000);
    }

}
