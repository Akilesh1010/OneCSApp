package qa.oneCSiOS.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.device.DeviceDriverManager;
import qa.framework.device.IOSAppDriver;
import qa.framework.utils.Action;

public class DashboardScreen {


	static DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSApp_iOS"));


	public boolean dashboardScreenFieldValidations() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("PORTFOLIO_SHOWALL_TXT"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_BREAKDOWN_I_BTN"));
		fields.add((MobileElement) action.getElement("WELCOME_BACK_TXT"));
		fields.add((MobileElement) action.getElement("YOUR_CURRENT_PORTFOLIO_VALUE_IS_TXT"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_VALUE_TXT"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_EYE_ICON_BTN"));
		fields.add((MobileElement) action.getElement("WELCOME_BACK_TXT"));

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;
	}

	public void dashboardBtnClickiOS(String btnName) {
		DeviceActions.click((MobileElement) action.getElement(btnName));
	}

	public void signoutIOS() {

	}

	public boolean pillBoxDisplayiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("PORTFOLIO_SHOWALL_TXT"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_SHOWALL_DOWN_ARROW"));

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;

	}

	public boolean welcomeBackPortfolioDisplayiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("WELCOME_BACK_TXT"));
		fields.add((MobileElement) action.getElement("YOUR_CURRENT_PORTFOLIO_VALUE_IS_TXT"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_PERFORMANCE_ARROW"));

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;

	}

	public boolean portfolioSummaryValueDetailsDisplayiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("PORTFOLIO_VALUE_TXT"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_EYE_ICON_BTN"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_SUMMARY_VALUE_CHANGE_TXT"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_SUMMARY_REFRESH_TIME_TXT"));
		

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;

	}
	
	public boolean bottomNavigationDisplayiOS() {
		boolean flag = false;

		List<MobileElement> fields = new ArrayList<MobileElement>();

		fields.add((MobileElement) action.getElement("YOUR_ACCOUNTS_TAB"));
		fields.add((MobileElement) action.getElement("PORTFOLIO_TAB"));
		fields.add((MobileElement) action.getElement("CONTACT_TAB"));
		fields.add((MobileElement) action.getElement("INVESTMENT_TAB"));
		fields.add((MobileElement) action.getElement("INSIGHTS_TAB"));
		fields.add((MobileElement) action.getElement("MORE_TAB"));
		

		for (MobileElement element : fields) {
			flag = element.isDisplayed();
		}	

		return flag;

	} 









}
