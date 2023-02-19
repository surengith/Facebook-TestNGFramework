package com.Pom.org;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	public static WebDriver driver;

	public loginpage(WebDriver selectorhubdriver) {
		this.driver = selectorhubdriver;
		PageFactory.initElements(selectorhubdriver, this);
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getPracticepage() {
		return practicepage;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassowrd() {
		return passowrd;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getMobilenumber() {
		return mobilenumber;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getCheckoutherefirst() {
		return checkoutherefirst;
	}

	public WebElement getTestCase() {
		return TestCase;
	}

	public WebElement getCheckoutheresecond() {
		return checkoutheresecond;
	}

	public WebElement getShubyt() {
		return shubyt;
	}
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement product;
	
	@FindBy(xpath="//a[text()='Practice Page']")
	private WebElement practicepage;
	
	@FindBy(id="userId")
	private WebElement email;

	@FindBy(id="pass")
	private WebElement passowrd;
	
	@FindBy(name="company")
	private WebElement company;
	
	@FindBy(name="mobile number")
	private WebElement mobilenumber;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath="//button[text()='Checkout here']")
	private WebElement checkoutherefirst;
	
	@FindBy(xpath="//a[text()='Try TestCase Studio']")
	private WebElement TestCase;
	
	@FindBy(xpath="//button[text()='Checkout here']")
	private WebElement checkoutheresecond;
	
	@FindBy(xpath="//a[text()='SHub Youtube Channel']")
	private WebElement shubyt;

}
