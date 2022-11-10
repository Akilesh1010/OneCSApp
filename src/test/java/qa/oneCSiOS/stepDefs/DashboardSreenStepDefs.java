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
import qa.oneCSiOS.pages.IOSSignInScreen;

public class DashboardSreenStepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSApp_iOS"));
	IOSSignInScreen iOSHomeScreen = new IOSSignInScreen();
	DashboardScreen dashboardScreen = new DashboardScreen();

	@Given("user Clicks on {string} button in dashboard screen for iOS")
	public void user_Clicks_on_button_in_dashboard_screen_for_iOS(String btnName) throws InterruptedException {
		//		Thread.sleep(10000);
		dashboardScreen.dashboardBtnClickiOS(btnName);
		Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");
	}	

	@Then("user should be displayed with Dashboard screen for iOS")
	public void user_should_be_displayed_with_Dashboard_screen_for_iOS() throws InterruptedException {
		Thread.sleep(3000);
		boolean flag = dashboardScreen.dashboardScreenFieldValidations();
		Assert.assertTrue(flag, "Error...Expected fields do not appear in Dashboard screen...");
	}

	@Then("user clicks on {string} from more menu for iOS")
	public void user_clicks_on_from_more_menu_for_iOS(String btnName) {
		
	}
	
	@Given("user is on the dashboard screen they should be displayed with pillbox with down arrow for iOS")
	public void user_is_on_the_dashboard_screen_they_should_be_displayed_with_pillbox_with_down_arrow() {
		boolean flag = dashboardScreen.pillBoxDisplayiOS();
		Assert.assertTrue(flag, "Error...Expected pillbox fields do not appear on the Dashboard screen...");
	}
	
	@Then("user should be displayed with welcome back your current portfolio section including the performance arrow on iOS")
	public void user_should_be_displayed_with_welcome_back_your_current_portfolio_section_including_the_performance_arrow_on_iOS() {
		boolean flag = dashboardScreen.welcomeBackPortfolioDisplayiOS();
		Assert.assertTrue(flag, "Error...Expected welcome back fields do not appear on the Dashboard screen...");
	}
	
	@Then("user should be displayed with Portfolio summary value details on iOS")
	public void user_should_be_displayed_with_Portfolio_summary_value_details_on_iOS() {
		boolean flag = dashboardScreen.portfolioSummaryValueDetailsDisplayiOS();
		Assert.assertTrue(flag, "Error...Expected summary value fields do not appear on the Dashboard screen...");
	}
	
	@Then("user should be displayed with bottom naviagation options for portfolio,contact,investments,insights and more on iOS")
	public void user_should_be_displayed_with_bottom_naviagation_options_for_portfolio_contact_investments_insights_and_more_on_iOS() {
		boolean flag = dashboardScreen.portfolioSummaryValueDetailsDisplayiOS();
		Assert.assertTrue(flag, "Error...Expected bottom navigation options do not appear on the Dashboard screen...");
	}
	

}
