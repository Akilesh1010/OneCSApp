package qa.oneCSAndroid.pages;

import io.appium.java_client.MobileElement;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;

public class SettingsAppSettingsScreen {
	
	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("SettingsApp_SettingsScreen"));
	
	public void clickSoundsAndVibration() {
		DeviceActions.click((MobileElement) action.getElement("SOUNDS_AND_VIBRATION_BTN"));
	}
	
	public void clickTemporaryMute() {
		DeviceActions.click((MobileElement) action.getElement("TOGGLE_BTN"));
	}
	
	public void aboutPhoneClick() {
		DeviceActions.click((MobileElement) action.getElement("ABOUT_PHONE_BTN"));	
	}

	public void InformationBtnClick(String btnName) {
		DeviceActions.click((MobileElement) action.getElement(btnName));	
	}
	
	public void backNavigation() {
		DeviceActions.click((MobileElement) action.getElement("BACK_NAVIGATION_BTN"));	
	}
}
