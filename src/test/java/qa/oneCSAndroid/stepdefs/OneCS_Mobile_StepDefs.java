package qa.oneCSAndroid.stepdefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.PendingException;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.device.DeviceDriverManager;
import qa.framework.utils.Reporter;
import qa.oneCSAndroid.pages.OneCS_Mobile;

public class OneCS_Mobile_StepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSApp_Android"));
	OneCS_Mobile OneCS = new OneCS_Mobile();

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

	@Then("user should {string} text on welcome screen for Android")
	public void user_should_text_on_welcome_screen_for_Android(String text) {
		OneCS.getText();
	}

	@Then("user should verifies {string} text in welcome screen for Android")
	public void user_should_verifies_text_in_welcome_screen_for_Android(String string) {

		Assert.assertEquals(DeviceActions.getTestData("CREATE_ONE_ON_OUR_WEBSITE"),
				OneCS.androidGetText("CREATE_ONE_ON_OUR_WEBSITE"));

	}

	@When("user taps on {string} link on Android")
	public void user_taps_on_link_on_Android(String website) {
		OneCS_Mobile.clickOnButton(website);
	}

	@Then("user should be Navigated to the {string} website for Android")
	public void user_should_be_Navigated_to_the_website_for_Android(String URL) {
		Assert.assertEquals(URL, OneCS.androidGetText("DEVICE_URL"));
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
	public void user_should_see_from_Signin_Screen_for_Android(String step) {

		Assert.assertEquals(step, OneCS_Mobile.getTextofsteop1of4());
	}

	@And("user should see {string} on the top left corner of the screen for Android")
	public void user_should_see_on_the_top_left_corner_of_the_screen_for_Android(String X) {
		Assert.assertTrue(action.isPresent(X));
	}

	@And("user should see progress bar as {string} in signin screen for Android")
	public void user_should_see_progress_bar_as_in_signin_screen_for_Android(String step1) {
		Assert.assertEquals(DeviceActions.getTestData(step1), OneCS.androidGetText("Step1_of_4"));
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
		Thread.sleep(10000);
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
	public void user_should_see_enabled(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("user should see the continue button turning to {string} for Android")
	public void user_should_see_the_continue_button_turning_to_for_Android(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("user should see the entered username and password retained in sigin Screen for Android")
	public void user_should_see_the_entered_username_and_password_retained_in_sigin_Screen_for_Android() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
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

	@When("user Clicks on I {string} button on login screen")
	public void user_Clicks_on_I_button_on_login_screen(String button) {
		DeviceActions.click((MobileElement) action.getElement(button));
	}

	@Then("user enters the {string} code in input box")
	public void user_enters_the_code_in_input_box(String otp) throws InterruptedException {
		Thread.sleep(4000);
		String codetext = DeviceActions.getText((MobileElement) action.getElement("CODE_TO_TYPE"));
		// String code = codetext.replaceAll("[^0-9]", "");
		DeviceActions.sendKeys((MobileElement) action.getElement("Incorrect_Username"), codetext);
//        WebDriverWait wait = new WebDriverWait(DeviceDriverManager.getDriver(),20);
//        String Xpath="(//android.widget.Button[@index='1'])[3]";
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));

		// Thread.sleep(5000);

	}

	@And("user clicks on Verify button")
	public void user_clicks_on_Verify_Button() throws InterruptedException {
		DeviceActions.click((MobileElement) action.getElement("VERIFY_BUTTON"));
		Thread.sleep(8000);

	}

	@When("user should tap on {string} in screen")
	public void user_should_tap_on_in_screen(String six) {

//		WebDriverWait wait = new WebDriverWait(DeviceDriverManager.getDriver(), 60);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Use 6-digit PIN']")));
		DeviceActions.click((MobileElement) action.getElement(six));
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

	@Then("user should see Dashboard screen")
	public void user_should_see_Dashboard_screen() throws InterruptedException {
		String Dashboard = DeviceActions.getText((MobileElement) action.getElement("DASHBOARD_SCREEN"));
		Assert.assertEquals(DeviceActions.getTestData("WELCOME_MSG"), Dashboard);
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");
		Thread.sleep(6000);

		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");

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

	@And("^user Clicks on More Option$")
	public void user_clicks_on_more_option() throws Throwable {
		DeviceActions.click((MobileElement) action.getElement("MORE_BUTTON"));
		Thread.sleep(1000);
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");
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

	@And("^user Signs Out the Mobile Application$")
	public void user_signs_out_the_mobile_application() throws Throwable {
		DeviceActions.scrollAndClick("Sign out");
		Thread.sleep(2000);
	}

}
