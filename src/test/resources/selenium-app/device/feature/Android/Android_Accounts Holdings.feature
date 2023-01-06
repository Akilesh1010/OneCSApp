@td_OneCSAndroid_TD
Feature: Verify the screen details and its validations for the Holdings screens.

	@Account_Holdings_Android @6.01_Android
  Scenario: 6.01 - To Verify the holdings details in the account screen [Minimized screen] 
    Given user launch app "OneCS.apk" on "BrowserStack" mobile device
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
		And user taps on "YOUR_ACCOUNTS" in Dashboard screen for Android
		And user selects Mr.Lucas Investment Account from yours Accounts screen for Android
		Then user minimized Holdings bottom sheet should be displayed for Android
		Then "Holdings" as Header should be displayed in the middle of the minimized sheet for Android
		Then "THREE_LINES" should be displayed on the extreme right beside to Holdings title for Android
		Then Holding name and details container with > right chevron on the extreme right for Android
		Then user verifes below fields are present in Holdings name 
											|Value|
											|Price|
											|Value Change|
											|Cost|
		Then user verifies all the Holdings are arranged in alphabetical order for Android
		And user closes "app" on mobile device
		
		@Account_Holdings_Android @6.03_Android
  Scenario: 6.03 - To verify the manual refresh the holdings screen 
    Given user launch app "OneCS.apk" on "BrowserStack" mobile device
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
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
		And user the pulls down and refreshes the Accounts Dashboard screen for Android
    And user navigates to other tabs and should be able to find a change in values in Accounts Dashboard screen for Android
		And user closes "app" on mobile device
		
		@Account_Holdings_Android @6.04_Android
  Scenario: 6.04 - To verify the account dashboard screen with no holdings 
    Given user launch app "OneCS.apk" on "BrowserStack" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "NoHoldings" and "Cupholder1" for Android
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
		Then user should verify "No_holdings" are displayed in the Holdings screen for Android
		Then "Holdings" as Header should be displayed in the middle of the minimized sheet for Android
		Then user should not see "Downward_Chevron_Button" In the minimized view of the Holdings screen
		Then user should see "Downward_Chevron_Button" In the fullscreen view of the Holdings screen
		Then "THREE_LINES" should be displayed on the extreme right beside to Holdings title for Android
		And user closes "app" on mobile device