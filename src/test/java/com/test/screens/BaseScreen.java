package com.test.screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinition.RunCucumberTest;


public abstract class BaseScreen extends RunCucumberTest {


    protected static Logger logger = LogManager.getLogger(BaseScreen.class.getName());


    protected void naviagateTo(String URL) {
        getDriver().navigate().to(URL);
    }

    protected void sendText(By by, String text) {
        getDriver().findElement(by).sendKeys(text);
    }

    protected void clickOnElement(By by) {
        getDriver().findElement(by).click();
    }

    protected void scrollDownBy(int pixel) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0," + pixel + ")");
    }

    protected void waitForElementAndSendTextInElement(By by, String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
    }

    protected void waitForElementToBeClickableAndClickOnElement(By by) {
        waitForElementToBeClickableAndClickOnElement(by, 10);
    }

    protected void waitForElementToBeClickableAndClickOnElement(By by, int timeOut) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected String waitForElementToBeClickableAndGetText(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        return wait.until(ExpectedConditions.elementToBeClickable(by)).getText();
    }


    protected String getCurrentURL() {
        return getDriver().getCurrentUrl();
    }

    protected Object executeJavaScript(String script) {
        return ((JavascriptExecutor) getDriver()).executeScript(script);
    }
}

