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
