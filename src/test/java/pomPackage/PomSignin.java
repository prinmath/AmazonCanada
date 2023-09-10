package pomPackage;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.TestBase;

public class PomSignin extends TestBase {

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement accountLink;

    @FindBy(className = "nav-action-inner")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signInSubmit']")   
    private WebElement signInSubmitButton;
    
    private WebDriverWait wait;

    public PomSignin() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToHomepage() {
        wait.until(ExpectedConditions.urlToBe(getProperty("url")));
        System.out.println("Navigated to homepage.");
    }

    public void performHoverAndClick() {
        Actions actions = new Actions(driver);

        // Wait for accountLink to be visible before hovering
        wait.until(ExpectedConditions.visibilityOf(accountLink));
        System.out.println("Hovering over accountLink.");

        // Hover over accountLink and click signInButton
        actions.moveToElement(accountLink)
               .moveToElement(signInButton)
               .click()
               .build()
               .perform();
        System.out.println("Performed hover and click.");
    }

    public void enterUsername(String username) {
        // Wait for emailField to be visible
        wait.until(ExpectedConditions.visibilityOf(emailField));
        System.out.println("Entering username: " + username);

        // Clear any pre-filled content
        emailField.clear();

        // Option 1: Click, sendKeys, and press Enter
        emailField.click();
        emailField.sendKeys(username);
        emailField.sendKeys(Keys.RETURN);

        // No need to wait for continueButton on the new page
        System.out.println("Clicked Enter on emailField.");    
   
    }
    
    public void enterPassword(String password) {
        // Wait for passwordField to be visible
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        System.out.println("Entering password.");

        // Clear the field and enter the password
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInSubmit() {
        // Wait for signInSubmitButton to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(signInSubmitButton));
        System.out.println("Clicking signInSubmitButton.");

        // Click the signInSubmitButton
        signInSubmitButton.click();
        System.out.println("signInSubmitButton clicked.");
    }
    
    public void clickContinueButton() {
        // Wait for signInSubmitButton to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        System.out.println("Clicking continueButton.");

        // Click the signInSubmitButton
        continueButton.click();
        System.out.println("continueButton clicked.");
    }

    // Add other methods for additional interactions
}
