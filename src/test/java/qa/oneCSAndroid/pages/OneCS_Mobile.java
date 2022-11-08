package qa.oneCSAndroid.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.utils.Action;
import qa.framework.utils.Reporter;

public class OneCS_Mobile {

	
	static Action action = new Action(SQLDriver.getEleObjData("MobileApp_HomeScreen"));

	public static List<String> getDashboarddata() {
		List<String> columnNames = new ArrayList<String>();
		Action.waitForPageLoad();
		Action.ScrollToElement(action.getElement("TAB_HEADER"));
		List<WebElement> listOfElements = action.getElements("TAB_HEADER");
		for (WebElement element : listOfElements) {
			columnNames.add(Action.getText(element));
			System.out.println("**********" + Action.getText(element));
		}
		Reporter.addScreenCapture();
		return columnNames;
		
		
	}

}

