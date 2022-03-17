package com.crm.PRACTICE;

import java.io.FileInputStream;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheetTest {
@Test
public void readDataFromExcel()
{
	//step 1:load excel file
	FileInputStream fis = new FileInputStream("");
	
	//step 2:create a workbook
	Workbook wb=WorkbookFactory.create(fis);
	
	//step 3:get the sheet
	Sheet sh=wb.getSheet("");
	
	//step 4:get the row
	Row ro=sh.getRow();
	
	//step 5:get
	
	
	
	
	
	
	
}
}
