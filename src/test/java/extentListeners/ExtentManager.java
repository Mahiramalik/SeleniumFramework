package extentListeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import tests.BaseTest;
import utilities.DriverManager;

public class ExtentManager extends BaseTest{
	
	private static ExtentReports extent;
	
	public static ExtentReports createInstance(String fileName) {
		
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("My project execution report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Automated Regression Suite");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Window", "version 10");
		extent.setSystemInfo("Automation Team", "My team");
		//extent.setSystemInfo("execution person name", "john");
		
		
		return extent;
		
		
	}
	
	public static String screenshotName;
	
	public static void captureScreenshot() throws IOException {
		
		Date d = new Date();
		
		screenshotName = "Screenshot_"+d.toString().replace(":", "_").replace(" ", "_")+".jpg";;
		
		System.out.println(screenshotName);
		
		File screenshotFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshotFile, new File("./src/test/resources/reports/"+screenshotName));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
