package org.selenium.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.selenium.driverFactory.DriverManager;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    protected WebDriver getDriver() {
        return this.driver.get();
    }

    @BeforeMethod
    public synchronized void setUp(){
        setDriver(new DriverManager().initializeDriver());
    }

    @AfterMethod
    public synchronized void tearDown(){
        getDriver().quit();
    }

    public String getScreenshot(String screenshotName) throws IOException {
        String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir")+"\\Reports\\screenshots\\"+screenshotName+date+".png";
        File file = new File(destination);
        FileUtils.copyFileToDirectory(srcFile, file);
        return destination;
    }

}
