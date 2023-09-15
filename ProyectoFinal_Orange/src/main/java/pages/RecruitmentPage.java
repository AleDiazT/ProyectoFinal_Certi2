package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {
    WebDriver driver;


    @FindBy(xpath = "//a[text()='Vacancies']")
    WebElement VacanciesButton;

    public RecruitmentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickVacanciesButton(){
        VacanciesButton.click();
    }
    public void clickADDvacancyButton(){
        WebElement addbutton = driver.findElement(By.xpath("//button[text()=' Add ']"));
        addbutton.click();
    }
    public void fillInformation(String vacancy, String Description) throws InterruptedException {
        WebElement nameTextBox = driver.findElement(By.xpath("//label[text()='Vacancy Name']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input[@class='oxd-input oxd-input--active']"));
        nameTextBox.sendKeys(vacancy);
        Thread.sleep(500);
        WebElement descriptionTextBox = driver.findElement(By.xpath("//textarea[@placeholder='Type description here']"));
        descriptionTextBox.sendKeys(Description);
    }


    public void selectJob(String job){
        String xpathArrow = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']";
        WebElement arrow = driver.findElement(By.xpath(xpathArrow));
        arrow.click();
        String xpath = "//span[text() = '"+ job + "']/ancestor::div[@class = 'oxd-select-option']";
        WebElement option = driver.findElement(By.xpath(xpath));
        option.click();
    }

    public void selectManager(String name) throws InterruptedException {
        WebElement nameTextBox = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        nameTextBox.sendKeys(name);
        Thread.sleep(2500);
        String xpath = "//span/ancestor::div[@class = 'oxd-autocomplete-option']";
        WebElement option = driver.findElement(By.xpath(xpath));
        option.click();
    }

    public void numPositions(String num){
        WebElement positionsTextbox = driver.findElement(By.xpath("//label[text()='Number of Positions']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']/div/input[@class='oxd-input oxd-input--active']"));
        positionsTextbox.sendKeys(num);
    }

    public void vacancySaveButton(){
        WebElement saveButton = driver.findElement(By.xpath("//button[text()=' Save ']"));
        saveButton.click();
    }

    public boolean isVacancyDisplayed(String name){
        String xpath = "//div[text()='" + name + "']";
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.isDisplayed();
    }


}
