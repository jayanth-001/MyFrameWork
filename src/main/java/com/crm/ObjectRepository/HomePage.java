package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility {
 
	//Step 1: Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;

	@FindBy(linkText = "More")
	private WebElement moreLnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement  administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	//step 2: initialization
   public HomePage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }

   //Step 3:generate Getters
   public WebElement getOrganizationLnk() {
	return organizationLnk;
      }

   public WebElement getContactsLnk() {
	return ContactsLnk;
   }

   	public WebElement getOpportunitiesLnk() {
	return opportunitiesLnk;
   	}

   	public WebElement getProductsLnk() {
	return productsLnk;
   	}

   	public WebElement getMoreLnk() {
	return moreLnk;
   	}

   	public WebElement getCampaignsLnk() {
	return campaignsLnk;
   	}

   	public WebElement getAdministratorImg() {
	return administratorImg;
   	}

   	public WebElement getSignOutLnk() {
	return signOutLnk;
   	}

       //Business Library 
    public void ClickOnOrgLnk()
    {
    	organizationLnk.click();
    }
   
    public void ClickOnContactLnk()
    {
        ContactsLnk.click();
    }
    
   public void signOutofApp(WebDriver driver)
   {
	   mouseHover(driver, administratorImg);
	   signOutLnk.click();
   }    
}
