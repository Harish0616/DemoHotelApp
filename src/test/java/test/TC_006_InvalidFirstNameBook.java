package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_006_InvalidFirstNameBook extends ProjectSpecificationMethod{
	@BeforeTest
	public void data() throws IOException {
//		readFromPropFile("HotelTestData");
		sheetName = "LoginTestData";
		testName="InvalidFirstNameBook";
		testDescription="Test the not Enter the First Name Booking Function Details";
		testAuthor="Harish";
		testCategory="smokeTesting";
	}
	
	@Test (dataProvider = "excelRead")
	public void InvalidFirstNameTest(String username, String password,String type ,String message, String checkindate ,String checkoutdate ,String bookfirstname , String booklastname ,String billaddress,String bookcreditcard ,String bookcvnumber   ) {
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
		.bookLastName(booklastname)
		.bookEnterAddress(billaddress)
		.bookCreditCard(bookcreditcard)
		.bookPaymentOptions()
		.bookExpiryDate()
		.bookYear()
		.bookCvvNumber(bookcvnumber)
		.bookSubmitButton()
		.invalidBookFirstName();
	}

}
