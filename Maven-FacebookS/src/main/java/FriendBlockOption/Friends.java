package FriendBlockOption;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Friends {
	
	@FindBy (xpath = "//span[text()='All friends']")
	private WebElement allFriends;
	
	@FindBy (xpath = "(//span[text()='Friend Requests'])[1]")
	private WebElement friendRequest;
	
	@FindBy (xpath = "//span[text()='Suggestions']")
	private WebElement suggestions;
	
	@FindBy (xpath = "//span[text()='Birthdays']")
	private WebElement birthdays;

	@FindBy (xpath = "//span[text()='Custom Lists']")
	private WebElement customList;
	
	public Friends(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void showAllFriends() {
		allFriends.click();
	}
	
	
}
