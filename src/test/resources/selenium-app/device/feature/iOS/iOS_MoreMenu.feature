@td_oneCSiOS_TD
Feature: Validate the More menu features on iOS app

  @More_iOS @8.01_iOS
  Scenario: 8.01 - Verify the  MORE screen details
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user should see "Sign in step 3 of 4" from Signin Screen for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    Then user should see "Secure sign in" as header for iOS
    When user Clicks on "MAYBE_LATER_BIOMETRICS_BTN" button for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    When user Clicks on "MORE_TAB" button for iOS
    Then user should see "OneCS" as tittle in more options Screen for iOS
    Then user should not see the "BACK_BUTTON" for iOS
    Then user should see below four categories in more screen for iOS
      | USER SETTINGS         |
      | HELP & SUPPORT        |
      | MARKETS INFORMATION   |
      | ABOUT CHARLES STANLEY |
    Then user should be displayed with below options under User Settings section in iOS
      | Account settings |
      | Documents        |
    Then user should be displayed with below options under Help & Suppport section in iOS
      | FAQs        |
      | Help centre |
      | Glossary    |
      | What's new  |
    Then user should be displayed with below options under Markets Info section in iOS
      | Market data    |
      | Currency rates |
    Then user should be displayed with below options under About Charles Stanley section in iOS
      | Contact details       |
      | Important information |
      | Licensing information |
      | Rate us               |
    And user Signs Out the Mobile Application for iOS
    And user closes "app" on mobile device
