package com.StepDefinition.org;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.Baseclass.org.Baseclass;
import com.Property.org.File_Reader_Manager;
import com.Singleton.org.Singleton;
import com.TestRunner.org.TestRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Baseclass {

	public static WebDriver driver = TestRunner.driver;
	public static Singleton sel = new Singleton(driver);

	@Before
	public void beforeHooks(Scenario s) {

		String name = s.getName();
		System.out.println("BeforeHooks: " + name);
	}

	@After
	public void afterHooks(Scenario s) throws IOException {

		Status status = s.getStatus();
		System.out.println("AfterHooks: " + status);
		if (s.isFailed()) {
			screenshot("Hooks");
		}
	}

	@Given("user must launch the url")
	public void user_must_launch_the_url() {
		launchUrl("https://selectorshub.com/");
		implicitlyWait(30);
	}

	@When("user click the product menu")
	public void user_click_the_product_menu() {
		clickOnElement(sel.getPom().getProduct());
	}

	@When("user click the practice page from drop down option")
	public void user_click_the_practice_page_from_drop_down_option() throws InterruptedException {
		clickOnElement(sel.getPom().getPracticepage());
		sleep(2000);
	}

//	@When("user enter the Email in the User Email field")
//	public void user_enter_the_email_in_the_user_email_field() throws IOException {
//		String email = File_Reader_Manager.getInstanceFRM().getInstanceCR().getEmail();
//		passInput(email, sel.getPom().getEmail());
//	}

	@When("user enter the {string} in the User Email field")
	public void user_enter_the_in_the_user_email_field(String string) throws IOException {
		// String email =
		// File_Reader_Manager.getInstanceFRM().getInstanceCR().getEmail();
		passInput(string, sel.getPom().getEmail());
	}

//	@When("user enter the Passowrd in the Password field")
//	public void user_enter_the_passowrd_in_the_password_field() throws IOException {
//		String password = File_Reader_Manager.getInstanceFRM().getInstanceCR().getPassword();
//		passInput(password, sel.getPom().getPassowrd());
//	}

	@When("user enter the {string} in the Password field")
	public void user_enter_the_in_the_password_field(String string) throws IOException {
		// String password =
		// File_Reader_Manager.getInstanceFRM().getInstanceCR().getPassword();
		passInput(string, sel.getPom().getPassowrd());
	}

	@When("user enter the Company name in the Company field")
	public void user_enter_the_company_name_in_the_company_field() throws IOException {
		String getcompany = File_Reader_Manager.getInstanceFRM().getInstanceCR().getcompany();
		passInput(getcompany, sel.getPom().getCompany());
	}

	@When("user enter the Mobile Number in the Mobile Number field")
	public void user_enter_the_mobile_number_in_the_mobile_number_field() throws IOException {
		String mobilenumber = File_Reader_Manager.getInstanceFRM().getInstanceCR().getmobilenumber();
		passInput(mobilenumber, sel.getPom().getMobilenumber());
	}

	@When("user click the submit button")
	public void user_click_the_submit_button() throws InterruptedException {
		clickOnElement(sel.getPom().getSubmit());
		sleep(3000);
	}

	@When("user click the checkout here button")
	public void user_click_the_checkout_here_button() throws InterruptedException {
		clickOnElement(sel.getPom().getCheckoutherefirst());
		sleep(3000);

	}

	@When("user click the Try TestCase Studio option")
	public void user_click_the_try_test_case_studio_option() {
		clickOnElement(sel.getPom().getTestCase());
	}

	@When("user switchto parent window")
	public void user_switchto_parent_window() {
		String parentid = driver.getWindowHandle();
		driver.switchTo().window(parentid);
	}

	@When("user again click the checkout here button")
	public void user_again_click_the_checkout_here_button() {
		clickOnElement(sel.getPom().getCheckoutheresecond());

	}

	@When("user click the Try SHub Youtube Channel option")
	public void user_click_the_try_s_hub_youtube_channel_option() throws InterruptedException {
		clickOnElement(sel.getPom().getShubyt());
		sleep(3000);
	}

	@When("user must close the opened child windows")
	public void user_must_close_the_opened_child_windows() throws InterruptedException {
		windowHandles("SelectorsHub - YouTube", "SelectorsHub - XPath, CssSelector, Recorder Plugin, TestCase");
		sleep(3000);
	}

	@When("user select the Audi car from the Choose a car drop down")
	public void user_select_the_audi_car_from_the_choose_a_car_drop_down() {
		WebElement cars = driver.findElement(By.id("cars"));
		Select sel = new Select(cars);
		sel.selectByVisibleText("Audi");

	}

	@When("user must take screenshot of the whole web page")
	public void user_must_take_screenshot_of_the_whole_web_page() throws IOException {
		screenshot("Loginpage");
	}

	@Then("user quit the browser")
	public void user_quit_the_browser() throws InterruptedException {
		sleep(3000);
	}

}
