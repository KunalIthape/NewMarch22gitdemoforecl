package com.UtilsLayer;

import org.openqa.selenium.JavascriptExecutor;

import com.BaseLayer.Baseclassforsalesforse;

public class JsMethods extends Baseclassforsalesforse {
	public static JavascriptExecutor js=(JavascriptExecutor)driver;
	public static void jsscrolldown() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}
}
