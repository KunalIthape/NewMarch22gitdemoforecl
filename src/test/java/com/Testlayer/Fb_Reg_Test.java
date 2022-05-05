package com.Testlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Exceleader.ExcelRead1;

public class Fb_Reg_Test  {
	public static WebDriver driver;
	
	@Test(dataProvider = "login")
	public void Register(String username,String lastname, String email, String verifyEmail, String passwd) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\External Download\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/reg/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		//
		driver.findElement(By.name("firstname")).sendKeys(username);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("reg_email__")).sendKeys(email);
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(verifyEmail);
		driver.findElement(By.name("reg_passwd__")).sendKeys(passwd);

//		Thread.sleep(7000);
		driver.quit();
}@DataProvider(name="login")
public Object [] [] getData() throws Exception{
	ExcelRead1 excelreader=new ExcelRead1("C:\\Users\\Kunal\\eclipes-workspace\\eclipse-workspace\\for.Framework\\Exceldata\\FB Login.xlsx");
	int rows=excelreader.getRowcount(0);
	int cols=excelreader.getCellcount(0);
	
	Object [] [] fbg=new Object [rows] [cols];
	for(int i=0; i<rows;i++)
	{
		
		fbg[i][0]=excelreader.getdata(0,i,0);
		fbg[i][1]=excelreader.getdata(0,i,1);
		fbg[i][2]=excelreader.getdata(0,i,2);
		fbg[i][3]=excelreader.getdata(0,i,3);
		fbg[i][4]=excelreader.getdata(0,i,4);

	}
	return fbg;
}
public void teardown() {
	driver.quit();
}
}