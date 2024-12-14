package pages;

import java.awt.datatransfer.SystemFlavorMap;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificationMethod;

public class RegisterPage extends ProjectSpecificationMethod {

	
	public RegisterPage (WebDriver driver) {
		this.driver=driver;
	}
	
	public RegisterPage signFirstName(String afirstname) {
		
		driver.findElement(By.id("username")).sendKeys(afirstname);
		System.out.println("the username entered");
		return this;
		
	}
	
	public RegisterPage signPassword(String apassword) {
		
		driver.findElement(By.id("password")).sendKeys(apassword);
		System.out.println("the password entered");
		return this;
	}
	
     public RegisterPage signRePassword(String arepassword) {
		
		driver.findElement(By.id("re_password")).sendKeys(arepassword);
		System.out.println("the repassword entered");
		return this;
	}
     
     public RegisterPage signFullName(String signfullname) throws InterruptedException {
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
 		
 		driver.findElement(By.id("full_name")).sendKeys(signfullname);
 		System.out.println("The full name entered");
 		return this;
 	}
     public RegisterPage signEmailId(String signemail) {
  		
  		driver.findElement(By.id("email_add")).sendKeys(signemail);
  		System.out.println("the email entered");
  		return this;
  	}
     
     public RegisterPage signCheckBox() {
    	 
    	 WebElement checkbox = driver.findElement(By.id("tnc_box"));
    	 checkbox.click();
    	 System.out.println("the clicked the cleckbox");
		return this;
    	 
     }
	public RegisterPage signRegisterButton() {
		
		driver.findElement(By.id("Submit")).click();
		return this;
		
	}
	public RegisterPage registerValidation() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    
	    try {
	        // Wait for presence of the element first, then check visibility
	        WebElement loginLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Click here to login')]")));
	        wait.until(ExpectedConditions.visibilityOf(loginLink));

	        // Get the actual text from the link
	        String actualText = loginLink.getText();
	        
	        // Define the expected text
	        String expectedText = "Click here to login";

	        // Print both actual and expected text for debugging
	        System.out.println("Expected text: " + expectedText);
	        System.out.println("Actual text: " + actualText);

	        // Assert that the actual text matches the expected text
	        if (actualText.equals(expectedText)) {
	            System.out.println("The text matches as expected.");
	        } else {
	            System.out.println("The text does not match. Expected: " + expectedText + ", but found: " + actualText);
	            throw new AssertionError("The actual text does not match the expected text.");
	        }
	    } catch (TimeoutException e) {
	        System.err.println("Timeout while waiting for 'Click here to login' link: " + e.getMessage());
	    }

	    return this;
	}

}
