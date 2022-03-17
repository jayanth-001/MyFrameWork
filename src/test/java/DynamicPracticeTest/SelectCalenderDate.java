package DynamicPracticeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectCalenderDate {
  
	@Test
	  
	  public void calender()
	  {
		  String date="10";
		  String monthAndYear="December 2022";
		  WebDriver driver= new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("https://www.makemytrip.com/");
		  
		  Actions actions= new Actions(driver);
		  actions.moveByOffset(10, 10).click().perform();
		  
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		  
		  driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		  String arrowXpath ="//span[@aria-label='Next Month']";
		  String datexpath="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		  
		  for(;;) {
			  try {
				  driver.findElement(By.xpath(datexpath)).click();
				  break;
			  }catch(Exception e) {
				  driver.findElement(By.xpath(arrowXpath)).click();
				  
			  }
		  }
	  }
}
