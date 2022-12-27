package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class AddToCartDetailsPage {
	private SHAFT.GUI.WebDriver driver;
	public AddToCartDetailsPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}
	
	private By quantityBox = By.cssSelector("input.input-text.qty");
	private By deleteItems = By.cssSelector("a.action:nth-child(3)");
	private By updateCartBtn = By.cssSelector("button.action:nth-child(3)");
	private By changeQuantityAssertion = By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/div/table/tbody/tr[4]/td/strong/span");
	
	public void changeQauntity(String quantity) {
		driver.element().type(quantityBox, quantity);
		driver.element().click(updateCartBtn);
	}
	
	public void deleteItems() {
		driver.element().click(deleteItems);
	}
	
	public String getAssertionText() {
		return driver.element().getText(changeQuantityAssertion);
	}
	public By getChangeQuantityLocator() {
		return changeQuantityAssertion;
	}

}
