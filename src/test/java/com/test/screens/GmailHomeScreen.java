package com.test.screens;


import org.openqa.selenium.By;

public class GmailHomeScreen extends BaseScreen {

    public static GmailHomeScreen getInstance() {
        return new GmailHomeScreen();
    }


    public String getGmailScreenText() {
         return waitForElementToBeClickableAndGetText(By.xpath("//span[text()='Use your Google Account']"));
    }
}
