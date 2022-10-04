package Login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private Actions act;
	private WebDriverWait wait;
	
	@FindBy (xpath = "(//input[@placeholder='Search Facebook'])[1]")
	private WebElement searchfacebook;
	
	@FindBy (xpath = "//span[text()='Friends']")
	private WebElement friends;
	
	@FindBy (xpath = "(//div[@aria-label='Messenger'])[1]")
	private WebElement messenger;
	
	@FindBy (xpath = "//a[text()='See all in Messenger']")
	private WebElement seeallinmessenger;
	
//	@FindBy (xpath = "(//span[text()='Done'])[2]")
//	private WebElement done;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		wait = new WebDriverWait(driver,5);
	}
	
	public void insertIntoSearch(String data) {
		wait.until(ExpectedConditions.visibilityOf(searchfacebook));
		act.moveToElement(searchfacebook).click().sendKeys(data).build().perform();        //sendkeys = "Ashutosh Kadukar"
		searchfacebook.sendKeys(Keys.ENTER);
	}
	
	public void openFriends() {
		friends.click();
	}
	
	public void clickonMessenger() {
		messenger.click();
	}
	
	public void openMessenger() {
		seeallinmessenger.click();
		//done.click();
	}
	

}
