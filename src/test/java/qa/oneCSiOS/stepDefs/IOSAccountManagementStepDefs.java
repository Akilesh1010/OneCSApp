package qa.oneCSiOS.stepDefs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import qa.framework.device.DeviceDriverManager;
import qa.framework.utils.Reporter;
import qa.oneCSAndroid.pages.OneCS_Mobile;
import qa.oneCSiOS.pages.AccountManagementScreeniOS;
import qa.oneCSiOS.pages.DashboardScreeniOS;
import qa.oneCSiOS.pages.SignInScreeniOS;

public class IOSAccountManagementStepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));
	SignInScreeniOS iOSSignInScreen = new SignInScreeniOS();
	DashboardScreeniOS dashboardScreeniOS = new DashboardScreeniOS();
	AccountManagementScreeniOS accountManagementiOS = new AccountManagementScreeniOS();
	WebDriverWait wait = new WebDriverWait(DeviceDriverManager.getDriver(),20);

	@Then("user should see {string} in the popup screen for iOS")
	public void user_should_see_popup_screen_for_iOS(String popUp) {
		Assert.assertTrue(action.isPresent(popUp));
		Reporter.addDeviceScreenshot("Account Management Screen", "Mobile App Acc Management Screen");

	}

	@Then("user should see below three options in Account Management screen for iOS")
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

	@Then("under Activity bar blank page should be displayed for iOS")
	public void under_Activity_bar_blank_page_should_be_displayed_for_iOS() {
		Assert.assertTrue(action.isDisplayed((MobileElement) action.getElement("EMPTY_LIST_ACTIVITY_TAB")));
		Reporter.addDeviceScreenshot("Activity tab", "Mobile App Activity tab Screen");		
	}

	@Then("under order or fund name below details should be displayed for iOS")
	public void under_order_or_fund_name_below_details_should_be_displayed_for_iOS(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = accountManagementiOS.getActivityOrderListLabelsiOS();
		AssertLogger.assertEquals(pageValues, data, "Error..... Order list screen values does not match");
		boolean flag = accountManagementiOS.orderListValuesiOS();
		Assert.assertTrue(flag, "Error...Expected fields do not appear in Order list screen...");
		Reporter.addDeviceScreenshot("Order list tab", "Mobile App Order list tab Screen");	

	}
	
	@Then("in extreme left right arrow in square bracket {string} should be displayed for iOS")
	public void in_extreme_left_right_arrow_in_square_bracket_should_be_displayed_for_iOS(String icon) {
		Assert.assertTrue(action.isPresent(icon));
		Reporter.addDeviceScreenshot("Activity tab under Account Management", "Mobile App Activity list tab Screen");  
	}
	
	@Then("Confirm the orders of the below types for iOS")
	public void confirm_the_orders_of_the_below_types_for_iOS(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = accountManagementiOS.getOrderTypesvaluesiOS();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");
		Reporter.addDeviceScreenshot("Order List tab under Account Management", "Mobile App Order list tab Screen");
	}
	
	@Then("user pull down Order list screen to see the spinner element appears on the screen for iOS")
	public void user_pull_down_Order_list_screen_to_see_the_spinner_element_appears_on_the_screen_for_iOS() {
		MobileElement startingElement= (MobileElement) action.getElement("ORDER_NAME_ORDER_LIST_LABEL");
		MobileElement endingElement= (MobileElement) action.getElement("PORTFOLIO_TAB");
		dashboardScreeniOS.swipeiOS(startingElement, endingElement);
		Assert.assertTrue(action.isPresent(""));
		Reporter.addDeviceScreenshot("Order List tab under Account Management", "Mobile App Order list tab Screen");
	}
	
	@Then("user see below fields in the Order Details screen for iOS")
	public void user_see_below_fields_in_the_Order_Details_screen_for_iOS(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = accountManagementiOS.getOrderDetailsScreenFieldsiOS();
		AssertLogger.assertEquals(pageValues, data, "Error..... Order detail screen values does not match");
		Reporter.addDeviceScreenshot("Order List tab under Account Management", "Order detail screen details tab Screen");
	}
	
	@Then("user selects the order {string} from Order list screen for iOS")
	public void user_selects_the_order_from_Order_list_screen_for_iOS(String orderName) {
		DeviceActions.click((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@value=\""+orderName+"\"]")));
	}
	
	@Then("under Order list tab blank page should be displayed for iOS")
	public void under_Order_list_tab_blank_page_should_be_displayed_for_iOS() {
		Assert.assertTrue(action.isDisplayed((MobileElement) action.getElement("EMPTY_LIST_ACTIVITY_TAB")));
		Reporter.addDeviceScreenshot("Order list tab", "Mobile App Order list tab Screen");		
	    
	}
	
	@Then("user waits until the account details displayed on screen for iOS")
	public void user_waits_until_the_account_details_displayed_on_screen_for_iOS() {
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("ACCOUNT_SUMMARY_NAME_LABEL_TXT")));
	}
	

}
