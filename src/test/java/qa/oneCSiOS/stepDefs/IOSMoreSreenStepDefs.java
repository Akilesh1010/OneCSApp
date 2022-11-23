package qa.oneCSiOS.stepDefs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.utils.Reporter;
import qa.oneCSiOS.pages.DashboardScreeniOS;
import qa.oneCSiOS.pages.SignInScreeniOS;

public class IOSMoreSreenStepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("OneCSAppiOS_iOS"));
	SignInScreeniOS iOSSignInScreen = new SignInScreeniOS();
	DashboardScreeniOS dashboardScreeniOS = new DashboardScreeniOS();


	@Then("user should see {string} as tittle in more options Screen for iOS")
	public void user_should_see_as_tittle_in_more_options_Screen_for_iOS(String Onecs) {
		Assert.assertEquals(Onecs, iOSSignInScreen.getTextiOS("ONECS_TXT_MORE_MENU")); 
	}

	@When("user Signs Out the Mobile Application for iOS")
	public void user_Signs_Out_the_Mobile_Application_for_iOS() {
		DeviceActions.scroll("down");
		DeviceActions.click((MobileElement) action.getElement("SIGN_OUT_BTN"));
	}




}
