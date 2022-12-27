@td_oneCSiOS_TD
Feature: Validate the Account Management module validation on iOS app

  Background: 
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should be displayed with secure sign in page for iOS
    Then user enters value in "SECURE_SIGN_IN_INPUT_FIELD" field with "SIX_DIGIT" pin for iOS
    And user Clicks on "SECURE_SIGN_IN_VERIFY_BTN" button for iOS

  @Account_Management_iOS @7.01_iOS
  Scenario: 7.01 - Verify the "Account Management" bottom sheet
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    And user selects one of the Account from yours Accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    Then user should see "ACCOUNT_MANAGEMENT_CLOSE_BTN" in the popup screen for iOS
    Then user should see below three options in Account Management screen for iOS
      | Pay money in      |
      | Activity          |
      | Account breakdown |
    And upon swiping up Account Management popup should go to fullscreen for iOS
    And upon swiping down Account Management popup should go to fullscreen for iOS
    Then user should not see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" overlay popup for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_CLOSE_BTN" button for iOS
    Then user should not see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" overlay popup for iOS
    When user Clicks on "MORE_TAB" button for iOS
    And user Signs Out the Mobile Application for iOS
    And user closes "app" on mobile device

  @Account_Management_iOS @7.02_iOS
  Scenario: 7.02 - Verify  the account, when it is having the "activity list"
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    And user selects one of the Account from yours Accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then user should be see "ACCOUNT_ACTIVITY_SCREEN_LABEL_TXT" screen for iOS
    Then user should see below tabs in Activity screen for iOS
      | Activity   |
      | Order list |
    When user Clicks on "MORE_TAB" button for iOS
    And user Signs Out the Mobile Application for iOS
    And user closes "app" on mobile device

  @Account_Management_iOS @7.03_iOS
  Scenario: 7.03 - Verify the Manual refresh of the Activity screen
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "bob" and password "Pass123$" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
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
    When user Clicks on "MORE_TAB" button for iOS
    And user Signs Out the Mobile Application for iOS
    And user closes "app" on mobile device

  @Account_Management_iOS @7.04_iOS
  Scenario: 7.04 - Verify the Activity screen, when the account is having no activities
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "testest" and password "Cupholder1" for iOS
    Then user should be displayed with Portfolio summary value details on iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    And user selects one of the Account from yours Accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then under Activity bar blank page should be displayed for iOS
    When user Clicks on "MORE_TAB" button for iOS
    And user Signs Out the Mobile Application for iOS
    And user closes "app" on mobile device

  @Account_Management_iOS @7.06_iOS
  Scenario: 7.06 - Verify the "Cash Movement" details when the "Cash Movement value" is positive in case of Money in
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Execution Mobileapps SIPP" from Your accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then in extreme left right arrow in square bracket "ACCOUNT_ACTIVITY_1ST_ACTIVITY_ICON_TXT" should be displayed for iOS
    Then user should see "ACCOUNT_ACTIVITY_1ST_ACTIVITY_NAME_TXT" and "ACCOUNT_ACTIVITY_1ST_ACTIVITY_TRANSACTION_TYPE_TXT" fields are displayed for iOS
    Then user should see the "ACCOUNT_ACTIVITY_1ST_ACTIVITY_VALUE_TXT" is displayed for iOS
    And user closes "app" on mobile device

  @Account_Management_iOS @7.13_iOS
  Scenario: 7.13 - verify the order details listed  in the order list screen
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    And user selects one of the Account from yours Accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    When user Clicks on "ORDER_LIST_TAB" button for iOS
    Then under order or fund name below details should be displayed for iOS
      | Date           |
      | Ref            |
      | Type           |
      | Current status |
    When user Clicks on "MORE_TAB" button for iOS
    And user Signs Out the Mobile Application for iOS
    And user closes "app" on mobile device

  @Account_Management_iOS @7.14_iOS
  Scenario: 7.14 - To verify the display of different order types/status of an order
    #Test data needed with all possible status types under 1 account
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then user Clicks on "ORDER_LIST_TAB" button for iOS
    Then Confirm the orders of the below types for iOS
      | PROCESSING |
      | DEALT      |
      | CANCELLED  |
      | COMPLETE   |
      | REJECTED   |
      | EXPIRED    |
    And user closes "app" on mobile device

  @Account_Management_iOS @7.16_iOS
  Scenario: 7.16 - Verify loading status of the pages
    #Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    #Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    #Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then user Clicks on "ORDER_LIST_TAB" button for iOS
    Then user pull down Order list screen to see the spinner element appears on the screen for iOS
    And user closes "app" on mobile device

  @Account_Management_iOS @7.17_iOS
  Scenario: 7.17-To verify the manual refresh of the order list screen
    #Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    #Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    #Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then user Clicks on "ORDER_LIST_TAB" button for iOS
    Then user pull down Order list screen to see the spinner element appears on the screen for iOS
    And user closes "app" on mobile device

  @Account_Management_iOS @7.18_iOS
  Scenario: 7.18 - Verify the details of each order status in order list
    #Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    #Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    #Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then user Clicks on "ORDER_LIST_TAB" button for iOS
    Then user selects the order "MARKS AND SPENCER GROUP PLC" from Order list screen for iOS
    Then user should see "CLOSE_ORDER_DETAILS_BTN" and "ORDER_DETAILS_TITLE" fields are displayed for iOS
    Then user see below fields in the Order Details screen for iOS
      | Status          |
      | Trade type      |
      | Date            |
      | Settlement date |
      | Price           |
      | Quantity        |
      | Consideration   |
      | Other           |
      | Dealing fee     |
      | Estimated value |
      | Cancel order    |
    And user closes "app" on mobile device

  @Account_Management_iOS @7.19_iOS
  Scenario: 7.19 - verify the transition of the bottom sheet- View Order
    #Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    #Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    #Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user waits until the account details displayed on screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then user Clicks on "ORDER_LIST_TAB" button for iOS
    Then user selects the order "MARKS AND SPENCER GROUP PLC" from Order list screen for iOS
    Then user should see "CLOSE_ORDER_DETAILS_BTN" and "ORDER_DETAILS_TITLE" fields are displayed for iOS
    And user closes "app" on mobile device

  @Account_Management_iOS @7.25_iOS
  Scenario: 7.25 - Verify when the account is having no orders
    #Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    #Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    #Then user sign in with valid username "testest" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Test Test SIPP" from Your accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then user Clicks on "ORDER_LIST_TAB" button for iOS
    Then under Order list tab blank page should be displayed for iOS
    And user closes "app" on mobile device

  @Account_Management_iOS @7.26_iOS
  Scenario: 7.26 - To verify the back button on the  "Order List" Screen
    #Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    #Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    #Then user sign in with valid username "testest" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Test Test SIPP" from Your accounts screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_ACTIVITY_BTN" button for iOS
    Then user Clicks on "ORDER_LIST_TAB" button for iOS
    Then user Clicks on "BACK_BUTTON" button for iOS
    Then user should see "ACCOUNT_SUMMARY_NAME_LABEL_TXT" screen for iOS
    And user closes "app" on mobile device
