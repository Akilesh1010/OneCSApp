@td_oneCSiOS_TD
Feature: Portfolio Dashboard feature validation on iOS app

  Background: 
    #Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    #Then user should be displayed with secure sign in page for iOS
    #Then user enters value in "SECURE_SIGN_IN_INPUT_FIELD" field with "SIX_DIGIT" pin for iOS
    #And user Clicks on "SECURE_SIGN_IN_VERIFY_BTN" button for iOS

  @PortfolioDashboard_iOS @4.01_iOS
  Scenario: 4.01 - To verify the "Portfolio Dashboard" Screen details and validations
    #execution/Cupholder1
    Given user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user should be displayed with welcome back your current portfolio section including the "PORTFOLIO_PERFORMANCE_INCREASE_ARROW" on iOS
    Then user should be displayed with Portfolio summary value details on iOS
    Then user should be displayed with bottom naviagation options for portfolio,contact,investments,insights and more on iOS
    Then user should be able to pull down the screen to refresh the details for iOS
    Then user should verify the value of date format displayed correctly on the "Portfolio dashboard" screen for iOS
    #And user Clicks on "YOUR_ACCOUNTS_TAB" button in dashboard screen for iOS
    #Then user should see the Total Portfolio value is matching with sum of all portfolio values for iOS
    Then user should see the Total Portfolio Value Change is matching with sum of all Portfolio Value Change for iOS
    Then user selects the "Mrs Lydia Jordan Mr Execution Mobileapps SIPP" from Your accounts screen for iOS
    Then user should see the Account Dashboard value is matching with holdings value of the same account for iOS
    Then user should see the Account Dashboard Value Change is matching with Sum of All Holdings Value Change for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.02_iOS
  Scenario: 4.02 - To verify the "Portfolio Dashboard" Screen when the monetary values had +ve change
    #execution/Cupholder1
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user should be displayed with welcome back your current portfolio section including the "PORTFOLIO_PERFORMANCE_INCREASE_ARROW" on iOS
    Then user should see "Positive" Portfolio Value Change in the Dashboard screen for iOS
    Then user should see "Positive" Sign in the Percentage value on the Dashboard screen for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.03_iOS
  Scenario: 4.03 - To verify the "Portfolio Dashboard" Screen when the monetary values had -ve change
    #Test data needed
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "" and password "" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user should be displayed with welcome back your current portfolio section including the "PORTFOLIO_PERFORMANCE_DECREASE_ARROW" on iOS
    Then user should see "Negative" Portfolio Value Change in the Dashboard screen for iOS
    Then user should see "Negative" Sign in the Percentage value on the Dashboard screen for iOS
    And user Clicks on "YOUR_ACCOUNTS_TAB" button in dashboard screen for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.05_iOS
  Scenario: 4.05 - To verify the "Portfolio breakdown" screen details
    #execution/Cupholder1
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    And user Clicks on "PORTFOLIO_BREAKDOWN_I_BTN" button for iOS
    Then user should see a back button and Portfolio Breakdown Title at the top of the screen for iOS
    Then user should see the "INVESTMENT_BREAKDOWN_LABEL_TXT" is displayed for iOS
    Then user should see "PORTFOLIO_LABEL_IN_PORTFOLIO_BREAKDOWN","CASH_LABEL_IN_PORTFOLIO_BREAKDOWN" and "COST_LABEL_IN_PORTFOLIO_BREAKDOWN" fields are displayed for iOS
    Then user should see the "COST_INFO_BTN" is displayed for iOS
    Then user should be displayed with bottom naviagation options for portfolio,contact,investments,insights and more on iOS
    Then user should see "PORTFOLIO_VALUE_IN_PORTFOLIO_BREAKDOWN","PORTFOLIO_CASH_VALUE_IN_PORTFOLIO_BREAKDOWN" and "COST_VALUE_IN_PORTFOLIO_BREAKDOWN" fields are displayed for iOS
    And user Clicks on "BACK_BUTTON" button for iOS
    Then user Clicks on "PORTFOLIO_BREAKDOWN_I_BTN" button for iOS
    Then user should see the "INVESTMENT_BREAKDOWN_LABEL_TXT" is displayed for iOS
    Then user should see "PORTFOLIO_LABEL_IN_PORTFOLIO_BREAKDOWN" and "CASH_LABEL_IN_PORTFOLIO_BREAKDOWN" fields are displayed for iOS
    Then user should see the "COST_INFO_BTN" is displayed for iOS
    Then user should be displayed with bottom naviagation options for portfolio,contact,investments,insights and more on iOS
    Then user should see "PORTFOLIO_IMAGE" and "CASH_IMAGE" fields are displayed for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.06_iOS
  Scenario: 4.06 - To verify the details of Cost Information Pop Up on the "Portfolio breakdown" screen details
    #execution/Cupholder1
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    And user Clicks on "PORTFOLIO_BREAKDOWN_I_BTN" button for iOS
    Then user should see a back button and Portfolio Breakdown Title at the top of the screen for iOS
    Then user Clicks on "COST_INFO_BTN" button for iOS
    Then user should see "COST_INFO_POP_UP_TITLE" text in the pop up for iOS
    Then user should see the "IC_CLOSE_BTN" is displayed for iOS
    Then user should see the "GOT_IT_BTN" is displayed for iOS
    Then user swipe up the pop up to the full screen for iOS
    Then user Clicks on "IC_CLOSE_BTN" button for iOS
    Then user Clicks on "COST_INFO_BTN" button for iOS
    Then user should see "COST_INFO_POP_UP_TITLE" text in the pop up for iOS
    Then user Clicks on "GOT_IT_BTN" button for iOS
    Then user Clicks on "COST_INFO_BTN" button for iOS
    Then user should see "COST_INFO_POP_UP_TITLE" text in the pop up for iOS
    Then user Clicks on "COST_INFO_BTN" button for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.08_iOS
  Scenario: 4.08 - To verify the "Your Accounts" bottom sheet details and its validations
    #execution/Cupholder1
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    #Then user should see the "YOUR_ACCOUNTS_TAB" is displayed for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user should see "YOUR_ACCOUNTS_TAB","YOUR_ACCOUNTS_TAB_MINIMIZE_BTN" and "TOTAL_ACCOUNTS_IN_ACCOUNTS_SCREEN" fields are displayed for iOS
    Then user should see "PORTFOLIO_ACCOUNT_NAME_YOUR_ACCOUNTS_1","PORTFOLIO_ACCOUNT_TOTAL_VALUE_1" and "PORTFOLIO_ACCOUNT_VALUE_CHANGE_1" fields are displayed for iOS
    Then user should see "PORTFOLIO_ACCOUNT_CODE_1","PORTFOLIO_ACCOUNT_PERCENTAGE_CHANGE_1" and "MANAGED_BY_CS_LABEL_IN_YAOUR_ACCOUNTS_1" fields are displayed for iOS
    Then user should be able to scroll "down" and view the list of accounts for iOS
    Then user should see the "YOUR_ACCOUNTS_TIME_STAMP_LABEL" is displayed for iOS
    Then user should verify the value of date format displayed correctly on the "Your accounts" screen for iOS
    Then user Clicks on "YOUR_ACCOUNTS_TAB_MINIMIZE_BTN" button for iOS
    Then user should be displayed with Portfolio summary value details on iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.10_iOS
  Scenario: 4.10 - To verify the "Your Accounts" bottom sheet when there are no accounts under the selected Portfolio
    #CoreyDuffy\Cupholder1
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "coreyduffy" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user should see "YOUR_ACCOUNTS_TAB" and "YOUR_ACCOUNTS_TAB_MINIMIZE_BTN" fields are displayed for iOS
    Then user should not see the "TOTAL_ACCOUNTS_IN_ACCOUNTS_SCREEN" displayed on screen for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.11_iOS
  Scenario: 4.11 - Portfolio Dashboard - To Verify the Number formatting & styling, when switching between the show/hide state.
    #execution/Cupholder1
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user should be displayed with Portfolio summary value details on iOS
    Then verify the "open eye" symbol is displayed for iOS
    Then user Clicks on "PORTFOLIO_EYE_ICON_BTN" button for iOS
    Then verify the "closed eye" symbol is displayed for iOS
    Then user should see the "PORTFOLIO_VALUE_TXT" field value is hidden on the screen for iOS
    And user should see the "PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT" field value is hidden on the screen for iOS
    Then user should still see the Percentage value is retained in the field "PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT" for iOS
    Then user should verify the value of date format displayed correctly on the "Portfolio dashboard" screen for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_TOTAL_VALUE_1" field value is hidden on the screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_VALUE_CHANGE_1" field value is hidden on the screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_CODE_1" field value is hidden on the screen for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.12_iOS
  Scenario: 4.12 - Portfolio Breakdown - To Verify the Number formatting & styling, when switching between the show/hide state.
    #execution/Cupholder1
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user Clicks on "PORTFOLIO_EYE_ICON_BTN" button for iOS
    Then verify the "closed eye" symbol is displayed for iOS
    And user Clicks on "PORTFOLIO_BREAKDOWN_I_BTN" button for iOS
    Then user should see a back button and Portfolio Breakdown Title at the top of the screen for iOS
    Then user should see the "PORTFOLIO_VALUE_IN_PORTFOLIO_BREAKDOWN" field value is hidden on the breakdown screen for iOS
    Then user should see the "PORTFOLIO_CASH_VALUE_IN_PORTFOLIO_BREAKDOWN" field value is hidden on the breakdown screen for iOS
    Then user Clicks on "BACK_BUTTON" button for iOS
    Then verify the "closed eye" symbol is displayed for iOS
    Then user should be displayed with Portfolio summary value details on iOS
    #Then user should see the "PORTFOLIO_VALUE_TXT" field value is hidden on the screen for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.13_iOS
  Scenario: 4.13 - Your Accounts - To Verify the Number formatting & styling, when switching between the show/hide state.
    #execution/Cupholder1
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user Clicks on "PORTFOLIO_EYE_ICON_BTN" button for iOS
    Then verify the "closed eye" symbol is displayed for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_TOTAL_VALUE_1" field value is hidden on the screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_VALUE_CHANGE_1" field value is hidden on the screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_CODE_1" field value is hidden on the screen for iOS
    Then user should still see the Percentage value is retained in the field "PORTFOLIO_ACCOUNT_PERCENTAGE_CHANGE_1" for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.14_iOS
  Scenario: 4.14 - Verify the Number formatting & styling, when user is backgrounding the app and foregrounding it again.
    #execution/Cupholder1
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user Clicks on "PORTFOLIO_EYE_ICON_BTN" button for iOS
    Then verify the "closed eye" symbol is displayed for iOS
    Then user push the app to background for 10 seconds and relaunch the app again for iOS
    Then user should see the "PORTFOLIO_VALUE_TXT" field value is hidden on the screen for iOS
    And user should see the "PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT" field value is hidden on the screen for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_TOTAL_VALUE_1" field value is hidden on the screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_VALUE_CHANGE_1" field value is hidden on the screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_CODE_1" field value is hidden on the screen for iOS
    Then user Clicks on "YOUR_ACCOUNTS_TAB_MINIMIZE_BTN" button for iOS
    And user Clicks on "PORTFOLIO_BREAKDOWN_I_BTN" button for iOS
    Then user should see a back button and Portfolio Breakdown Title at the top of the screen for iOS
    Then user should see the "PORTFOLIO_VALUE_IN_PORTFOLIO_BREAKDOWN" field value is hidden on the breakdown screen for iOS
    Then user should see the "PORTFOLIO_CASH_VALUE_IN_PORTFOLIO_BREAKDOWN" field value is hidden on the breakdown screen for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.15_iOS
  Scenario: 4.15 - Verify the Number formatting & styling, when user is closing the OneCS app and launching it again.
    #execution/Cupholder1
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    And user closes "app" on mobile device
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user should be displayed with secure sign in page for iOS
    Then user enters value in "SECURE_SIGN_IN_INPUT_FIELD" field with "SIX_DIGIT" pin for iOS
    And user Clicks on "SECURE_SIGN_IN_VERIFY_BTN" button for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user should see the "PORTFOLIO_VALUE_TXT" field value is NOT hidden on the screen for iOS
    Then user should see the "PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT" field value is NOT hidden on the screen for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_TOTAL_VALUE_1" field value is NOT hidden on the screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_VALUE_CHANGE_1" field value is NOT hidden on the screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_CODE_1" field value is NOT hidden on the screen for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.16_iOS
  Scenario: 4.16 - Verify the Number formatting & styling, when user is logging out the OneCS app and logging in it again.
    #execution/Cupholder1
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user Clicks on "PORTFOLIO_EYE_ICON_BTN" button for iOS
    Then verify the "closed eye" symbol is displayed for iOS
    When user Clicks on "MORE_TAB" button for iOS
    Then user should see "OneCS" as tittle in more options Screen for iOS
    And user Signs Out the Mobile Application for iOS
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user should see the "PORTFOLIO_VALUE_TXT" field value is hidden on the screen for iOS
    And user should see the "PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT" field value is hidden on the screen for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_TOTAL_VALUE_1" field value is hidden on the screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_VALUE_CHANGE_1" field value is hidden on the screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_CODE_1" field value is hidden on the screen for iOS
    Then user Clicks on "YOUR_ACCOUNTS_TAB_MINIMIZE_BTN" button for iOS
    And user Clicks on "PORTFOLIO_BREAKDOWN_I_BTN" button for iOS
    Then user should see a back button and Portfolio Breakdown Title at the top of the screen for iOS
    Then user should see the "PORTFOLIO_VALUE_IN_PORTFOLIO_BREAKDOWN" field value is hidden on the breakdown screen for iOS
    Then user should see the "PORTFOLIO_CASH_VALUE_IN_PORTFOLIO_BREAKDOWN" field value is hidden on the breakdown screen for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.20_iOS
  Scenario: 4.20 - Verify the Portfolio Dashboard "Settings"
    #execution/Cupholder1
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "execution" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    When user Clicks on "PORTFOLIO_SHOWALL_TXT" button for iOS
    Then user should see Show Total for, Close button, All accounts label along with toggle button and Update Total button for iOS
    Then user should see the list accouunts are matching with the accounts displayed in your accounts screen for iOS
    When user Clicks on "PORTFOLIO_SHOWALL_TXT" button for iOS
    Then user should see Show Total for, Close button, All accounts label along with toggle button and Update Total button for iOS
    Then user should be able to swipe down the screen to minimize the Portfolio Show all screen for iOS
    Then user should not see the Show total for screen for iOS
    When user Clicks on "PORTFOLIO_SHOWALL_TXT" button for iOS
    Then user should see All accounts toggle button is switched ON by default and list of accounts should be ticked for iOS
    Then user should see Update total button is disabled when no account is selected for iOS
    Then user should untick an account from list and closed the Show total for screen without clicking on Update total button for iOS
    When user Clicks on "PORTFOLIO_SHOWALL_TXT" button for iOS
    Then user should see All accounts toggle button is switched ON by default and list of accounts should be ticked for iOS
    Then user toggle Off All accounts and see ticked sign is removed from all accounts displayed for iOS
    When user clicks on one of the accounts then All accounts toggle button remains off on the screen for iOS
    Then user selects all displayed accounts then All accounts toggle button should turn On for iOS
    When user navigate to other screen and return again to show total screen the user selection should be retained for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.21_iOS
  Scenario: 4.21 - verify the portfolio dashboard screen when user having No Accounts with zero Portfolio and Zero Cash Balance
    #CoreyDuffy/Cupholder1
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    Then user sign in with valid username "coreyduffy" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user should see "PORTFOLIO_SUMMARY_TOTAL_VALUE_TXT" field value displayed as "£0.00" on dashboard screen for iOS
    Then user should see "PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT" field value displayed as "£0 0%" on dashboard screen for iOS
    Then user should see "PORTFOLIO_SUMMARY_REFRESH_TIME_TXT" displayed on screen for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    #Below step is commented due to Observation #28 - For iOS - It is not showing the Timestamp on the screen
    #Then user should see "ACCOUNT_SUMMARY_REFRESH_AT_LABEL" displayed on screen for iOS
    Then user should not see any accounts on the Your accounts screen for iOS
    When user Clicks on "YOUR_ACCOUNTS_TAB_MINIMIZE_BTN" button for iOS
    When user Clicks on "PORTFOLIO_SHOWALL_TXT" button for iOS
    Then user should not see any accounts listed on the Show total for screen for iOS
    And user closes "app" on mobile device
