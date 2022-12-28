@td_oneCSiOS_TD
Feature: Account Dashboard feature validation on iOS app

  Background: 
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    #Then user should be displayed with secure sign in page for iOS
    Then user enters value in "SECURE_SIGN_IN_INPUT_FIELD" field with "SIX_DIGIT" pin for iOS
    And user Clicks on "SECURE_SIGN_IN_VERIFY_BTN" button for iOS

  @AccountDashboard_iOS @5.01_iOS
  Scenario: 5.01 - To verify the "Account Dashboard" Screen details
    #edinburgh/Cupholder1
    #Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    #Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    #Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
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
    #Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    #Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    #Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
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
    #Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    #Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    #Then user sign in with valid username "edinburgh" and password "Cupholder1" for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user selects the "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" from Your accounts screen for iOS
    Then user waits until the account details displayed on screen for iOS
    Then user should see "ACCOUNT_SUMMARY_NAME_LABEL_TXT" screen for iOS
    And user navigates to More tab and should be able to find the value change in "Mrs Lydia Jordan Mr Edinburgh Edinburgh SIPP" in Accounts Dashboard screen for iOS
    And user closes "app" on mobile device
    
    
    
    
    
    
