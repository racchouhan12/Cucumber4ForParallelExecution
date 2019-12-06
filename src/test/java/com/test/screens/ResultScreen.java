package com.test.screens;

import org.openqa.selenium.By;

public class ResultScreen extends BaseScreen {


    public static ResultScreen getInstance() {
        return new ResultScreen();
    }

    public void clickOnResultByLinkText(String linkToBeClicked) {
        String finalLocatorOfResult = "//h2[contains(text(),'Web result')]//parent::div//child::div//child::div//child::div//child::div/a/h3/span";
        waitForElementToBeClickableAndClickOnElement(By.xpath(finalLocatorOfResult));
    }
}
