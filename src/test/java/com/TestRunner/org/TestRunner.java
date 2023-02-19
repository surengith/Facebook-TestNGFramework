package com.TestRunner.org;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.Baseclass.org.Baseclass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\Feature\\org", glue = "com.StepDefinition.org", plugin = {
		"html:Report/report.html", "json:Report/report.json" })
public class TestRunner {

	public static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = Baseclass.browserLaunch("Chrome");
	}

	@AfterClass
	public static void tearDown() {
		Baseclass.quit();
	}
}
