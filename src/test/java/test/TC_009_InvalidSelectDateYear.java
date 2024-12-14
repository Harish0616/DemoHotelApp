package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_009_InvalidSelectDateYear extends ProjectSpecificationMethod {
	

		@BeforeTest
		public void data() throws IOException {
//			readFromPropFile("HotelTestData");
			sheetName = "LoginTestData";
			testName="InvalidNotSelectDateYear";
			testDescription="Test the Not selected the year and date";
			testAuthor="Harish";
			testCategory="smokeTesting";
		}
		
		@Test (dataProvider = "excelRead")
		public void InvalidSelectDate(String username, String password,String type ,String message, String checkindate ,String checkoutdate ,String bookfirstname , String booklastname ,String billaddress,String bookcreditcard ,String bookcvnumber   ) {
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
			.bookCvvNumber(bookcvnumber)
			.bookSubmitButton()
			.invalidBookYearDate();
		}
	
}
