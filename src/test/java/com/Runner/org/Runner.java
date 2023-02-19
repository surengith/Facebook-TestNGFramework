package com.Runner.org;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import com.Baseclass.org.Baseclass;
import com.Pom.org.loginpage;
import com.Property.org.File_Reader_Manager;
import com.Singleton.org.Singleton;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Runner extends Baseclass {

	public static WebDriver driver = browserLaunch("Chrome");

	public static Singleton sel = new Singleton(driver);

	public static void main(String[] args) throws InterruptedException, IOException {

//		WebDriverManager.chromedriver().setup();
//		ChromeOptions op = new ChromeOptions();
//		op.addArguments("--disable-notifications");
//		driver = new ChromeDriver(op);
//		driver.manage().window().maximize();
//		browserLaunch("Chrome");

//		driver.get("https://selectorshub.com/");
		launchUrl("https://selectorshub.com/");

//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		implicitlyWait(30);

//		loginpage pom = new loginpage(driver);

//		WebElement product = driver.findElement(By.xpath("//a[text()='Products']"));
//		product.click();
		clickOnElement(sel.getPom().getProduct());

//		WebElement practicepage = driver.findElement(By.xpath("//a[text()='Practice Page']"));
//		practicepage.click();
		clickOnElement(sel.getPom().getPracticepage());
//		Thread.sleep(2000);
		sleep(2000);

//		WebElement email = driver.findElement(By.id("userId"));
//		email.sendKeys("Abcdef@gmail.com");
		String email = File_Reader_Manager.getInstanceFRM().getInstanceCR().getEmail();
		passInput(email, sel.getPom().getEmail());

//		WebElement password = driver.findElement(By.id("pass"));
//		password.sendKeys("123456");
		String password = File_Reader_Manager.getInstanceFRM().getInstanceCR().getPassword();
		passInput(password, sel.getPom().getPassowrd());

//		WebElement company = driver.findElement(By.name("company"));
//		company.sendKeys("SelectorHub");
		String getcompany = File_Reader_Manager.getInstanceFRM().getInstanceCR().getcompany();
		passInput(getcompany, sel.getPom().getCompany());

//		WebElement mobilenumber = driver.findElement(By.name("mobile number"));
//		mobilenumber.sendKeys("123987456");
		String mobilenumber = File_Reader_Manager.getInstanceFRM().getInstanceCR().getmobilenumber();
		passInput(mobilenumber, sel.getPom().getMobilenumber());

//		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
//		submit.click();
		clickOnElement(sel.getPom().getSubmit());

//		WebElement checkoutherefirst = driver.findElement(By.xpath("//button[text()='Checkout here']"));
//		checkoutherefirst.click();
		sleep(3000);
		clickOnElement(sel.getPom().getCheckoutherefirst());

//		try {
//			WebElement TestCase = driver.findElement(By.xpath("//a[text()='Try TestCase Studio']"));
//			TestCase.click();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		sleep(3000);
		clickOnElement(sel.getPom().getTestCase());

		String parentid = driver.getWindowHandle();
		driver.switchTo().window(parentid);

//		WebElement checkoutheresecond = driver.findElement(By.xpath("//button[text()='Checkout here']"));
//		checkoutheresecond.click();
		clickOnElement(sel.getPom().getCheckoutheresecond());

//		WebElement shubyt = driver.findElement(By.xpath("//a[text()='SHub Youtube Channel']"));
//		shubyt.click();
		clickOnElement(sel.getPom().getShubyt());

//		Thread.sleep(3000);
		sleep(3000);

//		Set<String> windowHandles = driver.getWindowHandles();
//		for (String window : windowHandles) {
//			System.out.println(driver.switchTo().window(window).getTitle());
//			if ((driver.switchTo().window(window).getTitle().contains("SelectorsHub - YouTube"))) {
//				driver.close();
//			} else if (driver.switchTo().window(window).getTitle()
//					.contains("SelectorsHub - XPath, CssSelector, Recorder Plugin, TestCase")) {
//				driver.close();
//			}
//		}
//		driver.switchTo().window(parentid);

		windowHandles("SelectorsHub - YouTube", "SelectorsHub - XPath, CssSelector, Recorder Plugin, TestCase");

		sleep(3000);
		WebElement cars = driver.findElement(By.id("cars"));
		Select sel = new Select(cars);
		sel.selectByVisibleText("Audi");

//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File destination = new File("//Screenshot/selectorhub.png");
//		FileUtils.copyFile(source, destination);
		screenshot("Loginpage");

//		Thread.sleep(3000);
		sleep(3000);

//		driver.quit();
		quit();
	}
}