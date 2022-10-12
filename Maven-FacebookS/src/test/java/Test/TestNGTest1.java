package Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import FriendBlockOption.AllFriendsList;
import FriendBlockOption.Friends;
import Login.HomePage;
import Login.LoginOrSignUP;
import Utils.Utility;

public class TestNGTest1 {
	
	private WebDriver driver;
	private SoftAssert soft;
	private LoginOrSignUP loginOrSignUP;
	private HomePage homePage;
	private Friends friends;
	private AllFriendsList allFriendsList;
	private String buttonText;
	private String url;
	private String title;
	private String expurl;
	private String exptitle;
	private String expButtonText;
	private int TestId;
	private ExtentTest test;
	private ExtentHtmlReporter reporter;
	
	@BeforeSuite
	public void beforesuit1() {
		System.out.println("Before Suite -Buttons");		
	}
	
	@Parameters("Browser")
	@BeforeTest
	public void LaunchBrowser(String BrowserName) {
		
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
	if(BrowserName.equals("Chrome"))            
	{
	    System.setProperty("webdriver.chrome.driver",
	    		"E:\\Velocity\\selenium\\chromedriver.exe");
	    driver = new ChromeDriver();
	}	
	if(BrowserName.equals("Edge"))
	{
		System.setProperty("webdriver.edge.driver",
				"E:\\Velocity\\selenium\\msedgedriver.exe");
		driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
	String userName = Utility.readExcelldata("Velocity", 0, 0);
	String passWord = Utility.readExcelldata("Velocity", 0, 1);
	
	loginOrSignUP.loginToApplication(userName,passWord);	
	url = driver.getCurrentUrl();
	System.out.println(url);
	title = driver.getTitle();
	System.out.println(title);
	
	expurl = Utility.readExcelldata("Velocity", 2, 0);
	exptitle = Utility.readExcelldata("Velocity", 2, 1);
	
	if (url.equals(expurl) && title.equals(exptitle))
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
	
	expurl = Utility.readExcelldata("Velocity", 3, 0);
	exptitle = Utility.readExcelldata("Velocity", 3, 1);
	
	if (url.equals(expurl) && title.equals(exptitle))
	{
		System.out.println("Result for Friendspage is : PASS");
	}
	else
	{
		System.out.println("Result for Friendspage is :FAIL");
	}
	
	System.out.println();
	
	friends.showAllFriends();
	String Name = Utility.readExcelldata("Velocity", 1, 0);
	
	allFriendsList.inputForSearchFriend(Name);
	allFriendsList.openExploreFriend(driver);
	soft = new SoftAssert(); 
	}
	
	@Test 
	public void VerifyMessageButtonActivity() throws EncryptedDocumentException, IOException{
	TestId = 0001 ;
	String buttonText = allFriendsList.clickOnMessageButton(driver);
	System.out.println(buttonText);
	
	url = driver.getCurrentUrl();
	System.out.println(url);
	
	title = driver.getTitle();
	System.out.println(title);
	System.out.println();
	
	expButtonText = Utility.readExcelldata("Velocity", 4, 2);
	expurl = Utility.readExcelldata("Velocity", 4, 0);
	exptitle = Utility.readExcelldata("Velocity", 4, 1);
	
	soft.assertEquals(buttonText, expButtonText,"Text Of Message button is wrong.");
	soft.assertEquals(url, expurl, "URL of 'All friends | Facebook'Page is wrong");
	soft.assertEquals(title, exptitle, "title Of Message button page is wrong");
	soft.assertAll();
	System.out.println();
	}
	
	@Test 
	public void VerifyUnfrienButtonActivity() throws EncryptedDocumentException, IOException {
		TestId = 0002;
		String buttonText = allFriendsList.clickOnUnfriendButton();
		System.out.println(buttonText);
		
		url = driver.getCurrentUrl();
		System.out.println(url);
		
		title = driver.getTitle();
		System.out.println(title);
		System.out.println();
		
		expButtonText = Utility.readExcelldata("Velocity", 5, 2);
		expurl = Utility.readExcelldata("Velocity", 5, 0);
		exptitle = Utility.readExcelldata("Velocity", 5, 1);
		
		soft.assertEquals(buttonText,expButtonText);
		System.out.println("ButtonText Of Message is : Passed");
		
		soft.assertEquals(url,expurl);
		System.out.println("URL Of page is matched");
		
		soft.assertEquals(title,exptitle);
		System.out.println("END");
	}
	
	@AfterMethod
	public void LogoutFromAcc(ITestResult result) throws IOException {
	if(ITestResult.FAILURE == result.getStatus()) {
		Utility.capturedScreenshot(driver, TestId);
	}
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
