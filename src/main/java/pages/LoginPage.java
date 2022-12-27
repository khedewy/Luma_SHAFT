package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class LoginPage {
	private SHAFT.GUI.WebDriver driver;

	public LoginPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By emailTxt = By.id("email");
	private By passwordTxt = By.name("login[password]");
	private By logButton = By.cssSelector("button.action.login.primary");
	
	public void UserLogIN(String email, String pass) {
		driver.element().type(emailTxt, email);
		driver.element().type(passwordTxt, pass);
		driver.element().click(logButton);
	}

}
