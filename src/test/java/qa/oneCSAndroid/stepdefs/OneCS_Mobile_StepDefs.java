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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.device.DeviceDriverManager;
import qa.framework.utils.Reporter;
import qa.oneCSAndroid.pages.OneCS_Mobile;

public class OneCS_Mobile_StepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSApp_Android"));

	@And("user Clicks on {string} button")
	public void user_Clicks_on_button(String button) {
		DeviceActions.click((MobileElement) action.getElement(button));
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String password) throws InterruptedException {

		DeviceActions.sendKeys((MobileElement) action.getElement(username), DeviceActions.getTestData(username));

		DeviceActions.sendKeys((MobileElement) action.getElement(password), DeviceActions.getTestData(password));

		Thread.sleep(2000);
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile App Login Screen");
	}

	@When("user Clicks on {string}")
	public void user_Clicks_on(String button) throws InterruptedException {
		DeviceActions.click((MobileElement) action.getElement(button));

		Thread.sleep(10000);
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
