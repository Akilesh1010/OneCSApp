@td_oneCSiOS_TD
Feature: Portfolio Dashboard feature validation on iOS app

  Background: 
    Given user launch app "OneCSiOSApp" on "realDevice" mobile device
    Then user should be displayed with secure sign in page for iOS
    Then user enters value in "SECURE_SIGN_IN_INPUT_FIELD" field with "SIX_DIGIT" pin for iOS
    And user Clicks on "SECURE_SIGN_IN_VERIFY_BTN" button for iOS

  @PortfolioDashboard_iOS @4.01_iOS
  Scenario: 4.01 - To verify the "Portfolio Dashboard" Screen details and validations
    Given user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user should be displayed with welcome back your current portfolio section including the "PORTFOLIO_PERFORMANCE_INCREASE_ARROW" on iOS
    Then user should be displayed with Portfolio summary value details on iOS
    Then user should be displayed with bottom naviagation options for portfolio,contact,investments,insights and more on iOS
    Then user should be able to pull down the screen to refresh the details for iOS
    Then user should verify the value of date format displayed on screen for iOS
    #And user Clicks on "YOUR_ACCOUNTS_TAB" button in dashboard screen for iOS
    Then user should see the Total Portfolio value is matching with sum of all portfolio values for iOS
    Then user should see the Total Portfolio Value Change is matching with sum of all Portfolio Value Change for iOS
    Then user selects the "Mrs Lydia Jordan Mr Execution Mobileapps SIPP" from Your accounts screen for iOS
    Then user should see the Account Dashboard value is matching with holdings value of the same account for iOS
    Then user should see the Account Dashboard Value Change is matching with Sum of All Holdings Value Change for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.02_iOS
  Scenario: 4.02 - To verify the "Portfolio Dashboard" Screen when the monetary values had +ve change
    Given user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user should be displayed with welcome back your current portfolio section including the "PORTFOLIO_PERFORMANCE_INCREASE_ARROW" on iOS
    Then user should see "Positive" Portfolio Value Change in the Dashboard screen for iOS
    Then user should see "Positive" Sign in the Percentage value on the Dashboard screen for iOS
    And user Clicks on "YOUR_ACCOUNTS_TAB" button in dashboard screen for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.03_iOS
  Scenario: 4.03 - To verify the "Portfolio Dashboard" Screen when the monetary values had -ve change
    Given user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    Then user should be displayed with welcome back your current portfolio section including the "PORTFOLIO_PERFORMANCE_DECREASE_ARROW" on iOS
    Then user should see "Negative" Portfolio Value Change in the Dashboard screen for iOS
    Then user should see "Negative" Sign in the Percentage value on the Dashboard screen for iOS
    And user Clicks on "YOUR_ACCOUNTS_TAB" button in dashboard screen for iOS
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.03_iOS
  Scenario: 4.05 - To verify the "Portfolio breakdown" screen details
    Given user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    And user Clicks on "PORTFOLIO_BREAKDOWN_I_BTN" button for iOS
    Then user should see a back button and Portfolio Breakdown Title at the top of the screen for iOS
