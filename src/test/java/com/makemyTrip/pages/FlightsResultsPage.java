package com.makemyTrip.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.makemyTrip.SeleniumUtilites.SeleniumWebElements;

import dev.failsafe.internal.util.Assert;

public class FlightsResultsPage {
	WebDriver driver;
	
	public FlightsResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String selectFlightName(String flightName) throws Exception {
		String flightNameChkLoc = "//span[@title='"+flightName+"']/ancestor::label";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flightNameChkLoc)));
		WebElement element = driver.findElement(By.xpath(flightNameChkLoc));
		SeleniumWebElements.clikOnElement(element);
		String value = driver.findElement(By.xpath(flightNameChkLoc)).getAttribute("class");
		System.out.println(value);
		return value;
	}
	
	public String selecStopsFilter(String stops) throws Exception {
		String stopsLocator = "(//span[@title='"+stops+"']/ancestor::label)[last()]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stopsLocator)));
		WebElement element = driver.findElement(By.xpath(stopsLocator));
		SeleniumWebElements.clikOnElement(element);
		String value = driver.findElement(By.xpath(stopsLocator)).getAttribute("class");
		System.out.println(value);
		return value;
	}

}
