package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.FlightSearchPage;
import pages.FlightSearchResultsPage;
import pages.HomePage;
import utilities.DataUtils;

public class FlightSearchTest extends BaseTest {
	
	
	@Parameters({"grid","browser", "url"})
	@BeforeClass
	public void init(String grid, String browser, String url) {
		System.out.println("adding for github 1");
		System.out.println("adding for github 2");
		launchBrowser(grid, browser, url);
	}

	@Test(dataProvider="getData", dataProviderClass=DataUtils.class)
	public void searchFlight(String origin, String destination, String checkinDate, String checkoutDate) {
		HomePage hp = new HomePage();
		FlightSearchPage fsp = hp.navigateToFlightSearchPage();
		FlightSearchResultsPage fsrp = fsp.searchFlight(origin, destination, checkinDate, checkoutDate);
		Assert.assertTrue(fsrp.isResultDisplayed());

	}
	
	

	
	
	
	@AfterClass
	public void tearDown() {
		closeBrowser();
	}

}
