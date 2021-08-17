package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import pages.HomePage;
import pages.HotelSearchPage;
import pages.HotelSearchResultsPage;
import utilities.DataUtils;
public class HotelSearchTest extends BaseTest {
	
	@Parameters({"grid","browser", "url"})
	@BeforeClass
	public void init(String grid, String browser, String url) {
		launchBrowser(grid, browser, url);
	}
	
	
	
	@Test(dataProvider="getData", dataProviderClass=DataUtils.class)
	public void searchHotel(String destination, String checkinDate, String checkoutDate, String title) {
		HomePage hp = new HomePage();
		HotelSearchPage hsp = hp.navigateToHotelSearchPage();
		HotelSearchResultsPage hsrp = hsp.searchHotel(destination, checkinDate, checkoutDate);
		String webTitle = hsrp.fetchTitle();
		Assert.assertTrue(webTitle.contains(title));
	
		}
		
	
	@AfterClass
	public void tearDown() {
		closeBrowser();
	}

}
