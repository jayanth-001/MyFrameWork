package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider="getData")
	public void sampleDataProvider(String Name,String model,int qty)
	{
		System.out.println(Name+"....."+model+"....."+qty);
    }
	@DataProvider
    public Object[][] getData()
    {
		Object[][] obj =new Object[4][3];
		
		obj[0][0]="Mi";
		obj[0][1]="Note 5";
		obj[0][2]=10;
		
		obj[1][0]="Samsung";
		obj[1][1]="Note 7";
		obj[1][2]=66;
		
		obj[2][0]="iphone";
		obj[2][1]="11 mini";
		obj[2][2]=10;
		
		obj[3][0]="Oneplus";
		obj[3][1]="7 pro";
		obj[3][2]=20;
		
		
		return obj;
    	
    }
}