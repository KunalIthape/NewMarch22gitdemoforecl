package Exceleader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {
	public void reader() throws Exception {
		File f=new File("C:\\Users\\Kunal\\eclipes-workspace\\eclipse-workspace\\for.Framework\\Exceldata\\FB Login.xlsx");
		boolean b=f.exists();
		System.out.println(b);
	FileInputStream fie = new FileInputStream(f);
	XSSFWorkbook sheet =new XSSFWorkbook(fie);
	XSSFSheet workbook=sheet.getSheetAt(0);
	
	int row=workbook.getLastRowNum();
	System.out.println(row);
	int col=workbook.getRow(0).getLastCellNum();
	System.out.println(col);
	
	for(int i=0; i<=row;i++)
	{
		String username=workbook.getRow(i).getCell(0).getStringCellValue();
		String password=workbook.getRow(i).getCell(1).getStringCellValue();
		System.out.println(username+" "+password);

	
	}
	
	}
}
