package com.UtilsLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.BaseLayer.Baseclassforsalesforse;
import com.BaseLayer.Basefornopcommerse;

public class SelectClass extends Baseclassforsalesforse {
	public static void dropdown(String xpath, String value) {
		//day
		WebElement wb=driver.findElement(By.xpath(xpath));
		Select sel=new Select(wb);
		sel.selectByVisibleText(value);
		String text=sel.getFirstSelectedOption().getText();
		System.out.println(text);
}
}
