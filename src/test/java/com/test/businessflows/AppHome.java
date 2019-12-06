package com.test.businessflows;

import com.test.screens.AppHomeScreen;
import org.testng.Assert;

public class AppHome {

    public void verifyHomeScreenIsOpen() {
        String currentURL = AppHomeScreen.getInstance().getCurrentScreenURL();
        String expectedURL = "https://selenium.dev/";
        Assert.assertEquals( expectedURL, currentURL,"Expected App Home page is not found");
    }
}
