package qa.oneCSiOS.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.utils.Action;

public class IOSHomeScreen {

	
	static DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSiOSApp_SplashScreen"));
	
//	static Action action = new Action(SQLDriver.getEleObjData("OneCSiOSApp_SplashScreen"));
	

	public void iOSBtnClick(String btnName) {
		DeviceActions.click((MobileElement) action.getElement(btnName));
	}
	
	public void iOSUserLogin(String userName, String pwd) {
		DeviceActions.sendKeys((MobileElement) action.getElement("USERNAME_BTN"), userName);
		DeviceActions.sendKeys((MobileElement) action.getElement("PWD_BTN"), pwd);	
	}
	
	public void input2FA() throws InterruptedException {
		Thread.sleep(3000);
        String codetext = DeviceActions.getText((MobileElement) action.getElement("SIGN_IN_CODE_2FA_TXT"));
        DeviceActions.sendKeys((MobileElement) action.getElement("SIGN_IN_2FA_CODE_INPUT_FIELD"), codetext);
	}
	
	public void iOSInputField(String inputField, String value) {
		DeviceActions.sendKeys((MobileElement) action.getElement(inputField), DeviceActions.getTestData(value));
	}
	
	
	
// INTEGRATION APP Methods:
	
	public void intergrationBtnClickiOS() {
		DeviceActions.click((MobileElement) action.getElement("BUTTON_ICON"));
	}
	
	public void integrationAppAlertBtnClickiOS() {
		DeviceActions.click((MobileElement) action.getElement("ALERTS_BTN"));
	}
	
	

	public void enterText(String value) {
		DeviceActions.sendKeys((MobileElement) action.getElement("EDIT_TXT_FIELD"), value);
	}

	public void enableProgressBar() {
		DeviceActions.click((MobileElement) action.getElement("btnProgressbar"));

		String percent = "0";
		try {
			while (!percent.contains("75")) {
				percent = DeviceActions.getText((MobileElement) action.getElement("txtProgressCompletion"));
				
			}

		} catch (Exception e) {
			//ignore
		}

		Action.pause(2000);
		DeviceActions.pressKey(AndroidKey.BACK);
		Action.pause(500);
		DeviceActions.pressKey(AndroidKey.BACK);
		Action.pause(100);

	}

	public void enableDispalyText() {

		DeviceActions.click((MobileElement) action.getElement("DISPLAY_TXT_VIEW_BTN"));
	}

	public String getDispalyText() {

		return DeviceActions.getText((MobileElement) action.getElement("TXT_SOMETIMES_DISPLAYED_TXT"));
	}

	public void openPopup() {

		DeviceActions.click((MobileElement) action.getElement("DISPLAY_POP_UP_WINDOW_BTN"));
	}

	public void closePopup() {

		DeviceActions.click((MobileElement) action.getElement("btnWinPopupDismiss"));
	}
}
