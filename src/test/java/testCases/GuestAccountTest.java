package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import basePackage.TestBase;
public class GuestAccountTest extends TestBase{
	
    @Test(priority = 1)
    public void navigateAsGuest() {
        initialization(); // Initialize the WebDriver and navigate to Amazon
        // Verify that Amazon.ca homepage is open and products are displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        WebElement productsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='hm-icon nav-sprite']")));
        productsSection.click();
                     
        WebElement bestSellers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='hmenu hmenu-visible']//a[@class='hmenu-item'][normalize-space()='Best Sellers']")));
        bestSellers.click();
        WebElement productFireTvStick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Fire TV Stick 4K streaming device with Alexa Voice Remote (includes TV controls), Dolby Vision']")));
        Assert.assertTrue(productFireTvStick.isDisplayed(), "Amazon.ca homepage is open, and best sellers are displayed");
            
       
    }

    @Test(priority = 2)
    public void buyAsGuest() {
        initialization(); // Initialize the WebDriver and navigate to Amazon

        // Verify that Amazon.ca homepage is open and products are displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='hm-icon nav-sprite']")));
        productsSection.click();

        WebElement bestSellers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='hmenu hmenu-visible']//a[@class='hmenu-item'][normalize-space()='Best Sellers']")));
        bestSellers.click();
        WebElement productFireTvStick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Fire TV Stick 4K streaming device with Alexa Voice Remote (includes TV controls), Dolby Vision']")));
        productFireTvStick.click();
        WebElement productFireTvStickDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='productTitle']")));
        Assert.assertTrue(productFireTvStickDetails.isDisplayed(), "Product details page is displayed");

        WebElement productFireTvStickAddToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));
        productFireTvStickAddToCart.click();

        // Switch to the alert window if present
		/* System.out.println("Before switching to alert"); */
		/*
		 * try {
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
		 * "#a-popover-header-3")));
		 * 
		 * // Wait for a longer time before checking for the alert WebDriverWait
		 * alertWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 * alertWait.until(ExpectedConditions.alertIsPresent());
		 * 
		 * // Switch to the alert dialog Alert alert = driver.switchTo().alert();
		 * 
		 * // Accept (No thanks) button (equivalent to clicking OK) alert.accept();
		 * 
		 * System.out.println("Alert accepted");
		 * 
		 * // Switch back to the main window driver.switchTo().defaultContent(); } catch
		 * (NoAlertPresentException e) { System.out.println("Alert was not present"); //
		 * Alert was not present, continue with the test }
		 */

        WebElement productFireTvStickAddedToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")));
        Assert.assertTrue(productFireTvStickAddedToCart.isDisplayed(), "Product 'Added to cart' text is displayed");
        
        //Proceed to Checkout button
        WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input")));
        proceedToCheckoutButton.click();
        
        WebElement guestCheckoutOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Checkout as a guest')]")));
        Assert.assertTrue(guestCheckoutOption.isDisplayed(), "Option to checkout as guest is present");
        
    }
    
    @AfterMethod
    public void tearDown() {
	driver.quit();
}
	
}
