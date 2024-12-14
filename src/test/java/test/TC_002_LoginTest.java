package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_002_LoginTest extends ProjectSpecificationMethod {

	@BeforeTest
	public void data() throws IOException {
//		readFromPropFile("HotelTestData");
		sheetName = "LoginTestData";
	}
	
	@Test (dataProvider = "excelRead")
	public void LoginTest(String username, String password,String type ,String message, String checkindate ,String checkoutdate ,String bookfirstname , String booklastname ,String billaddress,String bookcreditcard ,String bookcvnumber   ) {
		HomePage obj = new HomePage(driver);
		obj.validDetails()
		.isUserName(username)
		.isPassword(password)
		.loginButton()
    	.ValidateLoginResult(type,message)
		.isHotelLocation()
		.isSelectHotels()
		.isSelectRoomType()
		.isSelectNumberOfRooms()
		.isCheckInDate(checkindate)
		.isCheckOutDate(checkoutdate)
		.isSelectAdultPerRoom()
		.isSubmitButton()
		.clickRadioButton()
		.clickContinueButton()
		.vadidateBookaHotel()
		.bookFirstName(bookfirstname)
		.bookLastName(booklastname)
		.bookEnterAddress(billaddress)
		.bookCreditCard(bookcreditcard)
		.bookPaymentOptions()
		.bookExpiryDate()
		.bookYear()
		.bookCvvNumber(bookcvnumber)
		.bookSubmitButton()
		.validateBookingTitle()
		.clickLogoutButton()
		.validateLogout();
		
	}
}
