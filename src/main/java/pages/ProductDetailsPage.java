package pages;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class ProductDetailsPage {
	private SHAFT.GUI.WebDriver driver;

	public ProductDetailsPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	// first product
	private By firstJacket = By.linkText("Lando Gym Jacket");
	private By size = By.id("option-label-size-143-item-168");
	private By color = By.id("option-label-color-93-item-53");
	private By addToCartCbtn = By.id("product-addtocart-button");
	private By showProductCart = By.linkText("shopping cart");

	public void firstProduct() {
		driver.element().click(firstJacket);
	}

	public AddToCartDetailsPage addFirstProductToCart() {
		driver.element().click(size);
		driver.element().click(color);
		driver.element().click(addToCartCbtn);
		driver.element().click(showProductCart);
		return new AddToCartDetailsPage(driver);
		
	}
	

	public String firstProductAssertion() {
		return driver.element().getText(firstJacket);
	}

	public By getFirstProductAssertionLocator() {
		return firstJacket;
	}

	// second product
	private By secondProduct = By.linkText("Caesar Warm-Up Pant");
	private By scondProductSize = By.id("option-label-size-143-item-176");
	private By secondProductColor = By.id("option-label-color-93-item-49");

	public void secondProduct() {
		driver.element().click(secondProduct);
	}

	public void addSecondProductToCart() {
		driver.element().click(scondProductSize);
		driver.element().click(secondProductColor);
		driver.element().click(addToCartCbtn);
		driver.element().click(showProductCart);
	}

	public String seocnProductAssertion() {
		return driver.element().getText(secondProduct);
	}

	public By getSecondAssertionLocator() {
		return secondProduct;
	}

	// add your review
	private By addReviewBtn = By.linkText("Add Your Review");

	public AddReviewPage navigateToAddToreview() {
		driver.element().click(addReviewBtn);
		return new AddReviewPage(driver);
	}

	// add to wish list
	private By navigateToWishList = By.cssSelector(".product-addto-links > a:nth-child(1)");

	public AddToWishlistPage addToWishList() {
		driver.element().click(navigateToWishList);
		return new AddToWishlistPage(driver);
	}

	// add to compare list
	private By addToCompareListBtn = By.cssSelector(".product-addto-links > a:nth-child(2) > span:nth-child(1)");
	private By showCompareList = By.linkText("comparison list");

	public AddToCompareListPage addToCompareList() {
		driver.element().click(addToCompareListBtn);
		driver.element().click(showCompareList);
		return new AddToCompareListPage(driver);
	}

	// navigate Checkout Page
	private By checkOutBtn = By.cssSelector("ul.checkout > li:nth-child(1) > button:nth-child(1)");

	public CheckOutPage navigateToCheckOutPage() {
		driver.element().click(checkOutBtn);
		return new CheckOutPage(driver);
	}
}
