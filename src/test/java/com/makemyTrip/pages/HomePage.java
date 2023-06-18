package com.makemyTrip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemyTrip.SeleniumUtilites.SeleniumDriverActions;
import com.makemyTrip.SeleniumUtilites.SeleniumWebElements;

public class HomePage {

	WebDriver driver;
	@FindBy(xpath = "//a[@class= 'close']")
	private WebElement closeBtn;
	
	@FindBy(xpath = "//li[text()='OneWay']")
	private WebElement oneWayRdo;
	
	@FindBy(xpath = "//label[@for='fromCity']")
	private WebElement fromCityLnk;
	
	@FindBy(xpath = "//input[@placeholder='From']")
	private WebElement fromTxt;
	
	@FindBy(xpath = "//label[@for='toCity']")
	private WebElement toCityLnk;
	
	@FindBy(id = "toCity")
	private WebElement toText;
	
	@FindBy(xpath = "//a[text()='Search']")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void closeNotificationButton() {
		try {
		WebElement iframeElement = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
		SeleniumDriverActions.switchToFrameByElement(iframeElement);
		SeleniumWebElements.clikOnElement(driver.findElement(By.xpath("//a[@class= 'close']")));
		SeleniumDriverActions.switchTodefaultConent();
		}catch(Exception e) {
			System.out.println("Add is not closed");
		}
	}
	
	public void clickOneWayBtn() {
		oneWayRdo.click();
	}
	
	public void selectFromAndToInputs(String fromCitym, String toCity) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", fromCityLnk);
		SeleniumWebElements.enterInputIntoElement(fromTxt, fromCitym);
		String fromLocator = "//p[contains(text(),'"+fromCitym+"')]";
		WebElement fromCity = driver.findElement(By.xpath(fromLocator));
		js.executeScript("arguments[0].click()", fromCity);
		js.executeScript("arguments[0].click()", toCityLnk);
		SeleniumWebElements.enterInputIntoElement(toText, toCity);
		String toLocator = "//p[contains(text(),'"+toCity+"')]";
		WebElement toCityLnk = driver.findElement(By.xpath(toLocator));
		js.executeScript("arguments[0].click()", toCityLnk);
	}
	
	public void clickSearch() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", searchButton);
	}
	
}
