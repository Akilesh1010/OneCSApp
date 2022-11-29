@td_OneCSAndroid_TD
Feature: MORE

  @More_Android @8.01_Android
  Scenario: verify the details displayed on the Sign In Welcome Screen
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
		And user Clicks on "More_Option" in Dashboard Screen for Android
		Then user should see "OneCS" as tittle in more options Screen for Android
		Then no "BACK_BUTTON" should be displayed for the menu screen for Android
		Then user should see below four categories in more screen for Android
									|USER SETTINGS				|
									|HELP & SUPPORT				|
									|MARKETS INFORMATION	|
									|ABOUT CHARLES STANLEY|
		Then under User Settings screen below options should be displayed with back option at right
									|Account settings|
									|Documents			 |
		Then under Help & Suppport screen below options should be displayed with back option at right
									|FAQs 						 |
									|Help centre			 |	
									|Glossary					 |
									|What's new				 |
		Then under Market info screen below options should be displayed with back option at right
									|Market data 		|	
									|Currency rates |
		Then under About Charles Stanley screen below options should be displayed with back option at right
									|Contact details 				 |
									|Important information	 |	
									|Licensing information	 |
									|Rate us								 |
		Then user should see Sign Out button displayed at the bottom
		And user closes "app" on mobile device														