package Parallel_Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleBrowsers{
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kunal\\eclipes-workspace\\eclipse-workspace\\for.Framework\\drivers\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/signup");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@Test(priority=1)
	public void createNewAccount() {
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Kunal");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Ithape");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("kunalithape9@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("kunalithape9@gmail.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Devanshkunal@20");
	}
	@Test(priority=2)
	public void dropdown() {
		//day
		WebElement day=driver.findElement(By.id("day"));
		Select sel=new Select(day);
		sel.selectByVisibleText("21");
		System.out.println(sel.getFirstSelectedOption().getText());
		//month
		WebElement month=driver.findElement(By.id("month"));
		Select sel2=new Select(month);
		sel2.selectByVisibleText("Nov");
		System.out.println(sel2.getFirstSelectedOption().getText());
		//month
		WebElement year=driver.findElement(By.id("year"));
		Select sel3=new Select(year);
		sel3.selectByVisibleText("1994");
		System.out.println(sel3.getFirstSelectedOption().getText());
	
	}
	@Test(priority=3)
	public void radio() {
		//radiobtn
		driver.findElement(By.xpath("//input[@value='2']")).click();
	}
	@Test(priority=4)
	public void click() {
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();	
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
}