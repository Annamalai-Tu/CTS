package com.cts.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cts.base.BaseTest;
import com.cts.pageobjects.LoginPage;
import com.cts.utils.ConfigReader;

public class LoginTest extends BaseTest {
	String username = ConfigReader.getProperty("username");
	String password = ConfigReader.getProperty("password");

	@Test
	@Parameters("browser")
	public void testLogin(String browser) {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickSubmit();

	}
}
