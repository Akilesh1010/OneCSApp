@td_OneCSAndroid_TD
Feature: Account Management Screen

  @Account_Management_Android @7.01_Android
  Scenario: 7.01 - Verify the "Account Management" bottom sheet
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
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		Then user should see below tabs in Activity screen for Android
								|Activity  |
								|Order list|
		And user closes "app" on mobile device
		
		@Account_Management_Android @7.03_Android
  Scenario: 7.03 - Verify the Manual refresh of the Activity screen
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
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		And user taps on "BACK_BUTTON" in Activity screen for Android
		Then user should selected Account in "ACCOUNT_DASHBOARD" screen for Android
		And user closes "app" on mobile device
		
		@Account_Management_Android @7.04_Android
  Scenario: 7.04 - Verify the Activity screen, when the account is having no activities 
    Given user launch app "OneCS.apk" on "BrowserStack" mobile device
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
		And user selects a account from the list of accounts in Accounts screen for Android
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		Then under Activity bar blank page should be displayed for Android
		And user closes "app" on mobile device
		
		@Account_Management_Android @7.06_Android
  Scenario: 7.06 - Verify the "Cash Movement" details when the "Cash Movement value" is positive in case of Money in
    Given user launch app "OneCS.apk" on "BrowserStack" mobile device
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
		And user taps on "YOUR_ACCOUNTS" in Dashboard screen for Android
		And user selects Mr.Lucas Investment Account from yours Accounts screen for Android
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		Then in extreme left right arrow in square bracket "CASH_MOVEMENT_ICON" should be displayed for Android
		Then besides to cash movement icon "Cash movement" title should be displayed for Android
		Then beneath cash movement title "Money in" subtype should be displayed for Android
		Then in extreme right cash movement value should be displayed in pounds for Android
		Then user shoud see "+" symbol infront of currency symbol for Android
		And user closes "app" on mobile device
	
	
	
		
			
		@Account_Management_Android @7.13_Android
  Scenario: 7.13 - verify the order details listed  in the order list screen 
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
		
		@Account_Management_Android @7.16_Android
  Scenario: 7.16 - Verify loading status of the pages
    Given user launch app "OneCS.apk" on "BrowserStack" mobile device
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
		And user taps on "YOUR_ACCOUNTS" in Dashboard screen for Android
		And user selects Mr.Lucas Investment Account from yours Accounts screen for Android
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		Then user should see Loading spinner while navigating in Android
		And user closes "app" on mobile device
		
		@Account_Management_Android @7.18_Android
  Scenario: 7.18 - Verify the details of each order status in order list
    Given user launch app "OneCS.apk" on "BrowserStack" mobile device
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
		And user taps on "YOUR_ACCOUNTS" in Dashboard screen for Android
		And user selects Mr.Lucas Investment Account from yours Accounts screen for Android
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		And user taps on "ORDER_LIST" in Account Activity sheet for Android
		Then user clicks on any order from orderlist for Android
		Then user should see "CLOSE_BUTTON" in top left corner of order list screen for Android
		Then user see below details in selected order for Android
										|Status					|
										|Order reference|
										|Trade type			|
										|Date						|
										|Settlement date|
										|Price					|
										|Quantity				|
										|Consideration	|
										|Other					|
										|Dealing fee		|
										|Estimated value|
		Then user should see "CANCEL_0RDER" button at the bottom of the order details screen for Android								
		And user closes "app" on mobile device
		
		@Account_Management_Android @7.17_Android
  Scenario: 7.17 - To verify the manual refresh of the order list screen
    Given user launch app "OneCS.apk" on "BrowserStack" mobile device
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
		And user taps on "YOUR_ACCOUNTS" in Dashboard screen for Android
		And user selects Mr.Lucas Investment Account from yours Accounts screen for Android
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		And user taps on "ORDER_LIST" in Account Activity sheet for Android
		Then user should be able to swipe down and refresh the screen
		And user closes "app" on mobile device
		
		@Account_Management_Android @7.19_Android
  Scenario: 7.19 - Verify the transition of the bottom sheet- View Order
    Given user launch app "OneCS.apk" on "BrowserStack" mobile device
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
		And user taps on "YOUR_ACCOUNTS" in Dashboard screen for Android
		And user selects a account from the list of accounts in Accounts screen for Android
		And user taps on "EDIT_PENCIL" in Account Dashboard screen for Android
		And user taps on "ACTIVITY" in account management bottom sheet for Android
		And user taps on "ORDER_LIST" in Account Activity sheet for Android
		Then user clicks on any order from orderlist for Android
		Then user should see Order Details displayed in fullscreen for Android
		And user closes "app" on mobile device
		
		
		
		@Account_Management_Android @7.25_Android
  Scenario: 7.25 - Verify when the account is having no orders
    Given user launch app "OneCS.apk" on "BrowserStack" mobile device
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
  Scenario: 7.26 - To verify the back button on the  "Order List" Screen 
    Given user launch app "OneCS.apk" on "BrowserStack" mobile device
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
		
		
		
		
		
		
		
		
		
		