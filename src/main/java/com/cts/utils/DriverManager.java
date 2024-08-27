package com.cts.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	public static WebDriver getdriver(String browser) {
		WebDriver driver = null;
		switch (browser.toLowerCase()) {
		case "chrome":
			// WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Invalid browser type! Please choose from: Chrome, Firefox, Edge");
			break;
		}

		if (driver != null) {
			driver.manage().window().maximize();
		}
		return driver;

	}
}
