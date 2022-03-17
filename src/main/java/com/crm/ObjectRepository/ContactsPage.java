package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//Step 1:declaration
		@FindBy(xpath ="//img[@alt='Create Contact...']")
		private WebElement createContactLookUpImg;
		
		//Step 2: initialization
		public ContactsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Step 3:Utilization
		   public WebElement getCreateContactLookUpImg() {
			 return createContactLookUpImg;
		}	
		
		//Business library
		   public void clickOnCreateContactImg()
		   {
			   createContactLookUpImg.click();
		   }
}
