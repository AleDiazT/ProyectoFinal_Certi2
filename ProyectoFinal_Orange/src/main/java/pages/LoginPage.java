package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@name= 'username']")
    WebElement userNameTextBox;

    @FindBy(xpath = "//input[@name= 'password']")
    WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//p[text()='Invalid credentials']")
    WebElement loginErrorMessage;


    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserNameTextBox(String userName){
        userNameTextBox.sendKeys(userName);
    }

    public void setPasswordTextBox(String password){
        passwordTextBox.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public boolean isErrorTextDisplayed(String error){
        String actualErrorMessage = loginErrorMessage.getText();
        return error.equalsIgnoreCase(actualErrorMessage);
    }

    public boolean isLoginButtonDisplayed(){
        return loginButton.isDisplayed();
    }


}
