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

public class MoreMenuScreeniOS {


	static DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));


	public List<String> getMoreScreenLabelsiOS() {
		List<String> pageValues = new ArrayList<String>();

		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("USER_SETTINGS_LABEL_TXT_MORE")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("HELP_&_SUPPORT_LABEL_TXT_MORE")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("MARKETS_INFORMATION_LABEL_TXT_MORE")));
		pageValues.add(DeviceActions.getText((MobileElement) action.getElement("ABOUT_CHARLES_STANLEY_LABEL_TXT_MORE")));
		
		return pageValues;
	}
	
	public List<String> getUserSettingsLablesiOS() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("ACCOUNT_SETTINGS_LABEL_TXT_MORE"));
		listOfElements.add((MobileElement) action.getElement("DOCUMENTS_LABEL_TXT_MORE"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		return pageValues;
	}
	
	public boolean userSettingsImageAndChevronDisplayiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();
		fields.add((MobileElement) action.getElement("ACCOUNT_SETTINGS_PROFILE_IMAGE"));
		fields.add((MobileElement) action.getElement("ACCOUNT_SETTINGS_CHEVRON"));
		fields.add((MobileElement) action.getElement("DOCUMENTS_IMAGE"));
		fields.add((MobileElement) action.getElement("DOCUMENTS_CHEVRON"));
		
		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;
	}
	
	public List<String> getHelpAndSupportLablesiOS() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("FAQS_LABEL_TXT_MORE"));
		listOfElements.add((MobileElement) action.getElement("HELP_CENTRE_LABEL_MORE"));
		listOfElements.add((MobileElement) action.getElement("GLOSSARY_LABEL_MORE"));
		listOfElements.add((MobileElement) action.getElement("WHATS_NEW_LABEL_MORE"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		return pageValues;
	}
	
	public boolean helpAndSupportImageAndChevronDisplayiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();
		fields.add((MobileElement) action.getElement("FAQS_IMAGE"));
		fields.add((MobileElement) action.getElement("FAQS_CHEVRON"));
		
		fields.add((MobileElement) action.getElement("HELP_IMAGE"));
		fields.add((MobileElement) action.getElement("HELP_CHEVRON"));
		
		fields.add((MobileElement) action.getElement("GLOSSARY_IMAGE"));
		fields.add((MobileElement) action.getElement("GLOSSARY_CHEVRON"));
		
		fields.add((MobileElement) action.getElement("WHATS_NEW_IMAGE"));
		fields.add((MobileElement) action.getElement("WHATS_NEW_CHEVRON"));
		
		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	
		return flag;
	}
	
	public List<String> getMarketInformationLablesiOS() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		listOfElements.add((MobileElement) action.getElement("MARKET_DATA_LABEL_MORE"));
		listOfElements.add((MobileElement) action.getElement("CURRENCY_RATES_LABEL_MORE"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		return pageValues;
	}
	
	public boolean marketInfoImageAndChevronDisplayiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();
		
		fields.add((MobileElement) action.getElement("MARKET_DATA_IMAGE"));
		fields.add((MobileElement) action.getElement("MARKET_DATA_CHEVRON"));
		
		fields.add((MobileElement) action.getElement("CURRENCY_RATES_IMAGE"));
		fields.add((MobileElement) action.getElement("CURRENCY_RATES_CHEVRON"));
		
		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	
		return flag;
	}
	
	public List<String> getAboutCSLablesiOS() {
		List<String> pageValues = new ArrayList<String>();
		List<MobileElement> listOfElements = new ArrayList<MobileElement>();
		
		listOfElements.add((MobileElement) action.getElement("CONTACT_DETAILS_LABEL_MORE"));
		listOfElements.add((MobileElement) action.getElement("IMPORTANT_INFORMATION_LABEL_MORE"));
		listOfElements.add((MobileElement) action.getElement("LICENSING_INFORMATION_LABEL_MORE"));
		listOfElements.add((MobileElement) action.getElement("RATE_US_LABEL_MORE"));

		for (MobileElement element : listOfElements) {
			pageValues.add(DeviceActions.getText((MobileElement) element));
		}
		return pageValues;
	}
	
	public boolean aboutCSImageAndChevronDisplayiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();
		
		fields.add((MobileElement) action.getElement("CONTACT_DETAILS_IMAGE"));
		fields.add((MobileElement) action.getElement("CONTACT_DETAILS_CHEVRON"));
		
		fields.add((MobileElement) action.getElement("IMPORTANT_INFORMATION_IMAGE"));
		fields.add((MobileElement) action.getElement("IMPORTANT_INFORMATION_CHEVRON"));
		
		fields.add((MobileElement) action.getElement("LICENSING_INFORMATION_IMAGE"));
		fields.add((MobileElement) action.getElement("LICENSING_INFORMATION_CHEVRON"));
		
		fields.add((MobileElement) action.getElement("RATE_US_LABEL_IMAGE"));
		fields.add((MobileElement) action.getElement("RATE_US_LABEL_CHEVRON"));
		
		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	
		return flag;
	}

}


