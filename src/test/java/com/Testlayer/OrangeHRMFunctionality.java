package com.Testlayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BaseLayer.BaseClassforHRM;
import com.UtilsLayer.ExcelRead2;

public class OrangeHRMFunctionality extends BaseClassforHRM {
	public static String empID;
	@BeforeClass
		public void setup() throws InterruptedException {
			BaseClassforHRM.initilization();
			Thread.sleep(2000);
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click(); 

		}     
	@Test(priority=1)
	public void homePagevalidation() {
		Assert.assertEquals(driver.getCurrentUrl().contains("dashboard"), true);
	}
	@Test(priority=2, dataProvider = "PIMcreateNewUser")
	public void pimPage(String fName, String mName, String lName) {
			driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(fName);
		driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys(mName);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lName);
		empID=driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
//		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
//		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		//
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
		driver.findElement(By.xpath("//input[@id='empsearch_id']")).sendKeys(empID);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		//
		driver.findElement(By.xpath("//table[@id='resultTable']//td[1]")).click();
		driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
		String popupmsg=driver.findElement(By.xpath("//p[text()='Delete records?']")).getText();
		Assert.assertEquals(popupmsg.contains("Delete"), true);
		driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
		
	}	
	@DataProvider(name="PIMcreateNewUser")
	public Object [] [] getData() throws Exception{
		ExcelRead2 obj1=new ExcelRead2("C:\\Users\\Kunal\\eclipes-workspace\\eclipse-workspace\\for.Framework\\Exceldata\\HRMdataPIM.xlsx");
		int rows=obj1.getRowcount(0);
		int cols=obj1.getCellcount(0);
		
		Object [] [] hrm=new Object [rows] [cols];
		for(int i=0; i<rows;i++)
		{
			hrm[i][0]=obj1.getdata(0,i,0);
			hrm[i][1]=obj1.getdata(0,i,1);

		}
		
		
		
		
		
		
		
		
		
		
		
		return null;
		
	}
}
