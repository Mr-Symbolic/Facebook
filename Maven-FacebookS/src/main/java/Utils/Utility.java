package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EmptyFileException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Utility {
	private static  String value;
	private static double d;
	
	
	
	public static void capturedScreenshot(WebDriver driver,double TestId) throws IOException {
		String path = "C:\\Users\\Admin\\OneDrive\\Pictures\\Utility\\test";
		String time = new  SimpleDateFormat("dd-MM-yyyy hh.mm.ss").format(new Date());
		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File desc = new File(path+TestId+""+time +".jpg");
		FileHandler.copy(src, desc);
	}

	
	public static String readExcelldata(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		String ExcellPath = "C:\\Users\\Admin\\OneDrive\\Desktop\\New Microsoft Excel Worksheet.xlsx";
		FileInputStream file = new FileInputStream(ExcellPath);
		Workbook wb = WorkbookFactory.create(file);
		try {
		value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		}
		catch(IllegalStateException e) {
		double d = wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		value = Double.toString(d);
		}
		catch(Exception e){
			e.getStackTrace();
		}	
		return value;
	}
	
}




//try {
//CellType type = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getCellType();
//System.out.println(type);
//
//if(type.equals("STRING"))
//{
//	value = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
//}
//else
//{
//	double d = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
//	System.out.println(">>>>>>>>>");
//	System.out.println(d);
//	 value = Double.toString(d);
//}//value = String.valueOf(d);
//}
//catch(Exception e) {
//e.getStackTrace();
//}