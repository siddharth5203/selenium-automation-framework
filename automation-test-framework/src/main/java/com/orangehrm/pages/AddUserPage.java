package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.orangehrm.comman.WebDriverFactory;

public class AddUserPage {

	@FindBy(id="systemUser_userType")
	Select dropDownType;
	
	@FindBy(id="systemUser_employeeName_empName")
	WebElement empName;
	
	@FindBy(id="systemUser_userName")
	WebElement adduserName;
	
	@FindBy(id="systemUser_status")
	Select dropDownStatus;
	
	@FindBy(id="systemUser_password")
	WebElement uP;
	
	@FindBy(id="systemUser_confirmPassword")
	WebElement uRP;
	
	@FindBy(id="btnSave")
	WebElement btSave;
	
	@FindBy(id="UserHeading")
	WebElement usrHeading;
	
	@FindBy(id="btnAdd")
	WebElement addUserButton;
		
	public AddUserPage() {
		PageFactory.initElements(WebDriverFactory.getWebDriver(), this);
	}
	
	public AddUserPage verifyAddUserPage(String uhtxt) {
		Assert.assertEquals(usrHeading.getText(), uhtxt);
		return this;
	}
	public AdminPage adduser(String userRole, String ename, String auname, String up, String urp) {
		dropDownType.selectByVisibleText(userRole);
		empName.sendKeys(ename);
		adduserName.sendKeys(auname);
		uP.sendKeys(up);
		uRP.sendKeys(urp);
		btSave.click();
		return (new AdminPage());
	}
	
	
	
}
