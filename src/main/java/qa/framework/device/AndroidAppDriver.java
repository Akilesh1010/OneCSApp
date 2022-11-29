package qa.framework.device;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import qa.framework.utils.FileManager;
import qa.framework.utils.GlobalVariables;

public class AndroidAppDriver {

	private AndroidDriver<MobileElement> driver;

	/**
	 * Setting Generic capabilities
	 * 
	 * @author 10650956
	 * @return
	 */
	private DesiredCapabilities getCapabilities(String deviceType) {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", DeviceDriverManager.getPlatformName());
		capabilities.setCapability("platformVersion", DeviceDriverManager.getPlatformVersion());
		capabilities.setCapability("automationName", DeviceDriverManager.getAutomationEngine());

		capabilities.setCapability("deviceName", DeviceDriverManager.getDeviceName());

//		capabilities.setCapability("browserstack.user", "akileshs_JY4nW5");
//		capabilities.setCapability("browserstack.key", "C8qZDyUkZS39eHYnBsXL");
//
//		capabilities.setCapability("app", "bs://c0f0482fe14f8effacbff7219e623ef4ad1fe30e");
//
//		capabilities.setCapability("device", "Samsung Galaxy S20");
//		capabilities.setCapability("os_version", "10.0");
//
//		capabilities.setCapability("project", "OneCS Mobile");
//		capabilities.setCapability("build", "OneCS QA");
//
//		capabilities.setCapability("name", "OneCS Digital");
//
//		/* Do not stop app, do not clear app data, and do not uninstall apk. */
//
//		capabilities.setCapability("browserstack.local", "true");
//
//		capabilities.setCapability("browserstack.autoWait", "2");

		/* Do not stop app, do not clear app data, and do not uninstall apk. */
		capabilities.setCapability("noReset", false);

		return capabilities;

	}

	/**
	 * Starting app with app capabilities
	 * 
	 * @author 10650956
	 * @param apkFile
	 * @return
	 * @throws MalformedURLException
	 */
	public AndroidDriver<MobileElement> getDriver(String apkFile , String deviceType) throws MalformedURLException {
		if(deviceType.equalsIgnoreCase("Emulator")) {
		String userDir = System.getProperty("user.dir");
		String apkFilePath = null;

		DesiredCapabilities capabilities = getCapabilities(deviceType);
		/* Note: appium does not take relative path. */
		apkFilePath = FileManager.searchFile(userDir, apkFile);
		
		/*setting app capability*/
		capabilities.setCapability("app", apkFilePath);
		
		if (DeviceDriverManager.isAppiumServerCodeStarted() == true) {
			driver = new AndroidDriver<MobileElement>(new URL(
					"http://" + DeviceDriverManager.getHost() + ":" + DeviceDriverManager.getPort() + "/wd/hub"),
					capabilities);
		} else {
			driver = new AndroidDriver<MobileElement>(new URL(DeviceDriverManager.getServerUrl()), capabilities);
		}
		
				
		}
		else if(deviceType.equalsIgnoreCase("BrowserStack")) {
			DesiredCapabilities capabilities = getCapabilities(deviceType);
			
			driver = new AndroidDriver<MobileElement>(new 
					URL("http://hub.browserstack.com/wd/hub"), capabilities);
		}

		else if(deviceType.equalsIgnoreCase("SauceLabs")) {
						DesiredCapabilities caps = getCapabilities(deviceType);
						String username = "nasarcs";    
						String accesskey = "1d2d94fe-9cb8-4775-8590-330ab4e587e6";
						String sauceurl = "@ondemand.eu-central-1.saucelabs.com:443";
						String sauceremoteurl = "https://" + username + ":" + accesskey + sauceurl + "/wd/hub";
			
			
						URL url = new URL(sauceremoteurl);
						driver = new AndroidDriver<MobileElement>(url, caps);		

		}
		

		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;

	}

	/**
	 * Starting app with app package and app activity
	 * 
	 * @author 10650956
	 * @param appPackage
	 * @param appActivity
	 * @return
	 * @throws MalformedURLException
	 */
//	public AndroidDriver<MobileElement> getDriver(String appPackage, String appActivity) throws MalformedURLException {
//
//		DesiredCapabilities capabilities = getCapabilities();
//		capabilities.setCapability("appPackage", appPackage);
//		capabilities.setCapability("appActivity", appActivity);
//
//		if (DeviceDriverManager.isAppiumServerCodeStarted() == true) {
//			driver = new AndroidDriver<MobileElement>(new URL(
//					"http://" + DeviceDriverManager.getHost() + ":" + DeviceDriverManager.getPort() + "/wd/hub"),
//					capabilities);
//		} else {
//			driver = new AndroidDriver<MobileElement>(new URL(DeviceDriverManager.getServerUrl()), capabilities);
//		}
//
//		driver.manage().timeouts().implicitlyWait(GlobalVariables.waitTime, TimeUnit.SECONDS);
//
//		return driver;
//
//	}

}
