package com.makemyTrip.SeleniumUtilites;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.makemyTrip.Utils.Log;
import com.makemyTrip.listeners.TestNGListener;

import Scripts.BaseTest;

/**
 * 
 * @author Basha Online Training
 *
 */
public class SeleniumWebElements extends TestNGListener {

	/**
	 * to pass input to text box or text area
	 * 
	 * @param element
	 * @param input
	 * @throws Exception
	 */
	public static void enterInputIntoElement(WebElement element, String input) throws Exception {
		try {
			element.isDisplayed();
			element.sendKeys(input);
			test.log(Status.PASS, element + " passed");
		} catch (Exception e) {
			test.log(Status.FAIL, element + " failed");
			throw e;
		}
	}

	/**
	 * to pass input to text box or text area
	 * 
	 * @param element
	 * @param input
	 * @throws Exception
	 */
	public static void enterInputIntoElement(WebElement element, String input, int time) throws Exception {
		try {
			element.isDisplayed();
			element.sendKeys(input);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * to click on a element
	 * 
	 * @param element
	 * @throws Exception
	 */
	public static void clikOnElement(WebElement element) throws Exception {
		try {
			element.isDisplayed();
			element.click();
			test.log(Status.PASS, element + " passed");
		} catch (Exception e) {
			test.log(Status.FAIL, element + " failed");
			throw e;
		}

	}

	/**
	 * to pause execution
	 * 
	 * @param time
	 * @throws InterruptedException
	 */
	public static void Wait(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	/**
	 * to get the text of an element
	 * 
	 * @param element
	 * @return
	 */
	public static String getTextOfElement(WebElement element) {
		try {
			element.isDisplayed();
			return element.getText();
		} catch (Exception e) {
			return "";
		}

	}

	/**
	 * to get the attribute value
	 * 
	 * @param element
	 * @param attribute name
	 * @return
	 */

	public static String getAttributeOfElement(WebElement element, String attribute) {
		try {
			element.isDisplayed();
			return element.getAttribute(attribute);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * to click on checkbox or radio button
	 * 
	 * @param element
	 * @throws Exception
	 */
	public static void clickCheckBoxOrRadioButton(WebElement element) throws Exception {
		try {
			element.isDisplayed();
			clikOnElement(element);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * to select a value form dropdown
	 * 
	 * @param element
	 * @param value
	 */
	public static void selectValueFromDropDown(WebElement element, String value) {
		Select selection = new Select(element);
		List<WebElement> options = selection.getOptions();
		for (WebElement ele : options) {
			if (ele.getText().equalsIgnoreCase(value)) {
				selection.selectByValue(value);
				break;
			}
		}
	}

	/**
	 * to verify the dropdown values
	 * 
	 * @param element
	 * @param values
	 */
	public static void verifyPickListValues(WebElement element, String[] values) {
		Select selection = new Select(element);
		List<WebElement> options = selection.getOptions();
		for (WebElement ele : options) {
			for (int i = 0; i < values.length; i++) {
				assertTrue(ele.getText().equalsIgnoreCase(values[i]));
				break;
			}
		}
	}

	/**
	 * to move the mouse to element
	 * 
	 * @param element
	 */
	public static void moveToElement(WebElement element) {
		Actions action = new Actions(BaseTest.getDriver());
		action.moveToElement(element).build().perform();
	}

	/**
	 * to perform drag and drop
	 * 
	 * @param sourceEle
	 * @param desEle
	 */
	public static void dragAndDrop(WebElement sourceEle, WebElement desEle) {
		Actions action = new Actions(BaseTest.getDriver());
		action.dragAndDrop(sourceEle, desEle).build().perform();

	}

	/**
	 * to click on element by javascript executor
	 * 
	 * @param element
	 */
	public static void clickByJavaScript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) BaseTest.getDriver();
		js.executeScript("arguments[0].click();", element);
	}
}
