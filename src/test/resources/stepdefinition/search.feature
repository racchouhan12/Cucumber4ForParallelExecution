Feature: Search in Google

  Scenario: Search for SeleniumHQ and verify the website
    Given I search for "SeleniumHQ"
    When I click on official Selenium HQ website
    Then I verify official website is launched

  Scenario: Search for SeleniumHQ and verify the website2
    When I signIn in Gmail
