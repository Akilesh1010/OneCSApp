package qa.framework.device;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import qa.framework.utils.LoggerHelper;
import qa.framework.utils.PropertyFileUtils;

/**
 * 
 * @author 10650956
 *
 */
/**
 * @author 10650956
 *
 */
public class DeviceDriverManager {

	private static boolean device = false;

	private static PropertyFileUtils appiumPro = null;

	private static String host;

	private static String port;

	private static String automationEngine;

	private static String platformName;

	private static String platformVersion;

	private static String deviceName;

	private static String browserName;

	private static String browserVersion;

	private static String udid;

	private static String app;
	
	private static String bundleId;

	private static String appPackage;

	private static Process appiumServerProcee;

	private static AppiumDriverLocalService service;

	private static String appActivity;

	private static boolean flag = false;

	private static WebDriver driver;

	private static Logger log = LoggerHelper.getLogger(DeviceDriverManager.class);

	private static String serverUrl;

	private static boolean isAppiumServerCodeStarted = false;

	/* configuring switch 'devices' setting */
	private static synchronized void configSwitchDevice() {
		/* reading from cmd line */
		String cmdSwitchDevice = System.getProperty("device");

		if (cmdSwitchDevice != null) {
			device = Boolean.parseBoolean(cmdSwitchDevice);
		} else {
			/* reading from property file */
			device = Boolean.parseBoolean(appiumPro.getProperty("device"));
		}
	}

	/* configuring switch 'appium server url' setting */
	private static synchronized void configAppiumServerUrl() {
		/* reading from cmd line */
		String cmdSwitchDevice = System.getProperty("appium.server.url");

		if (cmdSwitchDevice != null) {
			serverUrl = cmdSwitchDevice;
		} else {
			/* reading from property file */
			serverUrl = appiumPro.getProperty("appium.server.url");
		}
	}

	/* configuring 'hostname' setting */
	private static synchronized void configHostName() {
		/* reading from cmd line */
		String cmdHost = System.getProperty("appium.hostName");

		if (cmdHost != null) {
			host = cmdHost;
		} else {
			/* reading from property file */
			host = appiumPro.getProperty("appium.hostName");
		}
	}

	/* configuring 'port' setting */
	private static synchronized void configPort() {
		/* reading from cmd line */
		String cmdPort = System.getProperty("appium.port");

		if (cmdPort != null) {
			port = cmdPort;
		} else {
			/* reading from property file */
			port = appiumPro.getProperty("appium.port");
		}
	}

	/* configuring 'automationName' setting */
	private static synchronized void configAutomationName() {
		/* reading from cmd line */
		String cmdAutomationEngine = System.getProperty("appium.automationName");

		if (cmdAutomationEngine != null) {
			automationEngine = cmdAutomationEngine;
		} else {
			/* reading from property file */
			automationEngine = appiumPro.getProperty("appium.automationName");
		}
	}

	/* configuring 'platformName' setting */
	private static synchronized void configPlatformName() {
		/* reading from cmd line */
		String cmdPlatformName = System.getProperty("device.platformName");

		if (cmdPlatformName != null) {
			platformName = cmdPlatformName;
		} else {
			/* reading from property file */
			platformName = appiumPro.getProperty("device.platformName");
		}
	}

	/* configuring 'platformVersion' setting */
	private static synchronized void configPlatformVersion() {
		/* reading from cmd line */
		String cmdPlatformVersion = System.getProperty("device.platformVersion");

		if (cmdPlatformVersion != null) {
			platformVersion = cmdPlatformVersion;
		} else {
			/* reading from property file */
			platformVersion = appiumPro.getProperty("device.platformVersion");
		}
	}

	/* configuring 'DeviceName' setting */
	private static synchronized void configDeviceName() {
		/* reading from cmd line */
		String cmdDeviceName = System.getProperty("device.deviceName");

		if (cmdDeviceName != null) {
			deviceName = cmdDeviceName;
		} else {
			/* reading from property file */
			deviceName = appiumPro.getProperty("device.deviceName");
		}
	}

	/* configuring 'browserName' setting */
	private static synchronized void configBrowserName() {
		/* reading from cmd line */
		String cmdBrowserName = System.getProperty("device.browserName");

		if (cmdBrowserName != null) {
			browserName = cmdBrowserName;
		} else {
			/* reading from property file */
			browserName = appiumPro.getProperty("device.browserName");
		}
	}

	/* configuring 'browserVersion' setting */
	private static synchronized void configBrowserVersion() {
		/* reading from cmd line */
		String cmdBrowserName = System.getProperty("device.browserVersion");

		if (cmdBrowserName != null) {
			browserVersion = cmdBrowserName;
		} else {
			/* reading from property file */
			browserVersion = appiumPro.getProperty("device.browserVersion");
		}
	}
	
	/* configuring 'udid' setting */
	private static synchronized void configDeviceUdid() {
		/* reading from cmd line */
		String cmdDeviceUdid = System.getProperty("device.udid");

		if (cmdDeviceUdid != null) {
			udid = cmdDeviceUdid;
		} else {
			/* reading from property file */
			udid = appiumPro.getProperty("device.udid");
		}
	}
	
	/* configuring 'app' setting */
	private static synchronized void configDeviceApp() {
		/* reading from cmd line */
		String cmdDeviceapp = System.getProperty("device.app");

		if (cmdDeviceapp != null) {
			app = cmdDeviceapp;
		} else {
			/* reading from property file */
			app = appiumPro.getProperty("device.app");
		}
	}
	
	/* configuring 'bundleId' setting */
	private static synchronized void configBundleId() {
		/* reading from cmd line */
		String cmdBundleId = System.getProperty("device.bundleId");

		if (cmdBundleId != null) {
			browserVersion = cmdBundleId;
		} else {
			/* reading from property file */
			bundleId = appiumPro.getProperty("device.bundleId");
		}
	}
	
	public static void config() {
		appiumPro = new PropertyFileUtils("appium.properties");

		configSwitchDevice();

		/* if appium.config file have device switch set as true */
		if (device == true) {
			configAppiumServerUrl();
			configAutomationName();
			configPlatformName();
			configPlatformVersion();
			configDeviceName();
			configBrowserName();
			configBrowserVersion();
			configDeviceUdid();
			configDeviceApp();
			configBundleId();
			
			/*
			 * if user had not specified 'appium.server.url' framework will start the appium
			 * server through code
			 */
			if (serverUrl == null || serverUrl.trim().length() == 0) {

				configHostName();
				configPort();
				/* starting appium server */
				// startAppiumServer();
				startAppiumServerGUI();

				isAppiumServerCodeStarted = true;
			}

		}

	}

	/* Use when appium is install using npm command */
	private static void startAppiumServer() {
		List<String> cmd = Arrays.asList("cmd.exe", "/C", "start", "appium", "-a", host, "-p", port, "-cp", port, "-bp",
				String.valueOf(Integer.parseInt(port) + 1));

		ProcessBuilder builder = new ProcessBuilder(cmd);

		try {
			appiumServerProcee = builder.start();
		} catch (IOException e) {
			log.info("!!! Expection Occured while starting Appium server !!!");
			log.error(e);
			e.printStackTrace();
		}

	}

	/**
	 * To Stop appium server
	 * 
	 * @author 10650956
	 */
	public static void stopAppiumServer() {
		appiumServerProcee.destroyForcibly();
	}

	/* Use when appium is install using GUI (.exe) */
	private static void startAppiumServerGUI() {
		String userName = System.getProperty("user.name");
		String nodeJsFilepath = appiumPro.getProperty("node.filepath");
		String mainJSFilePath = appiumPro.getProperty("appium.main.filepath").replace("${system.username}", userName);

		/*
		 * The drawback of below code is 1. Appium should be install using GUI 2. To
		 * start appium server 'main.js' file need to accessed which is installed in
		 * C:\User..folder
		 */
		// logs by default are generated in GMT time zone
		// changed the GMT time zone to local time zone using
		// withArgument(GeneralServerFlag.LOCAL_TIMEZONE);
		AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodeJsFilepath)).withAppiumJS(new File(mainJSFilePath))
				.withIPAddress(host).usingPort(Integer.parseInt(port)).withLogFile(new File(LoggerHelper.logPath+"\\appium.log"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE);

		service = AppiumDriverLocalService.buildService(appiumServiceBuilder);

		service.start();
	}

	public static void stopAppiumServerGUI() {
		service.stop();
	}

	/**************************************************************************/

	/**
	 * One common method to createSession for browser, android and ios app
	 * 
	 * App type should be provided as browser or app
	 * 
	 * @author 10650956
	 * @param appType
	 * @return
	 * @throws MalformedURLException
	 */
	public static WebDriver createBrowserSession() throws MalformedURLException {

		if (device) {
			switch (browserName.toLowerCase()) {
			case "chrome": {
				/* starting chrome browser session in device */
				driver = new ChromeBrowserDevice().getDriver();
				flag = true;
				break;
			}
			case "safari": {
				/* starting safari browser session in device-IN PROGRESS */
				driver = new SafariBrowserDevice().getDriver();
				flag = true;
				break;
			}
			default: {
				log.error("!!! Browser Support NOT available !!! " + browserName);
				Assert.fail("!!! Browser Support NOT available !!! " + browserName);
			}
			}
		} else {
			flag = false;
		}

		return driver;
	}

	/**
	 * 
	 * @param appfileName
	 * @return
	 * @throws MalformedURLException
	 */
	public static WebDriver createAppSession(String appfileName, String deviceType) throws MalformedURLException {

		if (device) {
			switch (platformName.toLowerCase()) {
			case "android": {
				/* starting android browser session in device */
				driver = new AndroidAppDriver().getDriver(appfileName,deviceType);
				flag = true;
				break;
			}
			case "ios": {
				/* starting ios session in device-IN PROGRESS */
				driver = new IOSAppDriver().getDriver(appfileName,deviceType);
				flag = true;
				break;
			}
			default: {
				log.error("!!! Platform Support NOT available !!! " + platformName);
				Assert.fail("!!! Platform Support NOT available !!! " + platformName);
			}
			}
		} else {
			flag = false;
		}

		return driver;
	}

	/**
	 * 
	 * @param appPackage
	 * @param appActivity
	 * @return
	 * @throws MalformedURLException
	 */
	public static WebDriver createAppSession(String appPackage, String appActivity, String deviceType) throws MalformedURLException {

		if (device) {
			/* starting chrome browser session in device */
			driver = new AndroidAppDriver().getDriver(appPackage, appActivity);
			flag = true;
			
		} else {
			flag = false;
		}

		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	
	/**
	 * Close all the application open in devices
	 */
	public static void closeApp() {
		flag=false;
		((AppiumDriver<?>)driver).closeApp();
	}
	
	public static void runAppInBackground(int seconds) {
		((AppiumDriver<?>)driver).runAppInBackground(Duration.ofSeconds(seconds));
	}
	
	public static void backButton() {
		((PressesKey)driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}
	

	public static void quit() {
		flag=false;
		driver.quit();
	}

	/**
	 * Get device switch
	 * 
	 * @return
	 */
	public static boolean getDeviceSwitch() {
		return device;
	}

	public static String getPlatformName() {
		return platformName;
	}

	public static PropertyFileUtils getAppiumPro() {
		return appiumPro;
	}

	public static String getHost() {
		return host;
	}

	public static String getPort() {
		return port;
	}

	public static String getAutomationEngine() {
		return automationEngine;
	}

	public static String getPlatformVersion() {
		return platformVersion;
	}

	public static String getDeviceName() {
		return deviceName;
	}

	public static String getBrowserName() {
		return browserName;
	}

	public static String getBrowserVersion() {
		return browserVersion;
	}

	

	public static Process getAppiumServerProcee() {
		return appiumServerProcee;
	}

	public static AppiumDriverLocalService getService() {
		return service;
	}

	public static Logger getLog() {
		return log;
	}

	public static boolean getflag() {
		return flag;
	}

	public static void setflag(boolean flag) {
		DeviceDriverManager.flag = flag;
	}

	public static String getServerUrl() {
		return serverUrl;
	}

	public static boolean isAppiumServerCodeStarted() {
		return isAppiumServerCodeStarted;
	}
	
	public static String getApp() {
		return app;
	}
	
	public static String getUdid() {
		return udid;
	}
	
	public static String getDeviceBundleId() {
		return bundleId;
	}


}
