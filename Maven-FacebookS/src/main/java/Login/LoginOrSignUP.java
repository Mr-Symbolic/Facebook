package Login;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Utility;

public class LoginOrSignUP {
	
	WebDriverWait wait;
	Actions act ;

	
	@FindBy (xpath = "//input[@id='email']")
	private WebElement username;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement password;
	
	@FindBy (xpath = "//button[@name='login']")       //     //button[text()='Log In']    //
	private WebElement login ;
	
	public LoginOrSignUP(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,8);
		act = new Actions(driver);
	}
	
	public void loginToApplication(String userName, String passWord) {
		username.sendKeys(userName);             //pratik57shirude@gmail.com
		password.sendKeys(passWord);             //SayaliP@5731
		act.moveToElement(login).click().build().perform();
	}
	
	public void inputUsername (String data)  {
		username.sendKeys(data);
		
	}
}
