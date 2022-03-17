package com.crm.PracticeJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;

public class SampleJDBCFinally {
	@Test
	public void sampleJDBCFinally() throws Throwable {
		Connection conn=null;
		try {
		
		        Driver driverref = new Driver();
				DriverManager.registerDriver(driverref);
				
				 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
				 System.out.println("connection is established");
				
				Statement stat = conn.createStatement();
				//insert into student values(7,'vicky','male')
				int result = stat.executeUpdate("insert into studnt values(8,'vicky','male')");
				if(result==1)
				{
					System.out.println("data added succesfully");
					
				}
				else {
					System.out.println("data not added");
				}
	
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
		conn.close();
		System.out.println("connection is closed");
		}

}
}
