package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.baseTest;

public class Listeners extends baseTest implements ITestListener
{
		ExtentReports extent = ExtentReporterNG.getExtentReport();
		ExtentTest test;
		ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
		
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passing : "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped : "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	
	 @Override 
	 public void onTestFailedWithTimeout(ITestResult result) {
	 
	 
	 }
	
	
	public void onTestFailure(ITestResult result) {

		extentTest.get().log(Status.FAIL, "Test Failed : "+result.getMethod().getMethodName());
		extentTest.get().fail(result.getThrowable());
		String testMethodName = result.getMethod().getMethodName();

		try 
		{
			WebDriver driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());	
			extentTest.get().addScreenCaptureFromPath(takeScreenshot(testMethodName,driver), testMethodName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		extent.flush();
	}

}
