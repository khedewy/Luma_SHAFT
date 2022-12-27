package tests;

import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;
import com.shaft.driver.SHAFT.TestData.JSON;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;

public class CheckOutTest extends TestBase {
	HomePage home;
	LoginPage log;
	SHAFT.TestData.JSON registerData;
	ProductDetailsPage details; 
	CheckOutPage check;
	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void userRegistration() {
		registerData = new JSON("registerData.json");
		home = new HomePage(driver);
		home.navigateToLoginPage();
		log = new LoginPage(driver);
		log.UserLogIN(registerData.getTestData("email"), registerData.getTestData("password"));
	}
	@Test(priority = 1)
	public void AddProductToCart() {
		home = new HomePage(driver);
		home.navigateToFirstProduct("jacket");
		details = new ProductDetailsPage(driver);
		details.firstProduct();
		details.addFirstProductToCart();
		driver.assertThat().element(details.getFirstProductAssertionLocator()).text().contains("Lando Gym Jacket")
				.perform();
		
	}
	
	@Test(priority = 2)
	public void completeCheckOut() {
		details = new ProductDetailsPage(driver);
		details.navigateToCheckOutPage();
		check = new CheckOutPage(driver);
		check.shippingAdress("Microsoft","Sohag","MARAGHA","Algazara","Sohag","Maragah","1234","01205456789");
		check.clickNextBtn();
		driver.assertThat().element(check.getAssertionLocator()).text().contains("Check / Money order").perform();
		check.clickPlaceOrder();
		driver.assertThat().element(check.placeOrderAssertionLocator()).text().contains("Thank you for your purchase!").perform();
		
	}
}
