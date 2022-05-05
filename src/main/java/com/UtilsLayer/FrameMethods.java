package com.UtilsLayer;

import org.openqa.selenium.By;

import com.BaseLayer.Baseclassforsalesforse;

public class FrameMethods extends Baseclassforsalesforse {
	public static void fr(String name, String value) {
		driver.switchTo().frame(name);
	driver.findElement(By.xpath(value)).click();
	}

}
