package com.test.businessflows;

import com.test.screens.ResultScreen;

public class Result {

     public void clickOnResultsLinkByText(String resultTextToBeClicked) {
            ResultScreen.getInstance().clickOnResultByLinkText(resultTextToBeClicked);
     }
}
