@td_OneCSAndroid_TD
Feature: Account Dashboard

  @Account_Dashboard_Android @5.01_Android
  Scenario: 5.01 - To verify the Account Dashboard Screen details
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "edinburgh" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
		And user taps on "YOUR_ACCOUNTS" in Dashboard screen for Android
		And user selects a account from the list of accounts in Accounts screen for Android
    Then user verifies whether it lands on "ACCOUNT_DASHBOARD" screen for Android
    And user taps on "BACK_BUTTON" in Dashboard screen for Android
    Then user verifies whether it lands on "PORTFOLIO_DASHBOARD" screen for Android
    And user taps on "YOUR_ACCOUNTS" in Dashboard screen for Android
    And user selects a account from the list of accounts in Accounts screen for Android
    Then user verifies whether it lands on "ACCOUNT_DASHBOARD" screen for Android
    And user taps on "BACK_BUTTON" in Dashboard screen for Android
   	And user taps on "YOUR_ACCOUNTS" in Dashboard screen for Android
    And user selects a account from the list of accounts in Accounts screen for Android
    Then user verifies whether it lands on "ACCOUNT_DASHBOARD" screen for Android
    Then user validates the details in the Account Dashboard screen for Android
    And user the pulls down and refreshes the Accounts Dashboard screen for Android
    And user navigates to other tabs and should be able to find a change in values in Accounts Dashboard screen for Android
    And user closes "app" on mobile device
    
@Account_Dashboard_Android @5.02_Android
  Scenario: To verify the Account Dashboard Screen details
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "edinburgh" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
		And user taps on "YOUR_ACCOUNTS" in Dashboard screen for Android
		And user selects a account from the list of accounts in Accounts screen for Android
    Then user verifies whether it lands on "ACCOUNT_DASHBOARD" screen for Android
    And user the pulls down and refreshes the Accounts Dashboard screen for Android
    And user navigates to other tabs and should be able to find a change in values in Accounts Dashboard screen for Android
    And user closes "app" on mobile device
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		    