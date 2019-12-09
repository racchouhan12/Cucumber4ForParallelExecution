package com.test.screens;


import org.openqa.selenium.By;

public class AppHomeScreen extends BaseScreen {

    public static AppHomeScreen getInstance() {
        return new AppHomeScreen();
    }

    public String getCurrentScreenURL() {
        return getCurrentURL();

    }

    public void clickOnSignIn() {
         clickOnElement(By.xpath("//a[text()='Sign in']"));
    }

}
