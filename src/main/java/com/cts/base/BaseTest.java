package com.cts.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.cts.utils.ConfigReader;
import com.cts.utils.DriverManager;
import com.cts.utils.ExtentReportManager;


public class BaseTest {

	public static WebDriver driver;
	protected ExtentTest extentTest;
	String baseUrl= ConfigReader.getProperty("url") ;
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String Browser) throws Exception {
		driver = DriverManager.getdriver(Browser);
		driver.get(baseUrl);
		extentTest = ExtentReportManager.createTest("Test in " + Browser + "browser");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
	}
	
	@AfterMethod
	private void aftermethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.pass("Test passed");
        } else {
            extentTest.skip("Test skipped");
        }

	}

	//@AfterSuite
	public void tearDown() {
		if (driver != null) {
	        driver.quit();
	    }
	}

}
