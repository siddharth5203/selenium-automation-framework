package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.comman.WebDriverFactory;

public class HomePage {

	@FindBy(id="welcome")
	WebElement welcomeText;

	@FindBy(id="menu_admin_viewAdminModule")
	WebElement admin;
	
	
	public HomePage() {
		
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}

	public HomePage verifyWelComeText(String txt) {
		Assert.assertEquals(welcomeText.getText(), txt);
		return this;
	}
	
	public AdminPage navigateToAdminPage() {
		admin.click();
		return new AdminPage();
	}
	
}
