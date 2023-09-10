package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.TestBase;

public class CreateAccountTest extends TestBase {
	
	    
    @BeforeMethod
    public void setUp() {
        initialization();
    }

    @Test(priority = 1)
    public void validYourName() {
        performHoverAndClick();

        // Find the Name input field
        WebElement nameField = driver.findElement(By.id("ap_customer_name"));

        // Enter any input you want to test (e.g., "Only Math")
        String inputText = "Only Math";
        nameField.sendKeys(inputText);
        nameField.sendKeys(Keys.RETURN);

        // Verify that the field's value contains the input text
        String fieldValue = nameField.getAttribute("value");
        Assert.assertTrue(fieldValue.contains(inputText), "Name field should contain the input text");
    }

    
    @Test(priority = 2)
    public void invalidYourName() {
        performHoverAndClick();

        // Find the Name input field
        WebElement nameField = driver.findElement(By.id("ap_customer_name"));

        // Clear the Name field (making it blank)
        nameField.clear();
        nameField.sendKeys(Keys.RETURN);

        // Wait for the error message element to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Enter your name')]")));

        // Get the text of the error message
        String errorMessageText = errorMessageElement.getText();

        // Assert that the error message contains the expected text
        Assert.assertTrue(errorMessageText.contains("Enter your name"), "Error message should contain 'Enter your name'");
    }
    
    
    @Test(priority = 3)
    public void validMobileNumber() {
        performHoverAndClick();

        // Find the Name input field
        WebElement mobileNumberField = driver.findElement(By.xpath("//input[@id='ap_email']"));

        // Enter any input you want to test (e.g., "Only Math")
        String inputText = "647";
        mobileNumberField.sendKeys(inputText);
        mobileNumberField.sendKeys(Keys.RETURN);

        // Verify that the field's value contains the input text
        String fieldValue = mobileNumberField.getAttribute("value");
        Assert.assertTrue(fieldValue.contains(inputText), "Mobile Number field should contain the input text");
    }
    
    
    @Test(priority = 4)
    public void invalidMobileNumber() {
        performHoverAndClick();

        // Find the Name input field
        WebElement mobileNumberField = driver.findElement(By.xpath("//input[@id='ap_email']"));

        // Clear the Name field (making it blank)
        mobileNumberField.clear();
        mobileNumberField.sendKeys(Keys.RETURN);

        // Wait for the error message element to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Enter your e-mail address or mobile phone number')]")));

        // Get the text of the error message
        String errorMessageText = errorMessageElement.getText();

        // Assert that the error message contains the expected text
        Assert.assertTrue(errorMessageText.contains("Enter your e-mail address or mobile phone number"), "Error message should contain 'Enter your e-mail address or mobile phone number'");
    }
    
    
    @Test(priority = 5)
    public void validEmail() {
        performHoverAndClick();

        // Find the Name input field
        WebElement emailField = driver.findElement(By.xpath("//input[@id='ap_email']"));

        // Enter any input you want to test (e.g., "Only Math")
        String inputText = "onlymathews@gmail.com";
        emailField.sendKeys(inputText);
        emailField.sendKeys(Keys.RETURN);

        // Verify that the field's value contains the input text
        String fieldValue = emailField.getAttribute("value");
        Assert.assertTrue(fieldValue.contains(inputText), "Email field should contain the input text");
    }
    
    
    @Test(priority = 6)
    public void invalidEmail() {
        performHoverAndClick();

        // Find the Name input field
        WebElement emailField = driver.findElement(By.xpath("//input[@id='ap_email']"));

        // Clear the Name field (making it blank)
        emailField.clear();
        emailField.sendKeys(Keys.RETURN);

        // Wait for the error message element to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Enter your e-mail address or mobile phone number')]")));

        // Get the text of the error message
        String errorMessageText = errorMessageElement.getText();

        // Assert that the error message contains the expected text
        Assert.assertTrue(errorMessageText.contains("Enter your e-mail address or mobile phone number"), "Error message should contain 'Enter your e-mail address or mobile phone number'");
    }
    

    @Test(priority = 7)
    public void validPasswordSixCharacters() {
        performHoverAndClick();

        // Find the Password input field
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='ap_password']"));

        // Enter a valid password with at least 6 characters
        String inputText = "myPass";
        passwordField.sendKeys(inputText);
        passwordField.sendKeys(Keys.RETURN);

        // Verify that the field's value contains the input text
        String fieldValue = passwordField.getAttribute("value");
        Assert.assertTrue(fieldValue.contains(inputText), "Password field should contain the input text");

        // Verify that the password has at least 6 characters
        int minLength = 6;
        Assert.assertTrue(fieldValue.length() >= minLength, "Password should have at least 6 characters");
    }

    
    @Test(priority = 8)
    public void invalidPasswordLessThanSixCharacters() {
        performHoverAndClick();

        // Find the Password input field
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='ap_password']"));

        // Enter a valid password with less than 6 characters
        String inputText = "myPas";
        passwordField.sendKeys(inputText);
        passwordField.sendKeys(Keys.RETURN);

        // Wait for the error message element to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='auth-password-invalid-password-alert']//div[@class='a-alert-content'][normalize-space()='Minimum 6 characters required']")));

        // Get the text of the error message
        String errorMessageText = errorMessageElement.getText();

        // Assert that the error message contains the expected text
        String expectedErrorMessage = "Minimum 6 characters required";
        Assert.assertTrue(errorMessageText.contains(expectedErrorMessage), "Error message should contain 'Minimum 6 characters required'");
    }

    
    @Test(priority = 9)
    public void validPasswordAgain() {
        performHoverAndClick();

        // Find the Password input field
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='ap_password']"));

        // Enter a valid password with at least 6 characters
        String inputPassword = "Mattonly@13";
        passwordField.sendKeys(inputPassword);

        // Find the "Re-enter password" input field
        WebElement reEnterPasswordField = driver.findElement(By.xpath("//input[@id='ap_password_check']"));

        // Enter the same password in the "Re-enter password" field
        reEnterPasswordField.sendKeys(inputPassword);

        // Submit the form (you can use the Enter key)
        reEnterPasswordField.sendKeys(Keys.RETURN);

        // Verify that both fields contain the same password
        String passwordFieldValue = passwordField.getAttribute("value");
        String reEnterPasswordFieldvalue = reEnterPasswordField.getAttribute("value");

        Assert.assertEquals(passwordFieldValue, reEnterPasswordFieldvalue, "Passwords should match");
    }


    @Test(priority = 10)
    public void invalidPasswordAgain() {
        performHoverAndClick();

        // Find the Password input field
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='ap_password']"));

        // Enter a valid password with at least 6 characters
        String inputPassword = "myPass";
        passwordField.sendKeys(inputPassword);

        // Find the "Re-enter password" input field
        WebElement reEnterPasswordField = driver.findElement(By.xpath("//input[@id='ap_password_check']"));

        // Enter a different password in the "Re-enter password" field
        String differentPassword = "yourPass";
        reEnterPasswordField.sendKeys(differentPassword);

        // Submit the form using Enter key
        reEnterPasswordField.sendKeys(Keys.RETURN);

        // Wait for the error message element to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Passwords do not match')]")));

        // Get the text of the error message
        String errorMessageText = errorMessageElement.getText();

        // Assert that the error message contains the expected text
        Assert.assertTrue(errorMessageText.contains("Passwords do not match"), "Error message should contain 'Passwords do not match'");
    }

    
    @Test(priority = 11)
    public void verifyEmail() {
        performHoverAndClick();
        
        //Find the Your Name input field
        WebElement nameField = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));

        // Enter a valid name
        String validName= "Only Mathews";
        nameField.sendKeys(validName);

        // Find the Email input field
        WebElement emailField = driver.findElement(By.xpath("//input[@id='ap_email']"));

        // Enter a valid email address
        String validEmail = "onymathews@gmail.com";
        emailField.sendKeys(validEmail);

        // Find the Password input field
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='ap_password']"));

        // Enter a valid password with at least 6 characters
        String validPassword = "Mattonly@13";
        passwordField.sendKeys(validPassword);

        // Find the "Re-enter password" input field
        WebElement reEnterPasswordField = driver.findElement(By.xpath("//input[@id='ap_password_check']"));

        // Re-enter the same valid password
        reEnterPasswordField.sendKeys(validPassword);

        // Find and click the "Verify Email" button
        WebElement verifyEmailButton = driver.findElement(By.xpath("//input[@id='continue']"));
        verifyEmailButton.click();

     // Wait for the OTP (One-Time Password) field to be present and visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cvf-input-code']")));

        // sendKeys to OTP field to enter the OTP
        otpField.sendKeys("123456"); // Replace "123456" with the actual OTP    

    }

    
    @Test(priority = 12)
    public void returningCustomer() {
        performHoverAndClickStartHere();
        
        //Find the Your Name input field
        WebElement nameField = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));

        // Enter a valid name
        String validName= "Only Mathews";
        nameField.sendKeys(validName);

        // Find the Email input field
        WebElement emailField = driver.findElement(By.xpath("//input[@id='ap_email']"));

        // Enter a valid email address
        String validEmail = "onlymathews@gmail.com";
        emailField.sendKeys(validEmail);

        // Find the Password input field
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='ap_password']"));

        // Enter a valid password with at least 6 characters
        String validPassword = "Mattonly@13";
        passwordField.sendKeys(validPassword);

        // Find the "Re-enter password" input field
        WebElement reEnterPasswordField = driver.findElement(By.xpath("//input[@id='ap_password_check']"));

        // Re-enter the same valid password
        reEnterPasswordField.sendKeys(validPassword);

        // Find and click the "Verify Email" button
        WebElement verifyEmailButton = driver.findElement(By.xpath("//input[@id='continue']"));
        verifyEmailButton.click();

        // Wait for the error message element to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement errorMessageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"register-mase-inlineerror\"]/div/div")));
    
        // Get the text of the error message
        String errorMessageText = errorMessageElement.getText();

        // Assert that the error message contains the expected text
        Assert.assertTrue(errorMessageText.contains("There is already an account with this email."), "Error message should contain 'There is already an account with this email.'");
    }   
       

    @AfterMethod
    public void tearDown() {
            driver.quit();
        }
    
    
    public void performHoverAndClick() {
        WebElement elementToHover = driver.findElement(By.id("nav-link-accountList"));
        WebElement elementToClick = driver.findElement(By.xpath("//div[@id='nav-flyout-ya-newCust']//a[@class='nav-a'][normalize-space()='Start here.']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover)
               .moveToElement(elementToClick)
               .click()
               .build()
               .perform();	
    }
    
    public void performHoverAndClickStartHere() {
        WebElement elementToHover = driver.findElement(By.id("nav-link-accountList"));
        WebElement elementToClick = driver.findElement(By.xpath("//a[@class='nav-a']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover)
               .moveToElement(elementToClick)
               .click()
               .build()
               .perform();	
    }
}
