package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.TestBase;
import pomPackage.PomSignin;

public class YourPaymentsTest extends TestBase{
	
	PomSignin signinPage;
	CreateAccountTest createaccountpage;

    @BeforeMethod
    public void setUp() {
        initialization(); // Initialize the properties and driver
        signinPage = new PomSignin();       
        
        signinPage.navigateToHomepage();
        signinPage.performHoverAndClick();
        signinPage.enterUsername(getProperty("username"));
        signinPage.enterPassword(getProperty("password"));

        signinPage.clickSignInSubmit();
        
        performHoverAndClickYourAccount();

}
    
    @Test(priority=1)
    public void yourPaymentsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement yourPaymentsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[2]/a/div/div/div/div[2]/h2")));
        yourPaymentsElement.click();
        
        WebElement addAPaymentMethodButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='a-button-input']")));
        
        // Check if the "Add A Payment Method" button is displayed
        boolean isAddAPaymentMethodButtonDisplayed = addAPaymentMethodButton.isDisplayed();
        
        // Assert that the button is displayed
        Assert.assertTrue(isAddAPaymentMethodButtonDisplayed, "The 'Add A Payment Method' button is displayed");
    }
    
    
    @Test(priority=2)
    public void defaultPaymentMethodPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement yourPaymentsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[2]/a/div/div/div/div[2]/h2")));
        yourPaymentsElement.click();
        
        WebElement addAPaymentMethodButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='a-button-input']")));
        addAPaymentMethodButton.click();
        
        WebElement addAPaymentMethodText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cpefront-mpo-widget\"]/div/div[2]/div[3]/div/div[2]/div/h2")));
        
        // Check if the "Add A Payment Method" button is displayed
        boolean isAddAPaymentMethodTextDisplayed = addAPaymentMethodText.isDisplayed();
        
        // Assert that the button is displayed
        Assert.assertTrue(isAddAPaymentMethodTextDisplayed, "The 'Add A new Payment Method' text is displayed");
    }

    
    
    
    
    
    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }
    
    public void performHoverAndClickYourAccount() {
        WebElement elementToHover = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
        WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"nav-al-your-account\"]/a[1]/span"));

        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover)
                .click(elementToClick)
                .build()
                .perform();
    }
}

