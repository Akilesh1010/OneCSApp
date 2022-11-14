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

public class IOSSignInScreen {

	
	static DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSApp_iOS"));
	

	public void btnClickiOS(String btnName) {
		DeviceActions.click((MobileElement) action.getElement(btnName));
	}
	
	public void userLoginiOS(String userName, String pwd) {
		DeviceActions.sendKeys((MobileElement) action.getElement("USERNAME_EDIT"), userName);
		DeviceActions.sendKeys((MobileElement) action.getElement("PWD_EDIT"), pwd);	
	}
	
	public void input2FA() throws InterruptedException {
		Thread.sleep(3000);
        String codetext = DeviceActions.getText((MobileElement) action.getElement("SIGN_IN_CODE_2FA_TXT"));
        DeviceActions.sendKeys((MobileElement) action.getElement("SIGN_IN_2FA_CODE_INPUT_FIELD"), codetext);
	}
	
	public void inputFieldiOS(String inputField, String value) {
		DeviceActions.sendKeys((MobileElement) action.getElement(inputField), DeviceActions.getTestData(value));
	}
	
	public void signIniOS(String userName, String pwd) {
		DeviceActions.click((MobileElement) action.getElement("SIGN_IN_BTN"));
		DeviceActions.sendKeys((MobileElement) action.getElement("USERNAME_EDIT"), userName);
		DeviceActions.sendKeys((MobileElement) action.getElement("PWD_EDIT"), pwd);
		DeviceActions.click((MobileElement) action.getElement("CONTINUE_SIGN_IN_BTN"));
		String codetext = DeviceActions.getText((MobileElement) action.getElement("SIGN_IN_CODE_2FA_TXT"));
        DeviceActions.sendKeys((MobileElement) action.getElement("SIGN_IN_2FA_CODE_INPUT_FIELD"), codetext);
        DeviceActions.click((MobileElement) action.getElement("VERIFY_BTN"));
        DeviceActions.sendKeys((MobileElement) action.getElement("SIGN_IN_NEW_PIN_INPUT"), DeviceActions.getTestData("SIX_DIGIT"));
        DeviceActions.click((MobileElement) action.getElement("CONTINUE_NEW_PIN_BTN"));
        DeviceActions.sendKeys((MobileElement) action.getElement("CONFIRM_PIN_INPUT"), DeviceActions.getTestData("SIX_DIGIT"));
        DeviceActions.click((MobileElement) action.getElement("CONFIRM_PIN_BTN"));
        DeviceActions.click((MobileElement) action.getElement("MAYBE_LATER_BIOMETRICS_BTN"));	
	}
	
	public String getTextiOS(String getText) {
		return DeviceActions.getText((MobileElement) action.getElement(getText));
	}
	
	
}
	
	
