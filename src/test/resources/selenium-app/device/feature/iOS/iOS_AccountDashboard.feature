@td_oneCSiOS_TD
Feature: Account Dashboard feature validation on iOS app

  Background: 

  #Given user launch app "OneCSiOSApp" on "realDevice" mobile device
  #Then user should be displayed with secure sign in page for iOS
  #Then user enters value in "SECURE_SIGN_IN_INPUT_FIELD" field with "SIX_DIGIT" pin for iOS
  #And user Clicks on "SECURE_SIGN_IN_VERIFY_BTN" button for iOS
  @AccountDashboard_iOS @5.01_iOS
  Scenario: 5.01 - To verify the "Account Dashboard" Screen details
    #edinburgh/Cupholder1
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user waits until the account details displayed on screen for iOS
    Then user should see "ACCOUNT_SUMMARY_NAME_LABEL_TXT" screen for iOS
    Then user Clicks on "BACK_BUTTON" button for iOS
    Then user should see "TOTAL_ACCOUNTS_IN_ACCOUNTS_SCREEN" screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user waits until the account details displayed on screen for iOS
    Then user should see "ACCOUNT_SUMMARY_NAME_LABEL_TXT" screen for iOS
    Then user Clicks on "PORTFOLIO_SHOWALL_DOWN_ARROW" button for iOS
    Then user should see "SELECT_ACCOUNT_TITLE" and "SELECT_ACCOUNT_CLOSE_BTN" fields are displayed for iOS
    Then user should see "CURRENTLY_SELECTED_LABEL" and "OTHER_ACCOUNTS_LABEL" fields are displayed for iOS
    Then user selects the "Mr E Edinburgh Investment" from Your accounts screen for iOS
    Then user waits until the account details displayed on screen for iOS
    Then user should see "ACCOUNT_SUMMARY_NAME_LABEL_TXT" screen for iOS
    Then user should see the Account Dashboard fields displayed on screen for iOS
    Then user should be able to pull down the Account dashboard screen to refresh the details for iOS
    Then user should verify the value of date format displayed correctly on the "Account dashboard" screen for iOS
    Then user should be displayed with bottom naviagation options for portfolio,contact,investments,insights and more on iOS
    And user closes "app" on mobile device

  @AccountDashboard_iOS @5.02_iOS
  Scenario: 5.02 - To verify  the manual refresh of the "Account Dashboard" screen
    #edinburgh/Cupholder1
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user waits until the account details displayed on screen for iOS
    Then user should see "ACCOUNT_SUMMARY_NAME_LABEL_TXT" screen for iOS
    Then user should be able to pull down the Account dashboard screen to refresh the details for iOS
    Then user should verify the value of date format displayed correctly on the "Account dashboard" screen for iOS
    And user closes "app" on mobile device

  @AccountDashboard_iOS @5.03_iOS
  Scenario: 5.03 - To verify the account values refresh after certain duration of time
    #edinburgh/Cupholder1
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user waits until the account details displayed on screen for iOS
    Then user should see "ACCOUNT_SUMMARY_NAME_LABEL_TXT" screen for iOS
    And user navigates to More tab and should be able to find the value change in "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" in Accounts Dashboard screen for iOS
    And user closes "app" on mobile device

  @AccountDashboard_iOS @5.05_iOS
  Scenario: 5.05 - To verify the "Account Dashboard" Screen when the values had +ve change
    #edinburgh/Cupholder1
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user waits until the account details displayed on screen for iOS
    Then user should see "ACCOUNT_SUMMARY_NAME_LABEL_TXT" screen for iOS
    Then user should be displayed with your current value is label and the "ACCOUNT_PERFORMANCE_INCREASE_ARROW" on iOS
    Then user confirms the value of the portfolio change is shown as a percentage figure for iOS
    Then user should see "Positive" Account Value Change in the Account Dashboard screen for iOS
    Then user should see "Positive" Sign in the Percentage value on the Account Dashboard screen for iOS
    And user closes "app" on mobile device

  @AccountDashboard_iOS @5.06_iOS
  Scenario: 5.06 - To verify the "Account Dashboard" Screen when the values had -ve change
    #Test data needed
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user waits until the account details displayed on screen for iOS
    Then user should see "ACCOUNT_SUMMARY_NAME_LABEL_TXT" screen for iOS
    Then user should be displayed with your current value is label and the "ACCOUNT_PERFORMANCE_DECREASE_ARROW" on iOS
    Then user confirms the value of the portfolio change is shown as a percentage figure for iOS
    Then user should see "negative" Account Value Change in the Account Dashboard screen for iOS
    Then user should see "negative" Sign in the Percentage value on the Account Dashboard screen for iOS
    And user closes "app" on mobile device

  @AccountDashboard_iOS @5.08_iOS
  Scenario: 5.08 - On the Account Dashboard Screen, verify the "Account switcher pillbox"
    #edinburgh/Cupholder1
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user waits until the account details displayed on screen for iOS
    Then user should see "ACCOUNT_SUMMARY_NAME_LABEL_TXT" screen for iOS
    Then user Clicks on "PORTFOLIO_SHOWALL_DOWN_ARROW" button for iOS
    Then user should see "SELECT_ACCOUNT_TITLE" and "SELECT_ACCOUNT_CLOSE_BTN" fields are displayed for iOS
    Then user should see "CURRENTLY_SELECTED_LABEL" and "OTHER_ACCOUNTS_LABEL" fields are displayed for iOS
    Then user Clicks on "SELECT_ACCOUNT_CLOSE_BTN" button for iOS
    Then user should see "ACCOUNT_SUMMARY_NAME_LABEL_TXT" screen for iOS
    Then user Clicks on "PORTFOLIO_SHOWALL_DOWN_ARROW" button for iOS
    Then user should see "SELECT_ACCOUNT_TITLE" and "SELECT_ACCOUNT_CLOSE_BTN" fields are displayed for iOS
    Then user should see "CURRENTLY_SELECTED_LABEL" and "OTHER_ACCOUNTS_LABEL" fields are displayed for iOS
    Then user should see "CURRENTLY_SELECTED_ACCOUNT_NAME" and "CURRENTLY_SELECTED_ACCOUNT_CODE" fields are displayed for iOS
    Then user Clicks on "SELECT_ACCOUNT_CLOSE_BTN" button for iOS
    Then user should see "ACCOUNT_SUMMARY_NAME_LABEL_TXT" screen for iOS
    And user closes "app" on mobile device

  @AccountDashboard_iOS @5.09_iOS
  Scenario: 5.09 - To verify the "Account breakdown" screen
    #edinburgh/Cupholder1
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user waits until the account details displayed on screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_BREAKDOWN_BTN" button for iOS
    Then user should see "ACCOUNT_BREAKDOWN_SCREEN_TITLE" and "BACK_BUTTON" fields are displayed for iOS
    Then user should see the "INVESTMENT_BREAKDOWN_LABEL_TXT" is displayed for iOS
    Then user should see "PORTFOLIO_LABEL_IN_PORTFOLIO_BREAKDOWN","CASH_LABEL_IN_PORTFOLIO_BREAKDOWN" and "COST_LABEL_IN_PORTFOLIO_BREAKDOWN" fields are displayed for iOS
    Then user should see the "COST_INFO_BTN" is displayed for iOS
    Then user should see "PORTFOLIO_VALUE_IN_ACCOUNT_BREAKDOWN","CASH_VALUE_IN_ACCOUNT_BREAKDOWN" and "COST_VALUE_IN_ACCOUNT_BREAKDOWN" fields are displayed for iOS
    Then user should see "PORTFOLIO_IMAGE" and "CASH_IMAGE" fields are displayed for iOS
    #Then user should see the "ACCOUNT_BREAKDOWN_REFRESH_TIME_LABEL" is displayed for iOS
    When user Clicks on "BACK_BUTTON" button for iOS
    Then user should see "ACCOUNT_SUMMARY_NAME_LABEL_TXT" screen for iOS
    Then user should be able to pull down the Account dashboard screen to refresh the details for iOS
    Then user should verify the value of date format displayed correctly on the "Account dashboard" screen for iOS
    And user closes "app" on mobile device

  @AccountDashboard_iOS @5.10_iOS
  Scenario: 5.10 - To verify the Cost Information Pop Up on the "Account breakdown" screen details
    #edinburgh/Cupholder1
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user waits until the account details displayed on screen for iOS
    Then user Clicks on "ACCOUNT_MANAGEMENT_PENCIL_BTN" button for iOS
    Then user should see "ACCOUNT_MANAGEMENT_DRAG_UP_BTN" in the popup screen for iOS
    When user Clicks on "ACCOUNT_BREAKDOWN_BTN" button for iOS
    Then user should see "ACCOUNT_BREAKDOWN_SCREEN_TITLE" and "BACK_BUTTON" fields are displayed for iOS
    When user Clicks on "COST_INFO_BTN" button for iOS
    Then user should see "COST_INFO_POP_UP_TITLE" text in the pop up for iOS
    Then user should see the "IC_CLOSE_BTN" is displayed for iOS
    Then user should see the "GOT_IT_BTN" is displayed for iOS
    #Then user swipe up the pop up to the full screen for iOS
    Then user should be able to swipe Up the screen to maximize the Cost information pop to full screen on iOS
    Then user should be able to swipe down the screen to close the Cost information pop on iOS
    Then user Clicks on "COST_INFO_BTN" button for iOS
    Then user should see "COST_INFO_POP_UP_TITLE" text in the pop up for iOS
    Then user Clicks on "GOT_IT_BTN" button for iOS
    Then user Clicks on "COST_INFO_BTN" button for iOS
    Then user should see "COST_INFO_POP_UP_TITLE" text in the pop up for iOS
    Then user Clicks on "IC_CLOSE_BTN" button for iOS
    And user closes "app" on mobile device
