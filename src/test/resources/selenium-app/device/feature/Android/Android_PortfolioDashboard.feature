@td_OneCSAndroid_TD
Feature: Portfolio Dashboard

  @More_Android @4.01_Android
  Scenario: 4.01 - To verify the "Portfolio Dashboard" Screen details and validations
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "NegativeBalance" and "Cupholder1" for Android
    #When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
		Then user should see a "PORTFOLIO_SELECTOR_PILLBOX" with a down arrow for Android
		Then user should see welcome back your current portfolio section including the performance arrow on Android
		Then user should be displayed with Portfolio summary value details on Android
		Then user should be displayed with bottom naviagation options for portfolio,contact,investments,insights and more on Android
		Then user should be able to pull down the screen to refresh the details for Android
		#Then user should verify the value of date format displayed on screen for Android
		Then user should see the Total Portfolio value is matching with sum of all portfolio values for Android
		Then user should see the Total Portfolio Value Change is matching with sum of all Portfolio Value Change for Android
		Then user selects the "Mr N Balancetest" from Your accounts screen for Android
		Then user should see the Account Dashboard value is matching with holdings value of the same account for Android
    Then user should see the Account Dashboard Value Change is matching with Sum of All Holdings Value Change for Android
		And user closes "app" on mobile device			
		
		@PortfolioDashboard_iOS @4.02_Android
  Scenario: 4.02 - To verify the "Portfolio Dashboard" Screen when the monetary values had +ve change
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "execution" and "Cupholder1" for Android
    #When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
    Then user should see "ZIG_ZAG_INCREASE" arrow in Portfolio Dashboard for Android
    Then user confirms the value of the portfolio change is shown as a percentage figure in Portfolio Dashboard for Android
    Then user should see "Positive" Portfolio Value Change in the Portfolio Dashboard screen for Android
    Then user should see "Positive" Sign in the Percentage value on the Portfolio Dashboard screen for Android
    And user closes "app" on mobile device

  @PortfolioDashboard_iOS @4.03_Android
  Scenario: 4.03 - To verify the "Portfolio Dashboard" Screen when the monetary values had -ve change
   	Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "NegativeBalance" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
		Then user confirms the value of the portfolio change is shown as a percentage figure in Portfolio Dashboard for Android
   	Then user should see "ZIG_ZAG_DECREASE" arrow in Portfolio Dashboard for Android
   	Then user should see "Negative" Portfolio Value Change in the Portfolio Dashboard screen for Android
    Then user should see "Negative" Sign in the Percentage value on the Portfolio Dashboard screen for Android
    And user closes "app" on mobile device
    
    
    @PortfolioDashboard_Android @4.05_Android
  Scenario: 4.05 - To verify the "Portfolio breakdown" screen details
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "NegativeBalance" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for Android
    And user Clicks on "PORTFOLIO_BREAKDOWN_I_BTN" button for Android
    Then user should see a back button and Portfolio Breakdown Title at the top of the screen for Android
    Then user should see the "INVESTMENT_BREAKDOWN_LABEL_TXT" is displayed for Android
    Then user should see "PORTFOLIO_LABEL_IN_PORTFOLIO_BREAKDOWN","CASH_LABEL_IN_PORTFOLIO_BREAKDOWN" and "COST_LABEL_IN_PORTFOLIO_BREAKDOWN" fields are displayed for Android
    Then user should see the "COST_INFO_BTN" is displayed for Android
    Then user should be displayed with bottom naviagation options for portfolio,contact,investments,insights and more on Android
    Then user should see "PORTFOLIO_VALUE_IN_PORTFOLIO_BREAKDOWN","PORTFOLIO_CASH_VALUE_IN_PORTFOLIO_BREAKDOWN" and "COST_VALUE_IN_PORTFOLIO_BREAKDOWN" fields are displayed for Android
    And user Clicks on "BACK_BUTTON" button for Android
    Then user Clicks on "PORTFOLIO_BREAKDOWN_I_BTN" button for Android
    Then user should see the "INVESTMENT_BREAKDOWN_LABEL_TXT" is displayed for Android
    Then user should see "PORTFOLIO_LABEL_IN_PORTFOLIO_BREAKDOWN","CASH_LABEL_IN_PORTFOLIO_BREAKDOWN" and "CASH_LABEL_IN_PORTFOLIO_BREAKDOWN" fields are displayed for Android
    Then user should see the "COST_INFO_BTN" is displayed for Android
    Then user should be displayed with bottom naviagation options for portfolio,contact,investments,insights and more on Android
    And user closes "app" on mobile device		
    
    
    @PortfolioDashboard_Android @4.06_Android
  Scenario: 4.06 - To verify the details of Cost Information Pop Up on the "Portfolio breakdown" screen details
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "NegativeBalance" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for Android
    And user Clicks on "PORTFOLIO_BREAKDOWN_I_BTN" button for Android
    Then user should see a back button and Portfolio Breakdown Title at the top of the screen for Android
    Then user Clicks on "COST_INFO_BTN" button for Android
    Then user should see "COST_INFO_POP_UP_TITLE" text in the pop up for Android
    Then user should see the "IC_CLOSE_BTN" is displayed for Android
    Then user should see the "GOT_IT_BTN" is displayed for Android
    Then user swipe up the pop up to the full screen for Android
    Then user Clicks on "IC_CLOSE_BTN" button for Android
    Then user Clicks on "COST_INFO_BTN" button for iOS
    Then user should see "COST_INFO_POP_UP_TITLE" text in the pop up for Android
    Then user Clicks on "GOT_IT_BTN" button for Android
    Then user Clicks on "COST_INFO_BTN" button for Android
    Then user should see "COST_INFO_POP_UP_TITLE" text in the pop up for Android
    Then user Clicks on "COST_INFO_BTN" button for Android
    And user closes "app" on mobile device	
    
    
    
    @PortfolioDashboard_Android @4.08_Android
  Scenario: 4.08 - To verify the "Your Accounts" bottom sheet details and its validations
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "NegativeBalance" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for Android
    Then user swipe up the Your Accounts screen to the full screen for Android
    Then user should see "YOUR_ACCOUNTS_TAB","YOUR_ACCOUNTS_TAB_MINIMIZE_BTN" and "TOTAL_ACCOUNTS_IN_ACCOUNTS_SCREEN" fields are displayed for Android
    Then user should see "PORTFOLIO_ACCOUNT_NAME_YOUR_ACCOUNTS_1","PORTFOLIO_ACCOUNT_TOTAL_VALUE_1" and "PORTFOLIO_ACCOUNT_VALUE_CHANGE_1" fields are displayed for Android
    Then user should see "PORTFOLIO_ACCOUNT_CODE_1","PORTFOLIO_ACCOUNT_PERCENTAGE_CHANGE_1" and "MANAGED_BY_CS_LABEL_IN_YAOUR_ACCOUNTS_1" fields are displayed for Android
    Then user should see the "YOUR_ACCOUNTS_TIME_STAMP_LABEL" is displayed for Android
    #Then user should verify the value of date format displayed correctly on the "Your accounts" screen for Android
    Then user Clicks on "YOUR_ACCOUNTS_TAB_MINIMIZE_BTN" button for Android
    Then user should be displayed with Portfolio summary value details on Android
    And user closes "app" on mobile device	
    
    @PortfolioDashboard_Android @4.10_Android
  Scenario: 4.10 - To verify the "Your Accounts" bottom sheet when there are no accounts under the selected Portfolio
    #CoreyDuffy\Cupholder1
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "CoreyDuffy" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for Android
    Then user swipe up the Your Accounts screen to the full screen for Android
    Then user should see "YOUR_ACCOUNTS_TAB" and "YOUR_ACCOUNTS_TAB_MINIMIZE_BTN" fields are displayed for Android
    Then user should not see the "TOTAL_ACCOUNTS_IN_ACCOUNTS_SCREEN" displayed on screen for Android
    And user closes "app" on mobile device
    
    
    @PortfolioDashboard_Android @4.11_Android
  Scenario: 4.11 - Portfolio Dashboard - To Verify the Number formatting & styling, when switching between the show/hide state.
    #execution/Cupholder1
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "execution" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for Android
    Then user should be displayed with Portfolio summary value details on Android
    Then verify the "open eye" symbol is displayed for Android
    Then user Clicks on "PORTFOLIO_EYE_ICON_BTN" button for Android
    Then verify the "closed eye" symbol is displayed for Android
    Then user should see the "PORTFOLIO_VALUE_TXT" field value is hidden on the screen for Android
    And user should see the "PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT" field value is hidden on the screen for Android
    Then user should still see the Percentage value is retained in the field "PORTFOLIO_DASH_PERCENTAGE_CHANGE" for Android
    Then user swipe up the Your Accounts screen to the full screen for Android
    Then user should see the "PORTFOLIO_ACCOUNT_TOTAL_VALUE_1" field value is hidden on the screen for Android
    Then user should see the "PORTFOLIO_ACCOUNT_VALUE_CHANGE_1" field value is hidden on the screen for Android
    Then user should see the "PORTFOLIO_ACCOUNT_CODE_1" field value is hidden on the screen for Android
    And user closes "app" on mobile device
    
    
    @PortfolioDashboard_Android @4.12_Android
  Scenario: 4.12 - Portfolio Breakdown - To Verify the Number formatting & styling, when switching between the show/hide state.
    #execution/Cupholder1
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "execution" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for Android
    Then user Clicks on "PORTFOLIO_EYE_ICON_BTN" button for Android
    Then verify the "closed eye" symbol is displayed for Android
    And user Clicks on "PORTFOLIO_BREAKDOWN_I_BTN" button for Android
    Then user should see a back button and Portfolio Breakdown Title at the top of the screen for Android
    Then user should see the "PORTFOLIO_VALUE_IN_PORTFOLIO_BREAKDOWN" field value is hidden on the breakdown screen for Android
    Then user should see the "PORTFOLIO_CASH_VALUE_IN_PORTFOLIO_BREAKDOWN" field value is hidden on the breakdown screen for Android
    Then user Clicks on "BACK_BUTTON" button for Android
    Then verify the "closed eye" symbol is displayed for Android
    Then user should be displayed with Portfolio summary value details on Android
    #Then user should see the "PORTFOLIO_VALUE_TXT" field value is hidden on the screen for iOS
    And user closes "app" on mobile device
    
    
    @PortfolioDashboard_Android @4.13_Android
  Scenario: 4.13 - Your Accounts - To Verify the Number formatting & styling, when switching between the show/hide state.
    #execution/Cupholder1
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "execution" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for Android
    Then user Clicks on "PORTFOLIO_EYE_ICON_BTN" button for iOS
    Then verify the "closed eye" symbol is displayed for iOS
    Then user swipe up the Your Accounts screen to the full screen for Android
    Then user should see the "PORTFOLIO_ACCOUNT_TOTAL_VALUE_1" field value is hidden on the screen for Android
    Then user should see the "PORTFOLIO_ACCOUNT_VALUE_CHANGE_1" field value is hidden on the screen for Android
    Then user should see the "PORTFOLIO_ACCOUNT_CODE_1" field value is hidden on the screen for iOS
    Then user should still see the Percentage value is retained in the field "PORTFOLIO_ACCOUNT_PERCENTAGE_CHANGE_1" for Android
    And user closes "app" on mobile device
    
    @PortfolioDashboard_Android @4.14_Android
  Scenario: 4.14 - Verify the Number formatting & styling, when user is backgrounding the app and foregrounding it again.
    #execution/Cupholder1
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "execution" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for Android
    Then user Clicks on "PORTFOLIO_EYE_ICON_BTN" button for Android
    Then verify the "closed eye" symbol is displayed for Android
    Then user push the app to background for 10 seconds and relaunch the app again for Android
    Then user should see the "PORTFOLIO_VALUE_TXT" field value is hidden on the screen for Android
    And user should see the "PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT" field value is hidden on the screen for Android
    Then user swipe up the Your Accounts screen to the full screen for Android
    Then user should see the "PORTFOLIO_ACCOUNT_TOTAL_VALUE_1" field value is hidden on the screen for Android
    Then user should see the "PORTFOLIO_ACCOUNT_VALUE_CHANGE_1" field value is hidden on the screen for Android
    Then user should see the "PORTFOLIO_ACCOUNT_CODE_1" field value is hidden on the screen for Android
    Then user Clicks on "YOUR_ACCOUNTS_TAB_MINIMIZE_BTN" button for Android
    And user Clicks on "PORTFOLIO_BREAKDOWN_I_BTN" button for Android
    Then user should see a back button and Portfolio Breakdown Title at the top of the screen for Android
    Then user should see the "PORTFOLIO_VALUE_IN_PORTFOLIO_BREAKDOWN" field value is hidden on the breakdown screen for Android
    Then user should see the "PORTFOLIO_CASH_VALUE_IN_PORTFOLIO_BREAKDOWN" field value is hidden on the breakdown screen for Android
    And user closes "app" on mobile device
    
    
    @PortfolioDashboard_Android @4.15_Android
  Scenario: 4.15 - Verify the Number formatting & styling, when user is closing the OneCS app and launching it again.
    #execution/Cupholder1
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "execution" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for Android
    And user closes "app" on mobile device
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "execution" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for Android
    Then user should see the "PORTFOLIO_VALUE_TXT" field value is NOT hidden on the screen for iOS
    Then user should see the "PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT" field value is NOT hidden on the screen for iOS
    Then user swipe up the Your Accounts screen to the full screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_TOTAL_VALUE_1" field value is NOT hidden on the screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_VALUE_CHANGE_1" field value is NOT hidden on the screen for iOS
    Then user should see the "PORTFOLIO_ACCOUNT_CODE_1" field value is NOT hidden on the screen for iOS
    And user closes "app" on mobile device
    							