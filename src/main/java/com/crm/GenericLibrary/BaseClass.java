package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
  // create the object of all utilities
	 public DatabaseUtility dbLib = new DatabaseUtility();
	 public ExcelUtility eLib = new ExcelUtility();
	 public ProprtyFileUtility pLib = new ProprtyFileUtility();
	 public WebDriverUtility wLib = new WebDriverUtility();
	 public JavaUtility jLib = new JavaUtility();
	 public WebDriver driver = null;
	 public static WebDriver sDriver;
	 
	 @BeforeSuite
	 public void connectDataBase() 
	 {
		// dLib.connectToDb();
		 Reporter.log("=====db connection successful=====",true);
	 }
	 
	 @BeforeClass
	// @Parameters("browser")
	// @BeforeTest
	 public void launchTheBrowser() throws Throwable
	 {
		//read data from property
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		 String URL = pLib.readDataFromPropertyFile("url");
		 
		 //create RunTime Polymorphism
		 if(BROWSER.equalsIgnoreCase("chrome"))
			{
			    WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				//WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invalid browser");
			}
			
		   sDriver=driver;
			wLib.maximizeWindow(driver);
			wLib.waitForPageLoad(driver);
			driver.get(URL);
			Reporter.log("====browser launch successful======",true);
	 }
	 
	 @BeforeMethod
	 public void login() throws Throwable
	 {
		 String USERNAME = pLib.readDataFromPropertyFile("username");
		 String PASSWORD = pLib.readDataFromPropertyFile("password");
		 LoginPage lp = new LoginPage(driver);
		 lp.LoginToApp(USERNAME, PASSWORD);
		 Reporter.log("=====login successful====",true);
	 }
	 
	 @AfterMethod
	 public void logout()
	 {
		 HomePage hp = new HomePage(driver);
		 hp.signOutofApp(driver);
		 Reporter.log("===logout successfull====",true);
	 }
	 
	 @AfterClass
	// @AfterTest
	 public void closeBrowser()
	 {
		 driver.quit();
		 Reporter.log("====browser close successful======",true);
	 }
	 
	 @AfterSuite
	 public void closeDb()
	 {
		 //DbLib.closeDB();
		 Reporter.log("====DataBase close successful======",true);
	 }
	  
}