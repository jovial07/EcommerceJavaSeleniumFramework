package com.ecommerce.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentlistenerClass implements ITestListener {
    //Create three objects of three classes
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    //This method configures the report-html and extent reports
    public void configureReport(){

        Readconfig readConfig = new Readconfig();

        String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        //Name of the report
        String reportName = "EcommerceTestingReport-"+timeStamp+".html";
        //ExtentListenerReportDemo.html will be the report that will be generated in the project
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        // add system information/environment info to reports
        reports.setSystemInfo("Machine:", "Home");//(key, value)
        reports.setSystemInfo("OS", "windows 10");
        reports.setSystemInfo("browser:", readConfig.getBrowser());
        reports.setSystemInfo("user name:", "JP");

        // configuration to change look and feel of report
        htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
        htmlReporter.config().setReportName("This is my First Report");
        htmlReporter.config().setTheme(Theme.DARK);
        }
        /*
        In interface all methods are abstract and all the classes that inherits those methods
        implements or addresses those methods, here all ITestListener methods are addressed
        When we inherit or implement any interface then all those methods in that interface
        should be addressed
         */
    // OnStart method is called when any Test starts.
    public void onStart(ITestContext Result) {
        configureReport();//This method is called in onStart to configure report
        System.out.println("On Start method invoked....");
        }
    // onFinish method is called after all Tests are executed
    public void onFinish(ITestContext Result) {
        System.out.println("On Finished method invoked....");
        reports.flush();// it is mandatory to call flush method to ensure information is written to the
        // started reporter.

        }
    // When Test case get failed, this method is called.
    public void onTestFailure(ITestResult Result) {
        System.out.println("Name of test method failed:" + Result.getName());
        test = reports.createTest(Result.getName());// create entry in html report
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.RED));

        String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png";

        //Create a screenshot file
        File screenShotFile = new File(screenShotPath);

        if (screenShotFile.exists()){
            test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
            }

        // test.addScreenCaptureFromPath(null)
        }

        // When Test case get Skipped, this method is called.
    public void onTestSkipped(ITestResult Result) {
        System.out.println("Name of test method skipped:" + Result.getName());
        test = reports.createTest(Result.getName());
        test.log(Status.SKIP,
                MarkupHelper.createLabel("Name of the skipped test case is: " + Result.getName(), ExtentColor.YELLOW));
        }

        // When Test case get Started, this method is called.
    public void onTestStart(ITestResult Result) {
        System.out.println("Name of test method started:" + Result.getName());

    }
    // When Test case get passed, this method is called.
    public void onTestSuccess(ITestResult Result) {
        System.out.println("Name of test method sucessfully executed:" + Result.getName());

        test = reports.createTest(Result.getName());
        test.log(Status.PASS,
                MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName(), ExtentColor.GREEN));
        String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\" + Result.getName() + ".png";

        //Create a screenshot file
        File screenShotFile = new File(screenShotPath);

        if (screenShotFile.exists()){
            test.pass("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
        }

        // test.addScreenCaptureFromPath(null)
    }
    //This method is not implemented but is addressed
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
    }
}



