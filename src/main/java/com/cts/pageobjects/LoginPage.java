package com.cts.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
		
	private By usernameField = By.xpath("//flt-semantics[@id='flt-semantic-node-8']/input[last()]");
	private By passwordField = By.xpath("//flt-semantics[@id='flt-semantic-node-9']/input[last()]");
	private By submitbutton = By.xpath("//flt-semantics[@id='flt-semantic-node-6'][last()]");

	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickSubmit() {
		driver.findElement(submitbutton).click();;
	}
}
