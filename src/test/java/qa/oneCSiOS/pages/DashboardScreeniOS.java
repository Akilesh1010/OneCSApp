package qa.oneCSiOS.pages;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.device.DeviceDriverManager;
import qa.framework.device.IOSAppDriver;
import qa.framework.utils.Action;

public class DashboardScreeniOS {


	static DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));


	public boolean dashboardScreenFieldValidationsiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("PORTFOLIO_SHOWALL_TXT"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_BREAKDOWN_I_BTN"));
		fields.add((MobileElement) action.getElement("WELCOME_BACK_TXT"));
		fields.add((MobileElement) action.getElement("YOUR_CURRENT_PORTFOLIO_VALUE_IS_TXT"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_VALUE_TXT"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_EYE_ICON_BTN"));
		fields.add((MobileElement) action.getElement("WELCOME_BACK_TXT"));

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;
	}

	public void dashboardBtnClickiOS(String btnName) {
		DeviceActions.click((MobileElement) action.getElement(btnName));
	}

	public void signoutIOS() {

	}

	public boolean pillBoxDisplayiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("PORTFOLIO_SHOWALL_TXT"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_SHOWALL_DOWN_ARROW"));

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;

	}

	public boolean welcomeBackPortfolioDisplayiOS(String performanceIndicator) {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("WELCOME_BACK_TXT"));
		fields.add((MobileElement) action.getElement("YOUR_CURRENT_PORTFOLIO_VALUE_IS_TXT"));
		fields.add((MobileElement) action.getElement(performanceIndicator));

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;

	}

	public boolean portfolioSummaryValueDetailsDisplayiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("PORTFOLIO_VALUE_TXT"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_EYE_ICON_BTN"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_SUMMARY_REFRESH_TIME_TXT"));


		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;

	}

	public boolean bottomNavigationDisplayiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

//		fields.add((MobileElement) action.getElement("YOUR_ACCOUNTS_TAB"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_TAB"));
		fields.add((MobileElement) action.getElement("CONTACT_TAB"));
		fields.add((MobileElement) action.getElement("INVESTMENT_TAB"));
		fields.add((MobileElement) action.getElement("INSIGHTS_TAB"));
		fields.add((MobileElement) action.getElement("MORE_TAB"));


		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;

	} 

	public void swipeiOS(MobileElement startingElement, MobileElement endingElement) {
		TouchAction swipe = new TouchAction((PerformsTouchActions) DeviceDriverManager.getDriver());
		swipe.press(ElementOption.element(startingElement)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1500)))
		.moveTo(ElementOption.element(endingElement)).release().perform();
	}

//	public static BigDecimal test() {
//		List<Object> accounts = action.getElements("TOTAL_ACCOUNTS_IN_ACCOUNTS_SCREEN");
//		int totalAccounts = accounts.size()-1;
//		System.out.println(totalAccounts);	
//		BigDecimal total = null;
//
//		for (int i=0; i<totalAccounts; i++) {
//			String value = DeviceActions.getText((MobileElement) DeviceDriverManager.getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"portfolio-account-"+i+"-total-value\"]")));
//			Double sumValue = Double.parseDouble(value.substring(1).replace(",", ""));
//			BigDecimal bd = BigDecimal.valueOf(sumValue);
//			System.out.println(bd);
//			total = total.add(bd);
//			
//		}
//		return null;
//		
//
//	}
	

	@SuppressWarnings("rawtypes")
	public void swipeByCooardinatesiOS(int startX, int startY, int endX, int endY) {
		new TouchAction((PerformsTouchActions) DeviceDriverManager.getDriver()).longPress(PointOption.point(startX, startY))
	    .moveTo(PointOption.point(endX, endY))
	    .release().perform();
	}
	
	public boolean fieldsDisplayiOS(String field1, String field2, String field3) {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement(field1));
		fields.add((MobileElement) action.getElement(field2));
		fields.add((MobileElement) action.getElement(field3));
	

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;

	}
	
	public boolean twoFieldsDisplayiOS(String field1, String field2) {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement(field1));
		fields.add((MobileElement) action.getElement(field2));
	
		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;

	}
	
	public boolean showAllScreenPortfolioSettingsiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("SHOW_TOTAL_FOR_SCREEN_TITLE"));
		fields.add((MobileElement) action.getElement("IC_CLOSE_BTN"));
		fields.add((MobileElement) action.getElement("ALL_ACCOUNTS_LABEL_IN_SHOW_ALL_SCREEN"));
		fields.add((MobileElement) action.getElement("TOGGLE_BTN_SHOW_ALL_SCREEN"));
		fields.add((MobileElement) action.getElement("UPDATE_TOTAL_BTN_SHOW_ALL_SCREEN"));
		
		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;

	}



}
