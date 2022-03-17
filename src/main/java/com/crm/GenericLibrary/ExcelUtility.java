package com.crm.GenericLibrary;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.EncryptedDocumentException;

/**
 * This class contains generic methods to read and write data into excel sheet
 * @author 
 *
 */
public class ExcelUtility {

	/**
	 * This method will read data from excel sheet and return the value when sheet name
	 * row no and cell no is specified
	 * @param SheetName
	 * @param Rownum
	 * @param CelNum
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String SheetName, int Rownum, int CelNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(Rownum);
		Cell cel = ro.getCell(CelNum);
		String value = cel.getStringCellValue();
		return value;
	}
	
	/**
	 * This method will write data into excel sheet
	 * @param SheetName
	 * @param Rownum
	 * @param CelNum
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String SheetName, int Rownum, int CelNum, String value) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(Rownum);
		Cell cel = ro.createCell(CelNum);
		 cel.setCellValue(value);
		 FileOutputStream fos=new FileOutputStream(IpathConstants.ExcelPath);
		 wb.write(fos);
	}

	/**
	 * This method will return last row number
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String SheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int row = sh.getLastRowNum();
		return row;
	}
	
	/**
	 * This method will read multiple data from excel sheet with the help of sheetname
	 * and return 2 dimensional object [][]
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i = 0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				//data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		
	}
	
}
