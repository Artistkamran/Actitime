package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**This contain is generic class which contains non static to read data from property and excel file
 * @author Ali sir
 */
public class FileLibrary {
	
	/**
	 * this method is a non static method used to read data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
public String readDataFromPropertyFile(String key) throws IOException {
	FileInputStream fis = new FileInputStream("./Testdata/commomdata.property");
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
}

/**
 * this method is a non static method used to read data from excel file
 * 
 * 
 
 */
public String readDataFromExcel (String sheet,int row , int cell) throws IOException {
	FileInputStream fis = new FileInputStream("./Testdata/exeltesdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String value = wb.getSheet(sheet).getRow(cell).getCell(cell).getStringCellValue();
	return value;
	
}
}
