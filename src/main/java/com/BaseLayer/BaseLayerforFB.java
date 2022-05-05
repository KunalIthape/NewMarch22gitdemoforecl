package com.BaseLayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseLayerforFB {
	public static WebDriver driver;
	public static Actions act;
	public static void initilization() {
		System.setProperty("webdriver.chrome.driver", "C:\\External Download\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/reg/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
}
