package qa.oneCSiOS.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import junit.framework.Assert;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.utils.Action;
import qa.framework.utils.Reporter;

public class SignInScreeniOS {

	
	static DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));
	

	public void btnClickiOS(String btnName) {
		DeviceActions.click((MobileElement) action.getElement(btnName));
	}
	
	public void userLoginiOS(String userName, String pwd) {
		DeviceActions.sendKeys((MobileElement) action.getElement("USERNAME_EDIT"), DeviceActions.getTestData(userName));
		DeviceActions.sendKeys((MobileElement) action.getElement("PWD_EDIT"), DeviceActions.getTestData(pwd));	
	}
	
	public void input2FA() throws InterruptedException {
		Thread.sleep(3000);
        String codetext = DeviceActions.getText((MobileElement) action.getElement("SIGN_IN_CODE_2FA_TXT"));
        DeviceActions.sendKeys((MobileElement) action.getElement("SIGN_IN_2FA_CODE_INPUT_FIELD"), codetext);
	}
	
	public void inputIncorrect2FAiOS() {
		DeviceActions.sendKeys((MobileElement) action.getElement("SIGN_IN_2FA_CODE_INPUT_FIELD"), DeviceActions.getTestData("INCORRECT_2FA_CODE"));
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
	
	public String buttonDisablediOS(String btnName) {
		MobileElement element = (MobileElement) action.getElement(btnName);
		String isEnabled = element.getAttribute("enabled");
		return isEnabled;
	}
	
	public boolean errorMsgPopDetailsiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("DETAILS_INCORRECT_TITLE_LABEL"));
		fields.add((MobileElement) action.getElement("PLEASE_CHECK_THE_DETAILS_ENTERED_TXT"));
		fields.add((MobileElement) action.getElement("EDIT_DETAILS_BTN"));

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;
	}
	
	public boolean secureSignInScreenFieldsDisplayiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("SECURE_SIGN_IN_LABEL"));
		fields.add((MobileElement) action.getElement("PLEASE_ENTER_SIX_DIGIT_PIN_LABEL_TXT"));
		fields.add((MobileElement) action.getElement("SECURE_SIGN_IN_INPUT_FIELD"));
		fields.add((MobileElement) action.getElement("I_NEED_HELP_WITH_MY_PIN_LINK"));
		fields.add((MobileElement) action.getElement("SECURE_SIGN_IN_VERIFY_BTN"));

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;
	}
	
	public boolean forgotSignInDetailsDisplayiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("FORGOT_SIGN_IN_DETAILS_LABEL_TXT"));
		fields.add((MobileElement) action.getElement("FORGOT_USER_NAME_BTN"));
		fields.add((MobileElement) action.getElement("FORGOT_PWD_BTN"));
		fields.add((MobileElement) action.getElement("CANCEL_BTN"));

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;
	}
	
	public List<String> getForgotUserWebScreeniOS() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("FORGOTTEN_USERNAME_TXT_IN_WEBSITE"));
		listOfElements.add((MobileElement) action.getElement("DOB_STATIC_TEXT_IN_WEBSITE"));
		listOfElements.add((MobileElement) action.getElement("ACCOUNT_NUMBER_STATIC_TEXT_IN_WEBSITE"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		return pageValues;
	}
	
	public List<String> getForgotPasswordWebScreeniOS() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("FORGOTTEN_PWD_TXT_IN_WEBSITE"));
		listOfElements.add((MobileElement) action.getElement("USERNAME_TXT_IN_WEBSITE"));
		listOfElements.add((MobileElement) action.getElement("NEXT_BTN_IN_WEBSITE"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		return pageValues;
	}
	
	public List<String> getVerifyAccountCodePopDetailsiOS() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("STRUGGLING_TO_VERIFY_CODE_POP_TXT"));
		listOfElements.add((MobileElement) action.getElement("RESEND_6_DIGIT_CODE_BTN"));
		listOfElements.add((MobileElement) action.getElement("CHECK_MOBILE_NUMBER_BTN"));
		listOfElements.add((MobileElement) action.getElement("CANCEL_BTN"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		return pageValues;
	}
	
	public List<String> loginPageWebiOS() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("USERNAME_TXT_IN_WEBSITE"));
		listOfElements.add((MobileElement) action.getElement("PASSWORD_TXT_IN_WEB"));
		listOfElements.add((MobileElement) action.getElement("LOGIN_BTN_IN_WEB"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		return pageValues;
	}
	
}
	
	
