package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class CareersPage extends BasePage {

    private By openPositionBtn = By.xpath("//section[@class='link_field']//button");
    private By dropdown = By.id("get_location");
    private By qaEngineer = By.xpath("//h2[@data-alt='Experienced Automation QA Engineer']");
    private By sections = By.xpath("//div[@class='content-title']//h2");
    private By applyBtn = By.xpath("//input[@value='Apply']");
    private By emailInput = By.name("your-email");
    private By mobileInput = By.name("mobile-number");
    private By uploadInput = By.name("uploadtextfield");
    private By sendBtn = By.xpath("//input[@type='submit']");
    private By closeForm = By.xpath("//button[@class='close-form']");
    private By hiddenErrorMessage = By.xpath("//input[@name='your-name']/following-sibling::span");
    private By emailErrorMessage = By.xpath("//input[@type='email']/following-sibling::span");

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public CareersPage checkOurOpenPosition(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(openPositionBtn)).click();
        return this;
    }

    public CareersPage selectLocationFromDropdown(String location){
        Select select = new Select(driver.findElement(dropdown));
        select.selectByValue(location);
        return this;
    }

    public CareersPage openPosition(){
        wait.until(ExpectedConditions.elementToBeClickable(qaEngineer)).click();
        return this;
    }

    public List<String> getActualSectionsName(){
        List<WebElement> elements = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(sections,0));
        List<String> ls = new ArrayList<>();
        for(WebElement element: elements){
                ls.add(element.getText());
        }
        return ls;
    }

    public boolean verifyApplyButton(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(applyBtn)).isDisplayed();
    }

    public CareersPage clickApplyButton() throws InterruptedException {

        WebElement apply = wait.until(ExpectedConditions.elementToBeClickable(applyBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", apply);
        return this;
    }

    public CareersPage enterEmail(String email){
        wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(email);
        return this;
    }

    public CareersPage enterMobile(String mobile){
        wait.until(ExpectedConditions.elementToBeClickable(mobileInput)).sendKeys(mobile);
        return this;
    }

    public CareersPage uploadCV(String path){
        wait.until(ExpectedConditions.elementToBeClickable(uploadInput)).sendKeys(path);
        return this;
    }

    public CareersPage submitTheForm(){
        WebElement send = wait.until(ExpectedConditions.elementToBeClickable(sendBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", send);
        return this;
    }

    public CareersPage closeErrorForm(){
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeForm));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);
        return this;
    }

    public String emptyErrorMessage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(hiddenErrorMessage)).getText();
    }
    public String emailErrorMessage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(emailErrorMessage)).getText();
    }

    public CareersPage getPositionInformation(String cityName){
        List<WebElement> city = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(getCity(cityName)),0));
        List<WebElement> moreInfo = driver.findElements(By.xpath(getCity(cityName)+"/ancestor::a"));
        List<WebElement> position = driver.findElements(By.xpath(getCity(cityName)+"/ancestor::a//h2"));

        System.out.println(city.get(1).getText());

        for (int i=0; i< city.size(); i++){
            System.out.println("Position: " + position.get(i).getText());
            System.out.println("More info: " + moreInfo.get(i).getAttribute("href"));
        }
        return this;
    }

    private String getCity(String city){
        return "//p[@class='card-jobsHot__location' and contains(text(), '"+city+"')]";
    }

    public CareersPage getPositionByCityAndPrintToConsoleFor(String city){
        return selectLocationFromDropdown(city).getPositionInformation(city);
    }
}
