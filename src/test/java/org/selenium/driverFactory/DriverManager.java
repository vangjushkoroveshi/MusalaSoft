package org.selenium.driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.utils.ConfigLoader;

public class DriverManager {
    public WebDriver initializeDriver(){

        WebDriver driver;

        if (ConfigLoader.getInstance().getBrowser().equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().cachePath("Drivers").setup();
            driver = new ChromeDriver();
        } else if(ConfigLoader.getInstance().getBrowser().equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalStateException("Invalid browser");
        }

        driver.manage().window().maximize();
        return driver;
    }
}
