package com.Testlayer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.BaseLayer.Baseclassforsalesforse;
import com.UtilsLayer.ExcelRead2;
import com.UtilsLayer.JsMethods;
import com.UtilsLayer.SelectClass;
import com.pagelayer.LoginPageSalesforse;
import Exceleader.ExcelRead1;
public class LoginTest extends Baseclassforsalesforse{
	@BeforeClass
	public void setup() {
		Baseclassforsalesforse.initilization();
	}
	@Test(priority=1)
	public void loginvalidate() throws InterruptedException {
		LoginPageSalesforse sflogin= new LoginPageSalesforse();
		sflogin.loginforsalesforse("rkproduction2119-dh3h@force.com", "Deva@2020");
	Thread.sleep(7000);
	}
	@Test(dataProvider = "User")
	public void add_new_User(String firstname,String lastname,String email,String Title, String company,String dept, String div , String phone) {
		driver.findElement(By.xpath("//a[text()='Setup']")).click();
		driver.findElement(By.xpath("//a[@title='New user']")).click();
		driver.findElement(By.xpath("//input[@id='name_firstName']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='name_lastName']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Title']")).sendKeys(Title);
		driver.findElement(By.xpath("//input[@id='CompanyName']")).sendKeys(company);
		driver.findElement(By.xpath("//input[@id='Department']")).sendKeys(dept);
		driver.findElement(By.xpath("//input[@id='Division']")).sendKeys(div);
		SelectClass.dropdown("//select[@id='user_license_id']", "Salesforce");
		SelectClass.dropdown("//select[@id='Profile']", "Chatter Free User");
		driver.findElement(By.xpath("//input[@id='accessible_mode']")).click();
		driver.findElement(By.xpath("//input[@id='Phone']")).sendKeys(phone);
		JsMethods.jsscrolldown();
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@name='save']")).click();
	}
	@DataProvider(name="User")
	public Object [] [] getData() throws Exception{
		ExcelRead1 excelreader=new ExcelRead1("C:\\Users\\Kunal\\eclipes-workspace\\eclipse-workspace\\for.Framework\\Exceldata\\NewUserSalesforse.xlsx");
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
			fbg[i][5]=excelreader.getdata(0,i,5);
			fbg[i][6]=excelreader.getdata(0,i,6);
			fbg[i][7]=excelreader.getdata(0,i,7);
		   
		}
		return fbg;
		
	}	
//	@Test(priority=2)
		public void userPage() {
//		String a=driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']")).getText();
//		System.out.println(a);
		driver.findElement(By.xpath("//a[text()='User Profile']")).click();
		WebElement frm=driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(frm);
		WebElement we=driver.findElement(By.xpath("//html[@dir='ltr']"));
		we.click();
		we.sendKeys("Hello");
		driver.findElement(By.xpath("//input[@id='publishersharebutton']")).click();
		
	}	//@Test(priority=3)
		public void teardown() {
			driver.quit();
}
}