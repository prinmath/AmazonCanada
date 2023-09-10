package testCases;

import java.time.Duration;
import java.util.List;

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

public class YourOrdersTest extends TestBase {
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
        
        performHoverAndClickYourOrders();

    }

    @Test(priority = 1)
    public void orderHistoryPage() {
        // Wait for the "Your Orders " element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
     // Locate the "Orders placed in" drop-down menu
        WebElement ordersPlacedInDropdown = driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]"));

        // Click on the drop-down menu to open it
        ordersPlacedInDropdown.click();

        // Wait for the drop-down options to be visible
        List<WebElement> dropdownOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("the past 30 days")));

        // Define the expected past order options
        String[] expectedOptions = {"the past 30 days", "past 3 months", "2023", "Archived Orders"};

        // Verify that each past order option is visible and contains the expected text
        for (int i = 0; i < expectedOptions.length; i++) {
            // You can use try-catch to handle cases where an option might not be present
            try {
                WebElement optionElement = dropdownOptions.get(i);
                String optionText = optionElement.getText();
                Assert.assertTrue(optionText.contains(expectedOptions[i]), "Expected past order option is visible: " + expectedOptions[i]);
            } catch (IndexOutOfBoundsException e) {
                // Handle the case where the option is not found
                System.out.println("Past order option not found: " + expectedOptions[i]);
            }
        }
    }


    @Test(priority = 2)
    public void buyAgainPage() {
    	
    	// Wait for the "Buy Again" element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));       
        WebElement buyAgainElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Buy Again")));
        
        buyAgainElement.click();
        
        WebElement recommendedItemsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'There are no recommended items for you to buy agai')]")));
        
        // Get the text of the element
        String recommendedItemsText = recommendedItemsElement.getText();
        
        // Assert that element contains the expected text
        String expectedRecommendedItemsText = "There are no recommended items for you to buy agai";
        Assert.assertTrue(recommendedItemsText.contains(expectedRecommendedItemsText), "Expected 'There are no recommended items for you to buy agai' title is displayed");
                 
    }
    
    
    @Test(priority = 3)
    public void notYetShippedPage() {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        
        WebElement notYetShippedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Not Yet Shipped")));
        
        notYetShippedElement.click();
        
        
        WebElement unshippedOrdersElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ordersContainer\"]/div[1]/div/a")));
        
        // Get the text of the element
        String unshippedOrdersText = unshippedOrdersElement.getText();
        
        // Assert that element contains the expected text
        String expectedUnshippedOrdersText = "View all orders";
        Assert.assertTrue(unshippedOrdersText.contains(expectedUnshippedOrdersText), "Expected 'View all orders' text is displayed");
                 
    }
     
    @Test(priority = 4)
    public void cancelledOrdersPage() {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        
        WebElement cancelledOrdersElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cancelled Orders")));
        
        cancelledOrdersElement.click();
        
        
        WebElement viewCancelledOrdersElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ordersContainer\"]/div[1]/div/a")));
        
        // Get the text of the element
        String viewCancelledOrdersText = viewCancelledOrdersElement.getText();
        
        // Assert that element contains the expected text
        String expectedViewCancelledOrdersText = "View all orders";
        Assert.assertTrue(viewCancelledOrdersText.contains(expectedViewCancelledOrdersText), "Expected 'View all orders' text is displayed");
                 
    }
    
     @AfterMethod
     public void tearDown() {
        driver.quit();
    }

    public void performHoverAndClickYourOrders() {
        WebElement elementToHover = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
        WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"nav_prefetch_yourorders\"]/span"));

        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover)
                .click(elementToClick)
                .build()
                .perform();
    }
}
