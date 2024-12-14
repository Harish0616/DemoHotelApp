package pages;

import java.nio.channels.SelectableChannel;
import java.time.Duration;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.AddHasCasting;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;
import org.testng.Assert;

import base.ProjectSpecificationMethod;

public class LoginPage extends ProjectSpecificationMethod {
	@FindBy(id="username")
	WebElement userid;
	
	@FindBy(id="password")
	WebElement passid;
	
	@FindBy(id="datepick_in")
	WebElement cidate;
	
	@FindBy(id="datepick_out")
	WebElement codate;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="last_name")
	WebElement lastname;
	
	@FindBy(id="address")
	WebElement address;
	
	@FindBy(id="cc_num")
	WebElement ccnum;
	
	@FindBy(id="cc_cvv")
	WebElement cccvv;
	
	

	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage isUserName(String userid) {
		driver.findElement(By.id("username")).sendKeys(userid);
		return this;
		
	}
	
	public LoginPage isPassword(String passid) {
		driver.findElement(By.id("password")).sendKeys(passid);
		return this;
	}
	
	public LoginPage loginButton() {
		driver.findElement(By.id("login")).click();
		System.out.println("The Login Button Successfully Clicked");
		return this;
	}
	
    
	public  LoginPage ValidateLoginResult(String testCase , String expected) {
				
			 if (testCase.equals("ValidEmailandValidPassword")) {
		            // Locate the input field and retrieve its value
		            WebElement userIdField = driver.findElement(By.xpath("//input[@id='username_show']")); // Assuming you want to locate by ID
		            String actualId = userIdField.getAttribute("value"); // Use getAttribute to get the value of input
		            System.out.println("The actual value is: " + actualId);

		            // Validate the retrieved value against expected
		            if (expected.equalsIgnoreCase(actualId)) {
		                System.out.println("Login Successful");
		            } else {
		                System.out.println("Login Failed");
		            }

		        } else if (testCase.equals("ValidEmailandInValidPassword")) {
		            // Locate the error message element and retrieve its text
		            String actualErrorMessage = driver.findElement(By.xpath("//b[contains(text(), 'Invalid Login details')]")).getText();
		            System.out.println("The actual error message is: " + actualErrorMessage);

		            // Validate the error message against expected
		            if (expected.equalsIgnoreCase(actualErrorMessage)) {
		                System.out.println("Test Passed");
		            } else {
		                System.out.println("Test Failed");
		            }
		        }

		        return this; // Returning this for method chaining if needed
		    
		}
	
		 public void sendKeysMethod(WebElement ele, String input) {
				ele.sendKeys(input);
			}
	//   //span[contains(text(),'Login was unsuccessful.')]
//	public LoginPage  isValidateLogin() {
//		 try {
//		        // Initialize WebDriverWait with a timeout of 30 seconds
//		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		        
//		        // Define the expected title
//		        String expectedTitle = "Hello Harishscar!";
//		        
//		        // Wait for the element to be present and retrieve its text
//		        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='username_show']")));
//		        
//		        // Retrieve the actual title of the web page
//		        String actualTitle = usernameElement.getText();
//		        
//		        // Assert that the actual title equals the expected title
//		        Assert.assertEquals(actualTitle, expectedTitle, "The actual title does not match the expected title");
//		        
//		        System.out.println("The actual Title is: " + actualTitle);
//		    } catch (Exception e) {
//		        // Print an error message
//		        System.out.println("An error occurred: " + e.getMessage());
//		    }
//		    return this;
//	}
	
	//HotelLocation
	public LoginPage isHotelLocation(){
		
		//Select the location
		
		WebElement locationEle =driver.findElement(By.id("location"));
		
		//initilize the select class
		
		Select locate =new Select(locationEle);
		locate.selectByValue("London");
		return this;
	}
	//Select the hotel
	public LoginPage isSelectHotels() {
		
		//select the location
		
		WebElement hoteleEle =driver.findElement(By.id("hotels"));
		
		Select hotel = new Select(hoteleEle);
		
		hotel.selectByValue("Hotel Sunshine");
		
		return this;
	}
	// postive select the roomtype
	public LoginPage isSelectRoomType() {
		
	WebElement roomEle =driver.findElement(By.id("room_type"));
		
		Select hotel = new Select(roomEle);
		
		hotel.selectByValue("Double");
		return this;
		
	}
	
	
	//select n number of rows
	public LoginPage isSelectNumberOfRooms() {
		
		WebElement noofrooms =driver.findElement(By.id("room_nos"));
			
			Select hotel = new Select(noofrooms);
			
			hotel.selectByValue("3");
			return this;
			
		}
	
	//Negative Select the number of rows
    public LoginPage isNoSelectofRooms() {
		
    	  WebElement noOfRooms = driver.findElement(By.id("room_nos"));
    	    Select hotel = new Select(noOfRooms);

    	    // Check if the dropdown has options before selecting
    	    if (hotel.getOptions().size() > 0) {
    	        hotel.selectByVisibleText("- Select Number of Rooms -");
    	    } else {
    	        System.out.println("No options available in the dropdown.");
    	    }
    	    
    	    return this;
			
		}
	
	//Enter the checkindate
	public LoginPage isCheckInDate(String cidate) {
		
		WebElement checkindate =driver.findElement(By.id("datepick_in"));
		
		checkindate.clear();
		checkindate.sendKeys(cidate);
		return this;
		
	}
	//Enter the checkoutdate
		public LoginPage isCheckOutDate(String codate) {
			
			WebElement checkoutdate =driver.findElement(By.id("datepick_out"));
			
			checkoutdate.clear();
			checkoutdate.sendKeys(codate);
			return this;
			
		}
		
		//Enter the select the date
		public LoginPage isSelectAdultPerRoom() {
			
			WebElement adultperoom =driver.findElement(By.id("adult_room"));
				
				Select perroom = new Select(adultperoom);
				
				perroom.selectByValue("4");
				return this;
				
	   }
		
		//Negative Select the Adult number of rows
	    public LoginPage isNoSelectofAdultRooms() {
			
	    	  WebElement noOfAdultRooms = driver.findElement(By.id("adult_room"));
	    	    Select hotel = new Select(noOfAdultRooms);

	    	    // Check if the dropdown has options before selecting
	    	    if (hotel.getOptions().size() > 0) {
	    	        hotel.selectByVisibleText("- Select Adults per Room -");
	    	    } else {
	    	        System.out.println("No options available in the dropdown.");
	    	    }
	    	    
	    	    return this;
				
			}
		
		//click the submit button
		public LoginPage isSubmitButton() {
			
			driver.findElement(By.id("Submit")).click();
			System.out.println("The Successfully submit button");
			return this;
			
		}
		
		//search click the Radio Button
		public LoginPage clickRadioButton() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.id("radiobutton_0")).click();
			return this;
			
		}
		
		//click the continue button
		public LoginPage clickContinueButton() {
			driver.findElement(By.id("continue")).click();
			System.out.println("the Succesfully clicked the continue button");
			return this;
			
		}
		
		//verified the Navigate page throw 
		public LoginPage vadidateBookaHotel() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			String expectedTitle = "Book A Hotel ";
			
			WebElement actualTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), 'Book A Hotel')]")));
			
			actualTitle.getText();
			Assert.assertEquals(expectedTitle, expectedTitle,"The expected Title not get");
			System.out.println("The actualtitle"+actualTitle);
		   return this;
			
		}
		
		//Enter the firstname
		public LoginPage bookFirstName(String firstname) {
			  driver.findElement(By.id("first_name")).sendKeys(firstname);
			   System.out.println("first name Entered");
			return this;
			
		}
		
		//Enter the lastname
				public LoginPage bookLastName(String lastname) {
					driver.findElement(By.id("last_name")).sendKeys(lastname);
					System.out.println("last name entered");
					return this;
					
				}
				
		//enter the address 
				public LoginPage bookEnterAddress(String address) {
					driver.findElement(By.id("address")).sendKeys(address);
					System.out.println("address");
					return this;
					
				}
		//Enter the 16 Digid credit card
				public LoginPage bookCreditCard(String ccnum) {
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					driver.findElement(By.id("cc_num")).sendKeys(ccnum);
					System.out.println("creditcard");
					return this;
					
				}
				
	  //Select the 	Payment options id-cc_type
				public LoginPage bookPaymentOptions() {
//					WebElement cardoption =driver.findElement(By.id("cc_type"));
//					
//					Select option = new Select(cardoption);
//					
//					option.selectByValue("Master Card");
//					System.out.println("payment option");
//					return this;
					try {
			            // Initialize WebDriverWait with a timeout of 30 seconds
			            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			            
			            // Wait for the card option dropdown to be present
			            WebElement cardOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cc_type")));
			            
			            // Create a Select object
			            Select option = new Select(cardOption);
			            
			            // Select "Master Card" by visible text or value
			            option.selectByVisibleText("Master Card"); // Use selectByVisibleText for better clarity
			            
			            System.out.println("Payment option selected: Master Card");
			        } catch (Exception e) {
			            System.out.println("The specified payment option could not be found: " + e.getMessage());
			        } 
			        return this;
					
				}

				//select the expiry month
				public LoginPage bookExpiryDate() {
                     
//					WebElement expirydate =driver.findElement(By.id("cc_exp_month"));
//					
//					Select option = new Select(expirydate);
//					
//					option.selectByValue("April");
//					System.out.println("expiry date");
//					return this;
					try {
			            // Initialize WebDriverWait with a timeout of 30 seconds
			            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			            
			            // Wait for the expiry date dropdown to be present
			            WebElement expiryDateDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cc_exp_month")));
			            
			            // Create a Select object
			            Select option = new Select(expiryDateDropdown);
			            
			            // Select "April" by visible text or by value
			            option.selectByVisibleText("April"); // Use selectByVisibleText for clarity
			            
			            System.out.println("Expiry date selected: April");
			        } catch (Exception e) {
			            System.out.println("The specified expiry date could not be found: " + e.getMessage());
			        }
					return this;
					
				}
				
				//select the expiry month
				public LoginPage bookYear() {
                     
					WebElement selectyear =driver.findElement(By.id("cc_exp_year"));
					
					Select option = new Select(selectyear);
					
					option.selectByValue("2027");
					System.out.println("bookyear");
					return this;
					
				}
				
				//Enter the cv number 
				public LoginPage bookCvvNumber(String cccvv) {
					
					driver.findElement(By.id("cc_cvv")).sendKeys(cccvv);
					System.out.println("cv three digits");
					return this;
					
				}
				
				//click the submit button
				
				public LoginPage bookSubmitButton() {
					
					driver.findElement(By.id("book_now")).click();
					
					System.out.println("Successfully submit the Book Details");
					
					return this;
					
				}
				
				//validate the Booking tittle
				
				public LoginPage validateBookingTitle() {
					 try {
					        String expectedTitle = "Booking Confirmation"; // Corrected here
					        
					        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

					        // Define the expected condition to wait for the visibility of the element
					        WebElement actualTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
					                By.xpath("//td[contains(text(), 'Booking Confirmation')]")
					        ));

					        // Get the actual title text
					        String actualTitle = actualTitleElement.getText();

					        // Print the actual message to verify
					        System.out.println("The Booking Confirmation title is: " + actualTitle);
					        
					        // Assert that the actual title matches the expected title
					        Assert.assertEquals(actualTitle, expectedTitle, "The actual title is not equal to the expected title.");
					        
					    } catch (Exception e) {
					        System.out.println("The error message is: " + e.getMessage());
					    }
					    
					    return this;

						       
			 }
						

				        
				  //click the logout button
				public LoginPage clickLogoutButton() {
					
					 WebElement logoutButton = driver.findElement(By.id("logout")); // Adjust XPath as needed
			          logoutButton.click();
			        System.out.println("the Successfully Logout Buton");
					return this;


			}
				public LoginPage validateLogout() {
					  // Wait for the logout confirmation message to be visible
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			        WebElement logoutMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), 'You have successfully logged out.')]")));

			        // Get the actual message text
			        String actualMessage = logoutMessage.getText();
			        System.out.println("The Actual message: " + actualMessage);

			        // Define the expected message (update this based on your application behavior)
			        String expectedMessage = "You have successfully logged out. Click here to login again";

			        // Assert that the actual message matches the expected message
			        Assert.assertEquals(actualMessage, expectedMessage, "Logout message does not match expected.");

			        // Alternatively, for partial matching
			        // Assert.assertTrue(actualMessage.contains("You have successfully logged out."), "Logout message does not contain expected text.");
                   
			        
			        return this;
			        
				}
				//Negative Scenerio Location
				public LoginPage invalidLocation() {
					
					   // Locate the error message element
			        String actualErrorMessage = driver.findElement(By.id("location_span")).getText();

			        // Define the expected error message
			        String expectedErrorMessage = "Please Select a Location";

			        // Assert that the actual message matches the expected message
			        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match!");
			        System.out.println("the error message:"+actualErrorMessage);
					return this;
					
				}
				//Negative Validation of not select the rooms
				public LoginPage invalidNotSelectRooms() {
					
					 // Capture the actual error message
			        String actualErrorMessage = driver.findElement(By.id("num_room_span")).getText(); // Adjust selector as needed

			        // Define the expected error message
			        String expectedErrorMessage = "Please Select Total Number of Rooms";

			        // Assert that the actual message matches the expected message
			        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error messages do not match!");
			        System.out.println("The Error invalid Not select the rooms:"+actualErrorMessage);
					return this;
				}
				
				//Negative Validation of not select adult per rooms rooms
				public LoginPage invalidNotSelectAdultRooms() {
					
					 // Capture the actual error message
			        String actualErrorMessage = driver.findElement(By.id("adults_room_span")).getText(); // Adjust selector as needed

			        // Define the expected error message
			        String expectedErrorMessage = "Please Select Adults per Room";

			        // Assert that the actual message matches the expected message
			        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error messages do not match!");
			        System.out.println("The Error invalid Not select Adult per rooms:"+actualErrorMessage);
					return this;
				}
				
				//negative empty FirstName
				public LoginPage invalidBookFirstName() {
					
					 // Capture the actual error message
			        String actualErrorMessage = driver.findElement(By.id("first_name_span")).getText(); // Adjust selector as needed

			        // Define the expected error message
			        String expectedErrorMessage = "Please Enter your First Name";

			        // Assert that the actual message matches the expected message
			        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error messages do not match!");
			        System.out.println("The Error Firstname  Message:"+actualErrorMessage);
					return this;
				}
				
				//negative empty  Lastname
				public LoginPage invalidBookLastName() {
					
					 // Capture the actual error message
			        String actualErrorMessage = driver.findElement(By.id("last_name_span")).getText(); // Adjust selector as needed

			        // Define the expected error message
			        String expectedErrorMessage = "Please Enter you Last Name";

			        // Assert that the actual message matches the expected message
			        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error messages do not match!");
			        System.out.println("The Error LastName Message:"+actualErrorMessage);
					return this;
				}
				//negative you not enter the 16 Digit number 
				//negative empty  Lastname
				public LoginPage invalidBookCreditCard() {
					
					 // Capture the actual error message
			        String actualErrorMessage = driver.findElement(By.id("cc_num_span")).getText(); // Adjust selector as needed

			        // Define the expected error message
			        String expectedErrorMessage = "Please Enter your 16 Digit Credit Card Number";

			        // Assert that the actual message matches the expected message
			        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error messages do not match!");
			        System.out.println("The Error invalidBookcreditcard Message:"+actualErrorMessage);
					return this;
				}
				
				//Negative not select in credit car type
				public LoginPage invalidBookCreditCardType() {
					
					 // Capture the actual error message
			        String actualErrorMessage = driver.findElement(By.id("cc_type_span")).getText(); // Adjust selector as needed

			        // Define the expected error message
			        String expectedErrorMessage = "Please Select your Credit Card Type";

			        // Assert that the actual message matches the expected message
			        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error messages do not match!");
			        System.out.println("The Error invalid not selected Bookcreditcard type Message:"+actualErrorMessage);
					return this;
				}
				
				//Negative not select credit card year and expiry
				public LoginPage invalidBookYearDate() {
					
					 // Capture the actual error message
			        String actualErrorMessage = driver.findElement(By.id("cc_expiry_span")).getText(); // Adjust selector as needed

			        // Define the expected error message
			        String expectedErrorMessage = "Please Select your Credit Card Expiry Month";

			        // Assert that the actual message matches the expected message
			        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error messages do not match!");
			        System.out.println("The Error invalid not selected Bookcreditcard Expiry and Date type Message:"+actualErrorMessage);
					return this;
				}
				
				//Negative Not enter the CVV Number
				public LoginPage invalidBookCvvNum() {
					
					 // Capture the actual error message
			        String actualErrorMessage = driver.findElement(By.id("cc_cvv_span")).getText(); // Adjust selector as needed

			        // Define the expected error message
			        String expectedErrorMessage = "Please Enter your Credit Card CVV Number";

			        // Assert that the actual message matches the expected message
			        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error messages do not match!");
			        System.out.println("The Error invalid message Not Enter cvv number:"+actualErrorMessage);
					return this;
				}

				
}
