package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.base.BasePage;

import java.util.ArrayList;

public class CompanyPage extends BasePage {

    private By leadership = By.className("company-members");
    private By facebookLink = By.xpath("//span[@class='musala musala-icon-facebook']/ancestor::a");
    private By facebookProfileImage = By.xpath("//*[@mask='url(#jsc_c_2)']/*[1]");


    public CompanyPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public boolean leadershipIsPresent(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(leadership)).isDisplayed();
    }

    public CompanyPage clickFacebookLink(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(facebookLink)).click();
        return this;
    }

    public CompanyPage jumpToFacebookTab(){
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        return this;
    }

    public boolean verifyFbProfileImage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(facebookProfileImage)).click();
        return false;
    }

}

