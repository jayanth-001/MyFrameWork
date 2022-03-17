package com.crm.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		String Methodname = result.getMethod().getMethodName();
		Reporter.log(Methodname+"-----Testscripts execution started");
		test=report.createTest(Methodname);
		
	}

	public void onTestSuccess(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		Reporter.log(Methodname+"-----Testscripts execution successfull-PASS");
		test.log(Status.PASS, Methodname+"..........>passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		String path = null;
		
		String Methodname = result.getMethod().getMethodName()+"-";
		Reporter.log(Methodname+"-----Testscripts Failed",true);
		
		//step 1:configure screenshot name
		String screenshotName = Methodname+new JavaUtility().getSystemDateInFormat();
		System.out.println(screenshotName);
		
		//Step 2: using screenshot method from webDriver Utility
				try {
					
					path=new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenshotName);
					
			
					//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
					//File src = eDriver.getScreenshotAs(OutputType.FILE);
					//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
					//String path = "./Screenshots/"+screenshotName+".png";
					//File dst = new File(pa);
					//Files.copy(src, dst);
					
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				test.log(Status.FAIL, Methodname+"......>failed");
				//It will capture the exception and log it in the report
				test.log(Status.FAIL, result.getThrowable());
				test.addScreenCaptureFromPath(path);
				
			}
	

	public void onTestSkipped(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		Reporter.log(Methodname+"-----Testscripts Skipped");
		//It will capture the exception and log it in the report
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		//Execution will start here
		/*configure the report */
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Sdet-30 Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Selenium Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("Base-url", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Jayanth");
		
		
	}

	public void onFinish(ITestContext context) {
		
		//consolidate all the parameters and generate the report
		report.flush();
		
	}

	
}
