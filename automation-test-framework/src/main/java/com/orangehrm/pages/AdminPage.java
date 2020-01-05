package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.comman.WebDriverFactory;

public class AdminPage {

	@FindBy(id="btnAdd")
	WebElement addUserButton;
	
	public AdminPage() {
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}
	
	public AddUserPage navigateToAddUserPage() {
		addUserButton.click();
		return (new AddUserPage());
	}
	
	public void verifyAdminPage() {
		if(addUserButton.isDisplayed()) 
		{
		System.out.println();	
		}
		
	}
}
