package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pomPackage.PomSignin;
import basePackage.TestBase;

public class ExistingCustomerTest extends TestBase {
   
    PomSignin signinPage;
    

    @BeforeMethod
    public void setUp() {
        initialization(); // Initialize the properties and driver
        signinPage = new PomSignin();
        
        signinPage.navigateToHomepage();
        signinPage.performHoverAndClick();
                
    }

    
    @Test(priority=1)
    public void invalidEmail() {
    	
        signinPage.enterUsername(getProperty("invalidUsername"));
        signinPage.clickContinueButton(); 
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-list-item']")));
    
        // Get the text of the error message
        String errorMessageText = errorMessageElement.getText();

        // Assert that the error message contains the expected text
        Assert.assertTrue(errorMessageText.contains("We cannot find an account with that e-mail address"), "Error message should contain 'We cannot find an account with that e-mail address'");
    }   
     
    @Test(priority=2)
    public void blankEmail() {
    	
        signinPage.enterUsername(getProperty("blankUsername"));
        signinPage.clickContinueButton(); 
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Enter your e-mail address or mobile phone number')]")));
    
        // Get the text of the error message
        String errorMessageText = errorMessageElement.getText();

        // Assert that the error message contains the expected text
        Assert.assertTrue(errorMessageText.contains("Enter your e-mail address or mobile phone number"), "Error message should contain 'Enter your e-mail address or mobile phone number'");
    }   

    
    @Test(priority=3)
    public void validEmail() {
       
        signinPage.enterUsername(getProperty("username"));
        signinPage.enterPassword(getProperty("password"));
        signinPage.clickSignInSubmit();   
        
		
        // Wait for the element containing 'Hello,' to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")));
        
        // Get the text of the element
        String helloText = helloTextElement.getText();

        // Assert that the text 'Hello,' is visible
        Assert.assertTrue(helloText.contains("Hello,"), "Expected text 'Hello,' is visible after sign-in");		 
            
    }
    
    @Test(priority = 4)
    public void keepMeSignedIn() {
        
        signinPage.enterUsername(getProperty("username"));
        signinPage.enterPassword(getProperty("password"));

        WebElement checkbox = driver.findElement(By.xpath("//input[@name='rememberMe']"));
        checkbox.click();
        boolean isChecked = checkbox.isSelected();
        Assert.assertTrue(isChecked, "Checkbox is selected");

        signinPage.clickSignInSubmit();

        // Initialize a new WebDriver instance
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\princ\\eclipse-workspace\\AmazonCanada\\chromedriver.exe");
        WebDriver newDriver = new ChromeDriver();

        // Navigate to a page where you can check if you're signed in
        newDriver.get("https://www.amazon.ca/");

        // Wait for the element containing 'Hello,' to be visible
        WebDriverWait wait = new WebDriverWait(newDriver, Duration.ofSeconds(10));
        WebElement helloTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")));

        // Get the text of the element
        String helloText = helloTextElement.getText();

        // Assert that the text 'Hello,' is visible
        Assert.assertTrue(helloText.contains("Hello,"), "Expected text 'Hello,' is visible after sign-in");

        // Close the new WebDriver instance
        newDriver.quit();
    }

            
    
    @AfterMethod
    public void tearDown() {
        // Need to close the driver here, as it's not handled by TestBase
            driver.quit();
        }
    }

