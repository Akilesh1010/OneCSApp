package qa.oneCSiOS.stepDefs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.framework.assertions.AssertLogger;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.utils.Reporter;
import qa.oneCSiOS.pages.AccountManagementScreeniOS;
import qa.oneCSiOS.pages.DashboardScreeniOS;
import qa.oneCSiOS.pages.SignInScreeniOS;

public class IOSAccountManagementStepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));
	SignInScreeniOS iOSSignInScreen = new SignInScreeniOS();
	DashboardScreeniOS dashboardScreeniOS = new DashboardScreeniOS();
	AccountManagementScreeniOS accountManagementiOS = new AccountManagementScreeniOS();

	@Then("user should see {string} in the popup screen for iOS")
	public void user_should_see_popup_screen_for_iOS(String popUp) {
		Assert.assertTrue(action.isPresent(popUp));
		Reporter.addDeviceScreenshot("Account Management Screen", "Mobile App Acc Management Screen");

	}

	@Then("user should see below two options in Account Management screen for iOS")
	public void user_should_see_below_two_options_in_Account_Management_screen_for_iOS(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = accountManagementiOS.getAccountManagementPopupValuesiOS();

		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");

		Reporter.addDeviceScreenshot("Account Management Screen", "Mobile App Acc Management Screen");
	}
	
	@Then("upon swiping up Account Management popup should go to fullscreen for iOS")
	public void upon_swiping_up_Account_Management_popup_should_go_to_fullscreen_for_iOS() {
		MobileElement startingElement= (MobileElement) action.getElement("ACCOUNT_MANAGEMENT_DRAG_UP_BTN");
		MobileElement endingElement= (MobileElement) action.getElement("ACCOUNT_DASHBOARD_SELECT_ACCOUNT_BTN");
		dashboardScreeniOS.swipeiOS(startingElement, endingElement);   
		
		Reporter.addDeviceScreenshot("Account Management Screen", "Mobile App Acc Management Screen");
	}
	
	@When("upon swiping down Account Management popup should go to fullscreen for iOS")
	public void upon_swiping_down_Account_Management_popup_should_go_to_fullscreen_for_iOS() {
		MobileElement startingElement= (MobileElement) action.getElement("ACCOUNT_MANAGEMENT_DRAG_UP_BTN");
		MobileElement endingElement= (MobileElement) action.getElement("ACCOUNT_BREAKDOWN_BTN");
		dashboardScreeniOS.swipeiOS(startingElement, endingElement);   
		dashboardScreeniOS.swipeiOS(startingElement, endingElement);  
		
		Reporter.addDeviceScreenshot("Account Management Screen", "Mobile App Acc Management Screen");
	   
	}
	
	@Then("user should see below tabs in Activity screen for iOS")
	public void user_should_see_below_tabs_in_Activity_screen_for_iOS(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = accountManagementiOS.getActivityScreenTabNamesiOS();

		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");

		Reporter.addDeviceScreenshot("Account Management Screen", "Mobile App Acc Management Screen");
	    
	}
	
	@Then("user should be see {string} screen for iOS")
	public void user_should_be_see_screen_for_iOS(String screenName) {
		Assert.assertTrue(action.isPresent(screenName));
		Reporter.addDeviceScreenshot(screenName, "Mobile App "+screenName+ "Acc Activity Screen");
	}
	
	@Then("user should be able to pull down the Activity tab to refresh the screen for iOS")
	public void user_should_be_able_to_pull_down_the_Activity_tab_to_refresh_the_screen_for_iOS() {
		MobileElement startingElement= (MobileElement) action.getElement("ACCOUNT_ACTIVITY_1ST_ACTIVITY_NAME_TXT");
		MobileElement endingElement= (MobileElement) action.getElement("PORTFOLIO_TAB");
		dashboardScreeniOS.swipeiOS(startingElement, endingElement);   
		boolean flag = accountManagementiOS.activityLabelsUnderActivityTabiOS();
		Assert.assertTrue(flag, "Error...Expected fields do not appear in Dashboard screen...");
		Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");
	}


}
