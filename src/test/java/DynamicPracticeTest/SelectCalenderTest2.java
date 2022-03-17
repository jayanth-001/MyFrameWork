package DynamicPracticeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectCalenderTest2 {
   @Test
   public void calender()
   {
	   String date="10";
		  String monthAndYear="May 2022";
		  WebDriver driver= new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("https://www.goibibo.com/");
		  
		  Actions actions= new Actions(driver);
		  actions.moveByOffset(10, 10).click().perform();
		  
		  driver.findElement(By.xpath("//span[@class='sc-kfPuZi dprjVP fswDownArrow']")).click();
		String arrowXpath = "//span[@aria-label='Next Month']";
		  String datexpath = "//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";	  
		
		  
		  for(;;) {
			  try {
				  driver.findElement(By.xpath(datexpath)).click();
				 
				 break;
			  }catch(Exception e) {
				  driver.findElement(By.xpath(arrowXpath)).click();
				  
			  }finally
			  {
				  driver.findElement(By.xpath("//span[text()='Done']")).click(); 
			  }
			  
		  }
   }
   }

