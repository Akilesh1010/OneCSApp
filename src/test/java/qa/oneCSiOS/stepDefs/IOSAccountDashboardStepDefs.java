package qa.oneCSiOS.stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
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
import qa.oneCSiOS.pages.AccountDashboardScreeniOS;
import qa.oneCSiOS.pages.DashboardScreeniOS;
import qa.oneCSiOS.pages.SignInScreeniOS;

public class IOSAccountDashboardStepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));
	SignInScreeniOS iOSSignInScreen = new SignInScreeniOS();
	DashboardScreeniOS dashboardScreeniOS = new DashboardScreeniOS();
	AccountDashboardScreeniOS accountDashboardiOS = new AccountDashboardScreeniOS();
	WebDriverWait wait = new WebDriverWait(DeviceDriverManager.getDriver(), 30);

	@Then("user should see the Account Dashboard fields displayed on screen for iOS")
	public void user_should_see_the_Account_Dashboard_fields_displayed_on_screen_for_iOS() {
		boolean flag = accountDashboardiOS.accountDashboardScreenFieldValidationsiOS();
		Assert.assertTrue(flag, "Error... Account Dashboard fields not appeared on screen."); 
		Reporter.addDeviceScreenshot("Account Dashboard screen", "");

	}

	@Then("user should be able to pull down the Account dashboard screen to refresh the details for iOS")
	public void user_should_be_able_to_pull_down_the_Account_dashboard_screen_to_refresh_the_details_for_iOS() {
		MobileElement startingElement= (MobileElement) action.getElement("ACCOUNT_SUMMARY_NAME_LABEL_TXT");
		MobileElement endingElement= (MobileElement) action.getElement("PORTFOLIO_TAB");
		dashboardScreeniOS.swipeiOS(startingElement, endingElement);   
		Reporter.addDeviceScreenshot("Account Dashboard Screen", "Mobile App Account Dashboard Screen");
	}
	
	@Then("user navigates to More tab and should be able to find the value change in {string} in Accounts Dashboard screen for iOS")
	public void user_navigates_to_More_tab_and_should_be_able_to_find_the_value_change_in_in_Accounts_Dashboard_screen_for_iOS(String accountName) throws InterruptedException {
	String AccValueBeforeRefresh = iOSSignInScreen.getTextiOS("ACCOUNT_SUMMARY_TOTAL_VALUE_LABEL");
		DeviceActions.click((MobileElement) action.getElement("MORE_TAB"));
		Thread.sleep(4000);
		DeviceActions.click((MobileElement) action.getElement("PORTFOLIO_TAB"));
		DeviceActions.click((MobileElement) action.getElement("PORTFOLIO_TAB"));
		Thread.sleep(2000);
		DeviceActions.click((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@value=\""+accountName+"\"]")));
		
		String AccValueAfterRefresh = iOSSignInScreen.getTextiOS("ACCOUNT_SUMMARY_TOTAL_VALUE_LABEL");
		Assert.assertNotEquals(AccValueBeforeRefresh, AccValueAfterRefresh, "Error.. Values matched.");
	}


}
