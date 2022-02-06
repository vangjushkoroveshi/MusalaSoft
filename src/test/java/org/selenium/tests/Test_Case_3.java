package org.selenium.tests;

import org.selenium.base.BaseTest;
import org.selenium.dataProviders.MyDataProvider;
import org.selenium.pages.CareersPage;
import org.selenium.pages.HomePage;
import org.selenium.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test_Case_3 extends BaseTest {

    public static final ArrayList<String> actualMainSection = new ArrayList<>(Arrays.asList("General description", "Requirements", "Responsibilities", "What we offer"));

    @Test(dataProvider = "getCareerData", dataProviderClass = MyDataProvider.class)
    public void test_case_3(String endpoint, String location, String email, String mobile, String cv, String emptyErrorMessage, String emailErrorMessage) throws InterruptedException {

        CareersPage careersPage = new HomePage(getDriver()).
                load().
                clickOnCareersTap().
                checkOurOpenPosition();
        Assert.assertEquals(careersPage.getUrl(), ConfigLoader.getInstance().getBaseUrl()+endpoint);

        careersPage.
                selectLocationFromDropdown(location).
                openPosition();
        Assert.assertEquals(careersPage.getActualSectionsName(), actualMainSection);

        Assert.assertTrue(careersPage.verifyApplyButton());

        careersPage.
                clickApplyButton().
                enterEmail(email).
                enterMobile(mobile).
                uploadCV(System.getProperty("user.dir")+cv).
                submitTheForm().
                closeErrorForm();
        Assert.assertEquals(careersPage.emptyErrorMessage(), emptyErrorMessage);
        Assert.assertEquals(careersPage.emailErrorMessage(), emailErrorMessage);
    }
}
