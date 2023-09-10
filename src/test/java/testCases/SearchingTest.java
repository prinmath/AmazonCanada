package testCases;

import java.time.Duration;
import java.util.List;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.TestBase;
import pomPackage.PomSignin;

public class SearchingTest extends TestBase{
	
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
	    
	    @Test(priority=1)
	    public void searchFacility() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));

	        // Check if the search bar is visible
	        boolean isSearchBarVisible = searchBar.isDisplayed();

	        // Assert that the search bar is displayed
	        Assert.assertTrue(isSearchBarVisible);
	    }
	    
	    @Test(priority = 2)
	    public void keywordSearch() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
	        searchBar.clear();
	        String inputText = "shoes";
	        searchBar.sendKeys(inputText);
	        searchBar.sendKeys(Keys.RETURN);

	        // Wait for the search results to load
	        WebElement searchResultsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2']//span[@class='a-size-base-plus a-color-base a-text-normal']")));

	     // Locate and interact with elements that represent the search results
	        List<WebElement> searchResultItems = searchResultsContainer.findElements(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2']//span[@class='a-size-base-plus a-color-base a-text-normal']")); // Adjust the locator as per your specific HTML structure

	        // Verify that at least one search result contains the keyword "shoes"
	        boolean isKeywordFound = false;
	        for (WebElement searchResult : searchResultItems) {
	            String productTitle = searchResult.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2']//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();
	            if (productTitle.toLowerCase().contains(inputText.toLowerCase())) {
	                isKeywordFound = true;
	                break; // If a result contains the keyword, set the flag to true and exit the loop
	            }
	        }

	        // Assert that at least one search result contains the keyword "shoes"
	        Assert.assertTrue("Search results contain products related to 'shoes'", isKeywordFound);

	    }
	    
	    @Test(priority = 3)
	    public void partialKeywordSearch() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
	        searchBar.clear();
	        String inputText = "head";
	        searchBar.sendKeys(inputText);
	        searchBar.sendKeys(Keys.RETURN);

	        // Wait for the search results to load
	        WebElement searchResultsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_5']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span[1]")));

	     // Locate and interact with elements that represent the search results
	        List<WebElement> searchResultItems = searchResultsContainer.findElements(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_5']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span[1]"));

	        // Verify that at least one search result contains the keyword "shoes"
	        boolean isKeywordFound = false;
	        for (WebElement searchResult : searchResultItems) {
	            String productTitle = searchResult.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_5']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']//span[1]")).getText();
	            if (productTitle.toLowerCase().contains(inputText.toLowerCase())) {
	                isKeywordFound = true;
	                break; // If a result contains the keyword, set the flag to true and exit the loop
	            }
	        }

	        // Assert that at least one search result contains the keyword "shoes"
	        Assert.assertTrue("Search results contain products related to 'head'", isKeywordFound);

	    }  
	    
	    
	    @Test(priority = 4)
	    public void descriptionTextSearch() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
	        searchBar.clear();
	        String inputText = "wireless headphone";
	        searchBar.sendKeys(inputText);
	        searchBar.sendKeys(Keys.RETURN);

	        // Wait for the search results to load
	        WebElement searchResultsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-base-plus a-color-base a-text-normal']")));

	     // Locate and interact with elements that represent the search results
	        List<WebElement> searchResultItems = searchResultsContainer.findElements(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-base-plus a-color-base a-text-normal']"));

	        // Verify that at least one search result contains the keyword "shoes"
	        boolean isKeywordFound = false;
	        for (WebElement searchResult : searchResultItems) {
	            String productTitle = searchResult.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-size-base-plus a-color-base a-text-normal']")).getText();
	            if (productTitle.toLowerCase().contains(inputText.toLowerCase())) {
	                isKeywordFound = true;
	                break; // If a result contains the keyword, set the flag to true and exit the loop
	            }
	        }

	        // Assert that at least one search result contains the keyword "shoes"
	        Assert.assertTrue("Search results contain products related to 'wireless headphone'", isKeywordFound);

	    }  
  
	    
	    @Test(priority = 4)
	    public void itemNumberSearch() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
	        searchBar.clear();
	        String inputText = "12345";
	        searchBar.sendKeys(inputText);
	        searchBar.sendKeys(Keys.RETURN);

	        // Wait for the search results to load
	        WebElement searchResultsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[8]/div/div/div/div/div[2]/div[1]/h2/a/span")));

	     // Locate and interact with elements that represent the search results
	        List<WebElement> searchResultItems = searchResultsContainer.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[8]/div/div/div/div/div[2]/div[1]/h2/a/span"));

	        // Verify that at least one search result contains the keyword "shoes"
	        boolean isKeywordFound = false;
	        for (WebElement searchResult : searchResultItems) {
	            String productTitle = searchResult.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[8]/div/div/div/div/div[2]/div[1]/h2/a/span")).getText();
	            if (productTitle.toLowerCase().contains(inputText.toLowerCase())) {
	                isKeywordFound = true;
	                break; // If a result contains the keyword, set the flag to true and exit the loop
	            }
	        }

	        // Assert that at least one search result contains the keyword "shoes"
	        Assert.assertTrue("Search results contain products related to '12345'", isKeywordFound);

	    }    
	    

	    @Test(priority = 5)
	    public void partialItemNumberSearch() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
	        searchBar.clear();
	        String inputText = "345";
	        searchBar.sendKeys(inputText);
	        searchBar.sendKeys(Keys.RETURN);

	        // Wait for the search results to load
	        WebElement searchResultsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[6]/div/div/div/div/div[2]/div[1]/h2")));

	     // Locate and interact with elements that represent the search results
	        List<WebElement> searchResultItems = searchResultsContainer.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[6]/div/div/div/div/div[2]/div[1]/h2"));

	        // Verify that at least one search result contains the keyword "shoes"
	        boolean isKeywordFound = false;
	        for (WebElement searchResult : searchResultItems) {
	            String productTitle = searchResult.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[6]/div/div/div/div/div[2]/div[1]/h2")).getText();
	            if (productTitle.toLowerCase().contains(inputText.toLowerCase())) {
	                isKeywordFound = true;
	                break; // If a result contains the keyword, set the flag to true and exit the loop
	            }
	        }

	        // Assert that at least one search result contains the keyword "shoes"
	        Assert.assertTrue("Search results contain products related to '345'", isKeywordFound);

	    }    

	    
	    @Test(priority = 6)
	    public void categoryKeywordSearch() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
	        searchBar.clear();
	        String inputText = "electronics";
	        searchBar.sendKeys(inputText);
	        searchBar.sendKeys(Keys.RETURN);

	        // Wait for the search results to load
	        WebElement searchResultsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div[3]/div[1]/h2/a/span")));

	     // Locate and interact with elements that represent the search results
	        List<WebElement> searchResultItems = searchResultsContainer.findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div[3]/div[1]/h2/a/span"));

	        // Verify that at least one search result contains the keyword "shoes"
	        boolean isKeywordFound = false;
	        for (WebElement searchResult : searchResultItems) {
	            String productTitle = searchResult.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div[3]/div[1]/h2/a/span")).getText();
	            if (productTitle.toLowerCase().contains(inputText.toLowerCase())) {
	                isKeywordFound = true;
	                break; // If a result contains the keyword, set the flag to true and exit the loop
	            }
	        }

	        // Assert that at least one search result contains the keyword "shoes"
	        Assert.assertTrue("Search results contain products related to 'electronics'", isKeywordFound);

	    } 
	    
	    @Test(priority = 7)
	    public void searchResultsPage() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
	        searchBar.clear();
	        String inputText = "camera";
	        searchBar.sendKeys(inputText);
	        searchBar.sendKeys(Keys.RETURN);
	        
	     // Wait for the Search Results Page (SRP) to load
	        WebElement srpHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]")));

	        // Verify that the SRP header is displayed, indicating the user is on the SRP
	        Assert.assertTrue(srpHeader.isDisplayed()); 
	    
	    }
	    
	    
	    @Test(priority = 8)
	    public void searchResultsPageRelevantItems() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
	        searchBar.clear();
	        String inputText = "Umbrella";
	        searchBar.sendKeys(inputText);
	        searchBar.sendKeys(Keys.RETURN);
	        
	     // Wait for the Search Results Page (SRP) to load
	        WebElement srpHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]")));

	        // Verify that the SRP header is displayed, indicating the user is on the SRP
	        Assert.assertTrue(srpHeader.isDisplayed()); 
	        
	        // Wait for the search results to load
	        WebElement searchResultsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='rush-component s-featured-result-item s-expand-height']//span[@class='a-size-base-plus a-color-base a-text-normal'][normalize-space()='Automatic Small Compact Travel Umbrella - Black']")));

	        // Locate and interact with elements that represent the search results
	        List<WebElement> searchResultItems = searchResultsContainer.findElements(By.xpath("//div[@class='rush-component s-featured-result-item s-expand-height']//span[@class='a-size-base-plus a-color-base a-text-normal'][normalize-space()='Automatic Small Compact Travel Umbrella - Black']"));

	    
	        // Verify that at least one search result contains the keyword "shoes"
	        boolean isKeywordFound = false;
	        for (WebElement searchResult : searchResultItems) {
	            String productTitle = searchResult.findElement(By.xpath("//div[@class='rush-component s-featured-result-item s-expand-height']//span[@class='a-size-base-plus a-color-base a-text-normal'][normalize-space()='Automatic Small Compact Travel Umbrella - Black']")).getText();
	            if (productTitle.toLowerCase().contains(inputText.toLowerCase())) {
	                isKeywordFound = true;
	                break; // If a result contains the keyword, set the flag to true and exit the loop
	            }
	        }

	        // Assert that at least one search result contains the keyword "shoes"
	        Assert.assertTrue("Search results contain products related to 'umbrella'", isKeywordFound);

	    
	    }    
	    
	    
	    @Test(priority = 9)
	    public void searchedProductImage() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
	        searchBar.clear();
	        String inputText = "umbrella";
	        searchBar.sendKeys(inputText);
	        searchBar.sendKeys(Keys.RETURN);
	        
	     // Wait for the Product name to load
	        WebElement productImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Sponsored Ad – Amazon Basics Automatic Small Compact Travel Umbrella - Black']")));

	        // Verify that the product name is displayed
	        Assert.assertTrue(productImage.isDisplayed()); 
	    
	    } 
	    
	
	    @Test(priority = 10)
	    public void searchedProductName() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
	        searchBar.clear();
	        String inputText = "umbrella";
	        searchBar.sendKeys(inputText);
	        searchBar.sendKeys(Keys.RETURN);
	        
	     // Wait for the Product name to load
	        WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='rush-component s-featured-result-item s-expand-height']//span[@class='a-size-base-plus a-color-base a-text-normal'][normalize-space()='Automatic Small Compact Travel Umbrella - Black']")));

	        // Verify that the product name is displayed
	        Assert.assertTrue(productName.isDisplayed()); 
	    
	    } 
	    
	    
	    @Test(priority = 11)
	    public void searchedProductPrice() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
	        searchBar.clear();
	        String inputText = "umbrella";
	        searchBar.sendKeys(inputText);
	        searchBar.sendKeys(Keys.RETURN);
	        
	     // Wait for the Product price to load
	        WebElement productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//span[@class='a-price-whole']")));

	        // Verify that the product price is displayed
	        Assert.assertTrue(productPrice.isDisplayed()); 
	    
	    } 
	    
	    
	    @Test(priority = 12)
	    public void searchedProductRatingsReviews() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
	        searchBar.clear();
	        String inputText = "umbrella";
	        searchBar.sendKeys(inputText);
	        searchBar.sendKeys(Keys.RETURN);
	        
	     // Wait for the Product rating to load
	        WebElement productRating = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom']")));

	        // Verify that the product rating is displayed
	        Assert.assertTrue(productRating.isDisplayed()); 
	        
	     // Wait for product listings to load (modify locator as needed)
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='rush-component s-featured-result-item s-expand-height']//span[@class='a-size-base-plus a-color-base a-text-normal'][normalize-space()='Automatic Small Compact Travel Umbrella - Black']")));

	        // Find all product listings on the page (modify locator as needed)
	        List<WebElement> productListings = driver.findElements(By.xpath("//div[@class='rush-component s-featured-result-item s-expand-height']//span[@class='a-size-base-plus a-color-base a-text-normal'][normalize-space()='Automatic Small Compact Travel Umbrella - Black']"));
	        
	        // Loop through each product listing to verify the presence of reviews
	        for (WebElement productListing : productListings) {
	            // Locate the element that displays the number of reviews (modify locator as needed)
	            WebElement reviewsElement = productListing.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div[3]/div[2]/div[1]/span[2]/a/span"));

	            // Verify that the reviews element is displayed and contains a number
	            Assert.assertTrue("Reviews element is displayed", reviewsElement.isDisplayed());
	            String reviewsText = reviewsElement.getText();
	            Assert.assertTrue("Number of reviews is displayed", !reviewsText.isEmpty());
	        }
	    
	    } 
	    @Test(priority = 13)
	    public void numberOfProductsPerPage() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Locate the search bar by its attribute, for example, the "id" attribute
	        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")));
	        searchBar.clear();
	        String inputText = "umbrella";
	        searchBar.sendKeys(inputText);
	        searchBar.sendKeys(Keys.RETURN);
	        
        // Wait for the Product listings to load (modify locator as needed)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]")));

        // Find all product listings on the page (modify locator as needed)
        List<WebElement> productListings = driver.findElements(By.xpath("//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]"));

        // Get the count of displayed products
        int displayedProductCount = productListings.size();

        // Verify that the number of displayed products is 60 by default
        int expectedProductCount = 60;
        Assert.assertEquals(displayedProductCount, expectedProductCount);
    }
	    
	    
	    @AfterMethod
	    public void tearDown() {
	    	driver.quit();
	    }
}
