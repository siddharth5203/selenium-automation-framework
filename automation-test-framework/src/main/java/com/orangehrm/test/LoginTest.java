package com.orangehrm.test;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.orangehrm.comman.BaseSelenium;
import com.orangehrm.comman.WebDriverFactory;
//import com.orangehrm.comman.WebDriverFactory;
//import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseSelenium{
		
	@Test(dataProvider="excelData", groups= {"LoginGroup"})
	public void validUNamenPWord(String userName, String passWord, String welcomeText)
	{ 	
		LoginPage lp = new LoginPage();
		//Actions action =new Actions(WebDriverFactory.getWebDriver());
		//action.click().build().perform();  //without build n perform action will not work
		//.isLoginPageLoaded()
		lp.login(userName, passWord)
			//	.isHomePageLoaded()
					.verifyWelComeText(welcomeText);
		
	}
	/*	
	@Test
	public void verifyInvalidPWord()
	{
		
		LoginPage lp = new LoginPage();
		lp.isLoginPageLoaded()
				.loginForInvalidCreadentials("admin", "admin1")
					.isLoginPageLoaded()
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
	
	}*/
}