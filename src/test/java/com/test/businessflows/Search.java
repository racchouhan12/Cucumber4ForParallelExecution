package com.test.businessflows;

import com.test.screens.SearchScreen;

public class Search {

    public void searchText(String searchText) {
        SearchScreen.getInstance().searchTextOnGoogleHomePage(searchText);
    }
}
