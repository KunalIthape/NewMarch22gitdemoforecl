package com.pagelayer;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseLayer.Baseclassforsalesforse;

public class LoginPageSalesforse extends Baseclassforsalesforse {
	@FindBy(id= "username")
	WebElement uname;
	@FindBy(id= "password")
	WebElement pass;
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	@FindBy(id="error")
	WebElement errormsg;
	@FindBy(id="rememberUn")
	WebElement check;
	
	public LoginPageSalesforse() {
		PageFactory.initElements(driver, this);		
	}
	public void loginforsalesforse(String usname, String passd) throws InterruptedException {
		uname.sendKeys(usname);
		pass.sendKeys(passd);
//		Thread.sleep(5000);
//		login.click();
		if((usname=="rkproduction2119-dh3h@force.com")&&(passd=="Deva@2020"))
		{
//			check.click();
			login.click();
		}
		else if(!(usname=="rkproduction2119-dh3h@force.com")||!(passd=="Tester@09"))
	{
//			check.click();
			login.click();
			String eror=errormsg.getText();
			System.out.println(eror);
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
