package qa.framework.webui.browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import qa.framework.utils.GlobalVariables;

public class IEBrowser implements BrowserInterface {
	private WebDriver driver;

	@Override
	public WebDriver getDriver() {
		System.setProperty("webdriver.ie.driver",
				System.getProperty("userDir") + "/src/test/resources/drivers/IEDriverServer.exe");
		this.driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(GlobalVariables.waitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

}
