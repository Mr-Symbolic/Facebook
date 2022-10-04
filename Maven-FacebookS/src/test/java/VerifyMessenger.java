import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import FriendBlockOption.AllFriendsList;
import Login.HomePage;
import Login.LoginOrSignUP;
import TextOnMessenger.MessengerPage;
import Utils.Utility;

public class VerifyMessenger {
	
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
	
	
	System.setProperty("webdriver.chrome.driver", "E:\\Velocity\\selenium\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.navigate().to("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	LoginOrSignUP loginOrSignUP = new LoginOrSignUP(driver);
	String userName = Utility.readExcelldata("Velocity", 0, 4);
	String passWord = Utility.readExcelldata("Velocity", 1, 4);
	loginOrSignUP.loginToApplication(userName,passWord);
	
	HomePage homePage = new HomePage(driver);
	homePage.clickonMessenger();
	homePage.openMessenger();
		
	MessengerPage messengerPage = new MessengerPage(driver);
	messengerPage.sendInFrndSearchBar();
	
	AllFriendsList allFriendsList = new AllFriendsList(driver);
	allFriendsList.Logout();
	driver.close();
	}
}
