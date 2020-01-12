package com.orangehrm.comman;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

public class ImplIInvokedMethodListener implements IInvokedMethodListener {

	
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// WebDriverFactory.dr.quit();
		WebDriverFactory.getWebDriver().quit();
	}

	
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

		// WebDriverFactory.dr = new ChromeDriver();
		// WebDriverFactory.threadLocalStorage.set(new ChromeDriver());
		WebDriverFactory.setWebDriver(new ChromeDriver());

		// WebDriverFactory.dr.get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/auth/login");
		WebDriverFactory.getWebDriver().get("http://127.0.0.1/orangehrm-3.3.1/symfony/web/index.php/auth/login");

		WebDriverFactory.getWebDriver().manage().window().maximize(); // For Maximize Window
		WebDriverFactory.getWebDriver().manage().timeouts().implicitlyWait(30000, TimeUnit.MICROSECONDS);

	}

}
