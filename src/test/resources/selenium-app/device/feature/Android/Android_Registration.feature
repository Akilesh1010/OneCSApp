@td_OneCSAndroid_TD
Feature: Sign In/Login

  @SignIn_Android @2.01_Android
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
    
    
    @SignIn_Android @2.02_Android
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
    Then user should see "CLOSED_EYE" symbol inside password box
    Then user should see "INFO_BUTTON" encircled in pink in signin screen
    And user should see a link stating "I need help entering the correct details?" in signin screen
    And user should verify continue button Disabled
   	And user closes "app" on mobile device
   	
   @SignIn_Android	@2.03_Android
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
	
    @SignIn_Android @2.04_Android
  Scenario: To verify the validation for the Progress bar present on the "Registration" and "2FA" Screen

		Given user launch app "OneCS.apk" on "RealDevice" mobile device
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


	@SignIn_Android @2.05_Android
  Scenario: Verify the "I need help in entering details" link

		Given user launch app "OneCS.apk" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    And user taps on "I_need_help_in_entering_details" in Signin screen for Android
    Then user should verify below details in signin Screen for Android
    			|Recover details																																			|
    			|Forgot sign in details? Not to worry, just tap the relevant button below to fix this.|
    			|Forgot username																																			|
    			|Forgot password																																			|
    And user should see "X_Button" on the top right corner of the screen for Android
    And user taps on anywhere on the "DARK_SPACE" for Android
    Then user should not see the "FORGOT_USERNAME_PASSWORD" pop up in Signin Screen for Android
    Then user should see the entered username and password retained in sigin Screen for Android
    And user taps on "I_need_help_in_entering_details" in Signin screen for Android
   	When user taps "FORGOT_USERNAME" on signin screen for Android
   	Then user should be Navigated to the "https://www.charles-stanley-direct.co.uk/app/forgotten-username" website for Android
   	Then user verifies below fields in forgot username website for Android
   							|Date Of Birth|
    						|Account Number|
		And user clicks on Back Button for Android
		And user taps on "X_Button" on Forgot usrname popup for Android
		Then user should see the entered username and password retained in Login Screen for Android
		Then user should be navigated back to the "LOG_IN" screen for Android
		And user taps on "I_need_help_in_entering_details" in Signin screen for Android
		When user taps "FORGOT_PASSWORD" on signin screen for Android
		Then user should be Navigated to the "https://www.charles-stanley-direct.co.uk/app/reset-password" website for Android
		Then user verifies below fields in forgot password website for Android
   							|Username|
    						|Next|
    And user clicks on Back Button for Android
    And user taps on "X_Button" on Forgot usrname popup for Android
		Then user should see the entered username and password retained in Login Screen for Android
		And user taps on "I_need_help_in_entering_details" in Signin screen for Android
		And user taps on "X_Button" on Forgot usrname popup for Android
		Then user should not see the "FORGOT_USERNAME_PASSWORD" pop up in Signin Screen for Android
		And user closes "app" on mobile device
		
		
	@SignIn_Android @2.06_Android
  Scenario: Verify the sign in step 2 of 4 screen details & validations [2FA Screen]
		Given user launch app "OneCS.apk" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
		Then user should see the continue button turning to "Loading_Spinner" for Android
		And user should see "Sign in step 2 of 4" from Signin Screen for Android
		And user should see "BACK_BUTTON" on the top left corner of the screen for Android
		Then user should see "Verify your account" text in step two of sigin screen for Android
		And user should see a link stating "I need help verifying my account" in step two of sigin screen for Android
		And user enters "ONE_DIGIT" code in six digit code box for Android
		Then user should verify "VERIFY_BUTTON" disabled for Android
		And user enters "TWO_DIGIT" code in six digit code box for Android
		Then user should verify "VERIFY_BUTTON" disabled for Android
		And user enters "THREE_DIGIT" code in six digit code box for Android
		Then user should verify "VERIFY_BUTTON" disabled for Android
		And user enters "FOUR_DIGIT" code in six digit code box for Android
		Then user should verify "VERIFY_BUTTON" disabled for Android
		And user enters "FIVE_DIGIT" code in six digit code box for Android
		Then user should verify "VERIFY_BUTTON" disabled for Android
		And user enters the "TWO_FA" code in input box
		Then user should verify "VERIFY_BUTTON" enabled for Android
		Then user verifies whether the "TWO_FA" code entered is in correct order for Android
    When user clicks on Verify button
    Then user should see "Sign in step 3 of 4" from Signin Screen for Android
		And user clicks on Back Button for Android
		And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
    And user should see "Sign in step 2 of 4" from Signin Screen for Android
		And user enters incorrect TWOFA code in input box
		When user clicks on Verify button
		Then user should see "INCORRECT_CODE" alert pop up for Android
		Then user should see the "ERROR_MSG_POPUP" in pop up for Android
		And user taps on "EDIT_DETAILS" button in error message for Android
		Then user should not see "EDIT_DETAILS" overlay popup for Android
		And user should see "Sign in step 2 of 4" from Signin Screen for Android
		Then user verfies the incorrect TWOFA code retained in the box for Android
		Then user should verify "VERIFY_BUTTON" enabled for Android
		And user closes "app" on mobile device
		
		
	@SignIn_Android @2.07_Android
  Scenario: To verify the Sign In process when Mobile number is linked to account 2FA
  	Given user launch app "OneCS.apk" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
		Then user should see the continue button turning to "Loading_Spinner" for Android
		And user should see "Sign in step 2 of 4" from Signin Screen for Android
  	And user taps on "I_need_help_verifying_my_account" in Signin screen for Android
  	And upon swiping up RECOVER DETAILS popup should go to fullscreen for Android
  	Then user should see below details in TwoFA	 Screen for Android
    			|Recover details																																													|
    			|Struggling to verify your account? Not to worry. Just tap the relevant button below to get back on track.|
    			|Resend 6-digit code																																											|
    			|Check mobile number																																											|
  	And user should see "CLOSE_BUTTON_RECOVER" on the top right corner of the screen for Android
  	When user taps "CHECK_MOBILE_NUMBER" on TwoFA screen for Android
  	Then user should be Navigated to the "https://www.charles-stanley-direct.co.uk/My_Dashboard/My_Direct_Accounts/My_Profile/PersonalInformation" website for Android
  	Then user validates below fields in web url opened for Android
   							|Username|
    						|Password|
  							|Login	 |
  	And user enters "WEB_USERNAME" and "WEB_PASSWORD" in web url opened for Android
  	When user Clicks on "LOGIN_BUTTON"
  	Then user should be able to login to web application for Android
  	And user clicks on Back Button for Android
    And user taps on "CLOSE_BUTTON_RECOVER" on Recover Details popup for Android
    Then user should not see the "RECOVER_DETAILS" pop up in TwoFA Screen for Android
    And user closes "app" on mobile device
  	
  	
  	@SignIn_Android @2.09_Android
  Scenario: To verify the "Sign in step 3 of 4" screen details
  	Given user launch app "OneCS.apk" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	Then user should see "Sign in step 3 of 4" from Signin Screen for Android
  	And user should see progress bar as "Step3_of_4" in signin screen for Android
  	Then user validates below details in Step three screen for Android
  					|Create your PIN																																										 |
    				|You’ll use this 6-digit PIN to log in to your OneCS account securely if you don’t enable Biometrics.|
    Then user should see six blank text boxes for Android
    Then user should see "CONTINUE_BUTTON_DISABLED" for Android
    Then user should not see the "BACK_BUTTON" for Android
    And user closes "app" on mobile device
  	
	@SignIn_Android @2.10_Android
  Scenario: To verify the "Sign in step 3 of 4" screen validations
  	Given user launch app "OneCS.apk" on "RealDevice" mobile device							
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	Then user should see "Sign in step 3 of 4" from Signin Screen for Android
  	And user tries to enter alphabets "abcdef" in "CREATE_YOUR_PIN_BOX" for Android
  	Then user verifies the alphabets entered doenot appear in "CREATE_YOUR_PIN_BOX" for Android
  	And user should verify continue button Disabled in step three screen for Android
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
  	Then user verfies "SIX_DIGIT" pin entered appears in "CREATE_YOUR_PIN_BOX" for Android
  	Then user verifies whether the "SIX_DIGIT" code entered is in sequential order for Android
  	And user should verify continue button Enabled in step three screen for Android
  	And user taps on "STEP3_CONTINUE_BUTTON" for Android
  	Then user should see "Sign in step 4 of 4" from Signin Screen for Android
  	And user closes "app" on mobile device
  	
  @SignIn_Android @2.11_Android
  Scenario: To verify the "Sign in step 4 of 4" screen details	
  	Given user launch app "OneCS.apk" on "RealDevice" mobile device							
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
  	And user taps on "STEP3_CONTINUE_BUTTON" for Android
   	And user should see progress bar as "Step4_of_4" in signin screen for Android
  	Then user should see "Sign in step 4 of 4" from Signin Screen for Android
  	Then user should see "BACK_BUTTON" on the top left corner of the screen for Android 
  	Then user validates below details in step four of sign in screen for Android
  				|Confirm your PIN																																										 |
					|You’ll use this 6-digit PIN to log in to your OneCS account securely if you don’t enable Biometrics.|
		Then user verifies the "CREATE_YOUR_PIN_BOX"  is empty for Android
		Then user should verify "CONFIRM_PIN" button in step four of singin screen for Android
		And user closes "app" on mobile device
		
		@SignIn_Android @2.12_Android
  Scenario: To verify the "Sign in step 4 of 4" screen validations
  	Given user launch app "OneCS.apk" on "RealDevice" mobile device							
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
  	And user taps on "STEP3_CONTINUE_BUTTON" for Android
  	And user taps on "BACK_BUTTON" in step four of sign in screen for Android
  	Then user should see "Sign in step 3 of 4" from Signin Screen for Android
  	And user should verify "CONTINUE_BUTTON_DISABLED" buttom Disabled in step four screen for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		Then user should see the continue button turning to "Loading_Spinner" for Android
		Then upon confirming user should see "Enable biometrics" and "Maybe later" options for Android
		And user closes "app" on mobile device
		
		@SignIn_Android @2.13_Android
  Scenario: To verify the "Sign in step 4 of 4" screen validations
		Given user launch app "OneCS.apk" on "RealDevice" mobile device							
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		Then user should see "Sign in step 4 of 4" from Signin Screen for Android
		And user enters "INCORRECT_SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		Then user should see "INCORRECT_PIN" pop up in step four of sigin screen for Android
		Then user should validates "ERROR_MSG_STEP4" pop up in step four of sigin screen for Android
		Then user should see "EDIT_DETAILS_STEP4" button for Android
		And user closes "app" on mobile device	
		
		
		@SignIn_Android @2.16_Android
  Scenario: To verify whether the user is able to skip the Fingerprint/Face ID authentication during Registration - Maybe later
		Given user launch app "OneCS.apk" on "RealDevice" mobile device							
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		Then user should see "Secure Sign in" as header for Android
		Then upon confirming user should see "Enable biometrics" and "Maybe later" options for Android
		And user taps on "MAY_BE_LATER" option for Android
		Then user should see Dashboard screen
		And user closes "app" on mobile device
		
		@SignIn_Android @2.22_Android
  Scenario: More - Verify the Sign out process for the PIN, Fingerprint and Face ID logins
  	Given user launch app "OneCS.apk" on "RealDevice" mobile device							
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
		And user Signs Out the Mobile Application
		And user should see "CHARLES_STANLEY" logo in welcome screen for Android
		And user closes "app" on mobile device
		
		@SignIn_Android @2.24_Android
  Scenario: To verify the "Sign In" Screen for  the new user login using 6 - digit PIN
		Given user launch app "OneCS.apk" on "RealDevice" mobile device							
    And user Clicks on "SIGN_IN" button
		When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
		And user should see "Sign in step 2 of 4" from Signin Screen for Android
		And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
		Then user should see "Sign in step 3 of 4" from Signin Screen for Android
		And user should verify continue button Disabled in step three screen for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user should verify continue button Enabled in step three screen for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		Then user validates below details in step four of sign in screen for Android
  				|Confirm your PIN																																										 |
					|You’ll use this 6-digit PIN to log in to your OneCS account securely if you don’t enable Biometrics.|
		
		Then user verfies "CONFIRM_PIN" button is disabled for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		Then user should see the continue button turning to "Loading_Spinner" for Android
		Then user should see "SECURE_SIGN_IN" screen for Android
		Then upon confirming user should see "Enable biometrics" and "Maybe later" options for Android
		And user taps on "MAY_BE_LATER" option for Android
		Then user should see Dashboard screen
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
    
    And user Signs Out the Mobile Application
    And user closes "app" on mobile device
    
