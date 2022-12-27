package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.shaft.driver.SHAFT;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests {
	public static SHAFT.GUI.WebDriver driver;
	
	@BeforeClass
	public void setDriver() {
		driver = new SHAFT.GUI.WebDriver();
		driver.browser().navigateToURL("https://magento.softwaretestingboard.com/");
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	}

}
