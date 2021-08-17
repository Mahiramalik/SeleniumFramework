package extentListeners;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListeners implements ITestListener{
	
	Date d = new Date();
	String fileName = "Extent_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
	
	
	ExtentReports extent = ExtentManager.createInstance("./src/test/resources/reports/"+fileName);
	
	public static ThreadLocal<ExtentTest> testReport= new ThreadLocal<ExtentTest>();
			
	public void onTestStart(ITestResult result) {
		
		Map<String, String> params = new HashMap<String, String>();
		params = result.getTestContext().getCurrentXmlTest().getAllParameters();
		
		ExtentTest test = extent.createTest(result.getMethod().getMethodName()+"_"+params.get("browser"));
		testReport.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
		
		String testName = result.getMethod().getMethodName();
		
		String logText = "<b>"+"Test Case: "+testName.toUpperCase()+ " PASSED"+"</b>";
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		
		testReport.get().pass(m);
		
	}

	public void onTestFailure(ITestResult result) {
		
		
		try {
			ExtentManager.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			testReport.get().fail("<b>"+"<font color="+"red>"+"screenshot of failure"+"</font>"+"</b>", MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String testName = result.getMethod().getMethodName();
		
		String logText = "<b>"+"Test Case: "+testName.toUpperCase()+ " FAILED"+"</b>";
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		
		testReport.get().fail(m);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
