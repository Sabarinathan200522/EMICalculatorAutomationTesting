package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report implements ITestListener {
	
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public ExtentTest test;
    ScreenShot screenShot;
    
    public void onStart(ITestContext context) {
        
        if (extent == null) {
            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/Report.html");
            
            sparkReporter.config().setDocumentTitle("Automation Report"); 
            sparkReporter.config().setReportName("Functional Testing"); 
            sparkReporter.config().setTheme(Theme.STANDARD);
            
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            
            extent.setSystemInfo("Computer Name", "localhost");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester Name", "MSD");
            extent.setSystemInfo("OS", "Windows10");
            extent.setSystemInfo("Browser name", "Chrome");
        }
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName()); 
        test.log(Status.PASS, "Test case PASSED is:" + result.getTestClass().getName());
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        if (driver != null) {
            screenShot = new ScreenShot(driver);
            String path = screenShot.takeScreenShot(result.getTestClass().getName());
            test.addScreenCaptureFromPath(path);
        } else {
            test.log(Status.WARNING, "Screenshot skipped: WebDriver was null.");
        }
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.log(Status.FAIL, "Test case FAILED is:" + result.getTestClass().getName());
        test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); 
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        if (driver != null) {
            screenShot = new ScreenShot(driver);
            String path = screenShot.takeScreenShot(result.getTestClass().getName());
            test.addScreenCaptureFromPath(path);
        } else {
            test.log(Status.WARNING, "Screenshot skipped: WebDriver was null.");
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.log(Status.SKIP, "Test case SKIPPED is:" + result.getTestClass().getName());
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        if (driver != null) {
            screenShot = new ScreenShot(driver);
            String path = screenShot.takeScreenShot(result.getTestClass().getName());
            test.addScreenCaptureFromPath(path);
        } else {
            test.log(Status.WARNING, "Screenshot skipped: WebDriver was null.");
        }
    }

    public void onFinish(ITestContext context) {

        if (extent != null) {
            extent.flush();
        }
    }
}