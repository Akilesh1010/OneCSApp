@td_oneCSiOS_TD
Feature: Portfolio Dashboard feature validation on iOS app

  Background: 
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should be displayed with secure sign in page for iOS
    Then user enters value in "SECURE_SIGN_IN_INPUT_FIELD" field with "SIX_DIGIT" pin for iOS
    And user Clicks on "SECURE_SIGN_IN_VERIFY_BTN" button for iOS
   

  @IOSDashboard @4.01_iOS
  Scenario: 4.0 - To verify the "Portfolio Dashboard" Screen details and validations
    Given user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user should be displayed with welcome back your current portfolio section including the performance arrow on iOS
    Then user should be displayed with Portfolio summary value details on iOS
    Then user should be displayed with bottom naviagation options for portfolio,contact,investments,insights and more on iOS
    Then user should be able to pull down the screen to refresh the details for iOS
    Then user should verify the value of date format displayed on screen for iOS 
    And user closes "app" on mobile device
