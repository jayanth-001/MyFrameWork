package com.crm.PRACTICE;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.ProprtyFileUtility;

public class PracticeForGenericUtility {
@Test
	
	public void practiceForGenericUtility() throws Throwable
	{
		JavaUtility jLib=new JavaUtility();
		int rand = jLib.getRandomnumber();
		System.out.println(rand);
		
		String date = jLib.getSystemDate();
		System.out.println(rand + date);
		
		String DateFormat = jLib.getSystemDateInFormat();
		System.out.println(DateFormat);
	
		ProprtyFileUtility pLib= new ProprtyFileUtility();
		String brows = pLib.readDataFromPropertyFile("browser");
		System.out.println(brows);
		String url = pLib.readDataFromPropertyFile("url");
		System.out.println(url);
		String usn = pLib.readDataFromPropertyFile("username");
		System.out.println(usn);
		String pwd = pLib.readDataFromPropertyFile("password");
		System.out.println(pwd);
		
		ExcelUtility eLib=new ExcelUtility();
		String val = eLib.readDataFromExcel("Lead",6,5);
		System.out.println(val);
	}

}
