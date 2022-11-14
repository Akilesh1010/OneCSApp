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
    Then user should be Navigated to the "‎CS_SECURE_URL" website for iOS
    #And user clicks on Back Button for iOS
    And user should see "CS_WELCOME_LOGO" in welcome screen for iOS
    And user closes "app" on mobile device

  @SignIn_iOS @2.02_Android
  Scenario: To verify the details displayed on the "Sign In Registration" Screens
    Given user launch app "OneCSiOSApp" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN_BTN" button for iOS
    And user should see "Sign in step 1 of 4" from Signin Screen for iOS
    And user should see "IC_CLOSE_BTN" on the top left corner of the screen for iOS
    #And user should see progress bar as "Step1_of_4" in signin screen for iOS
    And user should be displayed with "USERNAME_PASSWORD_LABEL_TXT" in sigin screen for iOS
    And user should be displayed with "Please enter your username and password associated with your Charles Stanley account." in signin screen for iOS
    And user should see "Username" text inside the username box for iOS
    And user should see "Password"  text inside the Password box for iOS
    And user should see Eye icon inside the password box in iOS
    
    
    And user closes "app" on mobile device
