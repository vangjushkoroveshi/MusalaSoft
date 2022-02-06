package org.selenium.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    static ExtentReports extent;

    public static ExtentReports extentReportGenerator(){

        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\spark.html");
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Extent Report");
        reporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Project", "MusalaSoft");
        extent.setSystemInfo("Tester", "Vangjush Koroveshi");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", ConfigLoader.getInstance().getBrowser());
        extent.setSystemInfo("URL", ConfigLoader.getInstance().getBaseUrl());
        return extent;
    }
}
