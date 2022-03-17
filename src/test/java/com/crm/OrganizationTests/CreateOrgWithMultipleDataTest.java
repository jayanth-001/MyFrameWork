package com.crm.OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ProprtyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
public class CreateOrgWithMultipleDataTest {
     	
		//Create Obj for all utilities
		ProprtyFileUtility pLib = new ProprtyFileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		@Test(dataProvider = "OrgtestData")
		public void createOrgWithMltipleData(String orgName, String indType) throws Throwable
		{
			
			
			//read data 
			String BROWSER = pLib.readDataFromPropertyFile("browser");
			String URL = pLib.readDataFromPropertyFile("url");
			String USERNAME = pLib.readDataFromPropertyFile("username");
			String PASSWORD = pLib.readDataFromPropertyFile("password");
			
			String orgname = orgName+jLib.getRandomnumber();
		
			//launch the application
			WebDriver driver = null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("FIREFOX"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invalid browser");
			}
			
			wLib.maximizeWindow(driver);
			wLib.waitForPageLoad(driver);
			driver.get(URL);
			
			//login to application
			LoginPage lp = new LoginPage(driver);
			lp.LoginToApp(USERNAME, PASSWORD);
			Reporter.log("login successful",true);
			
			//navigate to organization
			HomePage hp = new HomePage(driver);
			hp.ClickOnOrgLnk();
			Reporter.log("navigated to org link",true);
			
			//create Org
			OrganizationPage op = new OrganizationPage(driver);
			op.clickOnCreateOrgImg();
			Reporter.log("click on create org link",true);
			
			//create new org
			CreateOrganizationPage cop=new CreateOrganizationPage(driver);
			cop.createNewOrg(orgname, indType);
			Reporter.log("create org with insustry type",true);
			
			//validate
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String actHeader = oip.OrgNameInfo();
			if (actHeader.contains(orgname)) {
				System.out.println("passed");
			}
			else
			{
				System.out.println("failed");
			}
			Reporter.log("verification successful",true);		
			
			//logout
			hp.signOutofApp(driver);
			
			driver.quit();
		}
		
		@DataProvider(name = "OrgtestData")
		public Object[][] getData() throws Throwable
		{
			Object[][] data = eLib.readmultipleDataFromExcel("OrgMultipleData");
			return data;
		}
}
