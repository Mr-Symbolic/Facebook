package Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonDetailPage {
	
	private Actions act;
	private WebDriverWait wait;
	
	@FindBy (xpath = "//img[@data-imgperflogname=\"profileCoverPhoto\"]")
	private WebElement backgroundimage;

	public PersonDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		wait = new WebDriverWait(driver,5);
	}
	
	public void clickonBackgroundImage() {
		wait.until(ExpectedConditions.visibilityOf(backgroundimage));
		act.moveToElement(backgroundimage).click().build().perform();
	}

}
