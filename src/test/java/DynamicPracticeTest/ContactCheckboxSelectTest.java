package DynamicPracticeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.HomePage;

public class ContactCheckboxSelectTest extends BaseClass {

	
	@Test
	public void contactChechboxSelect()
	{
	HomePage hp = new HomePage(driver);
	hp.ClickOnContactLnk();
	
   List<WebElement> checkboxes = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
    int count=checkboxes.size();
    for(int i=0;i<count;i++)
    {
    	WebElement cb = checkboxes.get(i);
    	cb.click();
    }
   

}
}