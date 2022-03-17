package com.crm.GenericLibrary;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consisting of all generic methods related to webdriver
 * @author Jayanth M A
 *
 */
public class WebDriverUtility {
	

	/**
	 * This method will maximize the Window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will wait for 20 seconds for page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method will wait for 20 seconds for the element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBEClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will wait for 20 seconds for the visible element
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will select the data from dropdown using index
	 * @param driver
	 * @param element
	 */
	public void select(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 *  This method will select the data from dropdown using text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 *  This method will select the data from dropdown using value
	 * @param element
	 * @param text
	 */
	public void select(String value,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	 /**
	  * This method will perform the MouseHover action
	  * @param driver
	  */
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform the Drag and Drop  action
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement target )
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, target);
	}
	/**
	 *This method will perform the Double click on element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element )
	{
		Actions act=new Actions(driver);
		act.doubleClick(element );
	}
	
	/**
	 * This method will perform the Double click on web page
	 * @param driver
	 */
	public void doubliClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform the right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element )
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will press enter key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will release enter key
	 * @throws Throwable
	 */
	public void enterRelease() throws Throwable
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch the frame based on name or Id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method will switch the frame based on address of the element
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	
	/**
	 * This method will accept alert pop up
	 * @param driver
	 */

	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the alert pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	
	/**
	 * This method will switch to window depending on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		//step 1:use getWindowHandles to capture all window id's
		Set<String> windows = driver.getWindowHandles();
		
		//Step 2:Iterate through the windows
		Iterator<String> it = windows.iterator();
		
		//Step 3:check whether there is next window
		while(it.hasNext())
		{
			//step 4:capture current window id
			String winID = it.next();
			
			//step 5:Switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winID).getTitle();
			
			//Step 6:check whether the current window is expected
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}		
	}		
	
	/**
	 * This method will take screenshot and store it in folder called as Screenshot
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable 
	 * @throws Throwable
	 */
	public String getScreenShot(WebDriver driver,String screenShotName) throws Throwable
	{
		String path = ".\\Screenshot\\"+screenShotName+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(path);
		Files.copy(src, dst);
		
		return path;
	}
	
	/**
	 * This method perform random scroll
	 * @param driver
	 */
	 public void scrollAction(WebDriver driver)
	 {
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)", "");
	 }
	
	/**This method will scroll until the specified element is found
	 * @param driver
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		//js.executeScript("argument[0].scrollIntoview()", element);
	}
	 
	 
}
