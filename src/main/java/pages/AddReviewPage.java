package pages;



import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class AddReviewPage {
	private SHAFT.GUI.WebDriver driver;

	public AddReviewPage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	private By rateOptions = By.xpath("//*[@id=\"Rating_3_label\"]");
	private By nickNameTxt = By.id("nickname_field");
	private By summaryTxt = By.id("summary_field");
	private By reviewTxt = By.id("review_field");
	private By SubmitReviewBtn = By.cssSelector("button.action.submit.primary");
	private By assertionMessage = By.cssSelector(".message-success > div:nth-child(1)");

	public void addReview(String nickName, String summary, String reivew) {

		driver.element().type(nickNameTxt, nickName);
		driver.element().type(summaryTxt, summary);
		driver.element().type(reviewTxt, reivew);
		driver.element().click(rateOptions);
		driver.element().click(SubmitReviewBtn);
	}

	public String getAssertionMessage() {
		return driver.element().getText(assertionMessage);
	}

	public By assertionLocator() {
		return assertionMessage;
	}
}
