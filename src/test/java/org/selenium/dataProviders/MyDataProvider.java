package org.selenium.dataProviders;

import org.selenium.objects.UserData;
import org.selenium.utils.JacksonUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class MyDataProvider {

    @DataProvider(name = "getContactUsData", parallel = true)
    public Object[] getContactUsData() throws IOException {
        return JacksonUtils.deserializeJson("data.json", UserData[].class);
    }

    @DataProvider(name = "companyData")
    public Object[][] getCompanyData(){
        return new Object[][]
                {
                        { "/company/", "https://www.facebook.com/MusalaSoft?fref=ts" }
                };
    }

    @DataProvider(name = "getCareerData")
    public Object[] getCareerData(){
        return new Object[][]
                {
                        { "/careers/join-us/", "Anywhere", "test@test", "12345", "\\Inputs\\sample.pdf", "The field is required.","The e-mail address entered is invalid."}
                };
    }

    @DataProvider(name = "getOpenPositionData")
    public Object[] getOpenPositionData(){
        return new Object[][]
                {
                        { "Sofia", "Bulgaria"}
                };
    }
}


