package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	public WebDriver driver;
	public WebDriverWait wait;   // for explicitly wait 

	// page class constructor:   to initialize the browers 
	public Page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// create a method with Java Generics and return a new page  
	//
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) { //here passing page class as parameters 
		               //Tpage is definition of the generics   
		             //here i created a method name getInstance and return type of this methos is Tpage 
		             // and extends basepage
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
