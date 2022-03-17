package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice1 {


	@Test(dataProvider="getData")
	public void sampleDataProvider(String Name,String model)
	{
		System.out.println(Name+"....."+model);
    }
	@DataProvider
    public Object[][] getData()
    {
		Object[][] obj =new Object[6][2];
		
		obj[0][0]="Mi";
		obj[0][1]="Note 5";
		
		obj[1][0]="Samsung";
		obj[1][1]="Note 7";
		
		obj[2][0]="iphone";
		obj[2][1]="11 mini";
		
		obj[3][0]="Oneplus";
		obj[3][1]="7 pro";
		
		obj[4][0]="Nokia";
		obj[4][1]="1100";
		
		obj[5][0]="Oppo";
		obj[5][1]="F11";
		
		
		return obj;
    	
    }
	
	
}
