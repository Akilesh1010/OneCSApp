package qa.framework.webui.browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import qa.framework.utils.FileManager;
import qa.framework.utils.GlobalVariables;

public class FirefoxBrowser implements BrowserInterface {
	private WebDriver driver;
	@Override
	public WebDriver getDriver() {
		String userDir = System.getProperty("user.dir"); //this gives you absolute path of the user directory
		System.setProperty("webdriver.gecko.driver", userDir + "/src/test/resources/drivers/gecko_"+WebDriverManager.getDriverVerison()+".exe");
		
		FirefoxProfile profile = new FirefoxProfile();
		/* disabling download pop*/
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"image/jpeg,application/pdf,application/octet-stream,application/zip");
		
		/* user specified download folder config */
		profile.setPreference("browser.download,folderList", 2);
		
		/*download folder path*/
		profile.setPreference("browser,download.dir",
				FileManager.downloadFolderFilePath());
		
		profile.setPreference("pdfjs.disabled", "true");
	//	profile.setPreference("network.automatic-ntlm-auth.trusted-uris", "google.com");


		/*handling certificate issue*/
		profile.setAcceptUntrustedCertificates(true);
		
		FirefoxOptions option = new FirefoxOptions();
	/*
		ProfilesIni allProfiles = new ProfilesIni();         
		profile = allProfiles.getProfile("selenium_profile");

		option.setProfile(profile);

		option.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		
	 
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
	*/	
		driver=new FirefoxDriver(option);
		//driver = new FirefoxDriver(dc);
		driver.manage().timeouts().implicitlyWait(GlobalVariables.waitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}

}
