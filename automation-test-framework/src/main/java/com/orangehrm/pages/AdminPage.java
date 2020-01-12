package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.comman.WebDriverFactory;

public class AdminPage {

	@FindBy(id="btnAdd")
	WebElement addUserButton;
	
	WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), 30);
	
	public AdminPage isAdminPageLoaded() {
		wait.until(ExpectedConditions.elementToBeClickable(addUserButton));
		return this;
	}
	public AdminPage() {
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}
	
	public AddUserPage navigateToAddUserPage() {
		addUserButton.click();
		return (new AddUserPage().isAddUserPageLoaded());
	}
	
	public void verifyAdminPage() {
		if(addUserButton.isDisplayed()) 
		{
		System.out.println();	
		}
		
	}
}
