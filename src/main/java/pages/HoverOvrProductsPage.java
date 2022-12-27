package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class HoverOvrProductsPage {
	private SHAFT.GUI.WebDriver driver;
	public HoverOvrProductsPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}
	private By men = By.id("ui-id-5");
	private By top = By.id("ui-id-17");
	private By jacket = By.id("ui-id-19");
	
	public void hoverOverMenProduct() {
		driver.element().hover(men);
		driver.element().hover(top);
		driver.element().click(jacket);
	}
	
	// gear
	private By gear = By.id("ui-id-6");
	private By bags = By.id("ui-id-25");
	
	public void hoverOverGearProducts() {
		driver.element().hover(gear);
		driver.element().click(bags);
	}

}
