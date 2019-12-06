package com.test.screens;


import org.openqa.selenium.By;

public class SearchScreen extends BaseScreen{

    final String searchTextBoxLocator = "q";
    final String submitButtonLocator = "btnK";



    public static SearchScreen getInstance() {
        return new SearchScreen();
    }

    public void searchTextOnGoogleHomePage(String searchData) {
        sendText(By.name(searchTextBoxLocator), searchData);
        waitForElementToBeClickableAndClickOnElement(By.name(submitButtonLocator));
    }

}
