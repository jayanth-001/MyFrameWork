package com.crm.LeadTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Tl_17 {
	@Test
	public void createNewLeadsTest() throws Throwable
	{

		/*generate random number*/
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		/*Step 1: read all neccessary data*/
		//read data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//read data from excel sheet
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\AssignmentTest.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet("Lead");
		Row ro = sh.getRow(1);
		Cell cel = ro.getCell(1); 
		String LeadName = cel.getStringCellValue();
		String leadNameRan=LeadName+" "+ random;
		
		Cell ce = ro.getCell(2);
		String lastName = ce.getStringCellValue();
		String lastNameRan = lastName+" "+random;
		
		/*Step 2: launch the browser*/
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		/*Step 3: login to application*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*Step 4: Navigate to leads Link*/
		driver.findElement(By.linkText("Leads")).click();
		
		/*Step 5: click on create lead btn*/
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		
		/*Step 6: enter mandatory fields and save*/
		driver.findElement(By.name("lastname")).sendKeys(LeadName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 7:verify for orgaqnization*/
	//	String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	//	if(header.contains(OrgNameRan))
	//	{
	//		System.out.println(header);
	//		System.out.println("org created");
	//	}
	//	else
	//	{
	//		System.out.println(header);
	//		System.out.println("Org not created");
	//	}
		
		
		
		
		
}
}