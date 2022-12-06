@td_oneCSiOS_TD
Feature: Validate the Account Management module validation on iOS app

  @Account_Management_iOS @7.01_iOS
  Scenario: 7.01 - Verify the "Account Management" bottom sheet
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
    And user Clicks on "YOUR_ACCOUNTS_TAB" button in dashboard screen for iOS
    And user selects one of the Account from yours Accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    Then user should see "ACCOUNT_MANAGEMENT_CLOSE_BTN" in the popup screen for iOS
    Then user should see below two options in Account Management screen for iOS
      | Activity          |
      | Account breakdown |
    And upon swiping up Account Management popup should go to fullscreen for iOS
    And upon swiping down Account Management popup should go to fullscreen for iOS
    Then user should not see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" overlay popup for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    #Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    #Then user Clicks on "ACCOUNT_SUMMARY_NAME_LABEL_TXT" button for iOS
    #Then user should not see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" overlay popup for iOS
    #Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_CLOSE_BTN" button for iOS
    Then user should not see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" overlay popup for iOS
    And user closes "app" on mobile device

  @Account_Management_iOS @7.02_iOS
  Scenario: 7.02 - Verify  the account, when it is having the "activity list"
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
    And user Clicks on "YOUR_ACCOUNTS_TAB" button in dashboard screen for iOS
    And user selects one of the Account from yours Accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then user should be see "ACCOUNT_ACTIVITY_SCREEN_LABEL_TXT" screen for iOS
    Then user should see below tabs in Activity screen for iOS
      | Activity   |
      | Order list |
    And user closes "app" on mobile device

  @Account_Management_iOS @7.03_iOS
  Scenario: 7.03 - Verify the Manual refresh of the Activity screen
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
    And user Clicks on "YOUR_ACCOUNTS_TAB" button in dashboard screen for iOS
    And user selects one of the Account from yours Accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then user should be see "ACCOUNT_ACTIVITY_SCREEN_LABEL_TXT" screen for iOS
    When user Clicks on "BACK_BUTTON" button for iOS
    Then user should be see "ACCOUNT_DASHBOARD_SELECT_ACCOUNT_BTN" screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then user should be see "ACCOUNT_ACTIVITY_SCREEN_LABEL_TXT" screen for iOS
    Then user should be able to pull down the Activity tab to refresh the screen for iOS
    And user closes "app" on mobile device

  @Account_Management_iOS @7.04_iOS
  Scenario: 7.04 - Verify the Activity screen, when the account is having no activities
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user logins with "testest" and "Cupholder1" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    Then user should see "Secure sign in" as header for iOS
    When user Clicks on "MAYBE_LATER_BIOMETRICS_BTN" button for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    And user Clicks on "YOUR_ACCOUNTS_TAB" button in dashboard screen for iOS
    And user selects one of the Account from yours Accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then under Activity bar blank page should be displayed for iOS
    And user closes "app" on mobile device

  @Account_Management_iOS @7.13_iOS
  Scenario: 7.13 - verify the order details listed  in the order list screen
   Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user logins with "testest" and "Cupholder1" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    Then user should see "Secure sign in" as header for iOS
    When user Clicks on "MAYBE_LATER_BIOMETRICS_BTN" button for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    And user Clicks on "YOUR_ACCOUNTS_TAB" button in dashboard screen for iOS
    And user selects one of the Account from yours Accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    When user Clicks on "ORDER_LIST_TAB" button for iOS
    #Then under order or fund name below details should be there with > arrow
      #| Date           |
      #| Ref            |
      #| Type           |
      #| Current status |
    And user closes "app" on mobile device
