package qa.oneCSiOS.stepDefs;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.device.DeviceDriverManager;
import qa.framework.utils.Reporter;
import qa.oneCSiOS.pages.DashboardScreeniOS;
import qa.oneCSiOS.pages.SignInScreeniOS;

public class IOSSignInStepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));
	SignInScreeniOS iOSSignInScreen = new SignInScreeniOS();
	DashboardScreeniOS dashboardScreeniOS = new DashboardScreeniOS();


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
		Thread.sleep(3000);
		Assert.assertTrue(action.isPresent(twoFA));
		Reporter.addDeviceScreenshot("2FA Screen", "Mobile App Login Screen");		
	}

	@Then("user get the SIX digit code displayed on screen and enters in TWOFA input field for iOS")
	public void user_get_the_SIX_digit_code_displayed_on_screen_and_enters_in_TWOFA_input_field_for_iOS() throws InterruptedException {
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
		Assert.assertEquals(iOSSignInScreen.getTextiOS("BROWSER_URL"), DeviceActions.getTestData("CS_SECURE_URL"));
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Then("user clicks on Back Button for iOS")
	public void user_clicks_on_Back_Button_for_iOS() {
		DeviceDriverManager.getDriver().navigate().back();
		DeviceDriverManager.getDriver().navigate().back();
		
	}

	@Given("user should see {string} from Signin Screen for iOS")
	public void user_should_see_from_Signin_Screen_for_iOS(String step1TitleTxt) {
		Assert.assertEquals(iOSSignInScreen.getTextiOS("SIGN_IN_STEP_1_OF_4_TITLE"),step1TitleTxt);	
		Reporter.addDeviceScreenshot("Login Screen", "Mobile App Login Screen");
	}

	@Given("user should see {string} on the top left corner of the screen for iOS")
	public void user_should_see_on_the_top_left_corner_of_the_screen_for_iOS(String closeBtn) {
		Assert.assertTrue(action.isPresent(closeBtn));
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
	}
	
	@Then("user should see the entered password in password fiedls for iOS")
	public void user_should_see_the_entered_password_in_password_fiedls_for_iOS() {
		Assert.assertEquals(iOSSignInScreen.getTextiOS("PWD_EDIT"),
				DeviceActions.getTestData("Correct_Password"));
	}
	
	@Then("user should be displayed with secure sign in page for iOS")
	public void user_should_be_displayed_with_secure_sign_in_page_for_iOS() {
	    boolean flag = iOSSignInScreen.secureSignInScreenFieldsDisplayiOS();
	    Assert.assertTrue(flag, "Error...Secure sign in screen fields not displayed.");
	}



}
