package com.crm.PracticeJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	@Test
	public void sampleJDBCExicuteQuery() throws Throwable
	{
		//Step1:register the database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step2:get connection from database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//Step3:  issue create statement
		Statement stat = conn.createStatement();
		
		//Step4:execute query
		ResultSet result = stat.executeQuery("select * from student;");
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t\t"+result.getString(3));
		}
		
		//Step5: close database
		conn.close();
	}
	
	

}