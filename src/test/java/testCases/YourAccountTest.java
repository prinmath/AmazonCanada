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

public class YourAccountTest extends TestBase {
    PomSignin signinPage;

    @BeforeMethod
    public void setUp() {
        initialization(); // Initialize the properties and driver
        signinPage = new PomSignin();
        
        signinPage.navigateToHomepage();
        signinPage.performHoverAndClick();
        signinPage.enterUsername(getProperty("username"));
        signinPage.enterPassword(getProperty("password"));

        signinPage.clickSignInSubmit();
    }

    @Test(priority = 1)
    public void viewAccountInfo() {
      

        // Wait for the "Hello, " element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nav-link-accountList-nav-line-1']")));

        // Wait for the "Account & Lists" element to be visible
        WebElement accountListsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Account & Lists']")));

        // Get the text of both elements
        String helloText = helloTextElement.getText();
        String accountListsText = accountListsElement.getText();

        // Assert that both elements contain the expected text
        String expectedHelloText = "Hello, ";
        String expectedAccountListsText = "Account & Lists";

        Assert.assertTrue(helloText.contains(expectedHelloText), "Expected 'Hello' message is displayed after sign-in");
        Assert.assertTrue(accountListsText.contains(expectedAccountListsText), "Expected 'Account & Lists' message is displayed after sign-in");
    }

    @Test(priority = 2)
    public void myAccountPage() {

        // Wait for the "Hello, " element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement helloTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='nav-link-accountList-nav-line-1']")));

        // Wait for the "Account & Lists" element to be visible
        WebElement accountListsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Account & Lists']")));

        // Get the text of both elements
        String helloText = helloTextElement.getText();
        String accountListsText = accountListsElement.getText();

        // Assert that both elements contain the expected text
        String expectedHelloText = "Hello, ";
        String expectedAccountListsText = "Account & Lists";

        Assert.assertTrue(helloText.contains(expectedHelloText), "Expected 'Hello' message is displayed after sign-in");
        Assert.assertTrue(accountListsText.contains(expectedAccountListsText), "Expected 'Account & Lists' message is displayed after sign-in");

        performHoverAndClickYourAccount();

        // Wait for the "Your Account" page title to be visible
        WebElement yourAccountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Your Account']")));
        String yourAccountText = yourAccountElement.getText();
        String expectedYourAccountText = "Your Account";

        Assert.assertTrue(yourAccountText.contains(expectedYourAccountText), "Expected 'Your Account' text");

        // You can add more assertions or actions related to the Your Account page
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
