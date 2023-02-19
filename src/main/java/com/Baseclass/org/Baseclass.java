package com.Baseclass.org;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver;


	public static WebDriver browserLaunch(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-notifications");
			driver = new ChromeDriver(op);
			driver.manage().window().maximize();
		}

		else if (browser.equalsIgnoreCase("FireFox")) {
			WebDriverManager.chromedriver().setup();
			FirefoxOptions ff = new FirefoxOptions();
			ff.addArguments("--disable-notifications");
			driver = new FirefoxDriver(ff);
			driver.manage().window().maximize();
		}

		else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}

		return driver;
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void passInput(String value, WebElement element) {
		element.sendKeys(value);
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static void screenshot(String location) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("Screenshot" + "\\" + location + ".png");
		FileUtils.copyFile(source, destination);
	}

	public static void windowHandles(String value, String valueone) {
		String parentid = driver.getWindowHandle();
		driver.switchTo().window(parentid);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String window : windowHandles) {
			driver.switchTo().window(window).getTitle();
			if ((driver.switchTo().window(window).getTitle().contains(value))) {
				driver.close();
			} else if (driver.switchTo().window(window).getTitle().contains(valueone)) {
				driver.close();
			}
		}
		driver.switchTo().window(parentid);
	}

	public static void sleep(int value) throws InterruptedException {
		Thread.sleep(value);
	}

	public static void quit() {
		driver.quit();
	}

	public static void implicitlyWait(int value) {
		driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
	}

}
