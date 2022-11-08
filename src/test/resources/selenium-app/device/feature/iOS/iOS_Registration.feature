@td_oneCSiOS_TD
Feature: Device automation Demo for OneCS iOS App

  @IOSDemo @iOSDemo1
  Scenario: Verification of user login functionality with Incorrect Password
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Incorrect_Username" and "Incorrect_Password" for iOS
    When user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    #Then user should see Sign in error message for iOS
    And user closes "app" on mobile device

  @IOSDemo @iOSDemo2
  Scenario: Verification of user login functionality with Correct Username and Correct Password
    Given user launch app "OneCSiOSApp" on "browserStack" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Bob" and "Pass123$" for iOS
    When user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    Then user should see "VERIFY_YOUR_ACCOUNT_TWO_FA_TXT" screen for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    When user Clicks on "MAYBE_LATER_BIOMETRICS_BTN" button for iOS
    Then user should be displayed with Dashboard screen for iOS
    And user Clicks on "YOUR_ACCOUNTS_TAB" button in dashboard screen for iOS
    And user Clicks on "PORTFOLIO_TAB" button in dashboard screen for iOS
    And user Clicks on "CONTACT_TAB" button in dashboard screen for iOS
    And user Clicks on "INVESTMENT_TAB" button in dashboard screen for iOS
    And user Clicks on "MORE_TAB" button in dashboard screen for iOS
    #Then user clicks on "SIGNOUT_BTN" from more menu for iOS
    And user closes "app" on mobile device
