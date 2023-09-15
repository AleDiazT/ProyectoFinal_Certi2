package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimPage {
    WebDriver driver;
    @FindBy(xpath = "//a[text()='Add Employee']")
    WebElement addEmployeeButton;

    @FindBy(xpath = "//a[text()='Employee List']")
    WebElement employeelistButton;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement searchEmployeeName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//label[text()='Sub Unit']/ancestor::div/div[@class='oxd-input-group oxd-input-field-bottom-space']/div/div")
    WebElement subunitButton;



    public PimPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddEmployee(){
        addEmployeeButton.click();
    }

    public void clickOnSubUnit(){
        subunitButton.click();
    }

    public void clickOnEmployeeList(){
        employeelistButton.click();
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void setFirstName(String userName){
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys(userName);
    }
    public void setMiddleName(String userName){
        WebElement middleName = driver.findElement(By.xpath("//input[@name='middleName']"));
        middleName.sendKeys(userName);
    }
    public void setLastName(String userName){
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
        lastName.sendKeys(userName);
    }
    /*
    public void setID(String userName){
        WebElement id = driver.findElement(By.xpath("(//div[input[@class='oxd-input oxd-input--active']])[2]"));
        id.sendKeys(userName);
    }*/

    public void clickSaveButton(){
        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
        saveButton.click();
    }

    public void clickdeleteButton(){
        String xpath = "//i[@class='oxd-icon bi-trash']/ancestor::button[@class='oxd-icon-button oxd-table-cell-action-space']";
        WebElement deleteButton = driver.findElement(By.xpath(xpath));
        deleteButton.click();
        String xpath2 = "//i[@class='oxd-icon bi-trash oxd-button-icon']/ancestor::button";
        WebElement deleteButtonConfirmation = driver.findElement(By.xpath(xpath2));
        deleteButtonConfirmation.click();
    }

    public boolean messageverification(String message){
        String xpath = "//span[text() = 'No Records Found']";
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.isDisplayed();
    }

    public void setSearchEmployeeName(String userName){
        searchEmployeeName.sendKeys(userName);
    }

    public boolean isEmployeeFound(){
        String xpath = "//span[text() = '(1) Record Found']";
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.isDisplayed();
    }

    public void selectSubUnit(String subunit){
        clickOnSubUnit();
        String xpath = "//span[text() = '"+ subunit + "']/ancestor::div[@role='option']";
        WebElement option = driver.findElement(By.xpath(xpath));
        option.click();
    }

    public boolean isNameDisplayed(String name){
        String[] parts = name.split(" ");
        String firstName = parts[0];
        String lastName = parts[1];
        String xpath = "//div[text()='" + firstName + " ']";
        WebElement element = driver.findElement(By.xpath(xpath));
        String xpath1 = "//div[text()='" + lastName + "']";
        WebElement element1 = driver.findElement(By.xpath(xpath1));
        return element1.isDisplayed() && element.isDisplayed();
    }

}
