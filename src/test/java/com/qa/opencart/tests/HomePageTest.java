package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageTitleTest(){
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
    }

    @Test
    public void homePageURLTest(){
        String actualURL = homePage.getHomePageURL();
        Assert.assertEquals(actualURL, prop.getProperty("url"));
    }

    @DataProvider
    public Object[][] getProductData(){
        return new Object[][]{
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "getProductData")
    public void searchTest(String productName){
        String actualSearchResult = homePage.doSearch(productName);
        Assert.assertEquals(actualSearchResult, "Search - "+productName); //Search - macbook
    }
}
