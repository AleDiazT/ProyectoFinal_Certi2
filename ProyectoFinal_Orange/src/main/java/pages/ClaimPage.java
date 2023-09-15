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

public class ClaimPage {
    WebDriver driver;
    @FindBy(xpath = "//a[text()='Submit Claim']")
    WebElement submitclaimButton;

    @FindBy(xpath = "//a[text()='My Claims']")
    WebElement myclaimButton;

    public ClaimPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnsubmitClaim(){
        submitclaimButton.click();
    }

    public void clickOnMyClaims(){
        myclaimButton.click();
    }

    public void selectEvent(String event){
        String xpathArrow = "//label[text()='Event']/ancestor::div/div[@class='oxd-input-group oxd-input-field-bottom-space']/div/div";
        WebElement arrow = driver.findElement(By.xpath(xpathArrow));
        arrow.click();
        String xpath = "//span[text() = '"+ event + "']/ancestor::div[@class = 'oxd-select-option']";
        WebElement option = driver.findElement(By.xpath(xpath));
        option.click();
    }

    public void selectCurrency(String currency){
        String xpathArrow = "//label[text()='Currency']/ancestor::div/div[@class='oxd-input-group oxd-input-field-bottom-space']/div/div";
        WebElement arrow = driver.findElement(By.xpath(xpathArrow));
        arrow.click();
        String xpath = "//span[text() = '"+ currency + "']/ancestor::div[@class = 'oxd-select-option']";
        WebElement option = driver.findElement(By.xpath(xpath));
        option.click();
    }

    public void setRemarks(String remark){
        WebElement remarkTextBox = driver.findElement(By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']"));
        remarkTextBox.sendKeys(remark);
    }

    public void clickCreate(){
        WebElement createButton = driver.findElement(By.xpath("//button[text()=' Create ']"));
        createButton.click();
    }

    public void clickAddExpenses(){
        WebElement createButton = driver.findElement(By.xpath("//button[text()=' Add ']"));
        createButton.click();
    }

    public void selectExpenseType(String expense){
        String xpathArrow = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']";
        WebElement arrow = driver.findElement(By.xpath(xpathArrow));
        arrow.click();
        String xpath = "//span[text() = '"+ expense + "']/ancestor::div[@class = 'oxd-select-option']";
        WebElement option = driver.findElement(By.xpath(xpath));
        option.click();
    }

    public void selectDate(String num) throws InterruptedException {
        String xpathCalendar = "//i[@class='oxd-icon bi-calendar oxd-date-input-icon']";
        WebElement calendar = driver.findElement(By.xpath(xpathCalendar));
        calendar.click();
        Thread.sleep(500);
        String xpath = "//div[@class='oxd-calendar-date-wrapper']/div[text()='"+num+"']/ancestor::div[@class='oxd-calendar-date-wrapper']";
        WebElement option = driver.findElement(By.xpath(xpath));
        option.click();
    }
    public void setAmount(String num){
        WebElement amountTextbox = driver.findElement(By.xpath("//label[text()='Amount']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input[@class='oxd-input oxd-input--active']"));
        amountTextbox.sendKeys(num);
    }
    public void saveButtonClick(){
        WebElement saveButton = driver.findElement(By.xpath("//button[text()=' Save ']"));
        saveButton.click();
    }

    public void submitButtonClick(){
        WebElement submitButton = driver.findElement(By.xpath("//button[text()=' Submit ']"));
        submitButton.click();
    }

    public boolean isClaimDisplayed(String remark){
        String xpath = "//span[text()='" + remark + "']";
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.isDisplayed();
    }

}
