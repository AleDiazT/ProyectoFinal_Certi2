package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TimePage {
    WebDriver driver;
    @FindBy(xpath = "//span[text()='Project Info ']")
    WebElement pjInfoButton;

    public TimePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnCustomerButton() throws InterruptedException {
        pjInfoButton.click();
        Thread.sleep(300);
        WebElement customer = driver.findElement(By.xpath("//a[text()='Customers']"));
        customer.click();
    }

    public void clickOnAddButton(){
        pjInfoButton.click();
        WebElement addbutton = driver.findElement(By.xpath("//button[text()=' Add ']"));
        addbutton.click();
    }

    public void fillInformation(String name, String Description){
        WebElement nameTextBox = driver.findElement(By.xpath("//div[@class='']/input[@class='oxd-input oxd-input--active']"));
        WebElement descriptionTextBox = driver.findElement(By.xpath("//textarea[@placeholder='Type description here']"));
        nameTextBox.sendKeys(name);
        descriptionTextBox.sendKeys(Description);
    }

    public void saveButtonClick(){
        WebElement saveButton = driver.findElement(By.xpath("//button[text()=' Save ']"));
        saveButton.click();
    }

    public boolean isCustomerDisplayed(String product){
        String xpath = "//div[text()='" + product + "']";
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.isDisplayed();
    }

}
