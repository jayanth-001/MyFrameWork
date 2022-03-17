package com.crm.OpportunitiesTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.ProprtyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunitiesTest {
	@Test
	public void createOpportunities() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		/*read data*/
		ProprtyFileUtility pLib = new ProprtyFileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		/*Step 1: read all neccessary data*/
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		String oppName = eLib.readDataFromExcel("Opportunity", 1, 2);
		String relatedTo = eLib.readDataFromExcel("Opportunity", 1, 3);

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
			System.out.println("invalid browser name");
		}
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[.='Opportunities']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		
		driver.findElement(By.name("potentialname")).sendKeys(oppName);
		
		WebElement ReletedCategory = driver.findElement(By.id("related_to_type"));
		wLib.select(ReletedCategory, relatedTo);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
}