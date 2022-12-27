package tests;

import org.testng.annotations.Test;

import pages.AddToCompareListPage;
import pages.HomePage;
import pages.ProductDetailsPage;

public class AddToCompareList extends TestBase {
	HomePage home;
	ProductDetailsPage details;
	AddToCompareListPage compare;

	@Test
	public void searchForProduct() {
		home = new HomePage(driver);
		home.navigateToFirstProduct("jacket");
	}

	@Test(priority = 1)
	public void addToComapreList() {
		details = new ProductDetailsPage(driver);
		details.firstProduct();
		details.addToCompareList();
		compare = new AddToCompareListPage(driver);
		driver.assertThat().element(compare.getassertionLocator()).text().contains("1 item").perform();
	}
	
	@Test(priority = 2)
	public void AddAgainToComapreList() {
		home = new HomePage(driver);
		home.navigateToFirstProduct("pants");
		details = new ProductDetailsPage(driver);
		details.secondProduct();
		details.addToCompareList();
		compare = new AddToCompareListPage(driver);
		driver.assertThat().element(compare.getSecondAssertionLocator()).text().contains("2 items").perform();
		
	}
}
