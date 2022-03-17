package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactsPage  extends WebDriverUtility{
	
	  //Step 1: declaration
	   @FindBy(name = "lastname")
	   private WebElement lastNameEdt;
	   
		@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
		private WebElement orgNameLookUpImg;
		
		@FindBy(name = "search_text")
		private WebElement searchEdt;
		
		@FindBy(name = "search")
		private WebElement searchNowBtn;
		
		@FindBy(xpath ="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;

		
		//Step 2:initialization
		public CreateContactsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Step 3:Utilization
	
		public WebElement getLastNameEdt() {
			return lastNameEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
	

		public WebElement getOrgNameLookUpImg() {
			return orgNameLookUpImg;
		}

		public WebElement getSearchEdt() {
			return searchEdt;
		}

		public WebElement getSearchNowBtn() {
			return searchNowBtn;
		}

		//Business Library
		public void createNewContact(String lastName)
		{
			lastNameEdt.sendKeys(lastName);
			saveBtn.click();
		}
      
		/**
		 * This method will create the contact with organization
		 * @param driver
		 * @param lastname
		 * @param orgName
		 */
		public void createContact(WebDriver driver,String lastName,String orgName)
		{
			lastNameEdt.sendKeys(lastName);
			orgNameLookUpImg.click();
			switchToWindow(driver, "Accounts");
			searchEdt.sendKeys(orgName);
			searchNowBtn.click();
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			switchToWindow(driver, "Contacts");
			saveBtn.click();
		}
		
		/**
		 * this method will create the contact with mandatory field
		 * @param lastName
		 */
		public void createContact(String lastName)
		{
			lastNameEdt.sendKeys(lastName);
			
		}
		
}
