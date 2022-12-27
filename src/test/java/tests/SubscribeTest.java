package tests;

import org.testng.annotations.Test;

import pages.HomePage;

public class SubscribeTest extends TestBase {
	HomePage home;

	@Test
	public void Subscribe() {
		home = new HomePage(driver);
		home.subscribeAsNewAccount("MahmoudKhedewy5123314@gmail.com");
		driver.assertThat().element(home.getSubscribtionLocator()).text().contains("Thank you for your subscription.").perform();
	}
}
