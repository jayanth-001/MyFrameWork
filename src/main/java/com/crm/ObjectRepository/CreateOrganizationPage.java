package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	//Step 1: declaration
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name ="industry")
	private WebElement industryDropDown;
	
	@FindBy(name ="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	
	//Step 2:initialization
	public CreateOrganizationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	
	//Step 3:Utilization
	public WebElement getOrgNameEdt() 
	{
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
	//Business Library
	public void createNewOrg(String orgName)
	{
		OrgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	public void createNewOrg(String orgName,String indType)
	{
		OrgNameEdt.sendKeys(orgName);
		industryDropDown.sendKeys(indType);
		saveBtn.click();
	}
	
	
}
