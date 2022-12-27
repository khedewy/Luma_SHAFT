package tests;

import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;
import com.shaft.driver.SHAFT.TestData.JSON;

import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends TestBase {
	HomePage home;
	RegisterPage register;
	SHAFT.TestData.JSON registerData;

	@Test
	public void NavigateToRegister() {
		home = new HomePage(driver);
		home.navigateToRegisterPage();
	}

	@Test
	public void UserRegistration() {
		registerData = new JSON("registerData.json");
		register = new RegisterPage(driver);
		register.UserData(registerData.getTestData("firstName"),registerData.getTestData("lastName"),registerData.getTestData("email"),registerData.getTestData("password"));
		driver.assertThat().element(register.getAssertionLocator()).text()
				.contains("Thank you for registering with Fake Online Clothing Store.").perform();

		register.LogOut();
		driver.assertThat().element(register.logOutAssertionLocator()).text().contains("Default welcome msg!").perform();
	}
}
