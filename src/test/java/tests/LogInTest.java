package tests;

import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;
import com.shaft.driver.SHAFT.TestData.JSON;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class LogInTest extends TestBase {
	HomePage home;
	RegisterPage register;
	LoginPage log;
	SHAFT.TestData.JSON registerData;

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void userRegisteration() {
		home = new HomePage(driver);
		home.navigateToRegisterPage();
		registerData = new JSON("registerData.json");
		register = new RegisterPage(driver);
		register.UserData(registerData.getTestData("firstName"),registerData.getTestData("lastName"),registerData.getTestData("email"),registerData.getTestData("password"));
		driver.assertThat().element(register.getAssertionLocator()).text()
				.contains("Thank you for registering with Fake Online Clothing Store.").perform();

		register.LogOut();
		//driver.assertThat().element(register.logOutAssertionLocator()).text().contains("Default welcome msg!").perform();
	}
	@Test(priority = 1)
	public void I_can_log() {
		registerData = new JSON("registerData.json");
		home = new HomePage(driver);
		home.navigateToLoginPage();
		log = new LoginPage(driver);
		log.UserLogIN(registerData.getTestData("email"),registerData.getTestData("password"));
	}
}
