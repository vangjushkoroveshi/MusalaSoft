package org.selenium.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.selenium.base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

    ExtentReports extent = ExtentReportManager.extentReportGenerator();
    ExtentTest test;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName()).assignCategory("Vangjush Koroveshi").assignCategory("Test Case");
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get().log(Status.PASS, "Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {

//        extentTest.get().fail(result.getThrowable());
//        try {
//            extentTest.get().addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}
