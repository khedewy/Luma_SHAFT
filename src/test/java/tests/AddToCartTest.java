package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;

public class AddToCartTest extends TestBase {
	HomePage home;
	ProductDetailsPage details;

	@Test()
	public void AddFirstProduct() {
		home = new HomePage(driver);
		home.navigateToFirstProduct("jacket");
		details = new ProductDetailsPage(driver);
		details.firstProduct();
		details.addFirstProductToCart();
		driver.assertThat().element(details.getFirstProductAssertionLocator()).text().contains("Lando Gym Jacket")
				.perform();
	}

	@Test(priority = 1)
	public void search_for_another_product() {
		home = new HomePage(driver);
		home.navigateToFirstProduct("pant");
		details = new ProductDetailsPage(driver);
		details.secondProduct();
		details.addSecondProductToCart();
		driver.assertThat().element(details.getSecondAssertionLocator()).text().contains("Caesar Warm-Up Pant")
				.perform();
	}

}
