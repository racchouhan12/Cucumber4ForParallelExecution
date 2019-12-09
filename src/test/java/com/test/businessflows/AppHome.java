package com.test.businessflows;

import com.test.screens.AppHomeScreen;
import com.test.screens.GmailHomeScreen;
import org.testng.Assert;

public class AppHome {

    AppHomeScreen appHomeScreen = AppHomeScreen.getInstance();

    public void verifyHomeScreenIsOpen() {
        String currentURL = appHomeScreen.getCurrentScreenURL();
        String expectedURL = "https://selenium.dev/";
        Assert.assertEquals( expectedURL, currentURL,"Expected App Home page is not found");
    }

    public void verifyGmailScreenIsOpen() {
        appHomeScreen.clickOnSignIn();
        Assert.assertEquals(GmailHomeScreen.getInstance().getGmailScreenText(), "Use your Google Account", "Expected Gmail Home page is not found");
    }
}
