package tests;

import org.testng.annotations.Test;

import pages.HoverOvrProductsPage;

public class HoverTest extends TestBase {
	HoverOvrProductsPage hover;

	@Test
	public void HoverOverTest() {
		hover = new HoverOvrProductsPage(driver);
		hover.hoverOverMenProduct();
	}

	@Test(priority = 1)
	public void BagsHoverTest() {
		hover = new HoverOvrProductsPage(driver);
		hover.hoverOverGearProducts();
	}
}
