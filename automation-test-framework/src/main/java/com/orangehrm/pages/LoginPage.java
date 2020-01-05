package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.orangehrm.comman.WebDriverFactory;

public class LoginPage {

	@FindBy(id="txtUsername")
	WebElement userName;
	
	@FindBy(id="txtPassword")
	WebElement passWord;
	
	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	@FindBy(id="logInPanelHeading" )
	WebElement loginPanel;

	@FindBy(id="spanMessage")
	WebElement spanMSG;
	
	@FindBy(id="footer")
	WebElement ohrmLink;
	
	public LoginPage() {
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}
	public HomePage login(String uname, String pword) {
		userName.sendKeys(uname);
		passWord.sendKeys(pword);
		loginButton.click();
		return (new HomePage());
	}
	
	public LoginPage loginForInvalidCreadentials(String uname, String pword) {
		userName.sendKeys(uname);
		passWord.sendKeys(pword);
		loginButton.click();
		return this;
	}
	
	public void verifyLoginPanel(String lptxt) {
		Assert.assertEquals(loginPanel.getText(), lptxt);
		
	}
	
	public LoginPage verifySpanMsg(String smtxt) {
		Assert.assertEquals(spanMSG.getText(), smtxt);	
		return (new LoginPage());
	}
	
	public void verifyLink() {
		ohrmLink.click();
	}
	
	public void verifyEnabledField()
	{
		
		if(userName.isEnabled()==true)
		{
			System.out.println("Element is enabled");
		}
		//Assert.assertEquals(userName.isEnabled(), uname);
	}
}
