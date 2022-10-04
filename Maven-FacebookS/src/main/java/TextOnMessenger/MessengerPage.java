package TextOnMessenger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessengerPage {
	
	private WebDriverWait wait;
	
	@FindBy (xpath = "//input[@aria-label='Search Messenger']")
	private WebElement frndsearchbar;
	
	@FindBy (xpath = "//span[text()='mandark126']")
	private WebElement mandar;
	
	public MessengerPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver,10);
	}
	
	public void sendInFrndSearchBar() {
		frndsearchbar.sendKeys("Mandar Kulkarni");
		//wait.until(ExpectedConditions.visibilityOf(mandar));
		mandar.click();		
	}
}
