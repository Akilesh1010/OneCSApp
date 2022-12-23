package qa.oneCSAndroid.stepdefs;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.api.PendingException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.jfr.Percentage;
import qa.framework.assertions.AssertLogger;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.AndroidAppDriver;
import qa.framework.device.DeviceActions;
import qa.framework.device.DeviceDriverManager;
import qa.framework.utils.Reporter;
import qa.oneCSAndroid.pages.OneCS_Mobile;

public class OneCS_Mobile_StepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppAndroid_Android"));
	OneCS_Mobile OneCS = new OneCS_Mobile();
	SoftAssert softAssert = new SoftAssert();
	WebDriverWait wait = new WebDriverWait(DeviceDriverManager.getDriver(), 30);
	WebDriver driver = DeviceDriverManager.getDriver();

	@Given("user should see {string} logo in welcome screen for Android")
	public void user_should_see_logo_in_welcome_screen_for_Android(String Logo) {
		Assert.assertTrue(action.isPresent(Logo));
	}

	@Given("user should see {string} text in welcome screen for Android")
	public void user_should_see_text_in_welcome_screen_for_Android(String text) {

		Assert.assertEquals(DeviceActions.getTestData("CREATE_SECURE"), OneCS_Mobile.getDispalyText());

	}

	@Then("user verifies {string} button in welcome screen for Android")
	public void user_verifies_button_in_welcome_screen_for_Android(String signin) {
		Assert.assertTrue(action.isPresent(signin));
	}

	@Then("user should see {string} text on welcome screen for Android")
	public void user_should_see_text_on_welcome_screen_for_Android(String text) {
		Assert.assertEquals(text, OneCS.androidGetText("DON’T_HAVE_ACCOUNT"));

	}

	@Then("user should verify {string} text in welcome screen for Android")
	public void user_should_verify_text_in_welcome_screen_for_Android(String string) {

		Assert.assertEquals(DeviceActions.getTestData("CREATE_ONE_ON_OUR_WEBSITE"),
				OneCS.androidGetText("CREATE_ONE_ON_OUR_WEBSITE"));

	}

	@When("user taps on {string} link on Android")
	public void user_taps_on_link_on_Android(String website) {
		OneCS_Mobile.clickOnButton(website);
	}

	@Then("user should be Navigated to the {string} website for Android")
	public void user_should_be_Navigated_to_the_website_for_Android(String URL) {
		softAssert.assertEquals(URL, OneCS.androidGetText("DEVICE_URL"));
	}

	@Then("user clicks on Back Button for Android")
	public void user_clicks_on_Back_Button_for_Android() {
		DeviceDriverManager.getDriver().navigate().back();
	}

	@Then("user should be Navigated again to {string} for Android")
	public void user_should_be_Navigated_again_to_for_Android(String welcome) {

		Assert.assertTrue(action.isPresent(welcome));
	}

	@Given("user should see {string} from Signin Screen for Android")
	public void user_should_see_from_Signin_Screen_for_Android(String step) throws InterruptedException {
		wait.until(ExpectedConditions.textToBePresentInElement((MobileElement) action.getElement("SIGN_IN_STEP_1_OF_4"),
				step));
		Assert.assertEquals(step, OneCS.androidGetText("SIGN_IN_STEP_1_OF_4"));

	}

	@Given("user should see {string} from Sign-in Screen for Android")
	public void user_should_see_from_Sign_in_Screen_for_Android(String step) {
		wait.until(ExpectedConditions.textToBePresentInElement((MobileElement) action.getElement("USERNAME_PASSWORD"),
				"Username & password"));
		Assert.assertEquals(step, OneCS.androidGetText("SIGN_IN_STEP_1_OF_4"));
	}

	@Then("user enters the {string} code in input box")
	public void user_enters_the_code_in_input_box(String otp) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("VERIFY_ACCOUNT_TEXT")));
		String text = OneCS.androidGetText("CODE_TO_TYPE");

		if (!text.matches(".*[0-9].*")) {
			Thread.sleep(10000);
		}
		String codetext = DeviceActions.getText((MobileElement) action.getElement("CODE_TO_TYPE"));
		DeviceActions.sendKeys((MobileElement) action.getElement("SIX_DIGIT_INPUT_BOX"), codetext);

	}

	@And("user should see {string} on the top left corner of the screen for Android")
	public void user_should_see_on_the_top_left_corner_of_the_screen_for_Android(String X) {
		Assert.assertTrue(action.isPresent(X));
	}

	@And("user should see progress bar as {string} in signin screen for Android")
	public void user_should_see_progress_bar_as_in_signin_screen_for_Android(String step1) {
		Assert.assertEquals(DeviceActions.getTestData(step1), OneCS.androidGetText(step1));
	}

	@And("user should verify whether {string} is present in sigin screen for Android")
	public void user_should_verify_whether_is_present_in_sigin_screen_for_Android(String Userpass) {

		Assert.assertEquals(Userpass, OneCS.androidGetText("USERNAME_PASSWORD"));
	}

	@And("user should be able to see {string} on signin Screen For Android")
	public void user_should_be_able_to_see_on_signin_Screen_For_Android(String MSG) {
		Assert.assertEquals(MSG, OneCS.androidGetText("PLEASE_ENTER_USERNAME"));
	}

	@And("user should see {string} text inside the username box")
	public void user_should_see_text_inside_the_username_box(String user) {
		Assert.assertEquals(user, OneCS.androidGetText("USERNAME_TEXT"));
	}

	@And("user should see {string}  text inside the Password box")
	public void user_should_see_text_inside_the_Password_box(String pass) {
		Assert.assertEquals(pass, OneCS.androidGetText("PASSWORD_TEXT"));
	}

	@And("user verifies username and password field is empty")
	public void user_verifies_username_and_password_field_is_empty() {
		OneCS.usernameFieldEmpty();
	}

	@Then("user should see {string} symbol inside password box")
	public void user_should_see_symbol_inside_password_box(String eye) {
		Assert.assertTrue(action.isPresent(eye));
	}

	@Then("user should see {string} encircled in pink in signin screen")
	public void user_should_see_encircled_in_pink_in_signin_screen(String info) {
		Assert.assertTrue(action.isPresent(info));
	}

	@Then("user should see a link stating {string} in signin screen")
	public void user_should_see_a_link_stating_in_signin_screen(String help) {
		Assert.assertEquals(OneCS.androidGetText("I_need_help_in_entering_details"), help);
	}

	@Given("user enters {string} in username field")
	public void user_enters_in_username_field(String Username) {
		OneCS.AndroidInputText("USERNAME_INPUT_FIELD", Username);
	}

	@Given("user should verify continue button Disabled")
	public void user_should_verify_continue_button_Disabled() {
		OneCS.androidButtonDisabled("Continue_Button");
	}

	@Given("user removes username and enters {string} in password field")
	public void user_removes_username_and_enters_in_password_field(String password) {
		OneCS.androidFieldClear("USERNAME_INPUT_FIELD");
		OneCS.AndroidInputText("PASSWORD_INPUT_FIELD", password);
	}

	@Then("user should see {string} pop up for Android")
	public void user_should_see_pop_up_for_Android(String details) {

		Assert.assertEquals(OneCS.androidGetText(details), DeviceActions.getTestData("DETAILS_INCORRECT"));
	}

	@Then("user should see {string} in pop up for Android")
	public void user_should_see_in_pop_up_for_Android(String errorMsg) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("DETAILS_INCORRECT")));
		Assert.assertEquals(OneCS.androidGetText(errorMsg), DeviceActions.getTestData("ERROR_MSG"));
	}

	@Then("user taps on {string} button in error message for Android")
	public void user_taps_on_button_in_error_message_for_Android(String editFields) {
		OneCS.AndroidBtnClick(editFields);
	}

	@Then("user should not see {string} overlay popup for Android")
	public void user_should_not_see_overlay_popup_for_Android(String editFields) {
		Assert.assertFalse(action.isPresent(editFields));
	}

	@Then("user should see {string} Enabled for Android")
	public void user_should_see_Enabled_for_Android(String enabled) {
		OneCS.androidButtonEnabled(enabled);
	}

	@Then("user taps on {string} in signin Screen for Android")
	public void user_taps_on_in_signin_Screen_for_Android(String close) {
		OneCS.AndroidBtnClick(close);
	}

	@Then("user clears the entered Username and Password from the fields for Android")
	public void user_clears_the_entered_Username_and_Password_from_the_fields_for_Android() {
		OneCS.androidFieldClear("USERNAME_INPUT_FIELD");
		OneCS.androidFieldClear("PASSWORD_INPUT_FIELD");
	}

	@Then("user enteres a letter {string} in username fields for Android")
	public void user_enteres_a_letter_in_username_fields_for_Android(String letter) {
		OneCS.AndroidInputText("USERNAME_INPUT_FIELD", letter);
	}

	@Then("user enteres a letter {string} in password fields for Android")
	public void user_enteres_a_letter_in_password_fields_for_Android(String letter) {
		OneCS.AndroidInputText("PASSWORD_INPUT_FIELD", letter);
	}

	@Then("user enters {string} in password field and taps on {string} for Android")
	public void user_enters_in_password_field_and_taps_on_for_Android(String pass, String eyeIcon) {
		OneCS.AndroidInputText("PASSWORD_INPUT_FIELD", pass);
		OneCS.AndroidBtnClick(eyeIcon);

	}

	@Then("user should see the entered password in password fiedls for Android")
	public void user_should_see_the_entered_password_in_password_fiedls_for_Android() {
		Assert.assertEquals(OneCS.androidGetText("PASSWORD_INPUT_FIELD"),
				DeviceActions.getTestData("Correct_Password"));
	}

	@Then("user should see {string} enabled")
	public void user_should_see_enabled(String continueButton) {
		OneCS.androidButtonEnabled(continueButton);
	}

	@Then("user should see the continue button turning to {string} for Android")
	public void user_should_see_the_continue_button_turning_to_for_Android(String spinner) throws InterruptedException {
		Assert.assertTrue(action.isPresent(spinner));
		// wait.until(ExpectedConditions.invisibilityOf((MobileElement)
		// action.getElement("Loading_Spinner")));

	}

	@Then("user should see the entered username and password retained in sigin Screen for Android")
	public void user_should_see_the_entered_username_and_password_retained_in_sigin_Screen_for_Android()
			throws InterruptedException {

		Assert.assertEquals(OneCS.androidGetText("USERNAME_INPUT_FIELD"),
				DeviceActions.getTestData("Correct_Username"));
		OneCS.AndroidBtnClick("Eye_Icon");
		Thread.sleep(2000);
		Assert.assertEquals(OneCS.androidGetText("PASSWORD_INPUT_FIELD"),
				DeviceActions.getTestData("Correct_Password"));
	}

	@And("user Clicks on {string} button")
	public void user_Clicks_on_button(String button) {
		DeviceActions.click((MobileElement) action.getElement(button));
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String password) throws InterruptedException {
		OneCS.AndroidInputText("USERNAME_INPUT_FIELD", username);
		OneCS.AndroidInputText("PASSWORD_INPUT_FIELD", password);
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@When("user logins with {string} and {string} for Android")
	public void user_logins_with_and_for_Android(String user, String pass) {
		OneCS.AndroidInputUserPass("USERNAME_INPUT_FIELD", user);
		OneCS.AndroidInputUserPass("PASSWORD_INPUT_FIELD", pass);
	}

	@When("user Clicks on {string}")
	public void user_Clicks_on(String button) throws InterruptedException {

		OneCS.AndroidBtnClick(button);
	}

	@Then("user should see {string} screen")
	public void user_should_see_screen(String twofa) {
		Assert.assertTrue(action.isPresent(twofa));
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");
	}

	@Then("user should see {string}")
	public void user_should_see(String Error) {
		String ErrorMsg = DeviceActions.getText((MobileElement) action.getElement(Error));
		Assert.assertEquals(DeviceActions.getTestData("Error_Msg"), ErrorMsg);
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");
	}

	@And("user taps on {string} in Signin screen for Android")
	public void user_taps_on_in_Signin_screen_for_Android(String help) {
		OneCS.AndroidBtnClick(help);
	}

	@Then("user should verify below details in signin Screen for Android")
	public void user_should_verify_below_details_in_signin_Screen_for_Android(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getNeedHelpPopupScreen();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("user should see {string} on the top right corner of the screen for Android")
	public void user_should_see_on_the_top_right_corner_of_the_screen_for_Android(String x) {
		Assert.assertTrue(action.isPresent(x));
	}

	@Then("user taps on anywhere on the {string} for Android")
	public void user_taps_on_anywhere_on_the_for_Android(String empty) throws InterruptedException {

		OneCS.AndroidBtnClick(empty);
		Thread.sleep(2000);
	}

	@Then("user should not see the {string} pop up in Signin Screen for Android")
	public void user_should_not_see_the_pop_up_in_Signin_Screen_for_Android(String popup) {
		Assert.assertFalse(action.isPresent(popup));
	}

	@When("user taps {string} on signin screen for Android")
	public void user_taps_on_signin_screen_for_Android(String userpass) {
		OneCS.AndroidBtnClick(userpass);
	}

	@Then("user verifies below fields in forgot username website for Android")
	public void user_verifies_below_fields_in_forgot_username_website_for_Android(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getForgotUserWebScreen();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("user taps on {string} on Forgot usrname popup for Android")
	public void user_taps_on_on_Forgot_usrname_popup_for_Android(String close) {
		wait.until(ExpectedConditions.textToBePresentInElement((MobileElement) action.getElement("RECOVER_DETAILS"),
				"Recover details"));
		OneCS.AndroidBtnClick(close);
	}

	@Then("user should see the entered username and password retained in Login Screen for Android")
	public void user_should_see_the_entered_username_and_password_retained_in_Login_Screen_for_Android()
			throws InterruptedException {
		Assert.assertEquals(OneCS.androidGetText("USERNAME_INPUT_FIELD"),
				DeviceActions.getTestData("Correct_Username"));

		Assert.assertEquals(OneCS.androidGetText("PASSWORD_INPUT_FIELD"),
				DeviceActions.getTestData("Correct_Password"));
	}

	@Then("user should be navigated back to the {string} screen for Android")
	public void user_should_be_navigated_back_to_the_screen_for_Android(String signin) {
		Assert.assertTrue(action.isPresent(signin));
	}

	@Then("user verifies below fields in forgot password website for Android")
	public void user_verifies_below_fields_in_forgot_password_website_for_Android(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getForgotPassWebScreen();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("user should see {string} text in step two of sigin screen for Android")
	public void user_should_see_text_in_step_two_of_sigin_screen_for_Android(String verifyAccount) {
		Assert.assertEquals(OneCS.androidGetText("VERIFY_ACCOUNT_TEXT"), verifyAccount);
	}

	@Then("user should see a link stating {string} in step two of sigin screen for Android")
	public void user_should_see_a_link_stating_in_step_two_of_sigin_screen_for_Android(String accountHelp) {
		Assert.assertEquals(OneCS.androidGetText("HELP_VERIFY_ACCOUNT"), accountHelp);
	}

	@Then("user enters {string} code in six digit code box for Android")
	public void user_enters_code_in_six_digit_code_box_for_Android(String digit) {
		System.out.println(DeviceActions.getTestData(digit));
		if (digit.equalsIgnoreCase("ONE_DIGIT")) {
			OneCS.AndroidInputText("SIX_DIGIT_INPUT_BOX", digit);
		}
		if (digit.equalsIgnoreCase("TWO_DIGIT")) {
			OneCS.AndroidInputText("SIX_DIGIT_INPUT_BOX", digit);
		}
		if (digit.equalsIgnoreCase("THREE_DIGIT")) {
			OneCS.AndroidInputText("SIX_DIGIT_INPUT_BOX", digit);
		}
		if (digit.equalsIgnoreCase("FOUR_DIGIT")) {
			OneCS.AndroidInputText("SIX_DIGIT_INPUT_BOX", digit);
		}
		if (digit.equalsIgnoreCase("FIVE_DIGIT")) {
			OneCS.AndroidInputText("SIX_DIGIT_INPUT_BOX", digit);
		}

	}

	@Then("user should verify {string} disabled for Android")
	public void user_should_verify_disabled_for_Android(String verifyButton) {
		OneCS.androidButtonDisabled(verifyButton);

	}

	@Then("user should verify {string} enabled for Android")
	public void user_should_verify_enabled_for_Android(String verifyButton) {
		OneCS.androidButtonEnabled(verifyButton);
	}

	@Then("user verifies whether the {string} code entered is in correct order for Android")
	public void user_verifies_whether_the_code_entered_is_in_correct_order_for_Android(String twoFACode) {
		Assert.assertEquals(OneCS.androidGetText("SIX_DIGIT_INPUT_BOX"), OneCS.getEntered2FACode(twoFACode));
	}

	@When("user enters incorrect TWOFA code in input box")
	public void user_enters_incorrect_TWOFA_code_in_input_box() {
		OneCS.AndroidInputText("SIX_DIGIT_INPUT_BOX", "SIX_DIGIT_INCORRECT");
	}

	@Then("user should see the {string} in pop up for Android")
	public void user_should_see_the_in_pop_up_for_Android(String errorMsg) {
		Assert.assertEquals(DeviceActions.getTestData(errorMsg), OneCS.androidGetText(errorMsg));
	}

	@Then("user should see {string} alert pop up for Android")
	public void user_should_see_alert_pop_up_for_Android(String incorrectCodePopUp) {
		Assert.assertTrue(action.isPresent(incorrectCodePopUp));
	}

	@Then("user verfies the incorrect TWOFA code retained in the box for Android")
	public void user_verfies_the_incorrect_TWOFA_code_retained_in_the_box_for_Android() {
		Assert.assertEquals(OneCS.androidGetText("SIX_DIGIT_INPUT_BOX"), OneCS.androidGetText("SIX_DIGIT_INPUT_BOX"));
	}

	@And("upon swiping up RECOVER DETAILS popup should go to fullscreen for Android")
	public void upon_swiping_up_RECOVER_DETAILS_popup_should_go_to_fullscreen_for_Android()
			throws InterruptedException {
		MobileElement element = (MobileElement) action.getElement("RECOVER_DETAILS");
		MobileElement element1 = (MobileElement) action.getElement("SWIPING_RECOVER_FULLSCREEN");
		OneCS_Mobile.androidSwipe(element, element1);
	}

	@Then("user should see below details in TwoFA	 Screen for Android")
	public void user_should_see_below_details_in_TwoFA_Screen_for_Android(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getRecoverDetailsScreen();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@When("user taps {string} on TwoFA screen for Android")
	public void user_taps_on_TwoFA_screen_for_Android(String MobileNum) {
		OneCS.AndroidBtnClick(MobileNum);
	}

	@Then("user validates below fields in web url opened for Android")
	public void user_validates_below_fields_in_web_url_opened_for_Android(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getCheckMobileNumWebPage();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("user enters {string} and {string} in web url opened for Android")
	public void user_enters_and_in_web_url_opened_for_Android(String user, String pass) {
		OneCS.AndroidInputText(user, user);
		OneCS.AndroidInputText(pass, pass);
	}

	@Then("user should be able to login to web application for Android")
	public void user_should_be_able_to_login_to_web_application_for_Android() {
		Assert.assertTrue(action.isPresent("MEMORABLE_WORD"));
	}

	@Then("user taps on {string} on Recover Details popup for Android")
	public void user_taps_on_on_Recover_Details_popup_for_Android(String close) {
		OneCS.AndroidBtnClick(close);
	}

	@Then("user should not see the {string} pop up in TwoFA Screen for Android")
	public void user_should_not_see_the_pop_up_in_TwoFA_Screen_for_Android(String popup) {
		Assert.assertFalse(action.isPresent(popup));
	}

	@Then("user validates below details in Step three screen for Android")
	public void user_validates_below_details_in_Step_three_screen_for_Android(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getStep3Screenvalues();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("user should see six blank text boxes for Android")
	public void user_should_see_six_blank_text_boxes_for_Android() {
		OneCS.sixDigitBoxEmpty();
	}

	@Then("user should see {string} for Android")
	public void user_should_see_for_Android(String Continue) {
		Assert.assertTrue(action.isPresent(Continue));
	}

	@Then("user should not see the {string} for Android")
	public void user_should_not_see_the_for_Android(String backButton) {
		Assert.assertFalse(action.isPresent(backButton));
	}

	@Then("user tries to enter alphabets {string} in {string} for Android")
	public void user_tries_to_enter_alphabets_in_for_Android(String alphabets, String pinbox) {
		OneCS.AndroidInputText(pinbox, alphabets);
	}

	@Then("user verifies the alphabets entered doenot appear in {string} for Android")
	public void user_verifies_the_alphabets_entered_doenot_appear_in_for_Android(String pinbox) {
		Assert.assertEquals(OneCS.androidGetText(pinbox), "");
	}

	@Then("user should verify continue button Disabled in step three screen for Android")
	public void user_should_verify_continue_button_Disabled_in_step_three_screen_for_Android() {
		OneCS.androidButtonDisabled("CONTINUE_BUTTON_DISABLED");
	}

	@Then("user enters {string} pin in {string} for Android")
	public void user_enters_pin_in_for_Android(String code, String pinbox) {
		OneCS.AndroidInputText(pinbox, code);
	}

	@Then("user enters {string} pin in {string} box for Android")
	public void user_enters_pin_in_box_for_Android(String code, String pinbox) {
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("CONFIRM_PIN_TEXT")));
		OneCS.AndroidInputText(pinbox, code);
	}

	@When("user enters {string} pin in {string} in step four for Android")
	public void user_enters_pin_in_in_step_four_for_Android(String code, String pinbox) {
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("CONFIRM_PIN_TEXT")));
		OneCS.AndroidInputText(pinbox, code);
	}

	@Then("user verfies {string} pin entered appears in {string} for Android")
	public void user_verfies_pin_entered_appears_in_for_Android(String code, String pinbox) {
		Assert.assertNotEquals(OneCS.androidGetText(pinbox), "");
	}

	@Then("user verifies whether the {string} code entered is in sequential order for Android")
	public void user_verifies_whether_the_code_entered_is_in_sequential_order_for_Android(String code) {
		Assert.assertNotEquals(OneCS.androidGetText(code), "");
	}

	@Then("user should verify continue button Enabled in step three screen for Android")
	public void user_should_verify_continue_button_Enabled_in_step_three_screen_for_Android() {
		OneCS.androidButtonEnabled("CONTINUE_BUTTON_DISABLED");
	}

	@Then("user taps on {string} for Android")
	public void user_taps_on_for_Android(String continueButton) {
		OneCS.AndroidBtnClick(continueButton);
	}

	@Then("user validates below details in step four of sign in screen for Android")
	public void user_validates_below_details_in_step_four_of_sign_in_screen_for_Android(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getStep4Screenvalues();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("user verifies the {string}  is empty for Android")
	public void user_verifies_the_is_empty_for_Android(String string) {
		Assert.assertEquals(OneCS.androidGetText("CREATE_YOUR_PIN_BOX"), "");
	}

	@Then("user should verify {string} button in step four of singin screen for Android")
	public void user_should_verify_button_in_step_four_of_singin_screen_for_Android(String button) {
		Assert.assertTrue(action.isPresent(button));
	}

	@When("user taps on {string} in step four of sign in screen for Android")
	public void user_taps_on_in_step_four_of_sign_in_screen_for_Android(String back) {
		OneCS.AndroidBtnClick(back);
	}

	@Then("user should verify {string} buttom Disabled in step four screen for Android")
	public void user_should_verify_buttom_Disabled_in_step_four_screen_for_Android(String confirmPin) {
		OneCS.androidButtonEnabled(confirmPin);
	}

	@Then("user taps on {string} button in step four of sigin screen for Android")
	public void user_taps_on_button_in_step_four_of_sigin_screen_for_Android(String button) {
		OneCS.AndroidBtnClick(button);
	}

	@Then("upon confirming user should see {string} and {string} options for Android")
	public void upon_confirming_user_should_see_and_options_for_Android(String bio, String later) {
		Assert.assertEquals(OneCS.androidGetText("ENABLE_BIOMETRICS"), bio);
		Assert.assertEquals(OneCS.androidGetText("MAY_BE_LATER"), later);
	}

	@Then("user should see {string} pop up in step four of sigin screen for Android")
	public void user_should_see_pop_up_in_step_four_of_sigin_screen_for_Android(String incPin) {
		Assert.assertEquals(OneCS.androidGetText(incPin), DeviceActions.getTestData(incPin));
	}

	@Then("user should validates {string} pop up in step four of sigin screen for Android")
	public void user_should_validates_pop_up_in_step_four_of_sigin_screen_for_Android(String errorMsg) {
		Assert.assertEquals(OneCS.androidGetText(errorMsg), DeviceActions.getTestData(errorMsg));
	}

	@Then("user should see {string} button for Android")
	public void user_should_see_button_for_Android(String editdetails) {
		Assert.assertTrue(action.isPresent(editdetails));
	}

	@Then("user should see Dashboard screen")
	public void user_should_see_Dashboard_screen() throws InterruptedException {
		wait.until(ExpectedConditions.textToBePresentInElement((MobileElement) action.getElement("DASHBOARD_SCREEN"),
				DeviceActions.getTestData("WELCOME_MSG")));
		Assert.assertEquals(DeviceActions.getTestData("WELCOME_MSG"), OneCS.androidGetText("DASHBOARD_SCREEN"));
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");

	}

	@Then("user should see {string} as header for Android")
	public void user_should_see_as_header_for_Android(String header) {
		Assert.assertEquals(header, OneCS.androidGetText("SECURE_SIGN_IN"));
	}

	@Then("user taps on {string} option for Android")
	public void user_taps_on_option_for_Android(String later) {
		OneCS.AndroidBtnClick(later);
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("DASHBOARD_SCREEN")));
	}

	@And("user Clicks on {string} in Dashboard Screen for Android")
	public void user_clicks_on_in_dashboard_screen_for_android(String more) throws Throwable {
		DeviceActions.click((MobileElement) action.getElement(more));
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Then("user should see {string} as tittle in more options Screen for Android")
	public void user_should_see_as_tittle_in_more_options_Screen_for_Android(String Onecs) {
		Assert.assertEquals(Onecs, OneCS.androidGetText("OneCS_Tittle"));
	}

	@And("user Signs Out the Mobile Application")
	public void user_signs_out_the_mobile_application() throws Throwable {
		DeviceActions.scrollAndClick("Sign out");

	}

	@Then("user verfies {string} button is disabled for Android")
	public void user_verfies_button_is_disabled_for_Android(String confimPin) {
		OneCS.androidButtonDisabled(confimPin);
	}

	@Then("user should see {string} screen for Android")
	public void user_should_see_screen_for_Android(String secureSignIn) {
		wait.until(ExpectedConditions.textToBePresentInElement((MobileElement) action.getElement(secureSignIn),
				"Secure Sign in"));
		Assert.assertTrue(action.isPresent(secureSignIn));
	}

	@When("user Clicks on I {string} button on login screen")
	public void user_Clicks_on_I_button_on_login_screen(String button) {
		DeviceActions.click((MobileElement) action.getElement(button));
	}

	@And("user clicks on Verify button")
	public void user_clicks_on_Verify_Button() throws InterruptedException {
		DeviceActions.click((MobileElement) action.getElement("VERIFY_BUTTON"));
		wait.until(ExpectedConditions.invisibilityOf((MobileElement) action.getElement("Loading_Spinner")));

	}

	@When("user should tap on {string} in screen")
	public void user_should_tap_on_in_screen(String six) {
		DeviceActions.click((MobileElement) action.getElement(six));
	}

	@Then("user should see below four categories in more screen for Android")
	public void user_should_see_below_four_categories_in_more_screen_for_Android(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getMoreScreenvalues();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("no {string} should be displayed for the menu screen for Android")
	public void no_should_be_displayed_for_the_menu_screen_for_Android(String backButton) {
		Assert.assertFalse(action.isPresent(backButton));
	}

	@Then("under User Settings screen below options should be displayed with back option at right")
	public void under_User_Settings_screen_below_options_should_be_displayed_with_back_option_at_right(
			DataTable dataTable) {
		DeviceActions.scrollToElement("USER SETTINGS");
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getUserSettingsvalues();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("under Help & Suppport screen below options should be displayed with back option at right")
	public void under_Help_Suppport_screen_below_options_should_be_displayed_with_back_option_at_right(
			DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getHelpSupportvalues();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("under Market info screen below options should be displayed with back option at right")
	public void under_Market_info_screen_below_options_should_be_displayed_with_back_option_at_right(
			DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getMarketInfovalues();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("under About Charles Stanley screen below options should be displayed with back option at right")
	public void under_About_Charles_Stanley_screen_below_options_should_be_displayed_with_back_option_at_right(
			DataTable dataTable) {
		DeviceActions.scrollToElement("Sign out");
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getAboutCSvalues();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("user should see Sign Out button displayed at the bottom")
	public void user_should_see_Sign_Out_button_displayed_at_the_bottom() {
		Assert.assertTrue(action.isPresent("SIGN_OUT"));
	}

	@When("user taps on {string} in Dashboard screen for Android")
	public void user_taps_on_in_Dashboard_screen_for_Android(String yourAccounts) {
		DeviceActions.click((MobileElement) action.getElement(yourAccounts));
	}

	@When("user selects Mr.Lucas Investment Account from yours Accounts screen for Android")
	public void user_selects_Mr_Lucas_Investment_Account_from_yours_Accounts_screen_for_Android() {
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("YOUR_ACCOUNTS")));
		DeviceActions.click((MobileElement) action.getElement("MR_LUCAS_ISA"));
	}

	@When("user selects a account from the list of accounts in Accounts screen for Android")
	public void user_selects_a_account_from_the_list_of_accounts_in_Accounts_screen_for_Android() {
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("YOUR_ACCOUNTS")));
		DeviceActions.click((MobileElement) action.getElement("MR_LUCAS_ISA"));
	}

	@Then("user should see {string} account management screen for Android")
	public void user_should_see_account_management_screen_for_Android(String closeButton) {
		Assert.assertTrue(action.isPresent(closeButton));
	}

	@Then("user should see {string} popup screen for Android")
	public void user_should_see_popup_screen_for_Android(String AccMgm) {
		Assert.assertTrue(action.isPresent(AccMgm));
	}

	@Then("user should see below two options in Account Management screen for Android")
	public void user_should_see_below_two_options_in_Account_Management_screen_for_Android(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getAccountManagementPopupvalues();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("upon swiping up Account Management popup should go to fullscreen for Android")
	public void upon_swiping_up_Account_Management_popup_should_go_to_fullscreen_for_Android() {
		OneCS_Mobile.androidSwipe((MobileElement) action.getElement("ACCOUNT_MANAGEMENT"),
				(MobileElement) action.getElement("DARK_AREA"));
	}

	@Then("user swipes down the Account Management screen for Android")
	public void user_swipes_down_the_Account_Management_screen_for_Android() {
		OneCS_Mobile.androidSwipe((MobileElement) action.getElement("ACCOUNT_MANAGEMENT"),
				(MobileElement) action.getElement("ACCOUNT_MANAGEMENT_SWIPEDOWN"));
		OneCS_Mobile.androidSwipe((MobileElement) action.getElement("ACCOUNT_MANAGEMENT"),
				(MobileElement) action.getElement("ACCOUNT_MANAGEMENT_BREAKDOWN"));
	}

	@Then("user should not see {string} screen for Android")
	public void user_should_not_see_screen_for_Android(String AccMgm) {
		Assert.assertFalse(action.isPresent(AccMgm));
	}

	@Then("user taps on {string} in Account Dashboard screen for Android")
	public void user_taps_on_in_Account_Dashboard_screen_for_Android(String editPencil) {
		wait.until(
				ExpectedConditions.invisibilityOf((MobileElement) action.getElement("ACTIVITY_SCREEN_LOADINGSPINNER")));
		DeviceActions.click((MobileElement) action.getElement(editPencil));
	}

	@Then("users taps the {string} on Account Dashboard screen for Android")
	public void users_taps_the_on_Account_Dashboard_screen_for_Android(String darkArea) {
		DeviceActions.click((MobileElement) action.getElement(darkArea));
	}

	@Then("user taps the {string} in account management popup screen for Android")
	public void user_taps_the_in_account_management_popup_screen_for_Android(String closeButton) {
		DeviceActions.click((MobileElement) action.getElement(closeButton));
	}

	@When("user taps on {string} in account management bottom sheet for Android")
	public void user_taps_on_in_account_management_bottom_sheet_for_Android(String activity) {
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement(activity)));
		DeviceActions.click((MobileElement) action.getElement(activity));

	}

	@Then("user should see below tabs in Activity screen for Android")
	public void user_should_see_below_tabs_in_Activity_screen_for_Android(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getActivityScreenvalues();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@When("user taps on {string} in Activity screen for Android")
	public void user_taps_on_in_Activity_screen_for_Android(String backButton) {
		DeviceActions.click((MobileElement) action.getElement(backButton));
	}

	@Then("user should selected Account in {string} screen for Android")
	public void user_should_selected_Account_in_screen_for_Android(String accountDashboard) {
		Assert.assertTrue(action.isPresent(accountDashboard));
	}

	@Then("under Activity bar blank page should be displayed for Android")
	public void under_Activity_bar_blank_page_should_be_displayed_for_Android() {
//		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("REFRESH_CONTENT")));
//		DeviceActions.click((MobileElement) action.getElement("REFRESH_CONTENT"));
		Assert.assertEquals(OneCS.androidGetText("ACTIVITY_BLANK_PAGE"), "");
	}

	@When("user taps on {string} in Account Activity sheet for Android")
	public void user_taps_on_in_Account_Activity_sheet_for_Android(String orderList) {
		DeviceActions.click((MobileElement) action.getElement("ACCOUNT_ACTITVITY_ORDERLIST"));
	}

	@Then("under order or fund name below details should be there with > arrow")
	public void under_order_or_fund_name_below_details_should_be_there_with_arrow(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getActivityOrderListvalues();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("user minimized Holdings bottom sheet should be displayed for Android")
	public void user_minimized_Holdings_bottom_sheet_should_be_displayed_for_Android() {
		Assert.assertTrue(action.isPresent("MINIMIZED_HOLDINGS"));
	}

	@Then("{string} as Header should be displayed in the middle of the minimized sheet for Android")
	public void as_Header_should_be_displayed_in_the_middle_of_the_minimized_sheet_for_Android(String holdings) {
		Assert.assertEquals(OneCS.androidGetText("MINIMIZED_HOLDINGS"), holdings);
	}

	@Then("{string} should be displayed on the extreme right beside to Holdings title for Android")
	public void should_be_displayed_on_the_extreme_right_beside_to_Holdings_title_for_Android(String threeLines) {

		Assert.assertTrue(action.isPresent(threeLines));
	}

	@Then("Holding name and details container with > right chevron on the extreme right for Android")
	public void holding_name_and_details_container_with_right_chevron_on_the_extreme_right_for_Android() {
		Assert.assertTrue(action.isPresent("HOLDINGS_DETAIL_CONTAINER"));
	}

	@Then("user verifes below fields are present in Holdings name")
	public void user_verifes_below_fields_are_present_in_Holdings_name(DataTable dataTable) {
		DeviceActions.click((MobileElement) action.getElement("MINIMIZED_HOLDINGS"));
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getHoldingAccountvalues();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("user verifies all the Holdings are arranged in alphabetical order for Android")
	public void user_verifies_all_the_Holdings_are_arranged_in_alphabetical_order_for_Android()
			throws InterruptedException {
		boolean flag = OneCS_Mobile.sorting();
		Assert.assertTrue(flag);
	}

	@Then("Confirm the orders of the below types")
	public void confirm_the_orders_of_the_below_types(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getOrderTypesvalues();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("user verifies whether it lands on {string} screen for Android")
	public void user_verifies_whether_it_lands_on_screen_for_Android(String screen) {
		Assert.assertTrue(action.isPresent(screen));
	}

	@Then("user validates the details in the Account Dashboard screen for Android")
	public void user_validates_the_details_in_the_Account_Dashboard_screen_for_Android() {
		Assert.assertTrue(action.isPresent("VALUE_AS_OF_ACCOUNT"));
	}

	@Then("user the pulls down and refreshes the Accounts Dashboard screen for Android")
	public void user_the_pulls_down_and_refreshes_the_Accounts_Dashboard_screen_for_Android() {

		OneCS_Mobile.androidSwipe((MobileElement) action.getElement("ACCOUNT_DASHBOARD"),
				(MobileElement) action.getElement("VALUE_AS_OF_ACCOUNT"));
	}

	@Then("user navigates to other tabs and should be able to find a change in values in Accounts Dashboard screen for Android")
	public void user_navigates_to_other_tabs_and_should_be_able_to_find_a_change_in_values_in_Accounts_Dashboard_screen_for_Android()
			throws InterruptedException {
		String text = OneCS.androidGetText("ACCOUNT_TOTAL_VALUE");
		DeviceActions.click((MobileElement) action.getElement("More_Option"));
		Thread.sleep(2000);
		DeviceDriverManager.getDriver().navigate().back();
		OneCS_Mobile.androidSwipe((MobileElement) action.getElement("ACCOUNT_DASHBOARD"),
				(MobileElement) action.getElement("VALUE_AS_OF_ACCOUNT"));
		String text1 = OneCS.androidGetText("ACCOUNT_TOTAL_VALUE");
		Assert.assertNotEquals(text, text1);
	}

	@Then("user should see a {string} with a down arrow for Android")
	public void user_should_see_a_with_a_down_arrow_for_Android(String pillBox) {
		boolean flag = action.isDisplayed((MobileElement) action.getElement(pillBox));
		Assert.assertTrue(flag, "Error...Expected pillbox fields do not appear on the Dashboard screen...");
	}

	@Then("user should see welcome back your current portfolio section including the performance arrow on Android")
	public void user_should_see_welcome_back_your_current_portfolio_section_including_the_performance_arrow_on_Android() {
		boolean flag = OneCS.welcomeBackPortfolioDisplay();
		Assert.assertTrue(flag, "Error...Expected welcome back fields do not appear on the Dashboard screen...");
	}

	@Then("user should be displayed with Portfolio summary value details on Android")
	public void user_should_be_displayed_with_Portfolio_summary_value_details_on_Android() {
		boolean flag = OneCS.portfolioSummaryValueDetails();
		Assert.assertTrue(flag, "Error...Expected summary value fields do not appear on the Dashboard screen...");
		Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");
	}

	@Then("user should be displayed with bottom naviagation options for portfolio,contact,investments,insights and more on Android")
	public void user_should_be_displayed_with_bottom_naviagation_options_for_portfolio_contact_investments_insights_and_more_on_Android() {
		boolean flag = OneCS.bottomNavigationDisplay();
		Assert.assertTrue(flag, "Error...Expected bottom navigation options do not appear on the Dashboard screen...");
		Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");
	}

	@Then("user should be able to pull down the screen to refresh the details for Android")
	public void user_should_be_able_to_pull_down_the_screen_to_refresh_the_details_for_Android() {
		OneCS_Mobile.androidSwipe((MobileElement) action.getElement("PORTFOLIO_SELECTOR_PILLBOX"),
				(MobileElement) action.getElement("PORTFOLIO_SUMMARY_REFRESH_TIME_TXT"));
	}

	@Then("user should verify the value of date format displayed on screen for Android")
	public void user_should_verify_the_value_of_date_format_displayed_on_screen_for_Android() {
		Date date = new Date();

		String timeValueString = DeviceActions
				.getText((MobileElement) action.getElement("PORTFOLIO_SUMMARY_REFRESH_TIME_TXT"));
		String splitValues[] = timeValueString.split("2022");
		String split = splitValues[1];
		String timeOnScreen = split.substring(2, 6);

		@SuppressWarnings("deprecation")
		int hours = date.getHours() - 12;

		@SuppressWarnings("deprecation")
		int year = date.getYear();
		System.out.println(year);

		@SuppressWarnings("deprecation")
		int minutes = date.getMinutes();
		String actualTime = hours + "." + minutes;

		Assert.assertEquals(timeOnScreen, actualTime, "Error... Time mismatch between system and app.");
		Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");

	}

	@Then("user should see the Total Portfolio value is matching with sum of all portfolio values for Android")
	public void user_should_see_the_Total_Portfolio_value_is_matching_with_sum_of_all_portfolio_values_for_Android() {
		String totalPortfolioValue = DeviceActions.getText((MobileElement) action.getElement("PORTFOLIO_VALUE_TXT"));
		String TotalValue = totalPortfolioValue.substring(1).replace(",", "");
		DeviceActions.click((MobileElement) action.getElement("YOUR_ACCOUNTS"));
		List<Object> accounts = action.getElements("TOTAL_ACCOUNTS_IN_ACCOUNTS_SCREEN");

		Double total = 0.0;
		for (int i = 0; i < accounts.size(); i++) {

			String value1 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(
					By.xpath("//android.widget.TextView[@resource-id='portfolio-account-" + i + "-total-value']")));
			Double sumValue = Double.parseDouble(value1.substring(1).replace(",", ""));
			total = total + sumValue;

		}
		DecimalFormat df = new DecimalFormat("#");
		df.setMaximumFractionDigits(8);
		String IndividualAccountsTotal = df.format(total);
		Assert.assertEquals(TotalValue, IndividualAccountsTotal);

	}

	@Then("user should see the Total Portfolio Value Change is matching with sum of all Portfolio Value Change for Android")
	public void user_should_see_the_Total_Portfolio_Value_Change_is_matching_with_sum_of_all_Portfolio_Value_Change_for_Android() {
		DeviceActions.click((MobileElement) action.getElement("CLOSE_BUTTON"));
		String totalPortfolioValue = DeviceActions
				.getText((MobileElement) action.getElement("PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT"));
		String TotalValueChange = totalPortfolioValue.substring(2).replace(",", "");
		DeviceActions.click((MobileElement) action.getElement("YOUR_ACCOUNTS"));
		List<Object> accounts = action.getElements("TOTAL_ACCOUNTS_IN_ACCOUNTS_SCREEN");

		Double total = 0.0;
		for (int i = 0; i < accounts.size(); i++) {

			String value1 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(
					By.xpath("//android.widget.TextView[@resource-id='portfolio-account-" + i + "-value-change']")));
			Double sumValue = Double.parseDouble(value1.substring(2).replace(",", ""));
			total = total + sumValue;

		}
		DecimalFormat df = new DecimalFormat("#");
		df.setMaximumFractionDigits(8);
		String IndividualAccountsTotalChange = df.format(total);
		Assert.assertEquals(TotalValueChange, IndividualAccountsTotalChange);
	}

	@Then("user selects the {string} from Your accounts screen for Android")
	public void user_selects_the_from_Your_accounts_screen_for_Android(String accountName) throws InterruptedException {
		DeviceActions.click((MobileElement) DeviceDriverManager.getDriver()
				.findElement(By.xpath("//android.widget.TextView[@text=\"" + accountName + "\"]")));

	}

	@Then("user should see the Account Dashboard value is matching with holdings value of the same account for Android")
	public void user_should_see_the_Account_Dashboard_value_is_matching_with_holdings_value_of_the_same_account_for_Android() {
		String totalPortfolioValue = DeviceActions
				.getText((MobileElement) action.getElement("ACCOUNT_DASHBOARD_TOTAL_VALUE"));
		String TotalValueChange = totalPortfolioValue.substring(1).replace(",", "");
		DeviceActions.click((MobileElement) action.getElement("HOLDINGS_TAB"));
		List<Object> accounts = action.getElements("TOTAL_HOLDINGS_IN_ACCOUNTS_SCREEN");

		Double total = 0.0;
		for (int i = 0; i < accounts.size(); i++) {

			String value1 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(
					By.xpath("//android.widget.TextView[@resource-id='account-holding-" + i + "-total-value']")));
			Double sumValue = Double.parseDouble(value1.substring(1).replace(",", ""));
			total = total + sumValue;

		}
		DecimalFormat df = new DecimalFormat("#");
		df.setMaximumFractionDigits(8);
		String IndividualAccountsTotalChange = df.format(total);
		Assert.assertEquals(TotalValueChange, IndividualAccountsTotalChange);

	}

	@Then("user should see the Account Dashboard Value Change is matching with Sum of All Holdings Value Change for Android")
	public void user_should_see_the_Account_Dashboard_Value_Change_is_matching_with_Sum_of_All_Holdings_Value_Change_for_Android() {

	}

	@Then("in extreme left right arrow in square bracket {string} should be displayed for Android")
	public void in_extreme_left_right_arrow_in_square_bracket_should_be_displayed_for_Android(String cashMoveIcon) {
		wait.until(
				ExpectedConditions.invisibilityOf((MobileElement) action.getElement("ACTIVITY_SCREEN_LOADINGSPINNER")));
		Assert.assertTrue(action.isPresent(cashMoveIcon));
	}

	@Then("besides to cash movement icon {string} title should be displayed for Android")
	public void besides_to_cash_movement_icon_title_should_be_displayed_for_Android(String title) {
		Assert.assertEquals(title, OneCS.androidGetText("ACTIVITY_CASH_MOVEMENT"));
	}

	@Then("beneath cash movement title {string} subtype should be displayed for Android")
	public void beneath_cash_movement_title_subtype_should_be_displayed_for_Android(String money) {
		Assert.assertEquals(money, OneCS.androidGetText("ACTIVITY_MONEY_IN"));
	}

	@Then("in extreme right cash movement value should be displayed in pounds for Android")
	public void in_extreme_right_cash_movement_value_should_be_displayed_in_pounds_for_Android() {
		Assert.assertTrue(action.isPresent("ACTIVITY_CASH_MOVEMENT_POUNDS"));
	}

	@Then("user shoud see {string} symbol infront of currency symbol for Android")
	public void user_shoud_see_symbol_infront_of_currency_symbol_for_Android(String plus) {
		String txt = OneCS.androidGetText("ACTIVITY_CASH_MOVEMENT_POUNDS");
		boolean flag = txt.contains(plus);
		Assert.assertTrue(flag, "Error + sign Doesn't appear");
	}

	@Then("user see the Activity tab is fixed upon scrolling for Android")
	public void user_see_the_Activity_tab_is_fixed_upon_scrolling_for_Android() {
		DeviceActions.scroll("down");

	}

	@Then("user should see Loading spinner while navigating in Android")
	public void user_should_see_Loading_spinner_while_navigating_in_Android() {
		Assert.assertTrue(action.isPresent("ACTIVITY_SCREEN_LOADINGSPINNER"));
	}

	@Then("user should be able to swipe down and refresh the screen")
	public void user_should_be_able_to_swipe_down_and_refresh_the_screen() {
		OneCS_Mobile.androidSwipe((MobileElement) action.getElement("REFRESH_ORDERLIST_FROM"),
				(MobileElement) action.getElement("REFRESH_ORDERLIST_TO"));
		Assert.assertTrue(action.isPresent("ACTIVITY_SCREEN_LOADINGSPINNER"));
	}

	@Then("user clicks on any order from orderlist for Android")
	public void user_clicks_on_any_order_from_orderlist_for_Android() {
		DeviceActions.click((MobileElement) action.getElement("RANDOM_ORDER_ORDERLIST"));
	}

	@Then("user should see {string} in top left corner of order list screen for Android")
	public void user_should_see_in_top_left_corner_of_order_list_screen_for_Android(String closeButton) {
		Assert.assertTrue(action.isPresent(closeButton));
	}

	@Then("user see below details in selected order for Android")
	public void user_see_below_details_in_selected_order_for_Android(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = OneCS_Mobile.getOrderDetailvalues();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
	}

	@Then("user should see {string} button at the bottom of the order details screen for Android")
	public void user_should_see_button_at_the_bottom_of_the_order_details_screen_for_Android(String cancel) {
		Assert.assertTrue(action.isPresent(cancel));
	}

	@Then("user should see Order Details displayed in fullscreen for Android")
	public void user_should_see_Order_Details_displayed_in_fullscreen_for_Android() {
		Assert.assertFalse(action.isPresent("ACCOUNT_ACTITVITY_ORDERLIST"));
	}

	@Then("user confirms the value of the portfolio change is shown as a percentage figure for Android")
	public void user_confirms_the_value_of_the_portfolio_change_is_shown_as_a_percentage_figure_for_Android() {
		wait.until(
				ExpectedConditions.invisibilityOf((MobileElement) action.getElement("ACTIVITY_SCREEN_LOADINGSPINNER")));
		String percentage = OneCS.androidGetText("ACC_DASH_PERCENTAGE_VALUE");
		boolean flag = percentage.contains("%");
		Assert.assertTrue(flag, "Error...value is not shown in percentage value");
	}

	@Then("user should see Zig Zag Arrow pointing up for Android")
	public void user_should_see_Zig_Zag_Arrow_pointing_up_for_Android() {
		Assert.assertTrue(action.isPresent("ACC_ZIGZAG_INCARROW"));
	}

	@Then("user should see {string} Portfolio Value Change in the Dashboard screen for Android")
	public void user_should_see_Portfolio_Value_Change_in_the_Dashboard_screen_for_Android(
			String performanceIndicator) {
		String totalChangeValue = OneCS.androidGetText("ACC_DASH_CHANGE_VALUE");

		if (performanceIndicator.equalsIgnoreCase("positive")) {
			boolean postiveSign = totalChangeValue.contains("+");
			AssertLogger.assertTrue(postiveSign, "Postive sign does not appear in Portfolio Value Change field..");
		} else if (performanceIndicator.equalsIgnoreCase("negative")) {
			boolean negativeSign = totalChangeValue.contains("-");
			AssertLogger.assertTrue(negativeSign, "Negative sign does not appear in Portfolio Value Change field..");
		}
	}

	@Then("user should see {string} Sign in the Percentage value on the Dashboard screen for Android")
	public void user_should_see_Sign_in_the_Percentage_value_on_the_Dashboard_screen_for_Android(
			String performanceIndicator) {
		String totalChangePercenatge = OneCS.androidGetText("ACC_DASH_CHANGE_PERCENTAGE");

		if (performanceIndicator.equalsIgnoreCase("positive")) {
			boolean postiveSign = totalChangePercenatge.contains("+");
			AssertLogger.assertTrue(postiveSign, "Postive sign does not appear in Portfolio Value Change field..");
		} else if (performanceIndicator.equalsIgnoreCase("negative")) {
			boolean negativeSign = totalChangePercenatge.contains("-");
			AssertLogger.assertTrue(negativeSign, "Negative sign does not appear in Portfolio Value Change field..");
		}
	}

	@Then("user should see {string} arrow in Portfolio Dashboard for Android")
	public void user_should_see_arrow_in_Portfolio_Dashboard_for_Android(String arrow) {
		Assert.assertTrue(action.isPresent(arrow));
	}

	@Then("user should see {string} Portfolio Value Change in the Portfolio Dashboard screen for Android")
	public void user_should_see_Portfolio_Value_Change_in_the_Portfolio_Dashboard_screen_for_Android(
			String performanceIndicator) {
		String totalChangeValue = OneCS.androidGetText("PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT");

		if (performanceIndicator.equalsIgnoreCase("positive")) {
			boolean postiveSign = totalChangeValue.contains("+");
			AssertLogger.assertTrue(postiveSign, "Postive sign does not appear in Portfolio Value Change field..");
		} else if (performanceIndicator.equalsIgnoreCase("negative")) {
			boolean negativeSign = totalChangeValue.contains("-");
			AssertLogger.assertTrue(negativeSign, "Negative sign does not appear in Portfolio Value Change field..");
		}
	}

	@Then("user should see {string} Sign in the Percentage value on the Portfolio Dashboard screen for Android")
	public void user_should_see_Sign_in_the_Percentage_value_on_the_Portfolio_Dashboard_screen_for_Android(
			String performanceIndicator) {
		String totalChangePercenatge = OneCS.androidGetText("PORTFOLIO_DASH_PERCENTAGE_CHANGE");

		if (performanceIndicator.equalsIgnoreCase("positive")) {
			boolean postiveSign = totalChangePercenatge.contains("+");
			AssertLogger.assertTrue(postiveSign, "Postive sign does not appear in Portfolio Value Change field..");
		} else if (performanceIndicator.equalsIgnoreCase("negative")) {
			boolean negativeSign = totalChangePercenatge.contains("-");
			AssertLogger.assertTrue(negativeSign, "Negative sign does not appear in Portfolio Value Change field..");
		}
	}

	@Then("user confirms the value of the portfolio change is shown as a percentage figure in Portfolio Dashboard for Android")
	public void user_confirms_the_value_of_the_portfolio_change_is_shown_as_a_percentage_figure_in_Portfolio_Dashboard_for_Android() {
		String percentage = OneCS.androidGetText("PORTFOLIO_DASH_PERCENTAGE_CHANGE");
		boolean flag = percentage.contains("%");
		Assert.assertTrue(flag, "Error...value is not shown in percentage value");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() throws InterruptedException {
		DeviceActions.click((MobileElement) action.getElement("NEXT_BUTTON"));
		Thread.sleep(2000);
	}

	@When("user enters a desired {string} pin")
	public void user_enters_a_desired_pin(String pin) {
		DeviceActions.sendKeys((MobileElement) action.getElement("SIX_DIGIT"), DeviceActions.getTestData(pin));
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");
	}

	@When("user reenters the {string} pin again")
	public void user_reenters_the_pin_again(String pin) {
		DeviceActions.sendKeys((MobileElement) action.getElement("SIX_DIGIT"), DeviceActions.getTestData(pin));
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");
	}

	@When("user clicks on {string} button")
	public void user_clicks_on_button(String confirm) throws InterruptedException {
		DeviceActions.click((MobileElement) action.getElement(confirm));
		Thread.sleep(15000);
	}

	@When("^user clicks on Holdings Tab$")
	public void user_clicks_on_holdings_tab() throws Throwable {
		DeviceActions.click((MobileElement) action.getElement("HOLDINGS_TAB"));
		Thread.sleep(4000);
	}

	@Then("^user should see the list of Holdings$")
	public void user_should_see_the_list_of_holdings() throws Throwable {
		DeviceActions.click((MobileElement) action.getElement("RANDOM_HOLDINGS"));
		Thread.sleep(1000);
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");
	}

	@And("^user clicks on Accounts Tab$")
	public void user_clicks_on_accounts_tab() throws Throwable {
		DeviceActions.click((MobileElement) action.getElement("TAP_ACCOUNT"));

		Thread.sleep(1000);
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");
	}

	@And("^user clicks on Preferred Accounts$")
	public void user_clicks_on_preferred_accounts() throws Throwable {
		DeviceActions.click((MobileElement) action.getElement("YOUR_ACCOUNTS"));
		Thread.sleep(3000);
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");
	}

	@And("^user clicks on Buy Shares Button$")
	public void user_clicks_on_buy_shares_button() throws Throwable {
		DeviceActions.click((MobileElement) action.getElement("BUY_SHARES"));
		Thread.sleep(4000);
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");
	}

	@And("^user buys share with Desired Amount$")
	public void user_buys_share_with_desired_amount() throws Throwable {
		DeviceActions.sendKeys((MobileElement) action.getElement("SHARES_AMOUNT"),
				DeviceActions.getTestData("SHARES_AMOUNT"));
		Thread.sleep(1000);
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");
	}

	@And("^user cliks on Continue Button$")
	public void user_cliks_on_continue_button() throws Throwable {
		DeviceActions.click((MobileElement) action.getElement("SHARES_CONTINUE"));
		Thread.sleep(1000);

		DeviceActions.click((MobileElement) action.getElement("CONFIRM_CONTINUE"));
		Thread.sleep(1000);
	}

	@And("^user Prefers to Cancel the Transaction$")
	public void user_prefers_to_cancel_the_transaction() throws Throwable {
		DeviceActions.click((MobileElement) action.getElement("CANCEL_BUTTON"));
		Thread.sleep(1000);
	}

	@And("^User Navigates to Accounts Page$")
	public void user_navigates_to_accounts_page() throws Throwable {
		DeviceActions.click((MobileElement) action.getElement("BACK_BUTTON"));
		Thread.sleep(1000);

		DeviceActions.click((MobileElement) action.getElement("BACK_BUTTON"));
		Thread.sleep(1000);

		DeviceActions.click((MobileElement) action.getElement("BACK_BUTTON"));
		Thread.sleep(1000);

		DeviceActions.click((MobileElement) action.getElement("CLOSE_BUTTON"));
		Thread.sleep(1000);
	}

	@And("^User Clicks on Documents Tab$")
	public void user_clicks_on_documents_tab() throws Throwable {
		DeviceActions.click((MobileElement) action.getElement("DOCUMENTS_BUTTON"));
		Thread.sleep(6000);
	}

	@And("^user Navigates through all the Tab In Documents$")
	public void user_navigates_through_all_the_tab_in_documents() throws Throwable {
		DeviceActions.click((MobileElement) action.getElement("DOCUMENTS_BUTTON"));
		Thread.sleep(6000);
	}

	@And("^user Navigates back to More Page$")
	public void user_navigates_back_to_more_page() throws Throwable {
		throw new PendingException();
	}

}
