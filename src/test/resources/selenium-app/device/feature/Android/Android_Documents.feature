@td_OneCSAndroid_TD
Feature: DOCUMENTS

  @Documents_Android @9.02_Android
  Scenario: 9.02 - Verify the display of  documents having Longer names
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
		And user Clicks on "More_Option" in Dashboard Screen for Android
		And user Clicks on "Documents_Option" in More Screen for Android
		Then user verifies Name should be displayed in two separate multiple lines for Android
		And user closes "app" on mobile device	
		
		@Documents_Android @9.03_Android
  Scenario: 9.03 - Verify the display of  documents having Longer names
    Given user launch app "OneCS.apk" on "BrowserStack" mobile device
    And user Clicks on "SIGN_IN" button
    When user logins with "deepikadocument" and "Cupholder1" for Android
    When user Clicks on "Continue_Button"
  	And user enters the "TWO_FA" code in input box
  	When user clicks on Verify button
  	And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" for Android
		And user taps on "STEP3_CONTINUE_BUTTON" for Android
		And user enters "SIX_DIGIT" pin in "CREATE_YOUR_PIN_BOX" in step four for Android
		And user taps on "CONFIRM_PIN" button in step four of sigin screen for Android
		And user taps on "MAY_BE_LATER" option for Android
		And user Clicks on "More_Option" in Dashboard Screen for Android
		And user Clicks on "Documents_Option" in More Screen for Android
		And user Clicks on "Reports_Tab" in Documents Screen for Android
		When user Taps on any document listed under the tab for Android
		When user taps on "BACK_BUTTON" for Android
		Then user should be Navigated to "Documents_Screen" for Android
		Then user verifies "Report_Tab" is highlghted by default for Android
		And user closes "app" on mobile device
		
		@Documents_Android @9.04_Android
  Scenario: 9.04 - Verify the document details and  validations
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
		And user Clicks on "More_Option" in Dashboard Screen for Android
		And user Clicks on "Documents_Option" in More Screen for Android
		And user Clicks on "Reports_Tab" in Documents Screen for Android
		When user Taps on any document listed under the tab for Android
		Then user should see "DOCUMENT_NAME" as header in the middle with "BACK_BUTTON"n for Android
		Then user should see "SHARE_BUTTON" in the right corner for Android
		And user closes "app" on mobile device	
		
		@Documents_Android @9.05_Android
  Scenario: 9.05 - Verify sharing the documents
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
		And user Clicks on "More_Option" in Dashboard Screen for Android
		And user Clicks on "Documents_Option" in More Screen for Android
		And user Clicks on "Reports_Tab" in Documents Screen for Android
		When user Taps on any document listed under the tab for Android
		When user taps on "SHARE_BUTTON" in document for Android
		Then user should be navigated to the "Document_web_Url" for Android
		And user closes "app" on mobile device
		
		@Documents_Android @9.06_Android
  Scenario: 9.06 - Verify the validations on Search  tab
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
		And user Clicks on "More_Option" in Dashboard Screen for Android
		And user Clicks on "Documents_Option" in More Screen for Android
		
		And user closes "app" on mobile device
															