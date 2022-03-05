package maven;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjectRepository.baseClass;
import reportsTest.ExReports;


public class Listeners extends baseClass implements ITestListener {

	ExtentTest test;
	ExtentReports er=ExReports.reports();
	
	ThreadLocal<ExtentTest> t= new ThreadLocal<ExtentTest>();
	
	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		er.flush();
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		t.get().fail(result.getThrowable());
		WebDriver driver=null;
		
		String testMethodname=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			t.get().addScreenCaptureFromPath(getScreenshots(testMethodname,driver), result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		
		test=er.createTest(result.getMethod().getMethodName());
		t.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		t.get().log(Status.PASS, "Passed");
		
	}

}
