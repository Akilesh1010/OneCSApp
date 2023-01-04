@td_oneCSiOS_TD
Feature: Validate the More menu features on iOS app

  @More_iOS @8.01_iOS
  Scenario: 8.01 - Verify the  MORE screen details
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "bob" and password "Pass123$" for iOS
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
