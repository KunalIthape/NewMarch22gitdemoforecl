package Exceleader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead1  {
	static XSSFWorkbook workbook;
	public  ExcelRead1(String path) throws Exception {
		File f= new File(path);
		System.out.println(f.exists());
		FileInputStream fis= new FileInputStream(f);
		try {
			 workbook= new XSSFWorkbook(fis);
			 XSSFSheet sheet= workbook.getSheetAt(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
 public String getdata(int sheetindex,int row,int col) {
	 XSSFSheet sheet= workbook.getSheetAt(sheetindex);
	 String data= sheet.getRow(row).getCell(col).getStringCellValue();
	return data;
 }
 public int getRowcount(int sheetindex) {
	 int row=workbook.getSheetAt(sheetindex).getLastRowNum();
	return row;
	 
 }
 public int getCellcount(int sheetindex) {
	 int col=workbook.getSheetAt(sheetindex).getRow(0).getLastCellNum();
	return col;
	 
 }

}
