package extentReport;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import retry.RetryAnalyzer;

public class TestListener implements ITestListener {
	
	/**
	 * @author aleena wahid
	 * @author 
	 */

	// Extent Report Declarations
	//private  ExtentReports extent = ExtentManager.createInstance(); // This creates a static obj of the
																			// ExtentReports class.
	// to get each test
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public synchronized void onStart(ITestContext context) {
		System.out.println("Extent Reports Test Suite started!");
	}
	@Override
	public synchronized void onFinish(ITestContext context) {
		System.out.println("Extent Reports Test Suite is ending!");
		// stop event
		ExtentManager.extent.flush();
		System.out.println("Extent Report flushed/saved successfully");
	}

	// when 1st test case is executed
	@Override
	public synchronized void onTestStart(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " started!"));
		ExtentTest extentTest = ExtentManager.extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());
		test.set(extentTest);
	}
	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " passed!"));
		test.get().pass("Test passed");
	}
	@Override
	public synchronized void onTestFailure(ITestResult result) {

		System.out.println((result.getMethod().getMethodName() + " failed!"));
		ExtentTest extentTest = test.get();
		extentTest.fail(result.getThrowable());

		// Capture and attach screenshot
		String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
		if (screenshotPath != null) {
			extentTest.addScreenCaptureFromPath(screenshotPath, "Failed Screenshot");
		}
	}
	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		test.get().skip(result.getThrowable());
	}

	// pie chart
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}

	public static ThreadLocal<ExtentTest> getTestInstance() {
		return test;
	}

	// Method to capture screenshots
	private String captureScreenshot(String methodName) {
		
		WebDriver driver = BaseClass.getDriver();
		try {
			if(driver!=null){

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String rootPath = "/eclipse-workspace/com.simpleproject";
			String screenshotPath = System.getProperty("user.home") + rootPath + "/TestReport/Screenshots/" + methodName
					+ timeStamp + ".png";
			FileHandler.copy(screenshot, new File(screenshotPath));
			return screenshotPath;
			}
			else {
				System.out.println("driver is null, skipping screenshot...");
			}

		} catch (IOException e) {
			System.out.println("Failed to capture screenshot for " + methodName);
			e.printStackTrace();
			return null;
		}
		return null;

	}
}
