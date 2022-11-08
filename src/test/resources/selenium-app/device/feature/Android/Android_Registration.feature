@td_OneCSAndroid_TD
Feature: Device automation POC for Virtual Device

  @AndroidPOC1 @POC1
  Scenario: Verification of user login functionality with Incorrect Password
    Given user launch app "universal.apk" on "RealDevice" mobile device
    And user Clicks on "SIGN_IN" button
    When user enters "Incorrect_Username" and "Incorrect_Password"
    When user Clicks on "Continue_Button"
    Then user should see "Error_Msg"
    And user closes "app" on mobile device

  @AndroidPOC1 @POC2
  Scenario: Verification of user login functionality with Correct Username and Correct Password
    Given user launch app "OneCS.apk" on mobile device
    And user Clicks on "SIGN_IN" button
    When user enters "Correct_Username" and "Correct_Password"
    When user Clicks on "Continue_Button"
    Then user should see "TWO_FA" screen
    And user closes "app" on mobile device
    
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
    
