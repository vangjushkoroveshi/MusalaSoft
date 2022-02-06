package org.selenium.tests;

import org.selenium.base.BaseTest;
import org.selenium.dataProviders.MyDataProvider;
import org.selenium.pages.CareersPage;
import org.selenium.pages.HomePage;
import org.testng.annotations.Test;

public class Test_Case_4 extends BaseTest {

    @Test(dataProvider = "getOpenPositionData", dataProviderClass = MyDataProvider.class)
    public void test_Case_4(String location1, String location2){

        CareersPage careersPage = new HomePage(getDriver()).
                load().
                clickOnCareersTap().
                checkOurOpenPosition().
                getPositionByCityAndPrintToConsoleFor(location1).
                getPositionByCityAndPrintToConsoleFor(location2);
    }
}
