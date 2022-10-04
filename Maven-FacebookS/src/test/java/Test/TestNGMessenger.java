package Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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

import FriendBlockOption.AllFriendsList;
import Login.HomePage;
import Login.LoginOrSignUP;
import TextOnMessenger.MessengerPage;
import Utils.Utility;

public class TestNGMessenger {
	
	private WebDriver driver ;
	private AllFriendsList allFriendsList;
	private LoginOrSignUP loginOrSignUP;
	private HomePage homePage ;
	private MessengerPage messengerPage;
	private int TestId;
	
	@BeforeSuite
	public void beforesuit2() {
		System.out.println("Before Suite -Messenger");		
	}
	
	
	@Parameters("Browser")
	@BeforeTest
	public void LaunchFacebookApp(String BrowserName) {
		
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
	public void CreatePOMObjectsFB() {
		loginOrSignUP = new LoginOrSignUP(driver);
		homePage = new HomePage(driver);
		messengerPage = new MessengerPage(driver);
		allFriendsList = new AllFriendsList(driver);
	}
	
	
	@BeforeMethod
	public void OpenFacebookWindow() {
		driver.navigate().to("https://www.facebook.com/");
//		loginOrSignUP.loginToApplication();
	}
	
	@Test
	public void VerifyMessenger() throws EncryptedDocumentException, IOException {
		TestId = 0011;
		String userName = Utility.readExcelldata("Velocity", 0, 0);
		String passWord = Utility.readExcelldata("Velocity", 0, 1);
		loginOrSignUP.loginToApplication(userName,passWord);
		homePage.clickonMessenger();
		homePage.openMessenger();
		messengerPage.sendInFrndSearchBar();
	}
	
	@AfterMethod
	public void LogoutFromcurrentAcc(ITestResult result) throws IOException {
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.capturedScreenshot(driver, TestId);
		}
		
	allFriendsList.Logout();	
	System.out.println("Logout sucessfully done.");
	}
	
	@AfterClass
	public void removePOMObjectsFB() {
		loginOrSignUP = null;
		homePage = null;
		messengerPage = null;
		allFriendsList = null;
		
	}
	
	@AfterTest
	public void ExitFromBrowser() {
		driver.close();
		System.out.println("Browser successfully closed.");
		driver = null;
		System.gc();
		}
	
	@AfterSuite
	public void aftersuit2() {
		System.out.println("After Suite -Messenger");		
	}


}
