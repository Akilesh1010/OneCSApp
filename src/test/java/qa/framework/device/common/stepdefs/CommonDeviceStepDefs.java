package qa.framework.device.common.stepdefs;

import java.net.MalformedURLException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import qa.framework.device.DeviceDriverManager;
import qa.framework.utils.Reporter;

public class CommonDeviceStepDefs {

	@Given("user launch app {string} on mobile device")
    public void user_launch_app_on_mobile_device(String string) throws MalformedURLException {

       DeviceDriverManager.createBrowserSession();
    }

	@And("user closes {string} on mobile device")
	public void user_closes_browser_on_mobile_device(String type) {

		type = type.toLowerCase();

		/* flag is set false to know that device test is ended */
		DeviceDriverManager.setflag(false);

		if (type.equalsIgnoreCase("browser")) {

			DeviceDriverManager.quit();

		} else if (type.equalsIgnoreCase("app")) {
			DeviceDriverManager.quit();

		}

	}

	@Given("user launch app {string} on {string} mobile device")
	public void user_launch_app_on_mobile_device(String appFile, String deviceType) throws MalformedURLException {
		DeviceDriverManager.createAppSession(appFile, deviceType);
		//Reporter.addEntireScreenCaptured();
	}

	@Given("^user launch app with appPackage \"([^\"]*)\" and activity \"([^\"]*)\" on mobile device$")
	public void user_launch_app_with_apppackage_something_and_activity_something_on_mobile_device(String appPackage,
			String appActivity,String deviceType) throws MalformedURLException {
		
		DeviceDriverManager.createAppSession(appPackage, appActivity, deviceType);

	}

}
