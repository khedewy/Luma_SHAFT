package tests;

import org.testng.annotations.Test;

import pages.AddToCartDetailsPage;
import pages.HomePage;
import pages.ProductDetailsPage;

public class UpdateCartTest extends TestBase{
	HomePage home;
	ProductDetailsPage details;
	AddToCartDetailsPage cart;

	@Test
	public void addToCart() {
		home = new HomePage(driver);
		home.navigateToFirstProduct("jacket");
		details = new ProductDetailsPage(driver);
		details.firstProduct();
		details.addFirstProductToCart();
		driver.assertThat().element(details.getFirstProductAssertionLocator()).text().contains("Lando Gym Jacket")
				.perform();
	}
	
	@Test(priority = 1)
	public void changeQuantity() {
		cart = new AddToCartDetailsPage(driver);
		cart.changeQauntity("5");
		driver.assertThat().element(cart.getChangeQuantityLocator()).text().contains("$396.00").perform();
	}
	
	@Test(priority = 2)
	public void deleteItem() {
		cart = new AddToCartDetailsPage(driver);
		cart.deleteItems();
	}
}
