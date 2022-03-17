package DynamicPracticeTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class CheckboxLastSelectTest extends BaseClass {
@Test
public void checkboxLastSelect()
{
	HomePage hp = new HomePage(driver);
	hp.ClickOnContactLnk();
   element=driver.findElements(By.xpath());
}
}
