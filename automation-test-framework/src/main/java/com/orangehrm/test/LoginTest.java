package com.orangehrm.test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.orangehrm.comman.BaseSelenium;
//import com.orangehrm.comman.WebDriverFactory;
//import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseSelenium{
		
	@Test
	public void validUNamenPWord()
	{
			
		LoginPage lp = new LoginPage();
		lp.login("admin", "admin")
			.verifyWelComeText("Welcome Admin");
		
	}
		
	@Test
	public void verifyInvalidPWord()
	{
		
		LoginPage lp = new LoginPage();
		lp.loginForInvalidCreadentials("admin", "admin1")
			.verifySpanMsg("Invalid credentials");
	
	}
	
	@Test
	public void verifyInvalidUname()
	{
		
		LoginPage lp = new LoginPage();
		lp.loginForInvalidCreadentials("admin1", "admin")
			.verifySpanMsg("Invalid credentials");
	
	}
	
	@Test
	public void verifyInvalidUnamePWord()
	{
		
		LoginPage lp = new LoginPage();
		lp.loginForInvalidCreadentials("admin1", "admin1")
			.verifySpanMsg("Invalid credentials");
	
	}
	
	@Test
	public void verifyBlankPWord()
	{
		
		LoginPage lp = new LoginPage();
		lp.loginForInvalidCreadentials("admin", "")
			.verifySpanMsg("Password cannot be empty");
	
	}
	
	@Test
	public void verifyBlankUName()
	{
		
		LoginPage lp = new LoginPage();
		lp.loginForInvalidCreadentials("", "admin")
			.verifySpanMsg("Username cannot be empty");
	
	}
	
	@Test
	public void verifyBlankUNamePWord()
	{
		
		LoginPage lp = new LoginPage();
		lp.loginForInvalidCreadentials("", "")
			.verifySpanMsg("Username cannot be empty");
	
	}
}