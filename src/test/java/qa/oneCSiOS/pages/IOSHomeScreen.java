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

	
	static DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSApp_iOS"));
	

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
	
	
}
	
	
