package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.ProjectSpecificationMethod;

public class HomePage extends ProjectSpecificationMethod{
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public RegisterPage clickGoBuild2() {
		driver.findElement(By.className("login_register")).click();
		return new RegisterPage(driver);
	}
	
	public LoginPage validDetails() {
		
		return new LoginPage(driver);
	}
	
	

}
