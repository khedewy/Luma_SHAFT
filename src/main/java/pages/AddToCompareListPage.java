package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class AddToCompareListPage {
	private SHAFT.GUI.WebDriver driver;

	public AddToCompareListPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By assertionMessage = By.cssSelector("span.counter:nth-child(1)");
	public By secondProductAssertion = By.cssSelector("span.counter:nth-child(1)");
	

	public String assertionMessage() {
		return driver.element().getText(assertionMessage);
	}
	
	public By getassertionLocator() {
		return assertionMessage;
	}
	
	public String secondProductAssertion() {
		return driver.element().getText(secondProductAssertion);
	}
	public By getSecondAssertionLocator() {
		return secondProductAssertion;
	}

}
