package qa.oneCSAndroid.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import junit.framework.Assert;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.device.DeviceDriverManager;
import qa.framework.utils.Action;
import qa.framework.utils.Reporter;

public class OneCS_Mobile {

	static DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppAndroid_Android"));
	static WebDriverWait wait = new WebDriverWait(DeviceDriverManager.getDriver(), 20);

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
	
	public void AndroidInputUserPass(String btnName, String text) {
		DeviceActions.sendKeys((MobileElement) action.getElement(btnName), text);
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

	public String getEntered2FACode(String gettext) {
		String twoFA = DeviceActions.getText((MobileElement) action.getElement("SIX_DIGIT_INPUT_BOX"));
		String code = twoFA.trim();
		return code;

	}

	public String enterRandomSixDigitCode() {

		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		String code = String.format("%06d", number);
		return code;

	}

	public static void androidSwipe(MobileElement element, MobileElement element1) {
		TouchAction swipe = new TouchAction((PerformsTouchActions) DeviceDriverManager.getDriver());
		swipe.press(ElementOption.element(element)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(800)))
				.moveTo(ElementOption.element(element1)).release().perform();
	}

	public static List<String> getRecoverDetailsScreen() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("RECOVER_DETAILS"));
		listOfElements.add((MobileElement) action.getElement("STRUGGLING_VERIFY_ACCOUNT"));
		listOfElements.add((MobileElement) action.getElement("RESEND_SIX_DIGIT_CODE"));
		listOfElements.add((MobileElement) action.getElement("CHECK_MOBILE_NUMBER"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}

	public static List<String> getCheckMobileNumWebPage() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("MOBILE_NUM_USERNAME_WEB"));
		listOfElements.add((MobileElement) action.getElement("MOBILE_NUM_PASSWORD_WEB"));
		listOfElements.add((MobileElement) action.getElement("MOBILE_NUM_LOGIN_WEB"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}

	public static List<String> getStep3Screenvalues() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("CREATE_YOUR_PIN"));
		listOfElements.add((MobileElement) action.getElement("CREATE_YOUR_PIN_TEXT"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}

	public void sixDigitBoxEmpty() {

		String empty = DeviceActions.getText((MobileElement) action.getElement("CREATE_YOUR_PIN_BOX"));
		Assert.assertEquals(empty, "");

	}

	public static List<String> getStep4Screenvalues() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("CONFIRM_PIN_TEXT"));
		listOfElements.add((MobileElement) action.getElement("CREATE_YOUR_PIN_TEXT"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}

	public static List<String> getMoreScreenvalues() {
		List<String> pageValues = new ArrayList<String>();
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("MORE_USER_SETTINGS")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("MORE_HELP_SUPPORT")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("MORE_MARKET_INFO")));
		DeviceActions.scrollToElement("ABOUT CHARLES STANLEY");
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("MORE_ABOUT_CS")));
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}
	
	public static List<String> getUserSettingsvalues() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("MORE_ACCOUNT_SETTINGS"));
		listOfElements.add((MobileElement) action.getElement("MORE_USER_DOCUMENTS"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}
	
	public static List<String> getHelpSupportvalues() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("MORE_HELP_FAQ"));
		listOfElements.add((MobileElement) action.getElement("MORE_HELP_CENTRE"));
		listOfElements.add((MobileElement) action.getElement("MORE_HELP_GLOSSARY"));
		listOfElements.add((MobileElement) action.getElement("MORE_HELP_NEW"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}
	
	public static List<String> getMarketInfovalues() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("MORE_MARKET_DATA"));
		listOfElements.add((MobileElement) action.getElement("MORE_MARKET_CURRENCY"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}
	
	public static List<String> getAboutCSvalues() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("MORE_ABOUT_CONTACT_DET"));
		listOfElements.add((MobileElement) action.getElement("MORE_ABOUT_IMPINFO"));
		listOfElements.add((MobileElement) action.getElement("MORE_ABOUT_LICINFO"));
		listOfElements.add((MobileElement) action.getElement("MORE_ABOUT_RATEUS"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}
	public static List<String> getAccountManagementPopupvalues() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("ACCOUNT_MANAGEMENT_ACTIVITY"));
		listOfElements.add((MobileElement) action.getElement("ACCOUNT_MANAGEMENT_BREAKDOWN"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}
	
	public static List<String> getActivityScreenvalues() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("ACCOUNT_MANAGEMENT_ACTIVITY"));
		listOfElements.add((MobileElement) action.getElement("ACCOUNT_ACTITVITY_ORDERLIST"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}
	
	public static List<String> getActivityOrderListvalues() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("ORDER_LIST_DATE"));
		listOfElements.add((MobileElement) action.getElement("ORDER_LIST_REF"));
		listOfElements.add((MobileElement) action.getElement("ORDER_LIST_TYPE"));
		listOfElements.add((MobileElement) action.getElement("ORDER_LIST_CURRSTAT"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}
	
	public static List<String> getHoldingAccountvalues() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("HOLDINGS_VALUE"));
		listOfElements.add((MobileElement) action.getElement("HOLDINGS_PRICE"));
		listOfElements.add((MobileElement) action.getElement("HOLDINGS_VALUE_CHANGE"));
		listOfElements.add((MobileElement) action.getElement("HOLDINGS_COST"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		Reporter.addDeviceScreenshot("Login Scrren", "Mobile ");
		return pageValues;
	}
	
	public static boolean sorting() throws InterruptedException
	{
		List<String> list = new ArrayList<String>();
		Thread.sleep(2000);
		list.add(DeviceActions.getText((MobileElement) action.getElement("HOLDINGS_ACCOUNTS1")));
		list.add(DeviceActions.getText((MobileElement) action.getElement("HOLDINGS_ACCOUNTS2")));
		list.add(DeviceActions.getText((MobileElement) action.getElement("HOLDINGS_ACCOUNTS3")));
		if (!list.isEmpty()) {
			  Iterator<String> it = list.iterator();
			  String prev = it.next();
			  while (it.hasNext()) {
			    String next = it.next();
			    if (prev.compareTo(next) > 0) {
			      return false;
			    }
			    prev = next;
			  }
			}
			return true;
	}

}
