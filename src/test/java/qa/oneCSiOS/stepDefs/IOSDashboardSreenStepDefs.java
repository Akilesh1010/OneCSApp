package qa.oneCSiOS.stepDefs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.utils.Reporter;
import qa.oneCSiOS.pages.DashboardScreeniOS;
import qa.oneCSiOS.pages.SignInScreeniOS;

public class IOSDashboardSreenStepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));
	SignInScreeniOS iOSSignInScreen = new SignInScreeniOS();
	DashboardScreeniOS dashboardScreeniOS = new DashboardScreeniOS();

	@Given("user Clicks on {string} button in dashboard screen for iOS")
	public void user_Clicks_on_button_in_dashboard_screen_for_iOS(String btnName) throws InterruptedException {
		//		Thread.sleep(10000);
		dashboardScreeniOS.dashboardBtnClickiOS(btnName);
		Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");
	}	

	@Then("user should be displayed with Dashboard screen for iOS")
	public void user_should_be_displayed_with_Dashboard_screen_for_iOS() throws InterruptedException {
		Thread.sleep(3000);
		boolean flag = dashboardScreeniOS.dashboardScreenFieldValidationsiOS();
		Assert.assertTrue(flag, "Error...Expected fields do not appear in Dashboard screen...");
	}

	@Given("user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS")
	public void user_is_on_the_dashboard_screen_they_should_be_displayed_with_pillbox_with_down_arrow() {
		boolean flag = dashboardScreeniOS.pillBoxDisplayiOS();
		Assert.assertTrue(flag, "Error...Expected pillbox fields do not appear on the Dashboard screen...");
	}

	@Then("user should be displayed with welcome back your current portfolio section including the performance arrow on iOS")
	public void user_should_be_displayed_with_welcome_back_your_current_portfolio_section_including_the_performance_arrow_on_iOS() {
		boolean flag = dashboardScreeniOS.welcomeBackPortfolioDisplayiOS();
		Assert.assertTrue(flag, "Error...Expected welcome back fields do not appear on the Dashboard screen...");
	}

	@Then("user should be displayed with Portfolio summary value details on iOS")
	public void user_should_be_displayed_with_Portfolio_summary_value_details_on_iOS() {
		boolean flag = dashboardScreeniOS.portfolioSummaryValueDetailsDisplayiOS();
		Assert.assertTrue(flag, "Error...Expected summary value fields do not appear on the Dashboard screen...");
		Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");
	}

	@Then("user should be displayed with bottom naviagation options for portfolio,contact,investments,insights and more on iOS")
	public void user_should_be_displayed_with_bottom_naviagation_options_for_portfolio_contact_investments_insights_and_more_on_iOS() {
		boolean flag = dashboardScreeniOS.bottomNavigationDisplayiOS();
		Assert.assertTrue(flag, "Error...Expected bottom navigation options do not appear on the Dashboard screen...");
		Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");
	}

	@Then("user should be able to pull down the screen to refresh the details for iOS")
	public void user_should_be_able_to_pull_down_the_screen_to_refresh_the_details_for_iOS() throws InterruptedException {
		//		Thread.sleep(10000);
		MobileElement startingElement= (MobileElement) action.getElement("WELCOME_BACK_TXT");
		MobileElement endingElement= (MobileElement) action.getElement("PORTFOLIO_SUMMARY_REFRESH_TIME_TXT");
		dashboardScreeniOS.swipeiOS(startingElement, endingElement);   
		boolean flag = dashboardScreeniOS.dashboardScreenFieldValidationsiOS();
		Assert.assertTrue(flag, "Error...Expected fields do not appear in Dashboard screen...");
		Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");
	}

	@Then("user should verify the value of date format displayed on screen for iOS")
	public void user_should_verify_the_value_of_date_format_displayed_on_screen_for_iOS() {
		Date date = new Date();

		String timeValueString = iOSSignInScreen.getTextiOS("PORTFOLIO_SUMMARY_REFRESH_TIME_TXT");
		String splitValues[] = timeValueString.split("2022");
		String split = splitValues[1];
		String timeOnScreen = split.substring(2, 6);

		@SuppressWarnings("deprecation")
		int hours = date.getHours()-12;

		@SuppressWarnings("deprecation")
		int year = date.getYear();
		System.out.println(year);

		@SuppressWarnings("deprecation")
		int minutes = date.getMinutes();
		String actualTime = hours +"."+ minutes;

		Assert.assertEquals(timeOnScreen, actualTime, "Error... Time mismatch between system and app.");
		Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");

		//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		//		String formattedDate = sdf.format(date);
		//		System.out.println(formattedDate);

	}

	@Then("user selects one of the Account from yours Accounts screen for iOS")
	public void user_selects_one_of_the_Account_from_yours_Accounts_screen_for_iOS() {
		DeviceActions.click((MobileElement) action.getElement("PORTFOLIO_ACCOUNT_NAME_YOUR_ACCOUNTS_1"));
		Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");

	}

	@Then("user should verify the Total Portfolio value is matching with sum of all portfolio values for iOS")
	public void user_should_verify_the_Total_Portfolio_value_is_matching_with_sum_of_all_portfolio_values_for_iOS() {
		
		List<Object> accounts = action.getElements("TOTAL_ACCOUNTS_IN_ACCOUNTS_SCREEN");
		int totalAccounts = accounts.size()-1;
		System.out.println(totalAccounts);
		String value1 = "$12,123,45";
		String value2 = "$12,123,50";
		int x = Integer.parseInt(value1.substring(1).replace(",", ""));
		int y = Integer.parseInt(value2.substring(1).replace(",", ""));
		System.out.println(x + y);
		for (int i=0; i<totalAccounts; i++) {
			
			
		}
	}

}
