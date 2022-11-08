package qa.oneCSiOS.stepDefs;

import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.framework.assertions.AssertLogger;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.utils.Reporter;
import qa.oneCSAndroid.pages.SEA_HomeScreen;
import qa.oneCSiOS.pages.DashboardScreen;
import qa.oneCSiOS.pages.IOSHomeScreen;

public class IOSHomePageStepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSiOSApp_SplashScreen"));
	IOSHomeScreen iOSHomeScreen = new IOSHomeScreen();
	DashboardScreen dashboardScreen = new DashboardScreen();
	
	
	@Given("user Clicks on {string} button for iOS")
	public void user_Clicks_on_button(String btnName) throws InterruptedException {
//		Thread.sleep(2000);
		iOSHomeScreen.iOSBtnClick(btnName);
	}
	
	@When("user enters {string} and {string} for iOS")
	public void user_enters_and(String userName, String pwd) {
		iOSHomeScreen.iOSUserLogin(userName, pwd);   
	}
	
	@Then("user should see Sign in error message for iOS")
	public void user_should_see_Sign_in_error_message() {
		String actual = DeviceActions.getText((MobileElement) action.getElement("ERRORMSG_TXT"));
		String expected = DeviceActions.getTestData("IOS_INVALID_SIGN_IN_ERROR_MSG");
		AssertLogger.assertEquals(expected, actual, "iOS Error message do not match");
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
		iOSHomeScreen.input2FA();   
	}
	
	@Then("user enters value in {string} field with {string} pin for iOS")
	public void user_enters_value_in_field_with_pin_for_iOS(String fieldName, String value) throws InterruptedException {
//		Thread.sleep(3000);
		iOSHomeScreen.iOSInputField(fieldName, value);
	    
	}
	
}
