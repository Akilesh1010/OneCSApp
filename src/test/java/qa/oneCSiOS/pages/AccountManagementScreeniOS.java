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
		listOfElements.add((MobileElement) action.getElement("ACCOUNT_ACTIVITY_BTN"));
		listOfElements.add((MobileElement) action.getElement("ORDER_LIST_TAB"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
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


}