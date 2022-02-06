package org.selenium.tests;

import org.selenium.base.BaseTest;
import org.selenium.dataProviders.MyDataProvider;
import org.selenium.pages.CompanyPage;
import org.selenium.pages.HomePage;
import org.selenium.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Case_2 extends BaseTest {

    @Test(dataProvider = "companyData", dataProviderClass = MyDataProvider.class)
    public void test_Case_2(String endpoint, String fbUrl){
        CompanyPage companyPage = new HomePage(getDriver()).
                load().
                clickOnCompanyTap();
        Assert.assertEquals(companyPage.getUrl(), ConfigLoader.getInstance().getBaseUrl()+endpoint);
        Assert.assertTrue(companyPage.leadershipIsPresent());

        companyPage.
                clickFacebookLink().
                jumpToFacebookTab();

        Assert.assertEquals(companyPage.getUrl(), fbUrl);
        companyPage.verifyFbProfileImage();
    }
}
