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
		String  WebTitle = hsrp.fetchTitle();
		Assert.assertTrue(WebTitle.contains(title));
		
	}
	@DataProvider
	public Object[][] getData() throws IOException{
		File f = new File("./src/test/resources/ExcelFiles/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		
		Sheet sh = wb.getSheet("serchHotel");
		int numOfRows = sh.getPhysicalNumberOfRows();
		
		System.out.println("Num of rows in sheet test data: "+numOfRows);
		
		int numOfCols = sh.getRow(0).getLastCellNum();
		
		System.out.println("Num of cols in sheet test data: "+numOfCols);
		Object[][] data = new Object[numOfRows-1][numOfCols];
		
		for(int i=1;i<numOfRows;i++) {
			for(int j=0; j<numOfCols; j++) {
				data[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return data;
				}
	
	
	
	@AfterClass
	public void tearDown() {
		closeBrowser();
	}

}
