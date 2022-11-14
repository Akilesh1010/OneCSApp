package qa.oneCSAndroid.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import junit.framework.Assert;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.utils.Action;
import qa.framework.utils.Reporter;

public class OneCS_Mobile {

	static DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSApp_Android"));

	public static String getDispalyText() {

		MobileElement element = (MobileElement) action.getElement("CREATE_SECURE_FIANACIAL");
		String tagName = element.getAttribute("content-desc");

		return tagName;
	}

	public static void clickOnButton(String ele) {

		DeviceActions.click((MobileElement) action.getElement(ele));

	}

	public void getUrl() {

		String text = DeviceActions.getText((MobileElement) action.getElement("CREATE_SECURE_FIANACIAL"));
		Assert.assertEquals(DeviceActions.getTestData("CREATE_SECURE"), text);
	}

	public void usernameFieldEmpty() {

		DeviceActions.click((MobileElement) action.getElement("USERNAME_TEXT"));
		String empty = DeviceActions.getText((MobileElement) action.getElement("USERNAME_FIELD_EMPTY"));
		Assert.assertEquals(empty, "");
		DeviceActions.click((MobileElement) action.getElement("PASSWORD_TEXT"));
		String empty1 = DeviceActions.getText((MobileElement) action.getElement("PASSWORD_FIELD_EMPTY"));
		Assert.assertEquals(empty1, "");
	}

	public void AndroidBtnClick(String btnName) {
		DeviceActions.click((MobileElement) action.getElement(btnName));
	}

	public void AndroidInputText(String btnName, String text) {
		DeviceActions.sendKeys((MobileElement) action.getElement(btnName), DeviceActions.getTestData(text));
	}

	public void androidButtonDisabled(String btnName) {
		MobileElement element = (MobileElement) action.getElement(btnName);
		String disabled = element.getAttribute("clickable");
		Assert.assertEquals(disabled, "false");
	}

	public void androidButtonEnabled(String btnName) {
		MobileElement element = (MobileElement) action.getElement(btnName);
		String enabled = element.getAttribute("enabled");
		Assert.assertEquals(enabled, "true");
	}

	public void androidFieldClear(String clear) {
		MobileElement element = (MobileElement) action.getElement(clear);
		element.clear();
	}

	public String androidGetText(String gettext) {
		return DeviceActions.getText((MobileElement) action.getElement(gettext));
	}

	public static List<String> getNeedHelpPopupScreen() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("RECOVER_DETAILS"));
		listOfElements.add((MobileElement) action.getElement("FORGOT_SIGN_IN_DETAILS"));
		listOfElements.add((MobileElement) action.getElement("FORGOT_USERNAME"));
		listOfElements.add((MobileElement) action.getElement("FORGOT_PASSWORD"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}
	
	public static List<String> getForgotUserWebScreen() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("WEB_DATE_OF_BIRTH"));
		listOfElements.add((MobileElement) action.getElement("WEB_ACCOUNT_NUMBER"));
		

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}
	
	public static List<String> getForgotPassWebScreen() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("WEB_PASS_USERNAME"));
		listOfElements.add((MobileElement) action.getElement("WEB_PASS_NEXT"));
		

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}

}
