package org.selenium.tests;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.selenium.base.BaseTest;
import org.selenium.dataProviders.MyDataProvider;
import org.selenium.objects.UserData;
import org.selenium.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.selenium.utils.Listeners.extentTest;

public class Test_Case_1 extends BaseTest {

    @Test(dataProvider = "getContactUsData", dataProviderClass = MyDataProvider.class)
    public void test_Case_1(UserData data) throws InterruptedException {

        /**
         * Add test data to report file
         */
        String code = "Name: "+data.getName() + "\nEmail: "+data.getEmail() + "\nMobile: "+data.getMobile() + "\nSubject: : "+data.getSubject() + "\nMessage: "+data.getMessage();
        Markup m = MarkupHelper.createCodeBlock(code);
        extentTest.get().log(Status.INFO, m);

        HomePage homePage = new HomePage(getDriver()).
                load().
                scrollToElement().
                removeNavbarOverlapping().
                clickContactUsButton().
                enterName(data.getName()).
                enterEmail(data.getEmail()).
                enterMobile(data.getMobile()).
                enterSubject(data.getSubject()).
                enterMessage(data.getMessage()).
                submitTheForm();
        Assert.assertEquals(homePage.errorMessage(), "The e-mail address entered is invalid.");
    }
}
