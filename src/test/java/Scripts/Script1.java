package Scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemyTrip.DataDrivers.readPropertiesfile;
import com.makemyTrip.pages.FlightsResultsPage;
import com.makemyTrip.pages.HeaderPage;
import com.makemyTrip.pages.HomePage;

public class Script1 {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception{
		driver = BaseTest.lauchBrowser("Chrome", readPropertiesfile.readData("url"));
	}
	
	@Test
	public void seachForFlights() {
		try {
		HomePage homePage = new HomePage(BaseTest.getDriver());
		homePage.closeNotificationButton();
		HeaderPage headerPage = new HeaderPage(BaseTest.getDriver());
		headerPage.clickTabLink("Flights");
		homePage.selectFromAndToInputs("Chennai, India", "Mumbai, India");
		homePage.clickSearch();
		FlightsResultsPage flp = new FlightsResultsPage(BaseTest.getDriver());
		String statusOFFlight = flp.selectFlightName("Akasa Air");
		if(statusOFFlight.contains("checked")) {
			Assert.assertTrue(true, "Assertion failsed");
		}else {
			Assert.assertTrue(false);
		}
		String stopstatus = flp.selecStopsFilter("Non Stop");
		if(stopstatus.contains("checked")) {
			Assert.assertTrue(true, "Assertion failsed");
		}else {
			Assert.assertTrue(false);
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		WebElement ele = driver.findElement(By.xpath("//div[@class=\"rangeslider__fill\"]"));
		Point point = ele.getLocation();
		int x = point.x;
		int y = point.y;
		System.out.println(point.x);
		System.out.println(point.y);
		WebElement ele1 = driver.findElement(By.xpath("//div[@class=\"rangeslider__handle\"]"));
		Actions action = new Actions(driver);
		action.clickAndHold(ele1).moveToElement(ele, 0, 0).build().perform();
		
	}
	
	@Test
	public void seachForFlights1() {
		try {
		HomePage homePage = new HomePage(BaseTest.getDriver());
		homePage.closeNotificationButton();
		HeaderPage headerPage = new HeaderPage(BaseTest.getDriver());
		headerPage.clickTabLink("Flights");
		homePage.selectFromAndToInputs("Chennai, India", "Mumbai, India");
		homePage.clickSearch();
		FlightsResultsPage flp = new FlightsResultsPage(BaseTest.getDriver());
		String statusOFFlight = flp.selectFlightName("Akasa Air");
		if(statusOFFlight.contains("checked")) {
			Assert.assertTrue(true, "Assertion failsed");
		}else {
			Assert.assertTrue(false);
		}
		String stopstatus = flp.selecStopsFilter("Non Stop");
		if(stopstatus.contains("checked")) {
			Assert.assertTrue(true, "Assertion failsed");
		}else {
			Assert.assertTrue(false);
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		WebElement ele = driver.findElement(By.xpath("//div[@class=\"rangeslider__fill\"]"));
		Point point = ele.getLocation();
		int x = point.x;
		int y = point.y;
		System.out.println(point.x);
		System.out.println(point.y);
		WebElement ele1 = driver.findElement(By.xpath("//div[@class=\"rangeslider__handle\"]"));
		Actions action = new Actions(driver);
		action.clickAndHold(ele1).moveToElement(ele, 0, 0).build().perform();
		
	}
	
	@AfterMethod
	public void postActions() {
	//	driver.quit();
		
	}

}
