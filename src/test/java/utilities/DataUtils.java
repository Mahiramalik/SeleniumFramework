
	package utilities;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.lang.reflect.Method;

	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.testng.annotations.DataProvider;

	public class DataUtils {
		
		@DataProvider
		public Object[][] getData(Method m) throws IOException{
			
			File f = new File("./src/test/resources/ExcelFiles/TestData.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			
			Sheet sh = wb.getSheet(m.getName()); //wb.getSheet("searchHotel")
			int numOfRows = sh.getPhysicalNumberOfRows();
			
			System.out.println("Num of rows in sheet test data: "+numOfRows); //2
			
			int numOfCols = sh.getRow(0).getLastCellNum();
			
			System.out.println("Num of cols in sheet test data: "+numOfCols); //4
			
			Object[][] data = new Object[numOfRows-1][numOfCols]; //[1][5]
			
			for(int i=1; i<numOfRows;i++) {
				for(int j=0; j<numOfCols; j++) {
					//data[0][0]=				sh.getRow(0).getCell(0).getStringCellValue
					//data[0[1]= 				sh.getRow(0).getCell(1).getStringCellValue
					//data[0][2]= 				sh.getRow(0).getCell(2).getStringCellValue
					//data[0][3]= 				sh.getRow(0).getCell(3).getStringCellValue




					
					data[i-1][j] = sh.getRow(i).getCell(j).getStringCellValue(); //
				}
			}
			
			return data;
			
		}

	}
	

