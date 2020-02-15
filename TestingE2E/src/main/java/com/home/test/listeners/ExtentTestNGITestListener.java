/**
 * 
 */
package com.home.test.listeners;

import java.io.IOException;
import java.util.Arrays;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.home.base.TestBase;
import com.home.extentReport.ExtentManager;
import com.home.extentReport.ExtentTestManager;

/**
 * @author ashwini
 *
 */
public class ExtentTestNGITestListener extends ExtentTestManager implements ITestListener {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();   

    public synchronized void onStart(ITestContext context) {

    	
	}

	public synchronized void onFinish(ITestContext context) {
		
		if (extent != null) {

			ExtentManager.getInstance().flush();
		}
		
	}
	
	public synchronized void onTestStart(ITestResult result) {

		ExtentTest child = ExtentTestManager.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());		
        test.set(child);
	}

	public synchronized void onTestSuccess(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.get().pass(m);
	}

	public synchronized void onTestFailure(ITestResult result) {
		
        Object testClass = result.getInstance();
        WebDriver driver = ((TestBase) testClass).getDriver();			

        Throwable excepionMessage=result.getThrowable();
		test.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Main Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage+" \n");
		
		String excepionMessages=Arrays.toString(result.getThrowable().getStackTrace());
        test.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Detail Exception Occured:Click to see"
        		+ "</font>" + "</b >" + "</summary>" +excepionMessages.replaceAll(",", "<br>")+"</details>"+" \n");
        
        test.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Combined Exception Occured:Click to see"
        		+ "</font>" + "</b >" + "</summary>" +excepionMessage+ "\n"+excepionMessages.replaceAll(",", "<br>")+"</details>"+" \n");
		
		try {
			
			String screenshotName = TestBase.getScreenshot(driver, result.getName());
			ExtentTestManager.getTest().fail("Details", MediaEntityBuilder.createScreenCaptureFromPath(screenshotName).build());

		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		test.get().log(Status.FAIL, m);
	}

	public synchronized void onTestSkipped(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.get().skip(m);;
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	} 

}
