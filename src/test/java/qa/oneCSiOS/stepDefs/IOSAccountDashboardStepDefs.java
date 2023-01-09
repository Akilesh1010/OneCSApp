package qa.oneCSiOS.stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

	@Then("user should be displayed with your current value is label and the {string} on iOS")
	public void user_should_be_displayed_with_your_current_value_is_label_and_the_on_iOS(String perfomanceIndicator) {
		boolean flag = accountDashboardiOS.yourCurrentValueIsAndPerformanceIndicatorDisplayInAccountDashboardiOS(perfomanceIndicator);
		Assert.assertTrue(flag, "Error...Your account value is label and perfomanceIndicator fields do not appear on the Account Dashboard screen...");

	}

	@Then("user confirms the value of the portfolio change is shown as a percentage figure for iOS")
	public void user_confirms_the_value_of_the_portfolio_change_is_shown_as_a_percentage_figure_for_iOS() {
		String percentage = iOSSignInScreen.getTextiOS("ACCOUNT_SUMMARY_VALUE_CHANGE_LABEL");
		boolean flag = percentage.contains("%");
		Assert.assertTrue(flag, "Error...value is not shown in percentage value");

	}

	@Then("user should see {string} Account Value Change in the Account Dashboard screen for iOS")
	public void user_should_see_Account_Value_Change_in_the_Account_Dashboard_screen_for_iOS(String performanceIndicator) {
		String totalPortfolioValue = DeviceActions.getText((MobileElement) action.getElement("ACCOUNT_SUMMARY_VALUE_CHANGE_LABEL"));
		String[] valueChangeSplit = totalPortfolioValue.split(" ");

		if(performanceIndicator.equalsIgnoreCase("positive")) {
			boolean postiveSign = valueChangeSplit[0].contains("+");
			AssertLogger.assertTrue(postiveSign, "Postive sign does not appear in Account Value Change field..");
			System.out.println(postiveSign);
		}
		else if(performanceIndicator.equalsIgnoreCase("negative")) {
			boolean negativeSign = valueChangeSplit[0].contains("-");
			AssertLogger.assertTrue(negativeSign, "Negative sign does not appear in Account Value Change field..");
		}
	}


	@Then("user should see {string} Sign in the Percentage value on the Account Dashboard screen for iOS")
	public void user_should_see_Sign_in_the_Percentage_value_on_the_Account_Dashboard_screen_for_iOS(String performanceIndicator) {
		String totalPortfolioValue = DeviceActions.getText((MobileElement) action.getElement("ACCOUNT_SUMMARY_VALUE_CHANGE_LABEL"));
		String[] valueChangeSplit = totalPortfolioValue.split(" ");

		if(performanceIndicator.equalsIgnoreCase("Positive")) {
			boolean postivepPrcentageSign = valueChangeSplit[2].contains("+");
			AssertLogger.assertTrue(postivepPrcentageSign, "Postive sign does not appear in Account Percentage field..");
		}
		else if(performanceIndicator.equalsIgnoreCase("negative")) {
			boolean negativePercentageSign = valueChangeSplit[2].contains("-");
			AssertLogger.assertTrue(negativePercentageSign, "Negative sign does not appear in Account Percentage field..");
		}
	}

	@Then("user should be able to swipe Up the screen to maximize the Cost information pop to full screen on iOS")
	public void user_should_be_able_to_swipe_Up_the_screen_to_maximize_the_Cost_information_pop_to_full_screen_on_iOS() {
		MobileElement startingElement= (MobileElement) action.getElement("GOT_IT_BTN");
		MobileElement endingElement= (MobileElement) action.getElement("COST_INFO_POP_UP_TITLE");
		dashboardScreeniOS.swipeiOS(startingElement, endingElement);
		Reporter.addDeviceScreenshot("Account Breakdown", "Cost information pop up..");
	}

	@Then("user should be able to swipe down the screen to close the Cost information pop on iOS")
	public void user_should_be_able_to_swipe_down_the_screen_to_close_the_Cost_information_pop_on_iOS() {
		MobileElement startingElement= (MobileElement) action.getElement("COST_INFO_POP_UP_TITLE");
		MobileElement endingElement= (MobileElement) action.getElement("GOT_IT_BTN");
		dashboardScreeniOS.swipeiOS(startingElement, endingElement);
		Reporter.addDeviceScreenshot("Account Breakdown", "Cost information pop up..");
	}

	@Then("verify the {string} symbol is displayed on accounts screen for iOS")
	public void verify_the_symbol_is_displayed_on_accounts_screen_for_iOS(String symbol) {
		String actual= DeviceActions.getAttribute((MobileElement) action.getElement("EYE_SIGN_IN_ACCOUNT_DASHBOARD_BTN"), "label");

		if(symbol.equalsIgnoreCase("open eye")) {
			AssertLogger.assertEquals(actual, "ic eye", "Error..... Expected field not displayed");

		}
		else if(symbol.equalsIgnoreCase("closed eye") ) {
			AssertLogger.assertEquals(actual, "ic eye crossed", "Error..... Expected field not displayed.");
		}
		Reporter.addDeviceScreenshot("Portfolio screen", "Eye symbol display in portfolio screen"); 
	}

	@Then("user should see the {string} field value is hidden on the account dashboard screen for iOS")
	public void user_should_see_the_field_value_is_hidden_on_the_account_dashboard_screen_for_iOS(String fieldName) {
		String actual= DeviceActions.getAttribute((MobileElement) action.getElement(fieldName), "value");

		if(fieldName.equalsIgnoreCase("ACCOUNT_SUMMARY_TOTAL_VALUE_LABEL")|| fieldName.equalsIgnoreCase("PORTFOLIO_ACCOUNT_TOTAL_VALUE_1")|| 
				fieldName.equalsIgnoreCase("PORTFOLIO_ACCOUNT_VALUE_CHANGE_1")||fieldName.equalsIgnoreCase("PORTFOLIO_ACCOUNT_CODE_1")) {
			boolean flag = actual.matches(".*[0-9].*");
			Assert.assertFalse(flag, "Error..... Expected field not displayed.");
			//			AssertLogger.assertEquals(actual, "Hidden value", "Error..... Expected field not displayed.");
		}

		else if(fieldName.equalsIgnoreCase("ACCOUNT_SUMMARY_VALUE_CHANGE_LABEL")) {
			String[] split = actual.split(" ");
			boolean flag = split[0].matches(".*[0-9].*");
			Assert.assertFalse(flag, "Error...Expected field not displayed.");

			//			AssertLogger.assertEquals(split[0], "+£-,---,---.--", "Error..... Expected field not displayed.");
		}

		Reporter.addDeviceScreenshot("Portfolio screen", "Portfolio Summmary value and Value change fileds display in portfolio screen");
	}

	@Then("user should still see the Percentage value is retained in account dashboard {string} for iOS")
	public void user_should_still_see_the_Percentage_value_is_retained_in_account_dashboard_for_iOS(String fieldName) {
		String actual= DeviceActions.getAttribute((MobileElement) action.getElement(fieldName), "value");
		boolean flag = false;
		if(fieldName.equalsIgnoreCase("ACCOUNT_SUMMARY_VALUE_CHANGE_LABEL")) {
			String[] split = actual.split(" ");
			flag = split[2].matches(".*[0-9].*");
		}
		else if(fieldName.equalsIgnoreCase("ACCOUNT_HOLDING_PERCENTAGE_CHANGE_1")){
			flag = actual.matches(".*[0-9].*");
		}

		Assert.assertTrue(flag, "Error...Percentage field not retained.");
		Reporter.addDeviceScreenshot("Portfolio screen", "");

	}
	@Then("user waits until Investment breakdown details are displayed on screen for iOS")
	public void user_waits_until_Investment_breakdown_details_are_displayed_on_screen_for_iOS() {
		wait.until(ExpectedConditions.invisibilityOf((MobileElement) action.getElement("DASH_SIGN_IN_PORTFOLIO_BREAKDOWN")));
	}
	
	@Then("user should see the {string} field is hidden on the Account breakdown screen for iOS")
	public void user_should_see_the_field_is_hidden_on_the_Account_breakdown_screen_for_iOS(String fieldName) {
		String actual= DeviceActions.getAttribute((MobileElement) action.getElement(fieldName), "value");
		if(fieldName.equalsIgnoreCase("PORTFOLIO_VALUE_IN_ACCOUNT_BREAKDOWN")) {
			AssertLogger.assertEquals(actual, "£---,---.--", "Error..... Expected breakdown field displayed on screen.");
		}

		else if(fieldName.equalsIgnoreCase("CASH_VALUE_IN_ACCOUNT_BREAKDOWN")) {
			AssertLogger.assertEquals(actual, "£---,---.--", "Error..... Expected breakdown field displayed on screen.");
		}
		Reporter.addDeviceScreenshot("Account Breakdown screen", "Account breakdown");

	}


}
