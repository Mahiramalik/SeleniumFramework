package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import extentListeners.ExtentListeners;
import tests.BaseTest;
import utilities.DriverManager;
public class BasePage {

	WebDriver driver;
	public BasePage()
	{
		this.driver=DriverManager.getDriver();
		
		
	}
	public static void click(WebElement element, String elementName) {
		element.click();
		ExtentListeners.testReport.get().info("Clicking on: "+elementName);
	}
	
	public static void typeWithEnter(WebElement element, String elementName, String value) {
		element.sendKeys(value, Keys.ENTER);
		ExtentListeners.testReport.get().info("Entering "+value+" in: " +elementName);
		
	}	
}

