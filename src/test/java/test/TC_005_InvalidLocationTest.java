package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_005_InvalidLocationTest extends ProjectSpecificationMethod {
	
	@BeforeTest
	public void data() throws IOException {
//		readFromPropFile("HotelTestData");
		sheetName = "LoginTestData";
		testName="InvalidLocationTest";
		testDescription="Test Not select the Location";
		testAuthor="Harish";
		testCategory="smokeTesting";
	}
	
	@Test (dataProvider = "excelRead")
	public void InvalidLocationTest(String username, String password,String type ,String message, String checkindate ,String checkoutdate ,String bookfirstname , String booklastname ,String billaddress,String bookcreditcard ,String bookcvnumber   ) {
		HomePage obj = new HomePage(driver);
		obj.validDetails()
		.isUserName(username)
		.isPassword(password)
		.loginButton()
    	.ValidateLoginResult(type,message)
		.isSelectHotels()
		.isSelectRoomType()
		.isSelectNumberOfRooms()
		.isCheckInDate(checkindate)
		.isCheckOutDate(checkoutdate)
		.isSelectAdultPerRoom()
		.isSubmitButton()
		.invalidLocation();
	}

}
