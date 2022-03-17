package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility {

	//Step 1:declaration
	@FindBy(xpath ="//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	//Step 2: initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step 3:Utilization
	   public WebElement getCreateOrgLookUpImg() {
		 return createOrgLookUpImg;
	}	
	
	//Business library
	   public void clickOnCreateOrgImg()
	   {
		   createOrgLookUpImg.click();
	   }
	
}
