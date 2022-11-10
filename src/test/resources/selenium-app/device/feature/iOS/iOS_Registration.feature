@td_oneCSiOS_TD
Feature: Sign in / Login feature validation on iOS app

  Background: 
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user sign in with valid username 'Bob' and password 'Pass123$'

  @IOSDemo @2.01
  Scenario: 2.01 - To verify the details displayed on the Sign In Welcome Screend
    #Then user should be displayed with welcome screen logo
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Incorrect_Username" and "Incorrect_Password" for iOS
    When user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    #Then user should see Sign in error message for iOS
    And user closes "app" on mobile device
