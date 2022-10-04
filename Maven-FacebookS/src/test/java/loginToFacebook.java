

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Login.HomePage;
import Login.LoginOrSignUP;
import Login.PersonDetailPage;
import Login.SearchResult;
import Utils.Utility;

public class loginToFacebook {
	
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Velocity\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Login.LoginOrSignUP loginOrSignUP = new LoginOrSignUP(driver);
		String data = Utility.readExcelldata("Velocity", 0, 0);
		System.out.println(data);
		loginOrSignUP.inputUsername(data);
//		loginOrSignUP.loginToApplication();
//		Thread.sleep(3000);
//		
//		HomePage homePage = new HomePage(driver);
//		homePage.insertIntoSearch();
//		Thread.sleep(3000);
//		
//		SearchResult searchResult = new SearchResult(driver);
//		searchResult.clickonFirstSearch();
//		Thread.sleep(3000);
//		
//		PersonDetailPage personDetailPage = new PersonDetailPage(driver);
//		personDetailPage.clickonBackgroundImage();
	}
	


}
