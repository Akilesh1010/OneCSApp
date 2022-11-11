@td_OneCSAndroid_TD
Feature: Sign In/Login

  @2.01_Android
  Scenario: verify the details displayed on the Sign In Welcome Screen
    Given user launch app "OneCS.apk" on "RealDevice" mobile device
    And user should see "CHARLES_STANLEY" logo in welcome screen for Android
    And user should see "CREATE_SECURE" text in welcome screen for Android
    Then user verifies "SIGN_IN" button in welcome screen for Android
    And user should see "Don't have an account?" text on welcome screen for Android
    And user should verify "CREATE_ONE_ON_OUR_WEBSITE" text in welcome screen for Android
    When user taps on "CREATE_ONE_ON_OUR_WEBSITE" link on Android
    Then user should be Navigated to the "https://www.charles-stanley.co.uk/services/save" website for Android
    And user clicks on Back Button for Android
    Then user should be Navigated again to "WELCOME_SCREEN" for Android
    And user closes "app" on mobile device
    
    
    @2.02_Android
  Scenario: To verify the details displayed on the "Sign In Registration" Screens
    Given user launch app "OneCS.apk" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN" button
    And user should see "Sign in step 1 of 4" from Signin Screen for Android
    And user should see "X_Button" on the top left corner of the screen for Android
    And user should see progress bar as "Step1_of_4" in signin screen for Android
    And user should verify whether "Username & password" is present in sigin screen for Android
    And user should be able to see "Please enter your username and password associated with your Charles Stanley account." on signin Screen For Android
    And user should see "Username" text inside the username box
    And user should see "Password"  text inside the Password box
    And user verifies username and password field is empty
   	And user closes "app" on mobile device
   	
   	@2.03_Android
  Scenario: To verify the Username/Password validation  on the "Registration" Screen
    Given user launch app "OneCS.apk" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN" button
    And user enters "Correct_Username" in username field
    And user should verify continue button Disabled
    And user removes username and enters "Correct_Password" in password field
    And user should verify continue button Disabled
		And user taps on "X_Button" in signin Screen for Android
		Then user should be Navigated again to "WELCOME_SCREEN" for Android
		And user Clicks on "SIGN_IN" button
		When user enters "Correct_Username" and "Incorrect_Password"
		When user Clicks on "Continue_Button"
		Then user should see "DETAILS_INCORRECT" pop up for Android
		Then user should see "ERROR_MSG" in pop up for Android
		And user taps on "EDIT_DETAILS" button in error message for Android
		Then user should not see "EDIT_DETAILS" overlay popup for Android
		And user should see progress bar as "Step1_of_4" in signin screen for Android
		Then user should see "Continue_button" Enabled for Android
		And user taps on "X_Button" in signin Screen for Android
		Then user should be Navigated again to "WELCOME_SCREEN" for Android
		And user Clicks on "SIGN_IN" button
		When user enters "Incorrect_Username" and "Correct_Password"
		When user Clicks on "Continue_Button"
		Then user should see "ERROR_MSG" in pop up for Android
		And user taps on "EDIT_DETAILS" button in error message for Android
		Then user should not see "EDIT_DETAILS" overlay popup for Android
		And user should see progress bar as "Step1_of_4" in signin screen for Android
		Then user should see "Continue_button" Enabled for Android
		And user clears the entered Username and Password from the fields for Android
		And user enteres a letter "A" in username fields for Android
		And user should verify continue button Disabled
		Then user should not see "EDIT_DETAILS" overlay popup for Android
		And user clears the entered Username and Password from the fields for Android
		And user enteres a letter "A" in password fields for Android
		And user should verify continue button Disabled
		Then user should not see "EDIT_DETAILS" overlay popup for Android
		And user taps on "X_Button" in signin Screen for Android
		Then user should be Navigated again to "WELCOME_SCREEN" for Android
		And user Clicks on "SIGN_IN" button
		And user enters "Correct_Password" in password field and taps on "Eye_Icon" for Android
		Then user should see the entered password in password fiedls for Android
		And user closes "app" on mobile device
	
    @2.04_Android
  Scenario: Verify the "I need help in entering details" link

		Given user launch app "OneCS.apk" on mobile device
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    Then user should see "Continue_Button" enabled
    And user should see progress bar as "Step1_of_4" in signin screen for Android
    When user Clicks on "Continue_Button"
    Then user should see the continue button turning to "Loading_Spinner" for Android
    And user should see progress bar as "Step2_of_4" in signin screen for Android
    And user clicks on Back Button for Android
    And user should see progress bar as "Step1_of_4" in signin screen for Android
    Then user should see the entered username and password retained in sigin Screen for Android
    Then user should see "TWO_FA" screen
		And user closes "app" on mobile device











  @AndroidPOC1 @POC2
  Scenario: Verification of user login functionality with Correct Username and Correct Password
    Given user launch app "OneCS.apk" on mobile device
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
    Then user should see "TWO_FA" screen
    And user closes "app" on mobile device
    
    And user Clicks on "SIGN_IN" button
    When user enters "Incorrect_Username" and "Incorrect_Password"
    When user Clicks on "Continue_Button"
    Then user should see "Error_Msg"
    
    @AndroidPOC1 @POC3
  Scenario: Verification of user login functionality with Correct Username and Correct Password
    Given user launch app "universal.apk" on mobile device
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
    Then user should see "TWO_FA" screen
    And user enters the "TWO_FA" code in input box
    When user clicks on Verify button
    And user should tap on "USE_SIX_DIGIT_PIN" in screen
    And user should see "CREATE_YOUR_PIN" screen
    And user enters a desired "SIX_DIGIT" pin
    When user clicks on continue button
    And user reenters the "SIX_DIGIT" pin again
    When user clicks on "CONFIRM_PIN" button
    Then user should see Dashboard screen
    And user clicks on Accounts Tab
    And user clicks on Preferred Accounts
    When user clicks on Holdings Tab
    Then user should see the list of Holdings
    And user clicks on Buy Shares Button
    And user buys share with Desired Amount
    And user cliks on Continue Button
    And user Prefers to Cancel the Transaction
    And User Navigates to Accounts Page
    And user Clicks on More Option
    And user Signs Out the Mobile Application
    And user closes "app" on mobile device
    
