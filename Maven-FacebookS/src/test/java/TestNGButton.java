import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



import FriendBlockOption.AllFriendsList;
import FriendBlockOption.Friends;
import Login.HomePage;
import Login.LoginOrSignUP;
import Utils.Utility;

public class TestNGButton {
	
	private WebDriver driver;
	private SoftAssert soft;
	private LoginOrSignUP loginOrSignUP;
	private HomePage homePage;
	private Friends friends;
	private AllFriendsList allFriendsList;
	private String buttonText;
	private String url;
	private String title;
	
	@BeforeSuite
	public void beforesuit1() {
		System.out.println("Before Suite -Buttons");		
	}
	
	@Parameters("Browser")
	@BeforeTest
	public void LaunchBrowser(String BrowserName) {
	if(BrowserName.equals("Chrome"))
	{
	    System.setProperty("webdriver.chrome.driver",
	    		"E:\\Velocity\\selenium\\chromedriver.exe");
	    driver = new ChromeDriver();
	}
	
	if(BrowserName.equals("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver",
				"E:\\Velocity\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	if(BrowserName.equals("Edge"))
	{
		System.setProperty("webdriver.edge.driver",
				"E:\\Velocity\\selenium\\msedgedriver.exe");
		driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void CreatePOMObjects() {
		loginOrSignUP = new LoginOrSignUP(driver);
		homePage = new HomePage(driver);
		friends = new Friends(driver);
		allFriendsList = new AllFriendsList(driver);
	}
	
	@BeforeMethod
	public void EnterInFacebook() throws InterruptedException, EncryptedDocumentException, IOException {
	driver.navigate().to("https://www.facebook.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String userName = Utility.readExcelldata("Velocity", 0, 4);
	String passWord = Utility.readExcelldata("Velocity", 1, 4);
	loginOrSignUP.loginToApplication(userName,passWord);	
	
	url = driver.getCurrentUrl();
	System.out.println(url);
	title = driver.getTitle();
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
	allFriendsList.inputForSearchFriend("Michael Leung");
	allFriendsList.openExploreFriend(driver);
	soft = new SoftAssert(); 
	}
	
	
	@Test 
	public void VerifyMessageButtonActivity(){
	String buttonText = allFriendsList.clickOnMessageButton(driver);
	System.out.println(buttonText);
	
	url = driver.getCurrentUrl();
	System.out.println(url);
	
	title = driver.getTitle();
	System.out.println(title);
	System.out.println();
	
	
	soft.assertEquals(buttonText, "Message Michael","Text Of Message button is wrong.");
	soft.assertEquals(url, "https://www.facebook.com/friends/list", "URL of 'All friends | Facebook'Page is wrong");
	soft.assertEquals(title, "All friends | Facebook", "title Of Message button page is wrong");
	soft.assertAll();
//	if (buttonText.equals("Message Michael") && url.equals("https://www.facebook.com/friends/list")
//			&& title.equals("All friends | Facebook"))
//	{
//		System.out.println("Result for All Friendspage is : PASS");
//	}
//	else
//	{
//		System.out.println("Result for All Friendspage is : FAIL");
//	}
	System.out.println();
	}
	
	@Test 
	public void VerifyUnfrienButtonActivity() {
		
		String buttonText = allFriendsList.clickOnUnfriendButton();
		System.out.println(buttonText);
		
		url = driver.getCurrentUrl();
		System.out.println(url);
		
		title = driver.getTitle();
		System.out.println(title);
		System.out.println();
		
		soft.assertEquals(buttonText, "Unfriend Michael");
		System.out.println("ButtonText Of Message is : Passed");
		soft.assertEquals(url, "https://www.facebook.com/friends/list");
		System.out.println("URL Of page is matched");
		soft.assertEquals(title, "All friends |");
		System.out.println("END");
		
		
//		if (buttonText.equals("Unfriend Michael") && url.equals("https://www.facebook.com/friends/list")
//				&& title.equals("All friends | Facebook"))
//		{
//			System.out.println("Result for All Friendspage is : PASS");
//		}
//		else
//		{
//			System.out.println("Result for All Friendspage is : FAIL");
//		}
		allFriendsList.clickOnUnfriendtabClose();
	}
	
	@Test 
	public void VerifyUnfollowButtonActivity() {
		String buttonText = allFriendsList.clickOnUnfollowButton();
		System.out.println(buttonText);
		
		url = driver.getCurrentUrl();
		System.out.println(url);
		
		title = driver.getTitle();
		System.out.println(title);
		System.out.println();
		
		allFriendsList.openExploreFriend(driver);
		String newbuttonText = allFriendsList.clickOnUnfollowButton();
		System.out.println(newbuttonText);
		
		if (buttonText.equals(newbuttonText))
		{
			System.out.println("Result for All Friendspage is : FAIL");
		}
		else
		{
			System.out.println("Result for All Friendspage is : PASS");
		}
		
		if (url.equals("https://www.facebook.com/friends/list")
				&& title.equals("All friends | Facebook"))
		{
			System.out.println("Result for All Friendspage is : PASS");
		}
		else
		{
			System.out.println("Result for All Friendspage is : FAIL");
		}	
		
	}
	
	
	@Test 
	public void VerifyBlockButtonActivity() {
		String buttonText = allFriendsList.clickOnBlockButton();
		System.out.println(buttonText);
		
		url = driver.getCurrentUrl();
		System.out.println(url);
		
		title = driver.getTitle();
		System.out.println(title);
		System.out.println();
		
		if (buttonText.equals("Block Michael's profile") && url.equals("https://www.facebook.com/friends/list")
				&& title.equals("All friends | Facebook"))
		{
			System.out.println("Result for All Friendspage is : PASS");
		}
		else
		{
			System.out.println("Result for All Friendspage is : FAIL");
		}
	}
	
	
	
	@AfterMethod
	public void LogoutFromAcc() {
	allFriendsList.Logout();	
	System.out.println("Logout sucessfully done.");
	}
	
	
	@AfterClass
	public void removePOMObjects() {
		loginOrSignUP = null;
		homePage = null;
		allFriendsList = null;
		friends = null;
	
	}
	
	@AfterTest
	public void ExitFromBrowser() {
		driver.close();
		System.out.println("Browser successfully closed.");
		driver = null;
		System.gc();
		}
	
	@AfterSuite
	public void aftersuit1() {
		System.out.println("After Suite -Buttons");		
	}
	
	

}
