package qa.oneCSiOS.stepDefs;

import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.framework.assertions.AssertLogger;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.device.DeviceDriverManager;
import qa.framework.utils.Reporter;
import qa.oneCSAndroid.pages.OneCS_Mobile;
import qa.oneCSiOS.pages.DashboardScreeniOS;
import qa.oneCSiOS.pages.SignInScreeniOS;

public class IOSSignInStepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));
	SignInScreeniOS iOSSignInScreen = new SignInScreeniOS();
	DashboardScreeniOS dashboardScreeniOS = new DashboardScreeniOS();
	SoftAssert softAssert = new SoftAssert();
	WebDriverWait wait = new WebDriverWait(DeviceDriverManager.getDriver(),20);


	@Given("user Clicks on {string} button for iOS")
	public void user_Clicks_on_button(String btnName) throws InterruptedException {
		//		Thread.sleep(2000);
		iOSSignInScreen.btnClickiOS(btnName);
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@When("user enters {string} and {string} for iOS")
	public void user_enters_and(String userName, String pwd) {
		iOSSignInScreen.userLoginiOS(userName, pwd);  
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Then("user should see Sign in error message for iOS")
	public void user_should_see_Sign_in_error_message() {
		//		String actual = DeviceActions.getText((MobileElement) action.getElement("PLEASE_CHECK_THE_DETAILS_ENTERED_TXT"));
		//		String expected = DeviceActions.getTestData("IOS_INVALID_SIGN_IN_ERROR_MSG");
		//		AssertLogger.assertEquals(expected, actual, "iOS Error message do not match");
		boolean flag = iOSSignInScreen.errorMsgPopDetailsiOS();
		Assert.assertTrue(flag, "Error... The Incorrect details pop up fields not displayed");
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Then("user should see {string} screen for iOS")
	public void user_should_see_screen_for_iOS(String twoFA) throws InterruptedException {
		//		Thread.sleep(3000);
		Assert.assertTrue(action.isDisplayed((MobileElement) action.getElement(twoFA)));
		Reporter.addDeviceScreenshot("2FA Screen", "Mobile App Login Screen");		
	}

	@Then("user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS")
	public void user_get_the_SIX_digit_code_displayed_on_screen_and_enters_in_TWOFA_input_field_for_iOS() throws InterruptedException {
//		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("VERIFY_ACCOUNT_TEXT")));
		while (iOSSignInScreen.getTextiOS("SIGN_IN_CODE_2FA_TXT") == "code loading") {
//			System.out.println(iOSSignInScreen.getTextiOS("CODE_TO_TYPE"));	
			continue;
		}
		iOSSignInScreen.input2FA();  
	}

	@Then("user enters value in {string} field with {string} pin for iOS")
	public void user_enters_value_in_field_with_pin_for_iOS(String fieldName, String value) throws InterruptedException {
		//		Thread.sleep(3000);
		iOSSignInScreen.inputFieldiOS(fieldName, value);
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");

	}

	@Then("user sign in with valid username {string} and password {string} for iOS")
	public void user_sign_in_with_valid_username_and_password(String userName, String pwd) {
		iOSSignInScreen.signIniOS(userName, pwd);
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Then("user should see {string} in welcome screen for iOS")
	public void user_should_see_in_welcome_screen_for_iOS(String txtOrBtnOrLink) {
		Assert.assertTrue(action.isPresent(txtOrBtnOrLink));
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}


	@Given("user should see {string} text in welcome screen for iOS")
	public void user_should_see_text_in_welcome_screen_for_iOS(String text) {
		if(text.equalsIgnoreCase("CS_CREATE_A_SECURE")) {
			Assert.assertEquals(iOSSignInScreen.getTextiOS("CS_WELCOME_LOGO"),DeviceActions.getTestData(text));
		}
		else {
			Assert.assertEquals(iOSSignInScreen.getTextiOS("CREATE_ACCOUNT_ON_WEBSITE_LNK"), DeviceActions.getTestData(text));
		}
	}

	@Then("user should be Navigated to the {string} website for iOS")
	public void user_should_be_Navigated_to_the_website_for_iOS(String url) {
		//		Assert.assertEquals(iOSSignInScreen.getTextiOS("BROWSER_URL"), DeviceActions.getTestData("CS_SECURE_URL"));
		String text = iOSSignInScreen.getTextiOS("BROWSER_URL");
		
		softAssert.assertEquals(url, iOSSignInScreen.getTextiOS("BROWSER_URL"));

		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Given("user should see {string} from Signin Screen for iOS")
	public void user_should_see_from_Signin_Screen_for_iOS(String step1TitleTxt) {
		if(step1TitleTxt.equalsIgnoreCase("Sign in step 1 of 4")) {
			Assert.assertEquals(iOSSignInScreen.getTextiOS("SIGN_IN_STEP_1_OF_4_TITLE"),step1TitleTxt);	
		}
		else if(step1TitleTxt.equalsIgnoreCase("Sign in step 2 of 4")) {
			Assert.assertEquals(iOSSignInScreen.getTextiOS("SIGN_IN_STEP_2_OF_4_TITLE"),step1TitleTxt);	
		}
		else if(step1TitleTxt.equalsIgnoreCase("Sign in step 3 of 4")) {
			Assert.assertEquals(iOSSignInScreen.getTextiOS("SIGN_IN_STEP_3_OF_4_TITLE"),step1TitleTxt);	
		}
		else if(step1TitleTxt.equalsIgnoreCase("Sign in step 4 of 4")) {
			Assert.assertEquals(iOSSignInScreen.getTextiOS("SIGN_IN_STEP_4_OF_4_TITLE"),step1TitleTxt);	
		}

		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Given("user should see {string} on the top left corner of the screen for iOS")
	public void user_should_see_on_the_top_left_corner_of_the_screen_for_iOS(String btn) {
		Assert.assertTrue(action.isPresent(btn));
	}

	@Given("user should see progress bar as {string} in signin screen for iOS")
	public void user_should_see_progress_bar_as_in_signin_screen_for_iOS(String string) {

	}

	@Given("user should be displayed with {string} in sigin screen for iOS")
	public void user_should_be_displayed_with_in_sigin_screen_for_iOS(String userNameAndPwdLabel) {
		Assert.assertTrue(action.isPresent(userNameAndPwdLabel));
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");

	}

	@Given("user should be displayed with {string} in signin screen for iOS")
	public void user_should_be_displayed_with_in_signin_screen_for_iOS(String labelTxt) {
		Assert.assertEquals(iOSSignInScreen.getTextiOS("PLEASE_ENTER_UN_PWD_LABEL_TXT"),labelTxt);	
	}

	@Given("user should see {string} text inside the username box for iOS")
	public void user_should_see_text_inside_the_username_box_for_iOS(String editFieldTxt) {
		Assert.assertEquals(iOSSignInScreen.getTextiOS("USERNAME_EDIT"),editFieldTxt);
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Given("user should see {string} text inside the Password box for iOS")
	public void user_should_see_text_inside_the_Password_box_for_iOS(String editFieldTxt) {
		Assert.assertEquals(iOSSignInScreen.getTextiOS("PWD_EDIT"),editFieldTxt);
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Then("user should see {string} symbol inside password box for iOS")
	public void user_should_see_symbol_inside_password_box_for_iOS(String eyeHide) {
		Assert.assertTrue(action.isPresent(eyeHide));
	}

	@Then("user should see {string} encircled in pink in signin screen for iOS")
	public void user_should_see_encircled_in_pink_in_signin_screen_for_iOS(String infoImage) {
		Assert.assertTrue(action.isPresent(infoImage));
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Then("user should see a link stating {string} in signin screen for iOS")
	public void user_should_see_a_link_stating_in_signin_screen_for_iOS(String helpTxt) {
		Assert.assertEquals(iOSSignInScreen.getTextiOS("I_NEED_HELP_ENTERING_CORRECT_DETAILS_LINK"),helpTxt);
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Then("user should verify {string} Disabled for iOS")
	public void user_should_verify_Disabled_for_iOS(String btnName) {
		Assert.assertEquals(iOSSignInScreen.buttonDisablediOS(btnName), "false");
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Given("user enters {string} in username field for iOS")
	public void user_enters_in_username_field_for_iOS(String userName) {
		iOSSignInScreen.inputFieldiOS("USERNAME_EDIT",userName);
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Given("user removes username and enters {string} in password field for iOS")
	public void user_removes_username_and_enters_in_password_field_for_iOS(String pwd) {
		DeviceActions.clear((MobileElement) action.getElement("USERNAME_EDIT"));
		iOSSignInScreen.inputFieldiOS("PWD_EDIT",pwd);
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");   
	}

	@Given("user clicks on {string} in signin Screen for iOS")
	public void user_clicks_on_in_signin_Screen_for_iOS(String btnName) {
		iOSSignInScreen.btnClickiOS(btnName);
	}

	@Then("user should not see {string} overlay popup for iOS")
	public void user_should_not_see_overlay_popup_for_iOS(String label) {
		Assert.assertFalse(action.isPresent(label));
		
	}

	@Then("user should see {string} Enabled for iOS")
	public void user_should_see_Enabled_for_iOS(String btnName) {
		Assert.assertEquals(iOSSignInScreen.buttonDisablediOS(btnName), "true");
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Then("user clears the entered Username and Password from the fields for iOS")
	public void user_clears_the_entered_Username_and_Password_from_the_fields_for_iOS() {
		DeviceActions.clear((MobileElement) action.getElement("USERNAME_EDIT"));
		DeviceActions.clear((MobileElement) action.getElement("PWD_EDIT"));  
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Then("user should see the entered password in password fiedls for iOS")
	public void user_should_see_the_entered_password_in_password_fiedls_for_iOS() {
		Assert.assertEquals(iOSSignInScreen.getTextiOS("PWD_EDIT"),
				DeviceActions.getTestData("Correct_Password"));
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Then("user should be displayed with secure sign in page for iOS")
	public void user_should_be_displayed_with_secure_sign_in_page_for_iOS() {	
		boolean flag = iOSSignInScreen.secureSignInScreenFieldsDisplayiOS();
		Assert.assertTrue(flag, "Error...Secure sign in screen fields not displayed.");
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Then("user should verity the fields and labels of Forgot Sign in details section for iOS")
	public void user_should_verity_the_fields_and_labels_of_Forgot_Sign_in_details_section_for_iOS() {
		boolean flag = iOSSignInScreen.forgotSignInDetailsDisplayiOS();
		Assert.assertTrue(flag, "Error... Forgot Sign in details fields not displayed.");
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Then("user should not see the {string} pop up in Signin Screen for iOS")
	public void user_should_not_see_the_pop_up_in_Signin_Screen_for_iOS(String popup) throws InterruptedException {
		//		wait.until(ExpectedConditions.invisibilityOf((MobileElement) action.getElement("FORGOT_SIGN_IN_DETAILS_LABEL_TXT")));
		Thread.sleep(2000);
		Assert.assertFalse(action.isPresent(popup));
	}

	@Then("user should see the entered username and password retained in sigin Screen for iOS")
	public void user_should_see_the_entered_username_and_password_retained_in_sigin_Screen_for_iOS() {
		iOSSignInScreen.btnClickiOS("EYE_PWD_HIDE_BTN");

		Assert.assertEquals(iOSSignInScreen.getTextiOS("USERNAME_EDIT"),
				DeviceActions.getTestData("Correct_Username"));

		Assert.assertEquals(iOSSignInScreen.getTextiOS("PWD_EDIT"),
				DeviceActions.getTestData("Correct_Password"));
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile");
	}

	@Then("user verifies below fields in forgot username website for iOS")
	public void user_verifies_below_fields_in_forgot_username_website_for_iOS(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = iOSSignInScreen.getForgotUserWebScreeniOS();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile");

	}

	@Then("user verifies below fields in forgot password website for iOS")
	public void user_verifies_below_fields_in_forgot_password_website_for_iOS(DataTable dataTable) {
		iOSSignInScreen.btnClickiOS("FORGOTTEN_PWD_TXT_IN_WEBSITE");
		List<String> data = dataTable.asList();
		List<String> pageValues = iOSSignInScreen.getForgotPasswordWebScreeniOS();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile");
	}

	@Then("user should see a link stating {string} in step two of sigin screen for iOS")
	public void user_should_see_a_link_stating_in_step_two_of_sigin_screen_for_iOS(String accountHelp) {
		Assert.assertEquals(iOSSignInScreen.getTextiOS("I_NEED_HELP_VERIFYING_ACCOUNT_LINK"), accountHelp);
	}

	@Then("user enters {string} code in six digit code box for iOS")
	public void user_enters_code_in_six_digit_code_box_for_iOS(String code) {
		DeviceActions.sendKeys((MobileElement) action.getElement("SIGN_IN_2FA_CODE_INPUT_FIELD"), DeviceActions.getTestData(code));
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile");  
	}

	@When("user enters incorrect TWOFA code in input box for iOS")
	public void user_enters_incorrect_TWOFA_code_in_input_box_for_iOS() {
		iOSSignInScreen.inputIncorrect2FAiOS();
	}

	@Then("user should see {string} text in the pop up for iOS")
	public void user_should_see_alert_pop_up_for_iOS(String popAlrert) {
		Assert.assertTrue(action.isDisplayed((MobileElement) action.getElement(popAlrert)));
		Reporter.addDeviceScreenshot("2FA Screen", "Mobile App Login Screen");

	}

	@Then("user should see below details in TwoFA Screen for iOS")
	public void user_should_see_below_details_in_TwoFA_Screen_for_iOS(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = iOSSignInScreen.getVerifyAccountCodePopDetailsiOS();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile");
	}

	@Then("user validates below fields in web url opened for iOS")
	public void user_validates_below_fields_in_web_url_opened_for_iOS(DataTable dataTable) {
		iOSSignInScreen.btnClickiOS("LOGIN_TXT_IN_WEB");
		List<String> data = dataTable.asList();
		List<String> pageValues = iOSSignInScreen.loginPageWebiOS();
		AssertLogger.assertEquals(pageValues, data, "Error..... Web page - login screen details does not match");
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile");
	}

	@Then("user enters {string} and {string} in web url opened for iOS")
	public void user_enters_and_in_web_url_opened_for_iOS(String userName, String pwd) {
		DeviceActions.sendKeys((MobileElement) action.getElement("USERNAME_WEB_FIELD"), DeviceActions.getTestData(userName));
		DeviceActions.sendKeys((MobileElement) action.getElement("PASSWORD_WEB_FIELD"), DeviceActions.getTestData(pwd));

	}

	@Then("user should be able to view the memorable Word field in the web for iOS")
	public void user_should_be_able_to_view_the_memorable_Word_field_in_the_web_for_iOS() {
		Assert.assertTrue(action.isDisplayed((MobileElement) action.getElement("MEMERABLE_WORD_WEB_TXT")));
		Reporter.addDeviceScreenshot("2FA Screen", "Mobile App Login Screen");
	}

	//	@Then("user should see six blank text boxes for iOS")
	//	public void user_should_see_six_blank_text_boxes_for_iOS() {
	//		String empty = DeviceActions.getText((MobileElement) action.getElement("SIGN_IN_NEW_PIN_INPUT"));
	//		Assert.assertEquals(empty, "");
	//	}

	@Then("user should not see the {string} for iOS")
	public void user_should_not_see_the_for_iOS(String btnName) {
		Assert.assertFalse(action.isPresent(btnName));
		Reporter.addDeviceScreenshot("2FA Screen", "Mobile App Login Screen");
	}

	@Then("upon confirming user should see {string} and {string} options for iOS")
	public void upon_confirming_user_should_see_and_options_for_iOS(String bio, String later) {
		Assert.assertEquals(iOSSignInScreen.getTextiOS("ENABLE_BIOMETRICS_BTN"),bio);
		Assert.assertEquals(iOSSignInScreen.getTextiOS("MAYBE_LATER_BIOMETRICS_BTN"),later);
	}

	@Then("user should see {string} as header for iOS")
	public void user_should_see_as_header_for_iOS(String headerTitle) {
		Assert.assertEquals(headerTitle, iOSSignInScreen.getTextiOS("SECURE_SIGN_IN_LABEL_TXT_IN_BIOMETRICS"));
		Reporter.addDeviceScreenshot("2FA Screen", "Mobile App Login Screen");
	}

	@Then("user should navigate back to sign in one screen and come back and verify that updated TWOFA code is presented in screen for iOS")
	public void user_should_navigate_back_to_sign_in_one_screen_and_come_back_and_verify_that_updated_TWOFA_code_is_presented_in_screen_for_iOS() {
		String codeOld = DeviceActions.getText((MobileElement) action.getElement("SIGN_IN_CODE_2FA_TXT"));
		DeviceActions.click((MobileElement) action.getElement("BACK_BUTTON"));
		Assert.assertTrue(action.isPresent("SIGN_IN_STEP_1_OF_4_TITLE"));
		DeviceActions.click((MobileElement) action.getElement("CONTINUE_SIGN_IN_BTN"));
		String codeNew = DeviceActions.getText((MobileElement) action.getElement("SIGN_IN_CODE_2FA_TXT"));
		Assert.assertNotEquals(codeNew, codeOld, "Error...Old code still retained.");

	}
	
	@When("user logins with {string} and {string} for iOS")
	public void user_logins_with_and_for_iOS(String userName, String pwd) {
		DeviceActions.sendKeys((MobileElement) action.getElement("USERNAME_EDIT"), userName );
		DeviceActions.sendKeys((MobileElement) action.getElement("PWD_EDIT"), pwd);	
	}








}
