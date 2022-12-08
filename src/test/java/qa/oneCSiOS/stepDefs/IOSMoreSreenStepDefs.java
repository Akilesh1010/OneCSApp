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
import qa.oneCSiOS.pages.DashboardScreeniOS;
import qa.oneCSiOS.pages.MoreMenuScreeniOS;
import qa.oneCSiOS.pages.SignInScreeniOS;

public class IOSMoreSreenStepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));
	SignInScreeniOS iOSSignInScreen = new SignInScreeniOS();
	DashboardScreeniOS dashboardScreeniOS = new DashboardScreeniOS();
	MoreMenuScreeniOS moreScreeniOS = new MoreMenuScreeniOS();


	@Then("user should see {string} as tittle in more options Screen for iOS")
	public void user_should_see_as_tittle_in_more_options_Screen_for_iOS(String Onecs) {
		Assert.assertEquals(Onecs, iOSSignInScreen.getTextiOS("ONECS_TXT_MORE_MENU")); 
		Reporter.addDeviceScreenshot("More Screen", "More menu validations");
	}

	@When("user Signs Out the Mobile Application for iOS")
	public void user_Signs_Out_the_Mobile_Application_for_iOS() {
		DeviceActions.scroll("down");
		DeviceActions.click((MobileElement) action.getElement("SIGN_OUT_BTN"));

	}

	@Then("user should see below four categories in more screen for iOS")
	public void user_should_see_below_four_categories_in_more_screen_for_iOS(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = moreScreeniOS.getMoreScreenLabelsiOS();
		AssertLogger.assertEquals(pageValues, data, "Error..... More screen labels does not match");
		Reporter.addDeviceScreenshot("More Screen", "More menu validations");
	}

	@Then("user should be displayed with below options under User Settings section in iOS")
	public void user_should_be_displayed_with_below_options_under_User_Settings_section_in_iOS(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = moreScreeniOS.getUserSettingsLablesiOS();
		AssertLogger.assertEquals(pageValues, data, "Error..... Mobile screen values does not match");

		boolean flag = moreScreeniOS.userSettingsImageAndChevronDisplayiOS();
		Assert.assertTrue(flag, "Error... User settings Image and chevron not displayed.");

		Reporter.addDeviceScreenshot("More Screen", "User settings validations");
	}

	@Then("user should be displayed with below options under Help & Suppport section in iOS")
	public void user_should_be_displayed_with_below_options_under_Help_Suppport_section_in_iOS(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = moreScreeniOS.getHelpAndSupportLablesiOS();
		AssertLogger.assertEquals(pageValues, data, "Error..... Help & Support labels does not match");

		boolean flag = moreScreeniOS.helpAndSupportImageAndChevronDisplayiOS();
		Assert.assertTrue(flag, "Error... Help & Support Image and chevron not displayed.");

		Reporter.addDeviceScreenshot("More Screen", "Help & Support validations");

	}

	@Then("user should be displayed with below options under Markets Info section in iOS")
	public void user_should_be_displayed_with_below_options_under_Markets_Info_section_in_iOS(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = moreScreeniOS.getMarketInformationLablesiOS();
		AssertLogger.assertEquals(pageValues, data, "Error..... Market Information labels does not match");

		boolean flag = moreScreeniOS.marketInfoImageAndChevronDisplayiOS();
		Assert.assertTrue(flag, "Error... Market Information Image and chevron not displayed.");

		Reporter.addDeviceScreenshot("More Screen", "Market Infomration validations");
	}


	@Then("user should be displayed with below options under About Charles Stanley section in iOS")
	public void user_should_be_displayed_with_below_options_under_About_Charles_Stanley_section_in_iOS(DataTable dataTable) {
		List<String> data = dataTable.asList();
		List<String> pageValues = moreScreeniOS.getAboutCSLablesiOS();
		AssertLogger.assertEquals(pageValues, data, "Error..... About Charles Stanley labels does not match");

		boolean flag = moreScreeniOS.aboutCSImageAndChevronDisplayiOS();
		Assert.assertTrue(flag, "Error... About Charles Stanley Image and chevron not displayed.");

		Reporter.addDeviceScreenshot("More Screen", "About Charles Stanley validations");

	}

}
