package com.BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Baseclassforsalesforse {
	public static WebDriver driver;
	public static void initilization() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kunal\\eclipes-workspace\\eclipse-workspace\\Maven\\drivers\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
//		
//		driver= new ChromeDriver(options);
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://softech8.my.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kunal\\eclipes-workspace\\eclipse-workspace\\Maven\\drivers\\chromedriver.exe");
		
}
}

