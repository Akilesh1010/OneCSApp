@td_OneCSiOS_TD
Feature: Sign in / Login feature validation on iOS app

  @SignIn_iOS @2.01_iOS
  Scenario: 2.01 - verify the details displayed on the Sign In Welcome Screen
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    And user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    And user should see "CS_CREATE_A_SECURE" text in welcome screen for iOS
    Then user should see "SIGN_IN_BTN" in welcome screen for iOS
    And user should see "DON’T_HAVE_AN_ACCOUNT_LNK" text in welcome screen for iOS
    And user Clicks on "CREATE_ACCOUNT_ON_WEBSITE_LNK" button for iOS
    Then user should be Navigated to the "‎‎charles-stanley.co.uk, secure" website for iOS
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    And user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.02_iOS
  Scenario: 2.02 - To verify the details displayed on the "Sign In Registration" Screens
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    And user should see "Sign in step 1 of 4" from Signin Screen for iOS
    And user should see "IC_CLOSE_BTN" on the top left corner of the screen for iOS
    And user should be displayed with "USERNAME_PASSWORD_LABEL_TXT" in sigin screen for iOS
    And user should be displayed with "Please enter your username and password associated with your Charles Stanley account." in signin screen for iOS
    And user should see "Username" text inside the username box for iOS
    And user should see "Password" text inside the Password box for iOS
    Then user should see "EYE_PWD_SHOW_BTN" symbol inside password box for iOS
    Then user should see "INFO_IMAGE" encircled in pink in signin screen for iOS
    And user should see a link stating "I need help entering the correct details?" in signin screen for iOS
    And user should verify "CONTINUE_SIGN_IN_BTN" Disabled for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.03_iOS
  Scenario: 2.03 - To verify the Username/Password validation  on the "Registration" Screen
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
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
    And user Clicks on "EYE_PWD_SHOW_BTN" button for iOS
    Then user should see the entered password in password fiedls for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.05_iOS
  Scenario: 2.05 - Verify the "I need help in entering details" link
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
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
    Then user launch app "OneCSiOSApp" on "BrowserStack" mobile device
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
    Then user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user should see the entered username and password retained in sigin Screen for iOS
    And user Clicks on "I_NEED_HELP_ENTERING_CORRECT_DETAILS_LINK" button for iOS
    And user Clicks on "CANCEL_BTN" button for iOS
    Then user should not see the "FORGOT_SIGN_IN_DETAILS_LABEL_TXT" pop up in Signin Screen for iOS
    And user closes "app" on mobile device

  #2.06 and 2.06a have been covered togegther.
  @SignIn_iOS @2.06_iOS @2.06_a_iOS
  Scenario: 2.06 - Verify the sign in step 2 of 4 screen details & validations [2FA Screen]
    Then user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    When user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user should see "Sign in step 2 of 4" from Signin Screen for iOS
    And user should see "BACK_BUTTON" on the top left corner of the screen for iOS
    Then user should see "VERIFY_YOUR_ACCOUNT_TWO_FA_TXT" screen for iOS
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
    Then user launch app "OneCSiOSApp" on "BrowserStack" mobile device
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
    Then user should navigate back to sign in one screen and come back and verify that updated TWOFA code is presented in screen for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.07_iOS
  Scenario: 2.07 - To verify the Sign In process when Mobile number is linked to account 2FA
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
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
  Scenario: 2.09 - To verify the "Sign in step 3 of 4" screen details
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
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
  Scenario: 2.10 -  To verify the "Sign in step 3 of 4" screen validations
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
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
  Scenario: 2.11 - To verify the "Sign in step 4 of 4" screen details
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user should see "Sign in step 4 of 4" from Signin Screen for iOS
    And user should see "BACK_BUTTON" on the top left corner of the screen for iOS
    Then user should see "CONFIRM_PIN_LABEL_TXT_SIGN_IN_4" screen for iOS
    Then user should see "YOU_WILL_USE_THIS_PIN_TXT_IN_SIGN3_SCREEN" screen for iOS
    Then user should see "I_NEED_HELP_CONFIRMING_MY_PIN_LINK" screen for iOS
    And user should verify "CONFIRM_PIN_BTN" Disabled for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.12_iOS
  Scenario: 2.12 - To verify the "Sign in step 4 of 4" screen validations
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    When user Clicks on "BACK_BUTTON" button for iOS
    Then user should see "Sign in step 3 of 4" from Signin Screen for iOS
    And user should verify "CONTINUE_NEW_PIN_BTN" Disabled for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.13_iOS
  Scenario: 2.13 - To verify the "Sign in step 4 of 4" screen validations
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
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
    Then user should see "INCORRECT_PIN_POP_UP_LABEL_TXT" text in the pop up for iOS
    Then user should see "SORRY_PIN_DOES_NOT_MATCH_POP_UP_TXT" text in the pop up for iOS
    When user Clicks on "EDIT_DETAILS_BTN" button for iOS
    Then user should see "Sign in step 3 of 4" from Signin Screen for iOS
    And user should verify "CONTINUE_NEW_PIN_BTN" Disabled for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.16_iOS
  Scenario: 2.16 - To verify whether the user is able to skip the Fingerprint/Face ID authentication during Registration - Maybe later
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    Then user should see "Secure sign in" as header for iOS
    Then upon confirming user should see "Enable biometrics" and "Maybe later" options for iOS
    When user Clicks on "MAYBE_LATER_BIOMETRICS_BTN" button for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    When user Clicks on "MORE_TAB" button for iOS
    Then user should see "OneCS" as tittle in more options Screen for iOS
    And user Signs Out the Mobile Application for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.22_iOS
  Scenario: 2.22 - More - Verify the Sign out process for the PIN, Fingerprint and Face ID logins
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    When user Clicks on "MAYBE_LATER_BIOMETRICS_BTN" button for iOS
    Given user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    When user Clicks on "MORE_TAB" button for iOS
    Then user should see "OneCS" as tittle in more options Screen for iOS
    And user Signs Out the Mobile Application for iOS
    And user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.24_iOS
  Scenario: 2.24 - To verify the "Sign In" Screen for  the new user login using 6 - digit PIN
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
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
    And user should verify "CONFIRM_PIN_BTN" Disabled for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    Then user should see "Secure sign in" as header for iOS
    When user Clicks on "MAYBE_LATER_BIOMETRICS_BTN" button for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    When user Clicks on "MORE_TAB" button for iOS
    Then user should see "OneCS" as tittle in more options Screen for iOS
    And user Signs Out the Mobile Application for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.26_iOS
  Scenario: 2.26 - Verify the Sign In process validations when biometrics is turned off on the device
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user should see "Sign in step 3 of 4" from Signin Screen for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    Then user should see "Secure sign in" as header for iOS
    When user Clicks on "ENABLE_BIOMETRICS_BTN" button for iOS
    Then user should see "BIOMETRICS_DISABLED_LABEL_TXT" text in the pop up for iOS
    Then user should see "PLEASE_GO_TO_DEVICE_SETTINGS_BIO_TXT" text in the pop up for iOS
    When user Clicks on "BTN_OK_IN_POP_UP" button for iOS
    Then user should see "Secure sign in" as header for iOS
    When user Clicks on "MAYBE_LATER_BIOMETRICS_BTN" button for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    When user Clicks on "MORE_TAB" button for iOS
    Then user should see "OneCS" as tittle in more options Screen for iOS
    And user Signs Out the Mobile Application for iOS
    When user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.31_iOS
  Scenario: 2.31 - Verify the sign in screen - when PIN & Biometric is disabled
    Given user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user Clicks on "SIGN_IN_BTN" button for iOS
    When user enters "Correct_Username" and "Correct_Password" for iOS
    Then user Clicks on "CONTINUE_SIGN_IN_BTN" button for iOS
    And user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS
    When user Clicks on "VERIFY_BTN" button for iOS
    Then user should see "Sign in step 3 of 4" from Signin Screen for iOS
    Then user enters value in "SIGN_IN_NEW_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONTINUE_NEW_PIN_BTN" button for iOS
    Then user enters value in "CONFIRM_PIN_INPUT" field with "SIX_DIGIT" pin for iOS
    When user Clicks on "CONFIRM_PIN_BTN" button for iOS
    Then user should see "Secure sign in" as header for iOS
    When user Clicks on "ENABLE_BIOMETRICS_BTN" button for iOS
    Then user should see "BIOMETRICS_DISABLED_LABEL_TXT" text in the pop up for iOS
    Then user should see "PLEASE_GO_TO_DEVICE_SETTINGS_BIO_TXT" text in the pop up for iOS
    When user Clicks on "BTN_OK_IN_POP_UP" button for iOS
    Then user should see "Secure sign in" as header for iOS
    When user Clicks on "MAYBE_LATER_BIOMETRICS_BTN" button for iOS
    Then user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS
    When user Clicks on "MORE_TAB" button for iOS
    Then user should see "OneCS" as tittle in more options Screen for iOS
    And user Signs Out the Mobile Application for iOS
    When user launch app "OneCSiOSApp" on "BrowserStack" mobile device
    Then user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    And user closes "app" on mobile device
