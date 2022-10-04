package Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResult {
	
	private Actions act;
	private WebDriverWait wait;
	
	@FindBy (xpath = "(//a[@role='presentation'])[1]")
	private WebElement firstresult;

	public SearchResult(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		wait = new WebDriverWait(driver,5);
	}
	
	public void clickonFirstSearch() {
		wait.until(ExpectedConditions.visibilityOf(firstresult));
		act.moveToElement(firstresult).click().build().perform();
	}
}
