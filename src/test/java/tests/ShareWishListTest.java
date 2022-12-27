package tests;

import org.testng.annotations.Test;

import com.shaft.driver.SHAFT;
import com.shaft.driver.SHAFT.TestData.JSON;

import pages.AddToWishlistPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ShareWishListPage;
import pages.UpdateWishListPage;

public class ShareWishListTest extends TestBase {
	HomePage home;
	LoginPage log;
	ProductDetailsPage details;
	AddToWishlistPage wishlist;
	SHAFT.TestData.JSON registerData;
	UpdateWishListPage update;
	ShareWishListPage share;

	@Test
	public void userMustLogin() {
		registerData = new JSON("registerData.json");
		home = new HomePage(driver);
		home.navigateToLoginPage();
		log = new LoginPage(driver);
		log.UserLogIN(registerData.getTestData("email"), registerData.getTestData("password"));
	}

	@Test(priority = 1)
	public void addToWishList() {
		home = new HomePage(driver);
		home.navigateToFirstProduct("jacket");
		details = new ProductDetailsPage(driver);
		details.firstProduct();
		details.addToWishList();
		wishlist = new AddToWishlistPage(driver);
		driver.assertThat().element(wishlist.getassertionLocator()).text()
				.contains("Lando Gym Jacket has been added to your Wish List. Click").perform();
	}

	@Test(priority = 2)
	public void AddOneMoreProduct() {
		home = new HomePage(driver);
		home.navigateToFirstProduct("pant");
		details = new ProductDetailsPage(driver);
		details.secondProduct();
		details.addToWishList();
		wishlist = new AddToWishlistPage(driver);
		driver.assertThat().element(wishlist.getassertionLocator()).text()
				.contains("Caesar Warm-Up Pant has been added to your Wish List. Click").perform();

	}

	@Test(priority = 3)
	public void shareWishList() {
		update = new UpdateWishListPage(driver);
		update.navigateToShareWishList();
		share = new ShareWishListPage(driver);
		share.enterShareListData("mahmoudKhedewy2001@gmail.com", "This my wish list, take a look and send my ur feedback.");
		driver.assertThat().element(share.getassertionLocator()).text().contains("Your wish list has been shared.").perform();
	}
}
