package Scripts;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String eleScName = "WebElementScreenShot";
		String pageScName = "WebPageScreenShot";
		driver.get("https://www.amazon.in/");
		
		Date date = new Date();
		eleScName = eleScName + date.getTime();
		pageScName = pageScName + date.getTime();
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='a-cardui gw-sign-in sign-in-v2']"));
		File f = ele.getScreenshotAs(OutputType.FILE);
		File d = new File("D:\\SeleniumScreenshots\\"+eleScName+".png");
		FileUtils.copyFile(f, d);
		
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File("D:\\SeleniumScreenshots\\"+pageScName+".png");

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);
	}

}
