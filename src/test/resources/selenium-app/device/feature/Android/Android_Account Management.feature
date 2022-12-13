@td_OneCSAndroid_TD
Feature: Account Management Screen

  @Account_Management_Android @7.01_Android
  Scenario: 7.01 - Verify the "Account Management" bottom sheet
    Given user launch app "OneCS.apk" on "Emulator" mobile device
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
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		Then user should see "ACCOUNT_MANAGEMENT" popup screen for Android
		Then user should see "CLOSE_BUTTON" account management screen for Android
		Then user should see below two options in Account Management screen for Android
										|Activity         |
										|Account breakdown|
		And upon swiping up Account Management popup should go to fullscreen for Android
		And user swipes down the Account Management screen for Android
		Then user should not see "ACCOUNT_MANAGEMENT" screen for Android
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And users taps the "DARK_AREA" on Account Dashboard screen for Android
		Then user should not see "ACCOUNT_MANAGEMENT" screen for Android
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps the "CLOSE_BUTTON" in account management popup screen for Android
		Then user should not see "ACCOUNT_MANAGEMENT" screen for Android
		And user closes "app" on mobile device
		
		@Account_Management_Android @7.02_Android
  Scenario: 7.02 -  Verify  the account, when it is having the "activity list" 
    Given user launch app "OneCS.apk" on "Emulator" mobile device
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
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		Then user should see below tabs in Activity screen for Android
								|Activity  |
								|Order list|
		And user closes "app" on mobile device
		
		@Account_Management_Android @7.03_Android
  Scenario: 7.03 - Verify the Manual refresh of the Activity screen
    Given user launch app "OneCS.apk" on "Emulator" mobile device
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
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		And user taps on "BACK_BUTTON" in Activity screen for Android
		Then user should selected Account in "ACCOUNT_DASHBOARD" screen for Android
		And user closes "app" on mobile device
		
		@Account_Management_Android @7.04_Android
  Scenario: 7.04 - Verify the Activity screen, when the account is having no activities 
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "testest" and "Cupholder1" for Android
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
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		Then under Activity bar blank page should be displayed for Android
		And user closes "app" on mobile device
		
		
		@Account_Management_Android @7.13_Android
  Scenario: 7.13 - verify the order details listed  in the order list screen 
    Given user launch app "OneCS.apk" on "Emulator" mobile device
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
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		And user taps on "ORDER_LIST" in Account Activity sheet for Android
		Then under order or fund name below details should be there with > arrow
											|Date|
											|Ref|
											|Type|
											|Current status|
		And user closes "app" on mobile device
		
		
		@Account_Management_Android @7.14_Android
  Scenario: 7.14 - To verify the display of different order types/status of an order 
    Given user launch app "OneCS.apk" on "Emulator" mobile device
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
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		And user taps on "ORDER_LIST" in Account Activity sheet for Android
		Then Confirm the orders of the below types
											|PROCESSING |
											|DEALT			|
											|CANCELLED  |
											|COMPLETE   |
											|REJECTED 	|
											|EXPIRED	  |
		And user closes "app" on mobile device
		
		@Account_Management_Android @7.25_Android
  Scenario: 7.25 - Verify when the account is having no orders
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "testest" and "Cupholder1" for Android
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
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		And user taps on "ORDER_LIST" in Account Activity sheet for Android
		Then under Activity bar blank page should be displayed for Android
		And user closes "app" on mobile device
		
		@Account_Management_Android @7.26_Android
  Scenario: 7.14 - To verify the back button on the  "Order List" Screen 
    Given user launch app "OneCS.apk" on "Emulator" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "testest" and "Cupholder1" for Android
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
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		And user taps on "ORDER_LIST" in Account Activity sheet for Android
		And user taps on "BACK_BUTTON" in Activity screen for Android
		Then user should selected Account in "ACCOUNT_DASHBOARD" screen for Android
		And user closes "app" on mobile device
		
		
		
		
		
		
		
		
		
		