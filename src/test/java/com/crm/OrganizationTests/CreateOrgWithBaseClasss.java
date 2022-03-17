package com.crm.OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.ProprtyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.crm.GenericLibrary.ListnersImplementationClass.class)
public class CreateOrgWithBaseClasss extends BaseClass{

	

	@Test(groups="RegressionSuite")
    public void createOrgTest() throws Throwable
	{
		
		/*Step 4: Navigate to Organizations Link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLnk();
		
		/*Step 5: click on create organization btn*/
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		
		Assert.fail();
		
		/*Step 6: enter mandatory fields and save*/
		String OrgName = eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomnumber();
		System.out.println(OrgName);
	     CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	     cop.createNewOrg(OrgName);
		
	     
	     System.out.println("CreateOrgWithBaseClasss....passed....>RegressionSuite");
	     
	    /*Step 7:  verification   */
	    OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	    String actOrgName = oip.OrgNameInfo();
	    if(actOrgName.contains(OrgName))
	    {
	    	System.out.println(actOrgName+"-------->data verified");
	    }
	    else
	    {
	    	System.out.println("data invalid");
	    }
	
	
		/*Step 7: logout of application*/
	   
	//	hp.signOutofApp(driver);
		
		
		/*Step 8: close the browser*/
	//	driver.quit();
	
	}
	
	/*@Test
	public void createSample()
	{
		System.out.println("Sample test scripts");
	}
	@Test
	public void createSample1()
	{
		System.out.println("Sample test-1 scripts");
	}
	@Test
	public void createSample2()
	{
		System.out.println("Sample test-2 scripts");
	}*/
	
}
