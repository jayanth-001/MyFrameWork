package com.crm.PRACTICE;

import java.io.FileInputStream;

import org.testng.annotations.Test;

public class WriteDataIntoExcelSheetTest {
     @Test
      public void writeDataIntoExcelSheetTest()
{
     FileInputStream fis = new FileInputStream("\\")	;
    Workbook wb= WorkbookFactory.create(fis);
}
}
