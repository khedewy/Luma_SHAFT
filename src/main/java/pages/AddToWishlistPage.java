package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class AddToWishlistPage {
	private SHAFT.GUI.WebDriver driver;

	public AddToWishlistPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By assertionMessage = By.cssSelector(".message-success > div:nth-child(1)");

	public String getassertionText() {
		return driver.element().getText(assertionMessage);
	}

	public By getassertionLocator() {
		return assertionMessage;
	}

}
