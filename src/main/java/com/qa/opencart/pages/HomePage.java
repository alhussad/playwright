package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    //1. String Locators - OR
    private String inputField = "div#search input";
    private String searchIcon = "div#search span button";
    private String searchPageHeader = "div#content h1";
    private String myAccount = "span:text('My Account')";
    private String loginLink = "a:text('Login')";

    //2. Page constructor
    public HomePage(Page page){
        this.page = page;
    }

    //3. Page actions/methods
    public String getHomePageTitle(){
        String title = page.title();
        System.out.println("Page title: "+title);
        return title;
    }

    public String getHomePageURL(){
        String url = page.url();
        System.out.println("Page url: "+url);
        return url;
    }

    public String doSearch(String productName){
        page.fill(inputField, productName);
        page.click(searchIcon);
        String header = page.textContent(searchPageHeader);
        System.out.println("Search header: "+header);
        return header;
    }

    public void navigateToLoginPage(){
        page.click(myAccount);
        page.click(loginLink);
    }
}
