package FriendBlockOption;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllFriendsList {
	
	WebDriverWait wait;
	Actions act ;
	
	@FindBy (xpath ="//input[@placeholder='Search Friends']")
	private WebElement searchFriendsbar;
	
	@FindBy (xpath = "(//a[@tabindex='0'])[11]//i")
	private WebElement explorefriend;
	// ((//a[contains(@class,'qi72231t o9w3sbdw nu7423ey tav9wjvu')])[15]//div)[13] //

	@FindBy (xpath = "(//div[contains(@class,'o9w3sbdw gsbrmxu4 al')]//div)[9]//span")
	private WebElement message;
	
	@FindBy (xpath = "(//div[contains(@class,'o9w3sbdw gsbrmxu4 al')]//div)[15]//span")
	private WebElement unfollow;
	
	@FindBy (xpath = "(//div[contains(@class,'o9w3sbdw gsbrmxu4 al')]//div)[22]//span")
	private WebElement block;
	
	@FindBy (xpath = "(//div[contains(@class,'o9w3sbdw gsbrmxu4 al')]//div)[29]//span")
	private WebElement unfriend;
	
	// index 0-1-2-3 //
	@FindBy (xpath = "//span[contains(@class,'gvxzyvdx aeinzg81 t7p7dqev')]")
	private List<WebElement> explorefriendoptions;
	
	@FindBy (xpath = "//div[@class='om3e55n1 alzwoclg']")
	private WebElement yourprofileacc;
	
	@FindBy (xpath = "(//div[@class='jroqu855 nthtkgg5'])[5]")
	private WebElement logout;
	
	@FindBy (xpath = "//div[@aria-label='Close']")
	private WebElement unfriendtabclose;
	
	@FindBy (xpath = "//div[@class='b0ur3jhr facqkgn9 s8sjc6am h28iztb5']")
	private WebElement blocktabclose;
	
	public AllFriendsList(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,3);
		act = new Actions(driver);
		
	}
	
	public void inputForSearchFriend(String friendNamee) {
		wait.until(ExpectedConditions.visibilityOf(searchFriendsbar));
		act.moveToElement(searchFriendsbar).click().sendKeys(friendNamee).build().perform();
	}
	
	public void openExploreFriend(WebDriver driver) {
		wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(explorefriend));
		act.moveToElement(explorefriend).click().build().perform();
	}
	
	// index 0-1-2-3 //
	public String clickOnExploreFriendOption(int i) {
		wait.until(ExpectedConditions.visibilityOf(message));
		String buttonName = explorefriendoptions.get(i).getText();
		//explorefriendoptions.get(i).click();
		return buttonName;
	}
	
	public String clickOnMessageButton(WebDriver driver) {
		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(message));
		String buttonName = message.getText();
		act.moveToElement(message).click().build().perform();
		return buttonName;
	}
	
	public String clickOnUnfollowButton() {
		wait.until(ExpectedConditions.visibilityOf(unfollow));
		String buttonName = unfollow.getText();
		unfollow.click();
		return buttonName;
	}
	
	public String clickOnBlockButton() {
		wait.until(ExpectedConditions.visibilityOf(message));
		String buttonName = block.getText();
		block.click();
		blocktabclose.click();
		return buttonName;
	}
	
	public String clickOnUnfriendButton() {
		wait.until(ExpectedConditions.visibilityOf(message));
		String buttonName = unfriend.getText();
		unfriend.click();
		unfriendtabclose.click();
		return buttonName;
	}
	
	public void Logout() {
		yourprofileacc.click();
		wait.until(ExpectedConditions.visibilityOf(logout));
		logout.click();
	}
	
	public void clickOnUnfriendtabClose() {
		unfriendtabclose.click();
	}

}
