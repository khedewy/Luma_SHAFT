package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class RegisterPage {
	private SHAFT.GUI.WebDriver driver;

	public RegisterPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By firstNameTxt = By.id("firstname");
	private By lastNameTxt = By.id("lastname");
	private By newRegisterBtn = By.id("is_subscribed");
	private By emailTxt = By.id("email_address");
	private By passwordTxt = By.id("password");
	private By confirmPassword = By.id("password-confirmation");
	private By createSccountButton = By.cssSelector("button.action.submit.primary");
	private By assertionMessage = By.cssSelector(".message-success > div:nth-child(1)");
	private By OptionsList = By
			.cssSelector("ul.header:nth-child(2) > li:nth-child(2) > span:nth-child(1) > button:nth-child(1)");
	private By logOutOption = By.linkText("Sign Out");
	private By logOutAssertion = By.cssSelector("ul.header:nth-child(2) > li:nth-child(1) > span:nth-child(1)");

	public void UserData(String firstName, String lasrName, String email, String password) {
		driver.element().type(firstNameTxt, firstName);
		driver.element().type(lastNameTxt, lasrName);
		driver.element().click(newRegisterBtn);
		driver.element().type(emailTxt, email);
		driver.element().type(passwordTxt, password);
		driver.element().type(confirmPassword, password);
		driver.element().click(createSccountButton);
	}

	public void LogOut() {
		driver.element().click(OptionsList);
		driver.element().click(logOutOption);
	}

	public String assertionMessageText() {
		return driver.element().getText(assertionMessage);
	}

	public By getAssertionLocator() {
		return assertionMessage;
	}

	public String getlogOutAssertionMessage() {
		return driver.element().getText(logOutAssertion);
	}

	public By logOutAssertionLocator() {
		return logOutAssertion;
	}

}
