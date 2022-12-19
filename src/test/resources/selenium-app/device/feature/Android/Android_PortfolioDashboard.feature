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