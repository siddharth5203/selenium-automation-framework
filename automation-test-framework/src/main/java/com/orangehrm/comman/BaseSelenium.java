package com.orangehrm.comman;

import org.testng.annotations.Listeners;

@Listeners(ImplIInvokedMethodListener.class)
public class BaseSelenium {
	
	/*public static WebDriver dr; 
	
	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) 
	{
		dr.quit();
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		dr = new ChromeDriver();
		
		dr.get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/auth/login");
		dr.manage().window().maximize();								//For Maximize Window

	}*/
}
