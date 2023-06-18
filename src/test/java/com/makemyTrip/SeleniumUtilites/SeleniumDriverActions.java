package com.makemyTrip.SeleniumUtilites;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import Scripts.BaseTest;

/**
 * 
 * @author basha online training
 *
 */

public class SeleniumDriverActions extends BaseTest {

	/**
	 * to refresh the browser
	 */
	public static void refresh() {
		driver.navigate().refresh();
	}

	/**
	 * to switch to window by title of page
	 * 
	 * @param title
	 */
	public static void SwitchingMultipleWindowByTitle(String title) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(title))
				break;
		}
	}

	/**
	 * to switch to window by url of page
	 * 
	 * @param url
	 */
	public static void SwitchingMutlpleWindowsByURL(String url) {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains(url))
				break;
		}
	}

	/**
	 * to handle web alers
	 * 
	 * @param value
	 * @param status
	 */
	public static void handleAlerts(String value, String status) {
		if (value.isEmpty() && status.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else if (value.isEmpty() && status.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		} else {
			driver.switchTo().alert().sendKeys(value);
			driver.switchTo().alert().accept();
		}
	}

	/**
	 * to wait for page load
	 */
	public static void pageRoadTimeOut() {
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	public static void switchToFrameByElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public static void switchTodefaultConent() {
		driver.switchTo().defaultContent();
	}
}
