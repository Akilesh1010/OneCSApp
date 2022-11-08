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

public class DashboardSreenStepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSApp_iOS"));
	IOSHomeScreen iOSHomeScreen = new IOSHomeScreen();
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
	
	
}
