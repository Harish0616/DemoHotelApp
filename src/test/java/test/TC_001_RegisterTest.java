package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethod;
import pages.HomePage;

public class TC_001_RegisterTest extends ProjectSpecificationMethod{
	
	@BeforeTest
	public void data() throws IOException {
		readFromPropFile("HotelTestData");
	}
	
	@Test
	public void RegisterTest() throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.clickGoBuild2()
		.signFirstName(prop.getProperty("signusername"))
		.signPassword(prop.getProperty("signpassword"))
		.signRePassword(prop.getProperty("signrepassword"))
		.signFullName(prop.getProperty("signfullname"))
		.signEmailId(prop.getProperty("signemailid"))
		.signCheckBox()
		.signRegisterButton()
		.registerValidation();
	}

}
