package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orangehrm.comman.ExtentReportTestFactory;
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
	
	WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(), 30);
	public LoginPage isLoginPageLoaded() {

		wait.until(ExpectedConditions.elementToBeClickable(userName));
		wait.until(ExpectedConditions.elementToBeClickable(passWord));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		ExtentReportTestFactory.getTest().info("In login method");
		return this;
	}
	public LoginPage() {
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}
	public HomePage login(String uname, String pword) {
		ExtentReportTestFactory.getTest().info("In login method");

		userName.sendKeys(uname);
		passWord.sendKeys(pword);
		loginButton.click();
		return (new HomePage().isHomePageLoaded());
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
		return (new LoginPage().isLoginPageLoaded());
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
