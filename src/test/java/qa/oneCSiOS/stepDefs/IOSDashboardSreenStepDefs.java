package qa.oneCSiOS.stepDefs;

import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
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
	WebDriverWait wait = new WebDriverWait(DeviceDriverManager.getDriver(), 20);

	//	private IOSDriver<MobileElement> driver;	

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
		wait.until(ExpectedConditions.visibilityOf((MobileElement) action.getElement("PORTFOLIO_SHOWALL_TXT")));
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

	//*************PORTFOLIO TOTAL VALUE --VS-- SUM OF ALL PORTFOLIO VALUES****************
	@Then("user should see the Total Portfolio value is matching with sum of all portfolio values for iOS")
	public void user_should_see_the_Total_Portfolio_value_is_matching_with_sum_of_all_portfolio_values_for_iOS() {

		String totalPortfolioValue = DeviceActions.getText((MobileElement) action.getElement("PORTFOLIO_SUMMARY_TOTAL_VALUE_TXT"));
		Double PortfolioValue = Double.parseDouble(totalPortfolioValue.substring(1).replace(",", ""));
		BigDecimal portValue = BigDecimal.valueOf(PortfolioValue);
		System.out.println(portValue);

		DeviceActions.click((MobileElement) action.getElement("YOUR_ACCOUNTS_TAB"));

		//		List<Object> accounts = action.getElements("TOTAL_ACCOUNTS_IN_ACCOUNTS_SCREEN");
		//		int totalAccounts = accounts.size()-1;
		//		System.out.println(totalAccounts);	

		//		for (int i=0; i<totalAccounts; i++) {
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

		DeviceActions.click((MobileElement) action.getElement("YOUR_ACCOUNTS_TAB"));

		AssertLogger.assertEquals(totalAccountValues, portValue, "Error..... Portfolio & Account values does not match");
		//		}
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

		DeviceActions.click((MobileElement) action.getElement("YOUR_ACCOUNTS_TAB"));

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

		DeviceActions.click((MobileElement) action.getElement("HOLDINGS_DRAG_UP_BTN"));

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
		Reporter.addDeviceScreenshot("Portfolio Breakdown", "Portfolio Breakdown Screen");
	}



}
