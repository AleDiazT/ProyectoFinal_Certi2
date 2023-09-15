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

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement pageTitle;

    @FindBy(xpath = "//span[text()='Admin']")
    WebElement admin;

    @FindBy(xpath = "//span[text()='PIM']")
    WebElement pim;

    @FindBy(xpath = "//span[text()='Leave']")
    WebElement leave;

    @FindBy(xpath = "//span[text()='Time']")
    WebElement time;

    @FindBy(xpath = "//span[text()='Recruitment']")
    WebElement recruitment;

    @FindBy(xpath = "//span[text()='Claim']")
    WebElement claim;

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement dropname;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean pageTitleIsDisplayed(){
        return pageTitle.isDisplayed();
    }
    public void clickOnAdminButton(){admin.click();}
    public void clickOnPIMButton() throws InterruptedException {
        Thread.sleep(3000);
        pim.click();
    }

    public void clickOnButton(String section) throws InterruptedException {
        String xpath = "//span[text()='"+section+"']";
        WebElement tipo = driver.findElement(By.xpath(xpath));
        tipo.click();
    }
    public void clickOnLeaveButton(){
        leave.click();
    }
    public void clickOnTimeButton(){
        time.click();
    }
    public void clickOnRecruitmentButton(){
        recruitment.click();
    }
    public void clickOnClaimButton(){
        claim.click();
    }

    public boolean isItemDisplayed(String product){
        String xpath = "//p[text()='" + product + "']";
        WebElement element = driver.findElement(By.xpath(xpath));
        return element.isDisplayed();
    }

    public void logOut(){
        dropname.click();
        WebElement logoutButon = driver.findElement(By.xpath("//a[text()='Logout']"));
        logoutButon.click();
    }
}
