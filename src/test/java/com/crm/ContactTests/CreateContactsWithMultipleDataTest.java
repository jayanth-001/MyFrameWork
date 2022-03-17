package com.crm.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ProprtyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
public class CreateContactsWithMultipleDataTest extends BaseClass{
	//Create Obj for all utilities
	
			
			@Test(dataProvider = "ContactsTestdata")
			public void creatConWithMltipleData(String lastName) throws Throwable
			{
				
				
				//navigate to organization
				HomePage hp = new HomePage(driver);
				hp.ClickOnContactLnk();
				Reporter.log("navigated to Contact link",true);
				
				//create Contact
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactImg();
				Reporter.log("click on create Contact Icon",true);
				
				//create new Contact
				CreateContactsPage cop=new CreateContactsPage(driver);
				cop.createContact(lastName);
				Reporter.log("create contact...with lastName",true);
				
				//validate
				ContactsInfoPage oip = new ContactsInfoPage(driver);
				String actHeader = oip.ContactInfo();
				if (actHeader.contains(lastName)) {
					System.out.println("passed");
				}
				else
				{
					System.out.println("failed");
				}
				Reporter.log("verification successful",true);		
				
				
			}
			
			@DataProvider(name = "ContactsTestdata")
			public Object[][] getData() throws Throwable
			{
				Object[][] data = eLib.readmultipleDataFromExcel("ContactsMultiData");
				return data;
			}
}
