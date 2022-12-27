package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class ShareWishListPage {
	private SHAFT.GUI.WebDriver driver;
	public ShareWishListPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}
	
	private By emailTxt = By.id("email_address");
	private By messageTxt = By.id("message");
	private By shareWishList = By.cssSelector("button.action.submit.primary");
	private By shareAssertion = By.cssSelector(".message-success > div:nth-child(1)");
	
	public void enterShareListData(String email, String message) {
		driver.element().type(emailTxt, email);
		driver.element().type(messageTxt, message);
		driver.element().click(shareWishList);
	}
	
	public String getassertionMessage() {
		return driver.element().getText(shareAssertion);
	}
	
	public By getassertionLocator() {
		return shareAssertion;
	}

}
