package com.Singleton.org;

import org.openqa.selenium.WebDriver;

import com.Pom.org.loginpage;

public class Singleton {
	
	public static WebDriver driver;
	
	private loginpage pom;

	public Singleton(WebDriver singledriver) {
		this.driver = singledriver;
	}

	public loginpage getPom() {
		 pom = new loginpage(driver);
		return pom;
	}

}
