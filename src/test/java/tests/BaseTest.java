package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.DriverManager;

public class BaseTest {
			public  WebDriver driver;
	public void launchBrowser(String grid, String browser, String url) {
		
		if(grid.equalsIgnoreCase("true")) {

			DesiredCapabilities caps;

			if(browser.equalsIgnoreCase("chrome")) {
				caps = DesiredCapabilities.chrome();
				caps.setBrowserName("chrome");
				caps.setPlatform(Platform.ANY);
			}else if(browser.equalsIgnoreCase("firefox")) {
				caps=DesiredCapabilities.firefox();
				caps.setBrowserName("firefox");
				caps.setPlatform(Platform.ANY);
			}else {
				caps = DesiredCapabilities.edge();
				caps.setBrowserName("edge");
				caps.setPlatform(Platform.WIN10);
			}

			try {
				driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"), caps);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else {
			if(browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}else {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}


		}
		
		DriverManager.setDriver(driver);
		DriverManager.getDriver().get(url);
		DriverManager.getDriver().manage().window().maximize();
	
	}
	
	public void closeBrowser() {
		DriverManager.getDriver().quit();
	}

}
