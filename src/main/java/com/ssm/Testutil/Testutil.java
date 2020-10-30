package com.ssm.Testutil;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.xml.sax.XMLReader;

import com.ssm.Testbase.Testbase;

public class Testutil extends Testbase{
	public static Sheet sheet;
	public static  Workbook book;
	public static long IMPLICITLY_WAIT = 7;
	public static long PAGE_LOAD_TIMEOUT = 8;
	public static String TEST_SHEET_PATH = "";
	
	public static Object[][] getdata(String sheetname)
	
	{
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(TEST_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				
				data [i][k]= sheet.getRow(i+1).getCell(k).toString();			
				}
		}
		return data;
	}
		
		


	
}
