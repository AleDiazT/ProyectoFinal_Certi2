package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverManager;

public class HomeSteps {
    HomePage homePage = new HomePage(DriverManager.getDriver().driver);

    @Then("The home page should be displayed")
    public void verifyHomePageIsDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        Assertions.assertTrue(homePage.pageTitleIsDisplayed());
    }

    @When("I click on the {string} button")
    public void clickButton(String section) throws InterruptedException {
        homePage.clickOnButton(section);
        Thread.sleep(2000);
    }

    @Then("The dashboard item {string} should be displayed")
    public void verifyItemIsDisplayed(String product){
        Assertions.assertTrue(homePage.isItemDisplayed(product));
    }

    @And("I click on the pim button")
    public void clickPimButton() throws InterruptedException {
        homePage.clickOnPIMButton();
        Thread.sleep(2000);
    }

    @And("I click on the leave button")
    public void clickLeaveButton() throws InterruptedException {
        homePage.clickOnLeaveButton();
        Thread.sleep(2000);
    }

    @And("I logout from the page")
    public void logOutOrangePage(){
        homePage.logOut();

    }
}
