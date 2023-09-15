package stepDefinitions;

import io.cucumber.java.en.Given;
import utilities.DriverManager;

public class CommonSteps {

    @Given("I am in orange demo web page")
    public void goToOrangeDemoPage(){
        DriverManager.getDriver().driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        DriverManager.getDriver().driver.manage().window().maximize();
    }


}
