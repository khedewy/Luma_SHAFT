package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class CheckOutPage {
	private SHAFT.GUI.WebDriver driver;

	public CheckOutPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By companyTxt = By.name("company");
	private By address1TxT = By.name("street[0]");
	private By address2Txt = By.name("street[1]");
	private By address3Txt = By.name("street[2]");
	private By cityTxt = By.name("city");
	private By country = By.name("country_id");
	private By stateTxt = By.name("region");
	private By postCodeTxt = By.name("postcode");
	private By numberTxt = By.name("telephone");
	private By radioBtn = By.name("ko_unique_3");
	private By nextBtn = By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button/span");
	private By assertionMessage = By.cssSelector(".payment-method-title > label:nth-child(2) > span:nth-child(1)");
	private By placeOrderBtn = By.cssSelector("button.action.primary.checkout");
	private By placeOrderAssertion = By.xpath("/html/body/div[2]/main/div[1]/h1/span");

	public void shippingAdress(String company, String address1, String address2, String address3, String city,
			String state, String postCode, String number) {
		driver.element().type(companyTxt, company);
		driver.element().type(address1TxT, address1);
		driver.element().type(address2Txt, address2);
		driver.element().type(address3Txt, address3);
		driver.element().type(cityTxt, city);
		driver.element().select(country, "Egypt");
		driver.element().type(stateTxt, state);
		driver.element().type(postCodeTxt, postCode);
		driver.element().type(numberTxt, number);
		driver.element().click(radioBtn);
	}
	
	public void clickNextBtn() {
		driver.element().click(nextBtn);
	}

	public String getAssertionMessageText() {
		return driver.element().getText(assertionMessage);
	}

	public By getAssertionLocator() {
		return assertionMessage;
	}

	public void clickPlaceOrder() {
		driver.element().click(placeOrderBtn);
	}

	public String placeOrderAssertionText() {
		return driver.element().getText(placeOrderAssertion);
	}

	public By placeOrderAssertionLocator() {
		return placeOrderAssertion;
	}

}
