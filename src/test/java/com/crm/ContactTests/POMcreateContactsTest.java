package com.crm.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
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

import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(com.crm.GenericLibrary.ListnersImplementationClass.class)
public class POMcreateContactsTest {


	@Test(groups="SystemSuite")
    public void createcontactsTest() throws Throwable
	{
		
			
		ProprtyFileUtility pLib = new ProprtyFileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		/*Step 1: read all neccessary data*/
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		String lastName = eLib.readDataFromExcel("Contacts", 1, 2)+"_"+jLib.getRandomnumber();
		System.out.println(lastName);
		System.out.println("POMcreateContactsTest....passed....>SystemSuite");
		
		
		/*Step 2: launch the browser*/
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
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
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		/*Step 3: login to application*/
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		/*Step 4: Navigate to Contacts Link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();
		
		/*Step 5: click on create Contact btn*/
		ContactsPage op = new ContactsPage(driver);
		op.clickOnCreateContactImg();
		
		Assert.fail();
		
		/*Step 6: enter mandatory fields and save*/
		
		System.out.println(lastName);
		CreateContactsPage cp = new CreateContactsPage(driver);
		cp.createNewContact(lastName);
	    
		
	    /*Step 7:  verification   */
	   ContactsInfoPage Cip = new ContactsInfoPage(driver);
	    String actlastName = Cip.ContactInfo();
	  if(actlastName.contains(lastName))
	    {
	    	
			System.out.println(actlastName+"-------->data verified");
	    }
	    else
	    {
	    	System.out.println("data invalid");
	    }
	
	
		/*/*Step 7: logout of application*/
		//hp.signOutofApp(driver);
		
		
		/*Step 8: close the browser*/
		//driver.quit();
	
	}
	
}
