package Parallel_Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NopCommerseParallel {
	public static WebDriver driver;
	public static String email;
	public static String pass;
	public static String expectedMonth="November 1994";
	public static String actualMonth;
	@Parameters("kunal")
	@BeforeTest
	public void setUp(String open) {
		if(open.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kunal\\eclipes-workspace\\eclipse-workspace\\for.Framework\\drivers\\chromedriver.exe");
			driver =new ChromeDriver();
		}
//		else if(open.equals("edge"))
//		{
//			System.setProperty("webdriver.edge.driver", "C:\\Users\\Kunal\\eclipes-workspace\\eclipse-workspace\\for.Framework\\drivers\\msedgedriver.exe");
//			driver =new EdgeDriver();
//		}
		driver.manage().deleteAllCookies();
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test(priority=1)
	public void logIN() {
//		WebElement wb=driver.findElement(By.xpath("//input[@id='Email']"));
//		email=wb.getAttribute("value");
//		System.out.println(email);
//		WebElement wb1=driver.findElement(By.xpath("//input[@id='Email']"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@Test(priority=2)
	public void homePage() {
		boolean cURL=driver.getTitle().contains("Dashboard");
		Assert.assertEquals(cURL, true);
//		driver.findElement(By.xpath("//a[@id='nopSideBarPusher']")).click();
		driver.findElement(By.xpath("//a[@class='nav-link active']//i[@class='right fas fa-angle-left ']")).click();
		driver.findElement(By.xpath("//a[@href='/Admin/Customer/List']//p[text()=' Customers']")).click();
		driver.findElement(By.xpath("//a[@href='/Admin/Customer/Create']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("asdc@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("asdc@1234");
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Mahendra");
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Patil");
		driver.findElement(By.xpath("//input[@id='Gender_Male']")).click();
		driver.findElement(By.xpath("//span[@class='k-icon k-i-calendar']")).click();
		
		while(true)
		{
		actualMonth=driver.findElement(By.xpath("//a[text()='April 2022']")).getText();
		
		if(actualMonth.equals(expectedMonth))
		{
			break;
		}
		else {
			driver.findElement(By.xpath("//a[@class='k-link k-nav-prev']")).click();
		}
		}
		driver.findElement(By.xpath("//a[@title='Monday, November 21, 1994']")).click();
		
		

		
		
		
		
		
		
		
		
		
		
		
		
	}
}

