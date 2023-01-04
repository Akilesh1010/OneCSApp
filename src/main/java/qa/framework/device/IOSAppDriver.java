package qa.framework.device;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import qa.framework.utils.FileManager;
import qa.framework.utils.GlobalVariables;

public class IOSAppDriver {

	private IOSDriver<IOSElement> driver;

	private MutableCapabilities getCapabilities(String deviceType) throws MalformedURLException {
//		DesiredCapabilities capabilities = new DesiredCapabilities();
						MutableCapabilities capabilities = new MutableCapabilities();


		if(deviceType.equalsIgnoreCase("realDevice")) {

			capabilities.setCapability("platformName", DeviceDriverManager.getPlatformName());
			capabilities.setCapability("platformVersion", DeviceDriverManager.getPlatformVersion());
			capabilities.setCapability("automationName", DeviceDriverManager.getAutomationEngine());
			capabilities.setCapability("udid", DeviceDriverManager.getUdid());
			capabilities.setCapability("deviceName", DeviceDriverManager.getDeviceName());
			//			capabilities.setCapability("app", DeviceDriverManager.getApp());
			//			capabilities.setCapability("bundleId","uk.co.charles-stanley.ios.qa");
			capabilities.setCapability("forceAppLaunch","true");
			capabilities.setCapability("bundleId", DeviceDriverManager.getDeviceBundleId());


			/* Do not stop app, do not clear app data, and do not un-install .ipa */
			capabilities.setCapability("noReset", false);
			capabilities.setCapability("fullReset", false);

		}
		else if(deviceType.equalsIgnoreCase("BrowserStack")) {

			capabilities.setCapability("browserstack.user", "mohamednasarsyed_dJwZmc");
			capabilities.setCapability("browserstack.key", "8PEHGhm7dzbHtRqcptws");
//			capabilities.setCapability("browserstack.user", "akileshs_K8NpOV");
//			capabilities.setCapability("browserstack.key", "b4pfJpJmheYkiJoqhtax");

			capabilities.setCapability("device", "iPhone 13");
			capabilities.setCapability("os_version", "15.4");
			capabilities.setCapability("project", "MobileApp PoC");
			capabilities.setCapability("build", "CS QA iOS build");
			capabilities.setCapability("name", "iOS Sample test");
			capabilities.setCapability("app", "bs://b13502eb586f2bb423a76b9c681e4cf47d575a03");
			
			capabilities.setCapability("browserstack.local", "true");
			capabilities.setCapability("noReset", false);
			capabilities.setCapability("fullReset", false);

		}

		else if(deviceType.equalsIgnoreCase("SauceLabs")) {


			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("appium:app", "storage:filename=0.9.0_906.ipa");
			capabilities.setCapability("appium:deviceName", "iPhone 12 mini");
			capabilities.setCapability("appium:platformVersion", "15");
			capabilities.setCapability("appium:automationName", "XCUITest");
			MutableCapabilities sauceOptions = new MutableCapabilities();
			sauceOptions.setCapability("build", "<Sampletest>");
			sauceOptions.setCapability("name", "<iOSPoC>");
			capabilities.setCapability("sauce:options", sauceOptions);
			sauceOptions.setCapability("tunnelName", "nasarcs_tunnel_name");
			//			
		}

		return capabilities;

	}

	public IOSDriver<IOSElement> getDriver(String apkFile, String deviceType) throws MalformedURLException {

		
		if(deviceType.equalsIgnoreCase("realDevice")) {
			String userDir = System.getProperty("user.dir");
			String apkFilePath = null;
			//
			MutableCapabilities capabilities = getCapabilities(deviceType);
			//		/* Note: appium does not take relative path. */
			apkFilePath = FileManager.searchFile(userDir, apkFile);
			//
			//		
			//		/*setting app capability*/
			////		capabilities.setCapability("app", apkFilePath);
			//		
			if (DeviceDriverManager.isAppiumServerCodeStarted() == true) {
				driver = new IOSDriver<IOSElement>(new URL(
						"http://" + DeviceDriverManager.getHost() + ":" + DeviceDriverManager.getPort() + "/wd/hub"),
						capabilities);
			} else {
				driver = new IOSDriver<IOSElement>(new URL(DeviceDriverManager.getServerUrl()), capabilities);
			}
			//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		else if(deviceType.equalsIgnoreCase("BrowserStack")) {

			MutableCapabilities capabilities = getCapabilities(deviceType);

			driver = new IOSDriver<IOSElement>(new 
					URL("http://hub.browserstack.com/wd/hub"), capabilities);		

		}

		else if(deviceType.equalsIgnoreCase("SauceLabs")) {
						MutableCapabilities caps = getCapabilities(deviceType);
						String username = "nasarcs";    
						String accesskey = "1d2d94fe-9cb8-4775-8590-330ab4e587e6";
						String sauceurl = "@ondemand.eu-central-1.saucelabs.com:443";
						String sauceremoteurl = "https://" + username + ":" + accesskey + sauceurl + "/wd/hub";
			
			
						URL url = new URL(sauceremoteurl);
						driver = new IOSDriver<IOSElement>(url, caps);		

		}
		
//		driver.manage().timeouts().implicitlyWait(GlobalVariables.waitTime, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;		
	}
}
