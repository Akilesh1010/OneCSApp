package qa.oneCSiOS.stepDefs;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.framework.assertions.AssertLogger;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.device.DeviceDriverManager;
import qa.framework.utils.Reporter;
import qa.oneCSiOS.pages.DashboardScreeniOS;
import qa.oneCSiOS.pages.SignInScreeniOS;

public class IOSDashboardSreenStepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));
	SignInScreeniOS iOSSignInScreen = new SignInScreeniOS();
	DashboardScreeniOS dashboardScreeniOS = new DashboardScreeniOS();
	WebDriverWait wait = new WebDriverWait(DeviceDriverManager.getDriver(), 30);

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
		if(action.isPresent("PROGRESS_CIRCLE_ICON")) {
			wait.until(ExpectedConditions.invisibilityOf((MobileElement) action.getElement("PROGRESS_CIRCLE_ICON")));
		}
		
		boolean flag = dashboardScreeniOS.pillBoxDisplayiOS();
		Assert.assertTrue(flag, "Error...Expected pillbox fields do not appear on the Dashboard screen...");
	}

	@Then("user should be displayed with welcome back your current portfolio section including the {string} on iOS")
	public void user_should_be_displayed_with_welcome_back_your_current_portfolio_section_including_the_on_iOS(String perfomanceIndicator) {
		boolean flag = dashboardScreeniOS.welcomeBackPortfolioDisplayiOS(perfomanceIndicator);
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
		MobileElement endingElement= (MobileElement) action.getElement("PORTFOLIO_TAB");
		dashboardScreeniOS.swipeiOS(startingElement, endingElement);   
		boolean flag = dashboardScreeniOS.dashboardScreenFieldValidationsiOS();
		Assert.assertTrue(flag, "Error...Expected fields do not appear in Dashboard screen...");
		Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");
	}

	@Then("user should verify the value of date format displayed correctly on the {string} screen for iOS")
	public void user_should_verify_the_value_of_date_format_displayed_on_screen_for_iOS(String screenName) {
		Date date = new Date();

		if(screenName.equalsIgnoreCase("Portfolio dashboard")) {
			String timeValueString = iOSSignInScreen.getTextiOS("PORTFOLIO_SUMMARY_REFRESH_TIME_TXT");
			String splitValues[] = timeValueString.split("2022");
			String timeInApp = splitValues[1].substring(2, 6);
			@SuppressWarnings("deprecation")
			int hours = date.getHours()-12;

			//		@SuppressWarnings("deprecation")
			//		int year = date.getYear();

			@SuppressWarnings("deprecation")
			int minutes = date.getMinutes();
			String systemTime = hours +"."+ minutes;
			//		System.out.println(actualTime);

			AssertLogger.assertEquals(timeInApp, systemTime, "Error... Time mismatch between system and app");

			//		Assert.assertEquals(timeOnScreen, actualTime, "Error... Time mismatch between system and app.");
			Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");

			//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
			//		String formattedDate = sdf.format(date);
			//		System.out.println(formattedDate);
		}
		else if (screenName.equalsIgnoreCase("Your accounts")) {
			String timeValueString = iOSSignInScreen.getTextiOS("YOUR_ACCOUNTS_TIME_STAMP_LABEL");
			String splitValues[] = timeValueString.split("2022");
			String timeInApp = splitValues[1].substring(2, 6);
			@SuppressWarnings("deprecation")
			int hours = date.getHours()-12;

			@SuppressWarnings("deprecation")
			int minutes = date.getMinutes();
			String systemTime = hours +"."+ minutes;

			AssertLogger.assertEquals(timeInApp, systemTime, "Error... Time mismatch between system and app.");

			Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");

		}	

	}

	@Then("user selects one of the Account from yours Accounts screen for iOS")
	public void user_selects_one_of_the_Account_from_yours_Accounts_screen_for_iOS() {
		DeviceActions.click((MobileElement) action.getElement("PORTFOLIO_ACCOUNT_NAME_YOUR_ACCOUNTS_1"));
//		if (action.isPresent("PROGRESS_CIRCLE_ICON")) {
//			wait.until(ExpectedConditions.invisibilityOf((MobileElement) action.getElement("PROGRESS_CIRCLE_ICON")));
//		}
		Reporter.addDeviceScreenshot("Dashboard Screen", "Mobile App Dashboard Screen");
	}

	//*************PORTFOLIO TOTAL VALUE --VS-- SUM OF ALL PORTFOLIO VALUES****************
	@SuppressWarnings("rawtypes")
	@Then("user should see the Total Portfolio value is matching with sum of all portfolio values for iOS")
	public void user_should_see_the_Total_Portfolio_value_is_matching_with_sum_of_all_portfolio_values_for_iOS() {

		//		String totalPortfolioValue = DeviceActions.getText((MobileElement) action.getElement("PORTFOLIO_SUMMARY_TOTAL_VALUE_TXT"));
		//		String PortfolioValue = totalPortfolioValue.substring(1).replace(",", "");
		//		System.out.println(PortfolioValue);



		String totalPortfolioValue = DeviceActions.getText((MobileElement) action.getElement("PORTFOLIO_SUMMARY_TOTAL_VALUE_TXT"));
		Double portfolioValue = Double.parseDouble(totalPortfolioValue.substring(1).replace(",", ""));
		System.out.println("Portfolio value is: "+ portfolioValue);
		BigDecimal portValue = BigDecimal.valueOf(portfolioValue);
		//		System.out.println(portValue);

		dashboardScreeniOS.swipeByCooardinatesiOS(150, 700, 100, 200);

		//
		//		List<Object> accounts = action.getElements("TOTAL_ACCOUNTS_IN_ACCOUNTS_SCREEN");
		//		Double total = 0.0;
		//		int totalAccounts = accounts.size()-1;
		//		System.out.println(totalAccounts);	

		//		for (int i=0; i<totalAccounts; i++) {
		//			String accountValues = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+i+"-total-value\"]")));
		//			Double sumValue = Double.parseDouble(accountValues.substring(1).replace(",", ""));
		//			System.out.println(sumValue);
		//			total = total.doubleValue() + sumValue;
		//			System.out.println("Total value is: " +total);
		//		}

		//		DecimalFormat df = new DecimalFormat("0.00");
		//		//		df.setMaximumFractionDigits(2);
		//		String IndividualAccountsTotal = df.format(total);
		//		Assert.assertEquals(IndividualAccountsTotal, portfolioValue, "Error..... Portfolio & Account values does not match");


		String value1 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+0+"-total-value\"]")));
		Double sumValue1 = Double.parseDouble(value1.substring(1).replace(",", ""));
		BigDecimal bd1 = BigDecimal.valueOf(sumValue1);
		System.out.println(bd1);

		String value2 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+1+"-total-value\"]")));
		Double sumValue2 = Double.parseDouble(value2.substring(1).replace(",", ""));
		BigDecimal bd2 = BigDecimal.valueOf(sumValue2);
		System.out.println(bd2);

		String value3 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+2+"-total-value\"]")));
		Double sumValue3 = Double.parseDouble(value3.substring(1).replace(",", ""));
		BigDecimal bd3 = BigDecimal.valueOf(sumValue3);
		System.out.println(bd3);

		String value4 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+3+"-total-value\"]")));
		Double sumValue4 = Double.parseDouble(value4.substring(1).replace(",", ""));
		BigDecimal bd4 = BigDecimal.valueOf(sumValue4);
		System.out.println(bd4);

		DeviceActions.scroll("down");

		String value5 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+4+"-total-value\"]")));
		Double sumValue5 = Double.parseDouble(value5.substring(1).replace(",", ""));
		BigDecimal bd5 = BigDecimal.valueOf(sumValue5);
		System.out.println(bd5);

		String value6 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+5+"-total-value\"]")));
		Double sumValue6 = Double.parseDouble(value6.substring(1).replace(",", ""));
		BigDecimal bd6 = BigDecimal.valueOf(sumValue6);
		System.out.println(bd6);

		String value7 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+6+"-total-value\"]")));
		Double sumValue7 = Double.parseDouble(value7.substring(1).replace(",", ""));
		BigDecimal bd7 = BigDecimal.valueOf(sumValue7);
		System.out.println(bd7);

		BigDecimal totalAccountValues = bd1.add(bd2).add(bd3).add(bd4).add(bd5).add(bd6).add(bd7);

		System.out.println(totalAccountValues);
		
		DeviceActions.click((MobileElement) action.getElement("HOLDINGS_DRAG_UP_BTN"));
		
//		Assert.assertTrue(totalAccountValues.compareTo(totalAccountValues), "");

		AssertLogger.assertEquals(totalAccountValues.compareTo(totalAccountValues), portValue, "Error..... Portfolio & Account values does not match");
	}

	//	*************PORTFOLIO TOTAL VALUE CHANGE --VS-- SUM OF ALL PORTFOLIO VALUE CHANGE ****************
	@Then("user should see the Total Portfolio Value Change is matching with sum of all Portfolio Value Change for iOS")
	public void user_should_see_the_Total_Portfolio_Value_Change_is_matching_with_sum_of_all_Portfolio_Value_Change_for_iOS() {
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("PORTFOLIO_SUMMARY_TOTAL_VALUE_TXT")));
		String totalPortfolioValue = DeviceActions.getText((MobileElement) action.getElement("PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT"));
		String[] splitTotal = totalPortfolioValue.substring(2).split(" ");
		Double PortfolioValue = Double.parseDouble(splitTotal[0].replace(",", ""));
		BigDecimal portValueChange = BigDecimal.valueOf(PortfolioValue);
		System.out.println(portValueChange);

		dashboardScreeniOS.swipeByCooardinatesiOS(150, 700, 100, 200);

		String value1 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+0+"-value-change\"]")));
		String[] split1 = value1.substring(2).split(" ");
		Double sumValue1 = Double.parseDouble(split1[0].replace(",", ""));
		BigDecimal bd1 = BigDecimal.valueOf(sumValue1);
		System.out.println(bd1);

		String value2 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+1+"-value-change\"]")));
		String[] split2 = value2.substring(2).split(" ");
		Double sumValue2 = Double.parseDouble(split2[0].replace(",", ""));
		BigDecimal bd2 = BigDecimal.valueOf(sumValue2);
		System.out.println(bd2);

		String value3 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+2+"-value-change\"]")));
		String[] split3 = value3.substring(2).split(" ");
		Double sumValue3 = Double.parseDouble(split3[0].replace(",", ""));
		BigDecimal bd3 = BigDecimal.valueOf(sumValue3);
		System.out.println(bd3);

		String value4 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+3+"-value-change\"]")));
		String[] split4 = value4.substring(2).split(" ");
		Double sumValue4 = Double.parseDouble(split4[0].replace(",", ""));
		BigDecimal bd4 = BigDecimal.valueOf(sumValue4);
		System.out.println(bd4);

		DeviceActions.scroll("down");

		String value5 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+4+"-value-change\"]")));
		String[] split5 = value5.substring(2).split(" ");
		Double sumValue5 = Double.parseDouble(split5[0].replace(",", ""));
		BigDecimal bd5 = BigDecimal.valueOf(sumValue5);
		System.out.println(bd5);

		String value6 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+5+"-value-change\"]")));
		String[] split6 = value6.substring(2).split(" ");
		Double sumValue6 = Double.parseDouble(split6[0].replace(",", ""));
		BigDecimal bd6 = BigDecimal.valueOf(sumValue6);
		System.out.println(bd6);

		String value7 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+6+"-value-change\"]")));
		String[] split7 = value7.substring(2).split(" ");
		Double sumValue7 = Double.parseDouble(split7[0].replace(",", ""));
		BigDecimal bd7 = BigDecimal.valueOf(sumValue7);
		System.out.println(bd7);

		BigDecimal totalAccountValueChange = bd1.add(bd2).add(bd3).add(bd4).add(bd5).add(bd6).add(bd7);

		System.out.println(totalAccountValueChange);

		AssertLogger.assertEquals(totalAccountValueChange, portValueChange, "Error..... Total Portfolio Value Change & Sum of Account Value Change does not match");
	}

	@Then("user selects the {string} from Your accounts screen for iOS")
	public void user_selects_the_from_Your_accounts_screen_for_iOS(String accountName) {
		if(action.isPresent("PROGRESS_CIRCLE_ICON")) {
			wait.until(ExpectedConditions.invisibilityOf((MobileElement) action.getElement("PROGRESS_CIRCLE_ICON")));
		}
		DeviceActions.click((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@value=\""+accountName+"\"]")));
	}

	//	*************ACCOUNT DASHBOARD TOTAL VALUE --VS-- SUM OF ALL HOLDING VALUES ****************
	@Then("user should see the Account Dashboard value is matching with holdings value of the same account for iOS")
	public void user_should_see_the_Account_Dashboard_value_is_matching_with_holdings_value_of_the_same_account_for_iOS() {
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("ACCOUNT_SUMMARY_TOTAL_VALUE_LABEL")));

		String accountSummaryValue = DeviceActions.getText((MobileElement) action.getElement("ACCOUNT_SUMMARY_TOTAL_VALUE_LABEL"));
		Double accountValue = Double.parseDouble(accountSummaryValue.substring(1).replace(",", ""));
		BigDecimal accValue = BigDecimal.valueOf(accountValue);
		System.out.println(accValue);

		DeviceActions.click((MobileElement) action.getElement("YOUR_ACCOUNTS_TAB_MINIMIZE_BTN"));

		String value1 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"account-holding-"+0+"-value\"]")));
		Double sumValue1 = Double.parseDouble(value1.substring(1).replace(",", ""));
		BigDecimal bd1 = BigDecimal.valueOf(sumValue1);
		System.out.println(bd1);

		String value2 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"account-holding-"+1+"-value\"]")));
		Double sumValue2 = Double.parseDouble(value2.substring(1).replace(",", ""));
		BigDecimal bd2 = BigDecimal.valueOf(sumValue2);
		System.out.println(bd2);

		String value3 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"account-holding-"+2+"-value\"]")));
		Double sumValue3 = Double.parseDouble(value3.substring(1).replace(",", ""));
		BigDecimal bd3 = BigDecimal.valueOf(sumValue3);
		System.out.println(bd3);

		String value4 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"account-holding-"+3+"-value\"]")));
		Double sumValue4 = Double.parseDouble(value4.substring(1).replace(",", ""));
		BigDecimal bd4 = BigDecimal.valueOf(sumValue4);
		System.out.println(bd4);

		BigDecimal totalHoldingsValues = bd1.add(bd2).add(bd3).add(bd4);

		System.out.println(totalHoldingsValues);

		DeviceActions.click((MobileElement) action.getElement("HOLDINGS_DRAG_UP_BTN"));

		AssertLogger.assertEquals(totalHoldingsValues, accValue, "Error..... Account dashboard and Holdings values does not match");
	}
	//	*************ACCOUNT DASHBOARD TOTAL VALUE CHANGE --VS-- SUM OF ALL HOLDING VALUE CHANGE ****************
	@Then("user should see the Account Dashboard Value Change is matching with Sum of All Holdings Value Change for iOS")
	public void user_should_see_the_Account_Dashboard_Value_Change_is_matching_with_Sum_of_All_Holdings_Value_Change_for_iOS() {
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("ACCOUNT_SUMMARY_TOTAL_VALUE_LABEL")));
		String totalPortfolioValue = DeviceActions.getText((MobileElement) action.getElement("ACCOUNT_SUMMARY_VALUE_CHANGE_LABEL"));
		String[] splitTotal = totalPortfolioValue.substring(2).split(" ");
		Double PortfolioValue = Double.parseDouble(splitTotal[0].replace(",", ""));
		BigDecimal accValueChange = BigDecimal.valueOf(PortfolioValue);
		System.out.println(accValueChange);

		DeviceActions.click((MobileElement) action.getElement("HOLDINGS_DRAG_UP_BTN"));

		String value1 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"account-holding-"+0+"-value-change\"]")));
		Double sumValue1 = Double.parseDouble(value1.substring(2).replace(",", ""));
		BigDecimal bd1 = BigDecimal.valueOf(sumValue1);
		System.out.println(bd1);

		String value2 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"account-holding-"+1+"-value-change\"]")));
		Double sumValue2 = Double.parseDouble(value2.substring(2).replace(",", ""));
		BigDecimal bd2 = BigDecimal.valueOf(sumValue2);
		System.out.println(bd2);

		String value3 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"account-holding-"+2+"-value-change\"]")));
		Double sumValue3 = Double.parseDouble(value3.substring(2).replace(",", ""));
		BigDecimal bd3 = BigDecimal.valueOf(sumValue3);
		System.out.println(bd3);

		String value4 = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"account-holding-"+3+"-value-change\"]")));
		Double sumValue4 = Double.parseDouble(value4.substring(2).replace(",", ""));
		BigDecimal bd4 = BigDecimal.valueOf(sumValue4);
		System.out.println(bd4);;

		BigDecimal totalHoldingsValueChange = bd1.add(bd2).add(bd3).add(bd4);

		System.out.println(totalHoldingsValueChange);

		AssertLogger.assertEquals(totalHoldingsValueChange, accValueChange, "Error..... Total Portfolio Value Change & Sum of Account Value Change does not match");
	}

	@Then("user should see {string} Portfolio Value Change in the Dashboard screen for iOS")
	public void user_should_see_Portfolio_Value_Change_in_the_Dashboard_screen_for_iOS(String performanceIndicator) {
		String totalPortfolioValue = DeviceActions.getText((MobileElement) action.getElement("PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT"));
		String[] valueChangeSplit = totalPortfolioValue.split(" ");

		if(performanceIndicator.equalsIgnoreCase("positive")) {
			boolean postiveSign = valueChangeSplit[0].contains("+");
			AssertLogger.assertTrue(postiveSign, "Postive sign does not appear in Portfolio Value Change field..");
			System.out.println(postiveSign);
		}
		else if(performanceIndicator.equalsIgnoreCase("negative")) {
			boolean negativeSign = valueChangeSplit[0].contains("-");
			AssertLogger.assertTrue(negativeSign, "Negative sign does not appear in Portfolio Value Change field..");
		}
	}

	@Then("user should see {string} Sign in the Percentage value on the Dashboard screen for iOS")
	public void user_should_see_Sign_in_the_Percentage_value_on_the_Dashboard_screen_for_iOS(String performanceIndicator) {
		String totalPortfolioValue = DeviceActions.getText((MobileElement) action.getElement("PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT"));
		String[] valueChangeSplit = totalPortfolioValue.split(" ");

		if(performanceIndicator.equalsIgnoreCase("Positive")) {
			boolean postivepPrcentageSign = valueChangeSplit[2].contains("+");
			AssertLogger.assertTrue(postivepPrcentageSign, "Postive sign does not appear in Portfolio Percentage field..");
		}
		else if(performanceIndicator.equalsIgnoreCase("Negative")) {
			boolean negativePercentageSign = valueChangeSplit[2].contains("-");
			AssertLogger.assertTrue(negativePercentageSign, "Negative sign does not appear in Portfolio Percentage field..");
		}

	}

	@Then("user should see a back button and Portfolio Breakdown Title at the top of the screen for iOS")
	public void user_should_see_a_back_button_and_Portfolio_Breakdown_Title_at_the_top_of_the_screen_for_iOS() {
		Assert.assertTrue(action.isDisplayed((MobileElement) action.getElement("BACK_BUTTON")));
		Assert.assertTrue(action.isDisplayed((MobileElement) action.getElement("PORTFOLIO_BREAKDOWN_SCREEN_TITLE")));
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("INVESTMENT_BREAKDOWN_LABEL_TXT")));
		Reporter.addDeviceScreenshot("Portfolio Breakdown", "Portfolio Breakdown Screen");
	}

	@Then("user should see the {string} is displayed for iOS")
	public void user_should_see_the_Investment_breakdown_chart_is_displayed_for_iOS(String label) {
		
		Assert.assertTrue(action.isDisplayed((MobileElement) action.getElement(label)));
		Reporter.addDeviceScreenshot(label, "Screen name: "+label);
	}

	@Then("user should see {string},{string} and {string} fields are displayed for iOS")
	public void user_should_see_and_fields_are_displayed_for_iOS(String field1, String field2, String field3) {
		boolean flag = dashboardScreeniOS.fieldsDisplayiOS(field1, field2, field3);
		Assert.assertTrue(flag, "Error...The mentioned fields are not displayed.");
		Reporter.addDeviceScreenshot(field1, "Screen name: "+field1);
	}

	@Then("user swipe up the pop up to the full screen for iOS")
	public void user_swipe_up_the_pop_up_to_the_full_screen_for_iOS() {
		dashboardScreeniOS.swipeByCooardinatesiOS(150, 600, 150, 70);
	}

	@Then("user should be able to scroll {string} and view the list of accounts for iOS")
	public void user_should_be_able_to_scroll_and_view_the_list_of_accounts_for_iOS(String direction) {
		DeviceActions.scroll(direction);
	}

	@Then("user swipe up the Your Accounts screen to the full screen for iOS")
	public void user_swipe_up_the_Your_Accounts_screen_to_the_full_screen_for_iOS() {
		dashboardScreeniOS.swipeByCooardinatesiOS(150, 700, 100, 200);
	}

	@Then("user should see {string} and {string} fields are displayed for iOS")
	public void user_should_see_and_fields_are_displayed_for_iOS(String field1, String field2) {
		boolean flag = dashboardScreeniOS.twoFieldsDisplayiOS(field1, field2);
		Assert.assertTrue(flag, "Error...The mentioned fields are not displayed.");
		Reporter.addDeviceScreenshot(field1, "Screen name: "+field2);
	}

	@Then("user should not see the {string} displayed on screen for iOS")
	public void user_should_not_see_the_displayed_on_screen_for_iOS(String btnName) {
		Assert.assertFalse(action.isPresent(btnName));
		Reporter.addDeviceScreenshot("Mobile Screen", "Button is not displayed"); 
	}

	@Then("verify the {string} symbol is displayed for iOS")
	public void verify_the_symbol_is_displayed_for_iOS(String symbol) {

		String actual= DeviceActions.getAttribute((MobileElement) action.getElement("PORTFOLIO_EYE_ICON_BTN"), "label");

		if(symbol.equalsIgnoreCase("open eye")) {
			AssertLogger.assertEquals(actual, "ic eye", "Error..... Expected field not displayed");

		}
		else if(symbol.equalsIgnoreCase("closed eye") ) {
			AssertLogger.assertEquals(actual, "ic eye crossed", "Error..... Expected field not displayed.");
		}
		Reporter.addDeviceScreenshot("Portfolio screen", "Eye symbol display in portfolio screen");

	}

	@Then("user should see the {string} field value is hidden on the screen for iOS")
	public void user_should_see_the_field_value_is_hidden_on_the_screen_for_iOS(String fieldName) {

		String actual= DeviceActions.getAttribute((MobileElement) action.getElement(fieldName), "value");

		if(fieldName.equalsIgnoreCase("PORTFOLIO_VALUE_TXT")|| fieldName.equalsIgnoreCase("PORTFOLIO_ACCOUNT_TOTAL_VALUE_1")|| 
				fieldName.equalsIgnoreCase("PORTFOLIO_ACCOUNT_VALUE_CHANGE_1")||fieldName.equalsIgnoreCase("PORTFOLIO_ACCOUNT_CODE_1")) {
			boolean flag = actual.matches(".*[0-9].*");
			Assert.assertFalse(flag, "Error..... Expected field not displayed.");
//			AssertLogger.assertEquals(actual, "Hidden value", "Error..... Expected field not displayed.");
		}

		else if(fieldName.equalsIgnoreCase("PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT")) {
			String[] split = actual.split(" ");
			boolean flag = split[0].matches(".*[0-9].*");
			Assert.assertFalse(flag, "Error...Expected field not displayed.");

//			AssertLogger.assertEquals(split[0], "+£-,---,---.--", "Error..... Expected field not displayed.");
		}

		Reporter.addDeviceScreenshot("Portfolio screen", "Portfolio Summmary value and Value change fileds display in portfolio screen");
	}

	@Then("user should still see the Percentage value is retained in the field {string} for iOS")
	public void user_should_still_see_the_Percentage_value_is_retained_in_the_field_for_iOS(String fieldName) {
		String actual= DeviceActions.getAttribute((MobileElement) action.getElement(fieldName), "value");
		boolean flag = false;
		if(fieldName.equalsIgnoreCase("PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT")) {
			String[] split = actual.split(" ");
			flag = split[2].matches(".*[0-9].*");
		}
		else {
			flag = actual.matches(".*[0-9].*");
		}

		Assert.assertTrue(flag, "Error...Percentage field not retained.");
		Reporter.addDeviceScreenshot("Portfolio screen", "");
	}

	@Then("user should see the {string} field value is hidden on the breakdown screen for iOS")
	public void user_should_see_the_field_value_is_hidden_on_the_breakdown_screen_for_iOS(String fieldName) {
		String actual= DeviceActions.getAttribute((MobileElement) action.getElement(fieldName), "value");
		if(fieldName.equalsIgnoreCase("PORTFOLIO_VALUE_IN_PORTFOLIO_BREAKDOWN")) {
			AssertLogger.assertEquals(actual, "£-,---,---.--", "Error..... Expected breakdown field displayed on screen.");
		}

		else if(fieldName.equalsIgnoreCase("PORTFOLIO_CASH_VALUE_IN_PORTFOLIO_BREAKDOWN")) {
			AssertLogger.assertEquals(actual, "£--,---.--", "Error..... Expected breakdown field displayed on screen.");
		}
		Reporter.addDeviceScreenshot("Portfolio screen", "");

	}

	@Then("user push the app to background for {int} seconds and relaunch the app again for iOS")
	public void user_push_the_app_to_background_and_relaunch_the_app_again_for_iOS(int seconds) throws MalformedURLException {
		DeviceDriverManager.runAppInBackground(seconds);
		Reporter.addDeviceScreenshot("Portfolio screen", "");
	}

	@Then("user should see the {string} field value is NOT hidden on the screen for iOS")
	public void user_should_see_the_field_value_is_NOT_hidden_on_the_screen_for_iOS(String fieldName) {
		String actual= DeviceActions.getAttribute((MobileElement) action.getElement(fieldName), "value");
		boolean flag = actual.matches(".*[0-9].*");
		Assert.assertTrue(flag, "Error... Portfolio total value is retained on screen."); 
		Reporter.addDeviceScreenshot("Portfolio screen", "");
	}

	@Then("user should see Show Total for, Close button, All accounts label along with toggle button and Update Total button for iOS")
	public void user_should_see_Show_Total_for_Close_button_All_accounts_label_along_with_toggle_button_and_Update_Total_button_for_iOS() {
		boolean flag = dashboardScreeniOS.showAllScreenPortfolioSettingsiOS();
		Assert.assertTrue(flag, "Error... Portfolio Show all screen fields are not displayed.");
		Reporter.addDeviceScreenshot("Portfolio Show All screen", "");
	}

	@Then("user should see the list accouunts are matching with the accounts displayed in your accounts screen for iOS")
	public void user_should_see_the_list_accouunts_are_matching_with_the_accounts_displayed_in_your_accounts_screen_for_iOS() {
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("ACCOUNTS_LIST_SHOWALL_SCREEN")));
		List<Object> showAllAccounts = action.getElements("ACCOUNTS_LIST_SHOWALL_SCREEN");
		int totalShowAllAccounts = showAllAccounts.size();

		DeviceActions.click((MobileElement) action.getElement("IC_CLOSE_BTN"));
		dashboardScreeniOS.swipeByCooardinatesiOS(150, 700, 100, 200);
		List<Object> yourAccounts = action.getElements("TOTAL_ACCOUNTS_IN_ACCOUNTS_SCREEN");
		int totalYourAccounts = yourAccounts.size()-1;
		AssertLogger.assertEquals(totalYourAccounts, totalShowAllAccounts, "Error...The accounts did not match.");
		DeviceActions.click((MobileElement) action.getElement("YOUR_ACCOUNTS_TAB_MINIMIZE_BTN"));

	}

	@Then("user should not see the Show total for screen for iOS")
	public void user_should_not_see_the_Show_total_for_screen_for_iOS() {
		Assert.assertFalse(action.isPresent("SHOW_TOTAL_FOR_SCREEN_TITLE"), "Error... Portfolio Show all screen fields are not displayed."); 
		Reporter.addDeviceScreenshot("Portfolio Show All screen", "");
	}

	@Then("user should be able to swipe down the screen to minimize the Portfolio Show all screen for iOS")
	public void user_should_be_able_to_swipe_down_the_screen_to_minimize_the_Portfolio_Show_all_screen_for_iOS() {
		MobileElement startingElement= (MobileElement) action.getElement("SHOW_TOTAL_FOR_SCREEN_TITLE");
		MobileElement endingElement= (MobileElement) action.getElement("UPDATE_TOTAL_BTN_SHOW_ALL_SCREEN");
		dashboardScreeniOS.swipeiOS(startingElement, endingElement);
		Reporter.addDeviceScreenshot("Portfolio Show All screen", "");

	}

	@Then("user should see All accounts toggle button is switched ON by default and list of accounts should be ticked for iOS")
	public void user_should_see_All_accounts_toggle_button_is_switched_ON_by_default_and_list_of_accounts_should_be_ticked_for_iOS() {
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("ACCOUNTS_LIST_SHOWALL_SCREEN")));


		String actual= DeviceActions.getAttribute((MobileElement) action.getElement("TOGGLE_BTN_SHOW_ALL_SCREEN"), "value");
		AssertLogger.assertEquals(actual, "1", "Error..... Toggle button is not switched On by default on screen.");

		Assert.assertTrue(action.isPresent("TICKS_IN_SHOWALL_SCREEN"), "Error... Account tick is not displayed.");
		List<Object> showAllAccounts = action.getElements("ACCOUNTS_LIST_SHOWALL_SCREEN");
		int totalShowAllAccounts = showAllAccounts.size();

		List<Object> tickedAccounts = action.getElements("TICKS_IN_SHOWALL_SCREEN");
		int totalTickedAccounts = tickedAccounts.size();
		AssertLogger.assertEquals(totalShowAllAccounts, totalTickedAccounts, "Error...The ticked accounts did not match.");

		Reporter.addDeviceScreenshot("Portfolio Show All screen", "");
	}

	@Then("user should see Update total button is disabled when no account is selected for iOS")
	public void user_should_see_Update_total_button_is_disabled_when_no_account_is_selected_for_iOS() {
		DeviceActions.click((MobileElement) action.getElement("TOGGLE_BTN_SHOW_ALL_SCREEN"));
		String actual= DeviceActions.getAttribute((MobileElement) action.getElement("TOGGLE_BTN_SHOW_ALL_SCREEN"), "enabled");
		boolean flag = Boolean.valueOf(actual);
		Assert.assertTrue(flag, "Error... Portfolio Show all screen fields are not displayed.");
		Reporter.addDeviceScreenshot("Portfolio Show All screen", "");
		DeviceActions.click((MobileElement) action.getElement("TOGGLE_BTN_SHOW_ALL_SCREEN"));
	}

	@Then("user should untick an account from list and closed the Show total for screen without clicking on Update total button for iOS")
	public void user_should_untick_an_account_from_list_and_closed_the_Show_total_for_screen_without_clicking_on_Update_total_button_for_iOS() {
		DeviceActions.click((MobileElement) action.getElement("CHECK_BOX_1_SHOW_TOTAL_FOR_SCREEN"));
		Reporter.addDeviceScreenshot("Portfolio Show Total for screen", "");
		DeviceActions.click((MobileElement) action.getElement("IC_CLOSE_BTN"));
	}

	@Then("user toggle Off All accounts and see ticked sign is removed from all accounts displayed for iOS")
	public void user_toggle_Off_All_accounts_and_see_ticked_sign_is_removed_from_all_accounts_displayed_for_iOS() {
		DeviceActions.click((MobileElement) action.getElement("TOGGLE_BTN_SHOW_ALL_SCREEN"));

		String actual= DeviceActions.getAttribute((MobileElement) action.getElement("TOGGLE_BTN_SHOW_ALL_SCREEN"), "value");
		AssertLogger.assertEquals(actual, "0", "Error..... Toggle button is not switched On by default on screen.");

		Assert.assertFalse(action.isPresent("TICKS_IN_SHOWALL_SCREEN"), "Error... Account tick is not displayed.");
		Reporter.addDeviceScreenshot("Portfolio Show Total for screen", "");
	}

	@When("user clicks on one of the accounts then All accounts toggle button remains off on the screen for iOS")
	public void user_clicks_on_one_of_the_accounts_then_All_accounts_toggle_button_remains_off_on_the_screen_for_iOS() {
		DeviceActions.click((MobileElement) action.getElement("CHECK_BOX_1_SHOW_TOTAL_FOR_SCREEN"));

		String actual= DeviceActions.getAttribute((MobileElement) action.getElement("TOGGLE_BTN_SHOW_ALL_SCREEN"), "value");
		AssertLogger.assertEquals(actual, "0", "Error..... Toggle button is switched ON on the screen.");
		Reporter.addDeviceScreenshot("Portfolio Show Total for screen", "");

	}

	@Then("user selects all displayed accounts then All accounts toggle button should turn On for iOS")
	public void user_selects_all_displayed_accounts_then_All_accounts_toggle_button_should_turn_On_for_iOS() {
		DeviceActions.click((MobileElement) action.getElement("CHECK_BOX_1_SHOW_TOTAL_FOR_SCREEN"));
		List<Object> showAllAccounts = action.getElements("ACCOUNTS_LIST_SHOWALL_SCREEN");

		for ( Object element: showAllAccounts) {
			DeviceActions.click((MobileElement) element);
		}

		String actual= DeviceActions.getAttribute((MobileElement) action.getElement("TOGGLE_BTN_SHOW_ALL_SCREEN"), "value");
		AssertLogger.assertEquals(actual, "1", "Error..... Toggle button is not switched On by default on then screen.");
		Reporter.addDeviceScreenshot("Portfolio Show Total for screen", "");
	}

	@When("user navigate to other screen and return again to show total screen the user selection should be retained for iOS")
	public void user_navigate_to_other_screen_and_return_again_to_show_total_screen_the_user_selection_should_be_retained_for_iOS() {
		DeviceActions.click((MobileElement) action.getElement("IC_CLOSE_BTN"));
		DeviceActions.click((MobileElement) action.getElement("MORE_TAB"));
		Assert.assertEquals("OneCS", iOSSignInScreen.getTextiOS("ONECS_TXT_MORE_MENU"));
		DeviceActions.click((MobileElement) action.getElement("PORTFOLIO_TAB"));
		DeviceActions.click((MobileElement) action.getElement("PORTFOLIO_SHOWALL_TXT"));

		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("ACCOUNTS_LIST_SHOWALL_SCREEN")));

		String actual= DeviceActions.getAttribute((MobileElement) action.getElement("TOGGLE_BTN_SHOW_ALL_SCREEN"), "value");
		AssertLogger.assertEquals(actual, "1", "Error..... Toggle button is NOT switched ON on the screen.");
		Reporter.addDeviceScreenshot("Portfolio Show Total for screen", "");
	}

	@Then("user should see {string} field value displayed as {string} on dashboard screen for iOS")
	public void user_should_see_field_value_displayed_as_on_dashboard_screen_for_iOS(String fieldName, String value) {
		Assert.assertEquals(iOSSignInScreen.getTextiOS(fieldName), value, "Error... Zero value not displayed on screen.");
		Reporter.addDeviceScreenshot("Portfolio Show Total for screen", "");
	}

	@Then("user should see {string} displayed on screen for iOS")
	public void user_should_see_displayed_on_screen_for_iOS(String fieldName) {
		Assert.assertTrue(action.isPresent(fieldName), "Error... Timestamp field not displayed.");
		Reporter.addDeviceScreenshot("Portfolio dashboard screen", "");
	}

	@Then("user should not see any accounts on the Your accounts screen for iOS")
	public void user_should_not_see_any_accounts_on_the_Your_accounts_screen_for_iOS() {
		Assert.assertFalse(action.isPresent("TOTAL_ACCOUNTS_IN_ACCOUNTS_SCREEN"), "Error... List of accounts not displayed.");
		Reporter.addDeviceScreenshot("Your accounts screen", "");
	}

	@Then("user should not see any accounts listed on the Show total for screen for iOS")
	public void user_should_not_see_any_accounts_listed_on_the_Show_total_for_screen_for_iOS() {
		Assert.assertFalse(action.isPresent("ACCOUNTS_LIST_SHOWALL_SCREEN"), "Error... List of accounts not displayed.");
		Reporter.addDeviceScreenshot("Show total for screen", "");
	}






}
