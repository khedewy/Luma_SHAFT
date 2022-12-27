package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class UpdateWishListPage {
	private SHAFT.GUI.WebDriver driver;
	public UpdateWishListPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}
	
	private By delete_items = By.cssSelector("#wishlist-sidebar > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > a:nth-child(1)");
	private By deleteAssertion = By.cssSelector(".message-success > div:nth-child(1)");
	private By shareWishlist = By.name("save_and_share");
	
	
	public void deleteFirstProduct() {
		driver.element().click(delete_items);
	}
	
	public String getassertionMssage() {
		return driver.element().getText(deleteAssertion);
	}
	public By getassertionLocator() {
		return deleteAssertion;
	}
	
	public ShareWishListPage navigateToShareWishList() {
		driver.element().click(shareWishlist);
		return new ShareWishListPage(driver);
		
	}


}
