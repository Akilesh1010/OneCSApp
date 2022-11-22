@td_OneCSiOS_TD
Feature: Sign in / Login feature validation on iOS app

  @SignIn_iOS @2.01_iOS
  Scenario: verify the details displayed on the Sign In Welcome Screen
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    And user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    And user should see "CS_CREATE_A_SECURE" text in welcome screen for iOS
    Then user should see "SIGN_IN_BTN" in welcome screen for iOS
    And user should see "DON’T_HAVE_AN_ACCOUNT_LNK" text in welcome screen for iOS
    And user Clicks on "CREATE_ACCOUNT_ON_WEBSITE_LNK" button for iOS
    Then user should be Navigated to the "‎‎charles-stanley.co.uk, secure" website for iOS
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    And user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.02_iOS
  Scenario: To verify the details displayed on the "Sign In Registration" Screens
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    And user should see "Sign in step 1 of 4" from Signin Screen for iOS
    And user should see "IC_CLOSE_BTN" on the top left corner of the screen for iOS
    And user should be displayed with "USERNAME_PASSWORD_LABEL_TXT" in sigin screen for iOS
    And user should be displayed with "Please enter your username and password associated with your Charles Stanley account." in signin screen for iOS
    And user should see "Username" text inside the username box for iOS
    And user should see "Password" text inside the Password box for iOS
    Then user should see "EYE_PWD_HIDE_BTN" symbol inside password box for iOS
    Then user should see "INFO_IMAGE" encircled in pink in signin screen for iOS
    And user should see a link stating "I need help entering the correct details?" in signin screen for iOS
    And user should verify "CONTINUE_SIGN_IN_BTN" Disabled for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.03_iOS
  Scenario: To verify the Username/Password validation  on the "Registration" Screen
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    And user enters "Correct_Username" in username field for iOS
    And user should verify "CONTINUE_SIGN_IN_BTN" Disabled for iOS
    And user removes username and enters "Correct_Password" in password field for iOS
    And user should verify "CONTINUE_SIGN_IN_BTN" Disabled for iOS
    And user clicks on "IC_CLOSE_BTN" in signin Screen for iOS
    And user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Incorrect_Password" for iOS
    When user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    Then user should see Sign in error message for iOS
    And user Clicks on "EDIT_DETAILS_BTN" button for iOS
    Then user should not see "DETAILS_INCORRECT_TITLE_LABEL" overlay popup for iOS
    Then user should see "CONTINUE_SIGN_IN_BTN" Enabled for iOS
    And user clicks on "IC_CLOSE_BTN" in signin Screen for iOS
    And user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Incorrect_Username" and "Correct_Password" for iOS
    When user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    Then user should see Sign in error message for iOS
    And user Clicks on "EDIT_DETAILS_BTN" button for iOS
    Then user should not see "DETAILS_INCORRECT_TITLE_LABEL" overlay popup for iOS
    Then user should see "CONTINUE_SIGN_IN_BTN" Enabled for iOS
    And user clears the entered Username and Password from the fields for iOS
    And user enters "LETTER_A" in username field for iOS
    And user should verify "CONTINUE_SIGN_IN_BTN" Disabled for iOS
    Then user should not see "DETAILS_INCORRECT_TITLE_LABEL" overlay popup for iOS
    And user removes username and enters "LETTER_A" in password field for iOS
    And user should verify "CONTINUE_SIGN_IN_BTN" Disabled for iOS
    Then user should not see "DETAILS_INCORRECT_TITLE_LABEL" overlay popup for iOS
    And user clicks on "IC_CLOSE_BTN" in signin Screen for iOS
    And user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    And user Clicks on "EYE_PWD_HIDE_BTN" button for iOS
    Then user should see the entered password in password fiedls for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.05_iOS
  Scenario: Verify the "I need help in entering details" link
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    And user Clicks on "I_NEED_HELP_ENTERING_CORRECT_DETAILS_LINK" button for iOS
    Then user should verity the fields and labels of Forgot Sign in details section for iOS
    And user Clicks on "CANCEL_BTN" button for iOS
    Then user should not see the "FORGOT_SIGN_IN_DETAILS_LABEL_TXT" pop up in Signin Screen for iOS
    Then user should see the entered username and password retained in sigin Screen for iOS
    And user Clicks on "I_NEED_HELP_ENTERING_CORRECT_DETAILS_LINK" button for iOS
    When user Clicks on "FORGOT_USER_NAME_BTN" button for iOS
    #Then user should be Navigated to the "https://www.charles-stanley-direct.co.uk/app/forgotten-username" website for iOS
    Then user verifies below fields in forgot username website for iOS
      | Forgotten Username |
      | Date Of Birth      |
      | Account Number     |
    Then user launch app "OneCSiOSApp" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user should see the entered username and password retained in sigin Screen for iOS
    And user Clicks on "I_NEED_HELP_ENTERING_CORRECT_DETAILS_LINK" button for iOS
    When user Clicks on "FORGOT_PWD_BTN" button for iOS
    #Then user should be Navigated to the "https://www.charles-stanley-direct.co.uk/app/reset-password" website for iOS
    Then user verifies below fields in forgot password website for iOS
      | Forgotten Password |
      | Username           |
      | Next               |
    Then user launch app "OneCSiOSApp" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user should see the entered username and password retained in sigin Screen for iOS
    And user Clicks on "I_NEED_HELP_ENTERING_CORRECT_DETAILS_LINK" button for iOS
    And user Clicks on "CANCEL_BTN" button for iOS
    Then user should not see the "FORGOT_SIGN_IN_DETAILS_LABEL_TXT" pop up in Signin Screen for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.06_iOS
  Scenario: Verify the sign in step 2 of 4 screen details & validations [2FA Screen]
    Then user launch app "OneCSiOSApp" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    When user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user should see "Sign in step 2 of 4" from Signin Screen for iOS
    And user should see "BACK_BUTTON" on the top left corner of the screen for iOS
    Then user should see "VERIFY_YOUR_ACCOUNT_TWO_FA_TXT" screen for iOS
    #Then user should see "WE_HAVE_SENT_A_6_DIGIT_CODE_TXT_2FA_SCREEN" screen for iOS
    And user should see a link stating "I need help verifying my account" in step two of sigin screen for iOS
    And user enters "ONE_DIGIT" code in six digit code box for iOS
    And user should verify "VERIFY_BTN" Disabled for iOS
    And user enters "TWO_DIGIT" code in six digit code box for iOS
    And user should verify "VERIFY_BTN" Disabled for iOS
    And user enters "THREE_DIGIT" code in six digit code box for iOS
    And user should verify "VERIFY_BTN" Disabled for iOS
    And user enters "FOUR_DIGIT" code in six digit code box for iOS
    And user should verify "VERIFY_BTN" Disabled for iOS
    And user enters "FIVE_DIGIT" code in six digit code box for iOS
    And user should verify "VERIFY_BTN" Disabled for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    Then user should see "VERIFY_BTN" Enabled for iOS
    And user Clicks on "VERIFY_BTN" button for iOS
    And user should see "Sign in step 3 of 4" from Signin Screen for iOS
    #And user should see "BACK_BUTTON" on the top left corner of the screen for iOS
    Then user launch app "OneCSiOSApp" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    When user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user should see "Sign in step 2 of 4" from Signin Screen for iOS
    And user enters incorrect TWOFA code in input box for iOS
    And user Clicks on "VERIFY_BTN" button for iOS
    Then user should see "INCORRECT_CODE_LABEL_TXT" text in the pop up for iOS
    Then user should see "PLEASE_CHECK_THE_DETAILS_ENTERED_TXT" text in the pop up for iOS
    And user Clicks on "EDIT_DETAILS_BTN" button for iOS
    Then user should not see "INCORRECT_CODE_LABEL_TXT" overlay popup for iOS
    And user should see "Sign in step 2 of 4" from Signin Screen for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.07_iOS
  Scenario: To verify the Sign In process when Mobile number is linked to account 2FA
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    When user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user should see "Sign in step 2 of 4" from Signin Screen for iOS
    And user Clicks on "I_NEED_HELP_VERIFYING_ACCOUNT_LINK" button for iOS
    Then user should see below details in TwoFA Screen for iOS
      | Struggling to verify your account? Not to worry. Just tap the relevant button below to get back on track. |
      | Resend 6-digit code                                                                                       |
      | Check mobile number                                                                                       |
      | Cancel                                                                                                    |
    And user Clicks on "CHECK_MOBILE_NUMBER_BTN" button for iOS
    #	Then user should be Navigated to the "https://www.charles-stanley-direct.co.uk/My_Dashboard/My_Direct_Accounts/My_Profile/PersonalInformation" website for iOS
    Then user validates below fields in web url opened for iOS
      | Username |
      | Password |
      | Login    |
    And user enters "WEB_USERNAME" and "WEB_PASSWORD" in web url opened for iOS
    When user Clicks on "LOGIN_BTN_IN_WEB" button for iOS
    Then user should be able to view the memorable Word field in the web for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.09_iOS
  Scenario: To verify the "Sign in step 3 of 4" screen details
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user should see "Sign in step 3 of 4" from Signin Screen for iOS
    Then user should see "CREATE_YOUR_PIN_LABEL_TXT" screen for iOS
    Then user should see "YOU_WILL_USE_THIS_PIN_TXT_IN_SIGN3_SCREEN" screen for iOS
    Then user should see "WHY_DO_I_NEED_A_PASSCODE_PIN_LINK" screen for iOS
    And user should verify "CONTINUE_NEW_PIN_BTN" Disabled for iOS
    Then user should not see the "BACK_BUTTON" for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.10_iOS
  Scenario: To verify the "Sign in step 3 of 4" screen validations
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user should see "Sign in step 3 of 4" from Signin Screen for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "ALBHABETS" pin for iOS
    And user should verify "CONTINUE_NEW_PIN_BTN" Disabled for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    Then user should see "CONTINUE_NEW_PIN_BTN" Enabled for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user should see "Sign in step 4 of 4" from Signin Screen for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.11_iOS
  Scenario: To verify the "Sign in step 4 of 4" screen details
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user should see "Sign in step 4 of 4" from Signin Screen for iOS
    And user should see "BACK_BUTTON" on the top left corner of the screen for iOS
    #	Then user validates below details in step four of sign in screen for Android
    #				|Confirm your PIN																																										 |
    #					|You’ll use this 6-digit PIN to log in to your OneCS account securely if you don’t enable Biometrics.|
    #		Then user verifies the "CREATE_YOUR_PIN_BOX"  is empty for Android
    #		Then user should verify "CONFIRM_PIN" button in step four of singin screen for Android
    And user closes "app" on mobile device

  @SignIn_iOS @2.12_iOS
  Scenario: To verify the "Sign in step 4 of 4" screen validations
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    #And user taps on "BACK_BUTTON" in step four of sign in screen for Android
    #Then user should see "Sign in step 3 of 4" from Signin Screen for Android
    And user should verify "CONTINUE_NEW_PIN_BTN" Disabled for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    #Then upon confirming user should see "Enable biometrics" and "Maybe later" options for Android
    And user closes "app" on mobile device

  @SignIn_iOS @2.13_iOS
  Scenario: To verify the "Sign in step 4 of 4" screen validations
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user should see "Sign in step 4 of 4" from Signin Screen for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "INCORRECT_SIX_DIGIT_PIN" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    #		Then user should see "INCORRECT_PIN" pop up in step four of sigin screen for Android
    #		Then user should validates "ERROR_MSG_STEP4" pop up in step four of sigin screen for Android
    #		Then user should see "EDIT_DETAILS_STEP4" button for Android
    And user closes "app" on mobile device

  @SignIn_iOS @2.16_iOS
  Scenario: To verify whether the user is able to skip the Fingerprint/Face ID authentication during Registration - Maybe later
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "INCORRECT_SIX_DIGIT_PIN" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    #		Then user should see "Secure Sign in" as header for Android
    #		Then upon confirming user should see "Enable biometrics" and "Maybe later" options for Android
    #		And user taps on "MAY_BE_LATER" option for Android
    #		Then user should see Dashboard screen
    And user closes "app" on mobile device

  @SignIn_iOS @2.22_iOS
  Scenario: More - Verify the Sign out process for the PIN, Fingerprint and Face ID logins
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "INCORRECT_SIX_DIGIT_PIN" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    When user Clicks on "MAYBE_LATER_BIOMETRICS_BTN" button for iOS
    #		And user Clicks on "More_Option" in Dashboard Screen for Android
    #		Then user should see "OneCS" as tittle in more options Screen for Android
    #		And user Signs Out the Mobile Application
    And user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.24_iOS
  Scenario: To verify the "Sign In" Screen for  the new user login using 6 - digit PIN
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user should see "Sign in step 3 of 4" from Signin Screen for iOS
    And user should verify "CONTINUE_NEW_PIN_BTN" Disabled for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    Then user should see "CONTINUE_NEW_PIN_BTN" Enabled for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    #		Then user validates below details in step four of sign in screen for Android
    #				|Confirm your PIN																																										 |
    #					|You’ll use this 6-digit PIN to log in to your OneCS account securely if you don’t enable Biometrics.|
    #
    And user should verify "CONFIRM_PIN_BTN" Disabled for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    #		Then user should see "SECURE_SIGN_IN" screen for Android
    #		Then upon confirming user should see "Enable biometrics" and "Maybe later" options for Android
    When user Clicks on "MAYBE_LATER_BIOMETRICS_BTN" button for iOS
    #		Then user should see Dashboard screen
    And user closes "app" on mobile device
