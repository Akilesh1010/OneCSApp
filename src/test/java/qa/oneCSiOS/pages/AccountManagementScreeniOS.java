package qa.oneCSiOS.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.device.DeviceDriverManager;
import qa.framework.device.IOSAppDriver;
import qa.framework.utils.Action;
import qa.framework.utils.Reporter;

public class AccountManagementScreeniOS {


	static DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));


	public List<String> getAccountManagementPopupValuesiOS() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("PAY_MONEY_IN_BTN_ACC_MANAGEMENT"));
		listOfElements.add((MobileElement) action.getElement("ACCOUNT_ACTIVITY_BTN"));
		listOfElements.add((MobileElement) action.getElement("ACCOUNT_BREAKDOWN_BTN"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		return pageValues;
	}
	
	public List<String> getActivityScreenTabNamesiOS() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("ACTIVITY_TAB"));
		listOfElements.add((MobileElement) action.getElement("ORDER_LIST_TAB"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getAttribute((MobileElement) element, "label"));
		}
		return pageValues;
	}
	
	public boolean activityLabelsUnderActivityTabiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("ACCOUNT_ACTIVITY_1ST_ACTIVITY_NAME_TXT"));
		fields.add((MobileElement) action.getElement("ACCOUNT_ACTIVITY_1ST_ACTIVITY_ICON_TXT"));
		fields.add((MobileElement) action.getElement("ACCOUNT_ACTIVITY_1ST_ACTIVITY_VALUE_TXT"));
		fields.add((MobileElement) action.getElement("ACCOUNT_ACTIVITY_1ST_ACTIVITY_TRANSACTION_TYPE_TXT"));

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;
	}
	
	
	public List<String> getActivityOrderListLabelsiOS() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("ORDER_DATE_ORDER_LIST_LABEL"));
		listOfElements.add((MobileElement) action.getElement("ORDER_REF_ORDER_LIST_LABEL"));
		listOfElements.add((MobileElement) action.getElement("ORDER_TYPE_ORDER_LIST_LABEL"));
		listOfElements.add((MobileElement) action.getElement("CURRENT_STATUS_ORDER_LIST_LABEL"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}
	
	public boolean orderListValuesiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("ORDER_NAME_ORDER_LIST_LABEL"));
		fields.add((MobileElement) action.getElement("ORDER_DATE_ORDER_LIST_VALUE"));
		fields.add((MobileElement) action.getElement("ORDER_REF_ORDER_LIST_VALUE"));
		fields.add((MobileElement) action.getElement("ORDER_TYPE_ORDER_LIST_VALUE"));
		fields.add((MobileElement) action.getElement("CURRENT_STATUS_ORDER_LIST_VALUE"));

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}

		return flag;
	}
	
	public List<String> getOrderTypesvaluesiOS() {
		List<String> pageValues = new ArrayList<String>();
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_TYPE_PROCESSING")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_TYPE_DEALT")));
		DeviceActions.scrollToElement("CANCELLED");
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_TYPE_CANCELLED")));
		DeviceActions.scrollToElement("COMPLETE");
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_TYPE_COMPLETE")));
		DeviceActions.scrollToElement("REJECTED");
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_TYPE_REJECTED")));
		DeviceActions.scrollToElement("EXPIRED");
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_TYPE_EXPIRED")));
		return pageValues;
	}
	
	public List<String> getOrderDetailsScreenFieldsiOS() {
		List<String> pageValues = new ArrayList<String>();
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_DETAIL_STATUS_FIELD")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_DETAIL_TRADE_TYPE_FIELD")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_DETAIL_DATE_FIELD")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_DETAIL_SETTLEMENT_DATE_FIELD")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_DETAIL_PRICE_FIELD")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_DETAIL_QUANTITY_FIELD")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_DETAIL_CONSIDERATION_FIELD")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_DETAIL_OTHER_FIELD")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_DETAIL_DEALING_FEE_FIELD")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_DETAIL_ESTIMATED_VALUE_FIELD")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ORDER_DETAIL_CANCEL_ORDER_BTN")));
		return pageValues;
	}


}