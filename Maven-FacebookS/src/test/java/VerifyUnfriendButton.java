import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import FriendBlockOption.AllFriendsList;
import FriendBlockOption.Friends;
import Login.HomePage;
import Login.LoginOrSignUP;
import Utils.Utility;

public class VerifyUnfriendButton {
	
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
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		
		if (url.equals("https://www.facebook.com/") && title.equals("Facebook"))
		{
			System.out.println("Result for Homepage is : PASS");
		}
		else
		{
			System.out.println("Result for Homepage is :FAIL");
		}
		
		System.out.println();
		homePage.openFriends();
//--------------------------------------------------------------------------------------		
		
		Friends friends = new Friends(driver);
		Thread.sleep(500);
		url = driver.getCurrentUrl();
		System.out.println(url);
		Thread.sleep(1500);
	    title = driver.getTitle();
		System.out.println(title);
		
		if (url.equals("https://www.facebook.com/friends") && title.equals("Friends | Facebook"))
		{
			System.out.println("Result for Friendspage is : PASS");
		}
		else
		{
			System.out.println("Result for Friendspage is :FAIL");
		}
		
		System.out.println();
		friends.showAllFriends();
//--------------------------------------------------------------------------------------	
				
		AllFriendsList allFriendsList = new AllFriendsList(driver);
		String Name = Utility.readExcelldata("Velocity", 1, 0);
		allFriendsList.inputForSearchFriend(Name);
		allFriendsList.openExploreFriend(driver);
	
		String buttonText = allFriendsList.clickOnUnfriendButton();
		System.out.println(buttonText);
		
		url = driver.getCurrentUrl();
		System.out.println(url);
		
		title = driver.getTitle();
		System.out.println(title);
		System.out.println();
		
		if (buttonText.equals("Unfriend Michael") && url.equals("https://www.facebook.com/friends/list")
				&& title.equals("All friends | Facebook"))
		{
			System.out.println("Result for All Friendspage is : PASS");
		}
		else
		{
			System.out.println("Result for All Friendspage is : FAIL");
		}
		allFriendsList.clickOnUnfriendtabClose();
//---------------------------------------------------------------------------------		
		Thread.sleep(2000);
		allFriendsList.Logout();
		
		Thread.sleep(2000);
		
		driver.close();
	}
	
	

}
