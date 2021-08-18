
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.FileNotFoundException;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelReading {
		
		public static void main(String[] args) throws IOException {
			
			File f = new File("E:\\TestData.xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = new XSSFWorkbook(fis);
			
			Sheet sh = wb.getSheet("testdata");
			int numOfRows = sh.getPhysicalNumberOfRows();
			
			System.out.println("Num of rows in sheet test data: "+numOfRows);
			
			int numOfCols = sh.getRow(0).getLastCellNum();
			
			System.out.println("Num of cols in sheet test data: "+numOfCols);
			
			for(int i=0; i<numOfRows; i++) {
				for(int j=0; j<numOfCols; j++) {
					//sh.getRow(0).getCell(0).getStringCellValue
					//sh.getRow(0).getCell(1).getStringCellValue
					//sh.getRow(0).getCell(2).getStringCellValue
					//sh.getRow(0).getCell(3).getStringCellValue
					
					//sh.getRow(1).getCell(0).getStringCellValue
					//sh.getRow(1).getCell(1).getStringCellValue
					//sh.getRow(1).getCell(2).getStringCellValue
					
//					if(sh.getRow(i).getCell(j).getCellType().NUMERIC != null) {
//						System.out.println(sh.getRow(i).getCell(j).getNumericCellValue());
//	
//					}else if(sh.getRow(i).getCell(j).getCellType().STRING!=null) {
//						System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
//	
//					}
					
					System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
					
				}
			}
			
			
			
			
		}

	}
