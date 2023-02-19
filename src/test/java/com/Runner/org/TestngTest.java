package com.Runner.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.ReporterConfig.Property;

import com.Property.org.File_Reader_Manager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngTest {

	public static WebDriver driver;
	public static Properties p;

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public static void browser(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		else if (browser.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

		else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}

	}
//
//	@Test(priority = 0)
//	public static void property() throws IOException {
//
//		File f = new File(
//				"C:\\Users\\Surendhar\\eclipse-workspace\\SelectorHub\\src\\main\\java\\com\\Property\\org\\sel.property");
//		FileInputStream fis = new FileInputStream(f);
//		p = new Properties();
//		p.load(fis);
//
//	}

	@Parameters("url")
	@Test()
	public static void launchUrl(String url) {
		// String url = p.getProperty("urltest");
		driver.get(url);
	}

	@Parameters("email")
	@Test(priority = 1)
	public static void testOne(String email) throws InterruptedException {
	    Thread.sleep(3000);
		WebElement emailone = driver.findElement(By.xpath("//input[@id='email']"));
		// String emailone = p.getProperty("emailtest");
		emailone.sendKeys(email);
	}

	@Parameters("password")
	@Test(priority = 2)
	public static void testTwo(String password) throws InterruptedException {
		Thread.sleep(3000);
		WebElement passwordone = driver.findElement(By.xpath("//input[@id='pass']"));
		// String passwordone = p.getProperty("passowrdtest");
		passwordone.sendKeys(password);
	}

	@Test(priority = 3)
	public static void testThree() throws InterruptedException {
		Thread.sleep(3000);
		WebElement submit = driver.findElement(By.name("login"));
		submit.click();
	}

	@AfterClass
	public static void quit() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
