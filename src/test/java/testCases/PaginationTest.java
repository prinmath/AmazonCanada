package testCases;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.TestBase;
import pomPackage.PomSignin;

public class PaginationTest extends TestBase{
	
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
    public void paginationWithoutDuplicates() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the search bar by its attribute, for example, the "id" attribute
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
        searchBar.clear();
        String inputText = "umbrella";
        searchBar.sendKeys(inputText);
        searchBar.sendKeys(Keys.RETURN);

        // Create a set to store product identifiers on page 1
        Set<String> productIdentifiersPage1 = new HashSet<>();

        // Collect product names or identifiers on the first page
        List<WebElement> productElementsPage1 = driver.findElements(By.xpath("//input[contains(@id,'umbrella)]"));

        // Populate the set with product identifiers from page 1
        for (WebElement productElement : productElementsPage1) {
            String productIdentifier = productElement.getText(); //String productIdentifier = productElement.findElement(By.cssSelector("span.product-identifier-class")).getText();

            productIdentifiersPage1.add(productIdentifier);
        }

        // Click on the "Next Page" button to navigate to page 2 (adjust locator as needed)
        WebElement nextPageButton = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[67]/div/div/span/a[3]"));
        nextPageButton.click();

        // Collect product names or identifiers on the second page
        List<WebElement> productElementsPage2 = driver.findElements(By.xpath("//input[contains(@id,'umbrella)]"));

        // Check that products from page 1 are not repeated on page 2
        for (WebElement productElement : productElementsPage2) {
            String productIdentifier = productElement.getText(); // Change to your actual identifier retrieval logic
            if (productIdentifiersPage1.contains(productIdentifier)) {
                Assert.fail("Duplicate product found on page 2: " + productIdentifier);
            }
        }
    }

@AfterMethod
public void tearDown() {
	driver.quit();
	
}
}