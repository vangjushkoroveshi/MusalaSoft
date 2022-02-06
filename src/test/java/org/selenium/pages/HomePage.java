package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.base.BasePage;

public class HomePage extends BasePage {

    private By contactUsBtn = By.xpath("//span[@data-alt='Contact us']/ancestor::button");
    private By navbar = By.id("navbar");
    private By nameInput = By.name("your-name");
    private By emailInput = By.name("your-email");
    private By mobileInput = By.name("mobile-number");
    private By subjectInput = By.name("your-subject");
    private By messageInput = By.name("your-message");
    private By sendBtn = By.xpath("//input[@type='submit']");
    private By errorMessage = By.xpath("//input[@type='email']/following-sibling::span");
    private By companyTap = By.xpath("//ul[@id='menu-main-nav-1']//li/a[contains(text(),'Company')]");
    private By careersTap = By.xpath("//ul[@id='menu-main-nav-1']//li/a[contains(text(),'Careers')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }

    public HomePage scrollToElement(){
        WebElement contactButton = wait.until(ExpectedConditions.presenceOfElementLocated(contactUsBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactButton);
        return this;
    }

    public HomePage removeNavbarOverlapping(){
        WebElement nav = wait.until(ExpectedConditions.visibilityOfElementLocated(navbar));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','display:none')", nav);
        return this;
    }

    public HomePage clickContactUsButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsBtn)).click();
        return this;
    }

    public HomePage enterName(String name){
        wait.until(ExpectedConditions.elementToBeClickable(nameInput)).sendKeys(name);
        return this;
    }

    public HomePage enterEmail(String email){
        wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(email);
        return this;
    }

    public HomePage enterMobile(String mobile){
        wait.until(ExpectedConditions.elementToBeClickable(mobileInput)).sendKeys(mobile);
        return this;
    }

    public HomePage enterSubject(String subject){
        wait.until(ExpectedConditions.elementToBeClickable(subjectInput)).sendKeys(subject);
        return this;
    }

    public HomePage enterMessage(String message){
        wait.until(ExpectedConditions.elementToBeClickable(messageInput)).sendKeys(message);
        return this;
    }

    public HomePage submitTheForm(){
        wait.until(ExpectedConditions.elementToBeClickable(sendBtn)).click();
        return this;
    }

    public String errorMessage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(errorMessage)).getText();
    }

    public CompanyPage clickOnCompanyTap(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyTap)).click();
        return new CompanyPage(driver);
    }

    public CareersPage clickOnCareersTap(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(careersTap)).click();
        return new CareersPage(driver);
    }
}
