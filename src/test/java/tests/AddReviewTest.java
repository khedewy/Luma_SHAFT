package tests;

import org.testng.annotations.Test;

import pages.AddReviewPage;
import pages.HomePage;
import pages.ProductDetailsPage;

public class AddReviewTest extends TestBase {
	HomePage home;
	AddReviewPage review;
	ProductDetailsPage details;
	@Test
	public void searchForProduct() {
		home = new HomePage(driver);
		home.navigateToFirstProduct("jacket");
		details = new ProductDetailsPage(driver);
		details.firstProduct();
		details.navigateToAddToreview();
		
	}
	@Test(priority = 1)
	public void addReviewTest() {
		review = new AddReviewPage(driver);
		review.addReview("Khedewy","product review","this a very good product but quiet expensive");
		driver.assertThat().element(review.assertionLocator()).text().contains("You submitted your review for moderation.").perform();
	}
}
