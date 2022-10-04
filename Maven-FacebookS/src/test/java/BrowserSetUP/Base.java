package BrowserSetUP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	
	public static WebDriver openChromeDriver() {
		System.setProperty("webdriver.chrome.driver", 
				"E:\\Velocity\\selenium\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openEdgeDriver() {
		System.setProperty("webdriver.edge.driver",
				"E:\\Velocity\\selenium\\msedgedriver.exe");
		 WebDriver driver = new EdgeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxDriver() {
		System.setProperty("webdriver.chrome.driver", 
				"\"E:\\Velocity\\selenium\\geckodriver.exe\"");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	

}
