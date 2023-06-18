package Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
public class BaseTest {

	public static WebDriver driver;

	 public static WebDriver getDriver() {
	        return driver;
	  }
	 
	 @BeforeSuite
	 public void beforeSuite() {
		// Log.info("Tests is starting!");
	 }

	public static WebDriver lauchBrowser(String browserName, String url) {
		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;
		case "FireFox":
			System.setProperty("webdriver.geckodriver.driver", "/BrowserDrivers/firefoxdriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", "/BrowserDrivers/internetexplorer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;
		default:
			driver = null;
		}
		return driver;
	}
	
	 @AfterSuite
	 public void afterSuite() {
		// Log.info("Tests are ending!");
		 driver.quit();
	 }

}
