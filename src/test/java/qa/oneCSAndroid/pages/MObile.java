package qa.oneCSAndroid.pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;

public class MObile {

	@Test
	public static void runtests() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("browserstack.user", "akileshs_K8NpOV");
		capabilities.setCapability("browserstack.key", "b4pfJpJmheYkiJoqhtax");

		// Set URL of the application under test
		capabilities.setCapability("app", "bs://c75a77018706c6ebbe514627b832a20035a95f01");

		capabilities.setCapability("device", "Google Pixel 3");
		capabilities.setCapability("os_version", "9.0");

		// Set other BrowserStack capabilities
		capabilities.setCapability("project", "First Java Project");
		capabilities.setCapability("build", "browserstack-build-1");
		capabilities.setCapability("name", "OneCS Digital");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://hub.browserstack.com/wd/hub"), capabilities);
		driver.findElementByXPath("//android.widget.Button[@index='1']").click();
		driver.findElementByXPath("(//android.widget.EditText)[1]").sendKeys("bob");
		driver.findElementByXPath("(//android.widget.EditText)[2]").sendKeys("Pass123$");
		driver.findElementByXPath("(//android.widget.Button)[4]").click();
//		driver.findElementByXPath("//android.widget.EditText[@package='com.charlesstanley.android.mock']").sendKeys("000000");
//		driver.findElementByXPath("(//android.widget.Button[@package='com.charlesstanley.android.mock'])[3]").click();
//		driver.findElementByXPath("//android.widget.EditText").sendKeys("258036");
//		driver.findElementByXPath("(//android.widget.Button)[2]").click();
//		Thread.sleep(4000);
//		driver.findElementByXPath("//android.widget.EditText").sendKeys("258036");
//		driver.findElementByXPath("(//android.widget.Button)[2]").click();
//		
		
		//driver.quit();

	}
}
