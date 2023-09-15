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


public class RecruitmentSteps {
    RecruitmentPage recruitmentPage = new RecruitmentPage(DriverManager.getDriver().driver);

    @And("I click on the vacancies button")
    public void clickvacancyButton() throws InterruptedException {
        recruitmentPage.clickVacanciesButton();
        Thread.sleep(2000);
    }

    @And("click on add button")
    public void clickaddButton() throws InterruptedException {
        recruitmentPage.clickADDvacancyButton();
        Thread.sleep(2000);
    }

    @And("Put the name vacancy {string} and description {string}")
    public void fillVacancyInformation(String name, String information) throws InterruptedException {
        recruitmentPage.fillInformation(name,information);
        Thread.sleep(2000);
    }

    @And("the Job title as {string}")
    public void selectJobType(String job) throws InterruptedException {
        recruitmentPage.selectJob(job);
        Thread.sleep(2000);
    }
    @And("I put the manager as {string}")
    public void selectManagerName(String name) throws InterruptedException {
        recruitmentPage.selectManager(name);
        Thread.sleep(2000);
    }

    @And("{string} number of positions")
    public void selectPosNums(String num) throws InterruptedException {
        recruitmentPage.numPositions(num);
        Thread.sleep(2000);
    }

    @And("Click on save button")
    public void saveButton() throws InterruptedException {
        recruitmentPage.vacancySaveButton();
        Thread.sleep(2000);
    }
    @Then("the vacancy {string} should be displayed")
    public void verifyHomePageIsDisplayed(String vacancy) throws InterruptedException {
        Thread.sleep(2000);
        Assertions.assertTrue(recruitmentPage.isVacancyDisplayed(vacancy));
    }


}
