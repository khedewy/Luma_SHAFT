package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.shaft.driver.SHAFT;

public class HomePage {
	private SHAFT.GUI.WebDriver driver;

	public HomePage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By createEmailButton = By.linkText("Create an Account");
	private By loginButton = By.linkText("Sign In");
	private By emailSubscribe = By.id("newsletter");
	private By searchBox = By.id("search");
	private By firstProduct = By.id("qs-option-5");
	private By secondProduct = By.id("qs-option-6");
	private By subscribtionAssertion = By.cssSelector(".message-success > div:nth-child(1)");

	public RegisterPage navigateToRegisterPage() {
		driver.element().click(createEmailButton);
		return new RegisterPage(driver);
	}

	public ProductDetailsPage navigateToFirstProduct(String ProductOne) {
		driver.element().type(searchBox, ProductOne);
		driver.element().click(firstProduct);
		return new ProductDetailsPage(driver);
	}

	public ProductDetailsPage navigateToSecondProduct(String ProductTow) {
		driver.element().type(searchBox, ProductTow);
		driver.element().click(secondProduct);
		return new ProductDetailsPage(driver);
	}

	public LoginPage navigateToLoginPage() {
		driver.element().click(loginButton);
		return new LoginPage(driver);
	}

	public void subscribeAsNewAccount(String email) {
		driver.element().type(emailSubscribe, email).keyPress(emailSubscribe, Keys.ENTER);
	}
	
	public String getAssertionMessage() {
		return driver.element().getText(subscribtionAssertion);
	}
	
	public By getSubscribtionLocator() {
		return subscribtionAssertion;
	}

}
