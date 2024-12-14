package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_003_LoginAndInvalidTest extends ProjectSpecificationMethod {
	
	@BeforeTest
	public void data() throws IOException {
    	readFromPropFile("HotelTestData");
	//	sheetName = "InvalidTestDatas";
	}
	
	@Test (dataProvider = "excelRead")
	public void LoginTest(String username, String password,String type, String message  ) {
		HomePage obj = new HomePage(driver);
		obj.validDetails()
		.isUserName(username)
		.isPassword(password)
		.loginButton()
		.ValidateLoginResult(type, message);
	}

}
