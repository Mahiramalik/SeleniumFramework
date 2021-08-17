package utilities;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
public static ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>();
	
	
	public static void setDriver(WebDriver driver) {
		wd.set(driver);
	}
	
	public static WebDriver getDriver() {
		return wd.get();
	}

}
