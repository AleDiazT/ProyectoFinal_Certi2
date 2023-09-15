package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import utilities.DriverManager;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);

    @Given("I set the user name field with {string}")
    public void setUserName(String userName) throws InterruptedException {
        Thread.sleep(3000);
        loginPage.setUserNameTextBox(userName);
    }

    @And("I set the password field with {string}")
    public void setPassword(String password){
        loginPage.setPasswordTextBox(password);
    }

    @When("I click on the login button")
    public void clickOnLoginButton() throws InterruptedException {
        Thread.sleep(1000);
        loginPage.clickOnLoginButton();
        Thread.sleep(3000);
    }

    @Then("An error message that says {string} should be displayed")
    public void verifyLoginErrorMessage(String errorMessage) throws InterruptedException {
        Assertions.assertTrue(loginPage.isErrorTextDisplayed(errorMessage));
        Thread.sleep(2000);
    }

}
