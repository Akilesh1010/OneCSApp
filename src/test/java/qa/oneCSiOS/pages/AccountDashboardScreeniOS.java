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

public class AccountDashboardScreeniOS {


	static DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));


	public boolean accountDashboardScreenFieldValidationsiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("PORTFOLIO_SHOWALL_DOWN_ARROW"));
		fields.add((MobileElement) action.getElement("BACK_BUTTON"));
		fields.add((MobileElement) action.getElement("ACCOUNT_MANAGEMENT_PENCIL_BTN"));
		fields.add((MobileElement) action.getElement("ACCOUNT_SUMMARY_NAME_LABEL_TXT"));
		fields.add((MobileElement) action.getElement("YOUR_ACCOUNT_VALUE_IS_LABEL_TXT"));
		fields.add((MobileElement) action.getElement("ACCOUNT_PERFORMANCE_INCREASE_ARROW"));
		fields.add((MobileElement) action.getElement("ACCOUNT_SUMMARY_TOTAL_VALUE_LABEL"));
		fields.add((MobileElement) action.getElement("EYE_SIGN_IN_ACCOUNT_DASHBOARD_BTN"));
		fields.add((MobileElement) action.getElement("ACCOUNT_SUMMARY_VALUE_CHANGE_LABEL"));
		fields.add((MobileElement) action.getElement("ACCOUNT_SUMMARY_REFRESH_AT_LABEL"));
//		Visible set to false for below 2 elements
//		fields.add((MobileElement) action.getElement("DASHBOARD_SHAPE_1"));
//		fields.add((MobileElement) action.getElement("DASHBOARD_SHAPE_2"));

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;
	}

	
}
