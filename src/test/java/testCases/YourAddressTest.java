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
import pomPackage.PomSignin;

public class YourAddressTest extends TestBase{
	
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
    public void yourAddressesPage() {
    	
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));       
         WebElement yourAddressesElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/h2")));
         
         yourAddressesElement.click();
         
         WebElement addAddressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add Address")));
         
         // Get the text of the element
         String addAddressText = addAddressElement.getText();
         
         // Assert that element contains the expected text
         String expectedAddAddressText = "Add Address";
         Assert.assertTrue(addAddressText.contains(expectedAddAddressText), "Expected 'Add Address' title is displayed");
    
    }
    
    @Test(priority=2)
    public void validAddAddressPage() {
    	
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));       
         WebElement yourAddressesElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/h2")));
         
         yourAddressesElement.click();
         
         WebElement addAddressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ya-myab-address-add-link\"]/div/div/h2")));
         
         addAddressElement.click();
         
         WebElement addNewAddressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Add a new address']")));
         
		
	     // Get the text of the element 
         String addNewAddressText = addNewAddressElement.getText();
			  			  
		 // Assert that element contains the expected text 
	     String expectedAddNewAddressText = "Add a new address";
		 Assert.assertTrue(addNewAddressText.contains(expectedAddNewAddressText),"Expected 'Add a new address' text is displayed");
		 
		// Locate the country dropdown element
		 WebElement countryDropdownElement = driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode\"]/span/span")); 

		 // Get the text of the selected option
		 String selectedCountry = countryDropdownElement.getText();

		 // Verify that "Canada" is selected
		 String expectedCountry = "Canada";
		 Assert.assertEquals(selectedCountry, expectedCountry, "Expected country 'Canada' is selected");
		 
		// Enter Full name
		 WebElement fullNameField = driver.findElement(By.id("address-ui-widgets-enterAddressFullName"));

		 // Enter any input for Full Name
		 String fullNameInput = "Only Math";
		 fullNameField.sendKeys(fullNameInput);
		 fullNameField.sendKeys(Keys.RETURN);

		 // Enter Phone number
		 WebElement phoneNumberField = driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber"));

		 // Enter any input for Phone Number
		 String phoneNumberInput = "647";
		 phoneNumberField.sendKeys(phoneNumberInput);
		 phoneNumberField.sendKeys(Keys.RETURN);
		 
		 WebElement addressField = driver.findElement(By.id("address-ui-widgets-enterAddressLine1"));

		 // Enter any input for Phone Number
		 String addressInput = "40 Townmansion Drive";
		 addressField.sendKeys(addressInput);
		 addressField.sendKeys(Keys.RETURN);
		 
		 WebElement cityField = driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']"));

		 // Enter any input for Phone Number
		 String cityInput = "Hamilton";
		 cityField.sendKeys(cityInput);
		 cityField.sendKeys(Keys.RETURN);
		 
		// Locate the custom dropdown element and click to open it
		 WebElement dropdown = driver.findElement(By.xpath("//span[@id='address-ui-widgets-enterAddressStateOrRegion']//span[@role='button']"));
		 dropdown.click();

		 // Locate the option you want to select and click it
		 WebElement optionToSelect = driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8\"]"));
		 optionToSelect.click();
		 
		 //Postal code
		 WebElement postalCodeField = driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]"));		 
		 	String postalCodeInput = "L8T 5A7";
		 	postalCodeField.sendKeys(postalCodeInput);
		 	postalCodeField.sendKeys(Keys.RETURN);
		 
		 //Checkbox
		 WebElement defaultAddressCheckboxOption = driver.findElement(By.xpath("//input[@id='address-ui-widgets-use-as-my-default']"));
		 	boolean isdefaultAddressCheckboxOptionPresent = defaultAddressCheckboxOption.isDisplayed();
	        Assert.assertTrue(isdefaultAddressCheckboxOptionPresent, "Default Address Checkbox Option is present");
	        
	     // Locate the element that represents the option to add delivery instructions
	     WebElement deliveryInstructionsOption = driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[3]/label/span"));
	        // Check if the element is present
	        boolean isDeliveryInstructionsOptionPresent = deliveryInstructionsOption.isDisplayed();
	        // Assert that the option is present
	        Assert.assertTrue(isDeliveryInstructionsOptionPresent, "Delivery instructions option is present");
	     //Find and click Submit button  
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='a-button-input']"))).click();
	     //Confirm address saved
	     WebElement addressSavedText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-page\"]/div[1]/div/h1")));
	     	boolean isAddressSavedText = addressSavedText.isDisplayed();
	     	Assert.assertTrue(isAddressSavedText, "Your Addresses");   
    
    }
    
    
    @Test(priority=3)
    public void invalidAddAddressPage() {
    	
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));       
         WebElement yourAddressesElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[3]/div[1]/a/div/div/div/div[2]/h2")));
         
         yourAddressesElement.click();
         
         WebElement addAddressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ya-myab-address-add-link\"]/div/div/h2")));
         
         addAddressElement.click();
         
         WebElement addNewAddressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-page\"]/div[1]/div/div[2]/h2")));
         
		
	     // Get the text of the element 
         String addNewAddressText = addNewAddressElement.getText();
			  			  
		 // Assert that element contains the expected text 
	     String expectedAddNewAddressText = "Add a new address";
		 Assert.assertTrue(addNewAddressText.contains(expectedAddNewAddressText),"Expected 'Add a new address' text is displayed");
		 
		// Locate the country dropdown element
		 WebElement countryDropdownElement = driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-countryCode\"]/span/span")); 

		 // Get the text of the selected option
		 String selectedCountry = countryDropdownElement.getText();

		 // Verify that "Canada" is selected
		 String expectedCountry = "Canada";
		 Assert.assertEquals(selectedCountry, expectedCountry, "Expected country 'Canada' is selected");
		 
		// Enter Full name
		 WebElement fullNameField = driver.findElement(By.id("address-ui-widgets-enterAddressFullName"));

		 // Blank Full Name
		    fullNameField.clear();
	        fullNameField.sendKeys(Keys.RETURN);

	        // Wait for the error message element to be present	       
	        WebElement errorMessageElementFnameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFullName-full-validation-alerts\"]/div/div/div/div")));
	        String errorMessageTextFnameField = errorMessageElementFnameField.getText();
	        Assert.assertTrue(errorMessageTextFnameField.contains("Please enter a name"), "Error message should contain 'Please enter a name'");
		 
	        // Enter Phone number
		 WebElement phoneNumberField = driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber"));

		 // Blank Phone Number
		 	phoneNumberField.clear();
			phoneNumberField.sendKeys(Keys.RETURN); 
			
			WebElement errorMessageElementPhoneField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPhoneNumber-full-validation-alerts\"]/div/div/div/div")));
	        String errorMessageTextPhoneField = errorMessageElementPhoneField.getText();
	        Assert.assertTrue(errorMessageTextPhoneField.contains("Please enter a phone number so we can call if there are any issues with delivery."
	        		+ ""), "Error message should contain 'Please enter a phone number so we can call if there are any issues with delivery."
	        		+ "'");

		 
		 WebElement addressField = driver.findElement(By.id("address-ui-widgets-enterAddressLine1"));

		 	// Blank Address
		 	addressField.clear();
		 	addressField.sendKeys(Keys.RETURN);
		 	
		 	WebElement errorMessageElementAddressField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"address-ui-widgets-enterAddressLine2-full-validation-alerts\"]/div/div/div/div")));
	        String errorMessageTextAddressField = errorMessageElementAddressField.getText();
	        Assert.assertTrue(errorMessageTextAddressField.contains("Please enter an address"), "Error message should contain 'Please enter an address'");
		 
		 
		 WebElement cityField = driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressCity']"));

		 	cityField.clear();
		 	cityField.sendKeys(Keys.RETURN);
		 	WebElement errorMessageElementCityField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"address-ui-widgets-enterAddressCity-full-validation-alerts\"]/div/div/div/div")));
	        String errorMessageTextCityField = errorMessageElementCityField.getText();
	        Assert.assertTrue(errorMessageTextCityField.contains("Please enter a city name"), "Error message should contain 'Please enter a city name'");		 
		 
		 //Postal code
		 WebElement postalCodeField = driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPostalCode\"]"));		 
		 	postalCodeField.clear();
		 	postalCodeField.sendKeys(Keys.RETURN);
		 	WebElement errorMessageElementPostalCodeField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"address-ui-widgets-enterAddressPostalCode-full-validation-alerts\"]/div/div/div/div")));
	        String errorMessageTextPostalCodeField = errorMessageElementPostalCodeField.getText();
	        Assert.assertTrue(errorMessageTextPostalCodeField.contains("Please enter a postal code"), "Error message should contain 'Please enter a postal code'");		 

		 
		 //Checkbox
		 WebElement defaultAddressCheckboxOption = driver.findElement(By.xpath("//input[@id='address-ui-widgets-use-as-my-default']"));
		 	boolean isdefaultAddressCheckboxOptionPresent = defaultAddressCheckboxOption.isDisplayed();
	        Assert.assertTrue(isdefaultAddressCheckboxOptionPresent, "Default Address Checkbox Option is present");
	        
	     // Locate the element that represents the option to add delivery instructions
	     WebElement deliveryInstructionsOption = driver.findElement(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[3]/label/span"));
	        // Check if the element is present
	        boolean isDeliveryInstructionsOptionPresent = deliveryInstructionsOption.isDisplayed();
	        // Assert that the option is present
	        Assert.assertTrue(isDeliveryInstructionsOptionPresent, "Delivery instructions option is present");
	     //Find and click Submit button  
	     
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='a-button-input']"))).click();
	     
	        //Confirming the error message showing 'Please enter a name' again after clicking Add Address button
	     WebElement errorMessageElementFnameFieldAgain = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"address-ui-widgets-enterAddressFullName-full-validation-alerts\"]/div/div/div/div")));
	        String errorMessageTextFnameFieldAgain = errorMessageElementFnameFieldAgain.getText();
	        Assert.assertTrue(errorMessageTextFnameFieldAgain.contains("Please enter a name"), "Error message should contain 'Please enter a name'");

	        	         
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
