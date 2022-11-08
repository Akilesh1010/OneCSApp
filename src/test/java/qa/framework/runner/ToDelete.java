package qa.framework.runner;

import java.awt.Color;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;


import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import java.time.Duration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import qa.framework.device.DeviceDriverManager;
import qa.framework.device.DeviceWaitManager;
import qa.framework.httpclient.HttpClientUtils;
import qa.framework.httpclient.MethodType;
import qa.framework.httpclient.RetriveResponse;
import qa.framework.maths.MathFunctions;
import qa.framework.utils.Action;
import qa.framework.utils.GlobalVariables;
import qa.framework.webui.browsers.WebDriverManager;
import qa.framwork.excel.CellBorder;
import qa.framwork.excel.ExcelOperation;
import qa.framwork.excel.ExcelUtils;

public class ToDelete {

	private static final String MobileElement = null;


	@Test(enabled = false)
	public void Excell() {

		ExcelUtils obj = new ExcelUtils(ExcelOperation.LOAD, "dummy.xlsx");
		XSSFSheet sheet = obj.getSheet("Sheet1");

		obj.setCellData(sheet, 2, 2, "value");

		obj.setStyle(sheet, 2, 2)

				.setCellBorder(CellBorder.ALL, BorderStyle.THIN, Color.BLACK)

				.setAlignment(HorizontalAlignment.LEFT, VerticalAlignment.TOP)

				.setBackgroundColor(Color.CYAN, FillPatternType.SOLID_FOREGROUND)

				.setFontStyle(Color.RED, true, true, true)

				.build();

		obj.write();
		obj.closeWorkBook();

	}

	@Test(enabled = false)
	public void HttpClientTest() throws Exception {

		HttpClientUtils.baseURI = "https://application.com/something";
		HttpClientUtils.basePath = "/Entity/{resourceId}";

		RetriveResponse response = HttpClientUtils.given().setPathParameter("resourceId", "123").buildURI()
				.setCertificate("<path of .pfx certificate>", "<password>").executeRequest(MethodType.GET);

		int statusCode = response.getStatusCode();
		String body = response.getBody().asString();
		String satusLine = response.getSatusLine();

		Object jsonPath = response.getBody().jsonPath("equityInfo.Dividens");

	}

	@Test(enabled = false)
	public void HttpClientPath() throws Exception {

		String body = "{\r\n" + "  \"id\": ${unique},\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "  \"name\": \"doggie\",\r\n" + "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n" + "    {\r\n" + "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ],\r\n" + "  \"status\": \"available\"\r\n" + "}";

		int id = MathFunctions.getRandomNumber(9, 999);
		System.out.println(id);

		body = body.replace("${unique}", String.valueOf(id));

		HttpClientUtils.baseURI = "https://petstore.swagger.io/v2";

		HttpClientUtils.basePath = "/pet";

		RetriveResponse response = HttpClientUtils.given().buildURI().setBody(body).setContentType("application/json")
				.executeRequest(MethodType.POST);

		HttpClientUtils.basePath = "/pet/{petId}";

		response = HttpClientUtils.given().setPathParameter("petId", String.valueOf(id)).buildURI()
				.executeRequest(MethodType.GET);
		System.out.println(response.getBody().asString());
	}

	@Test(enabled = false)
	public void HttpClientQuery() throws Exception {
		HttpClientUtils.baseURI = "https://petstore.swagger.io/v2";
		HttpClientUtils.basePath = "/user/login";

		RetriveResponse response = HttpClientUtils.given().buildURI().setQueryParameter("username", "LoginUser")
				.setQueryParameter("password", "password").executeRequest(MethodType.GET);

		int statusCode = response.getStatusCode();
		String body = response.getBody().asString();
		String satusLine = response.getSatusLine();

		System.out.println(statusCode);
		System.out.println(body);

	}

//	C:\Users\10650956\AppData\Local\Android\Sdk\tools\bin

	// driver.pressKey(new KeyEvent(AndroidKey.HOME));
	// driver.pressKey(new KeyEvent(AndroidKey.A));
	// driver.toggleWifi();
	// driver.toggleAirplaneMode();

	@Test(enabled = false)
	public void app() throws InterruptedException {

		DeviceDriverManager.config();

		try {

			// com.google.android.permissioncontroller
			// com.android.permissioncontroller.permission.ui.ReviewPermissionsActivity

			DeviceDriverManager.createAppSession("selendroid-test-app-0.17.0.apk","");

			WebDriver driver = DeviceDriverManager.getDriver();

			// driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
			try {
				// driver.findElement(By.id("android:id/button1")).click();
			} catch (Exception e) {
				// do nothing
			}

			driver.findElement(MobileBy.id("io.selendroid.testapp:id/startUserRegistration")).click();

			driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys("Manjunath01");

			driver.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys("Manjunath01@gmail.com");

			driver.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys("password");

			driver.findElement(By.id("io.selendroid.testapp:id/inputName")).clear();
			driver.findElement(By.id("io.selendroid.testapp:id/inputName")).sendKeys("Mr. Manujnath Reddy");

			// String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\"
			// \")";
			String scrollViewContainer_finder = "new UiSelector().className(\"android.widget.LinearLayout\")";
			String neededElement_finder = "new UiSelector().text(\"Name\")";

			// WebElement abc = driver.findElement(MobileBy.AndroidUIAutomator("new
			// UiScrollable(" + scrollViewContainer_finder + ")" +".scrollIntoView(" +
			// neededElement_finder + ")"));

			((AndroidDriver<WebElement>) driver).pressKey(new KeyEvent(AndroidKey.BACK));

			driver.findElement(By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage")).click();

			@SuppressWarnings("unchecked")
			List<WebElement> programmingLanguages = (List<WebElement>) driver
					.findElements(By.className("android.widget.CheckedTextView"));

			for (WebElement option : programmingLanguages) {

				String des = option.getText();

				if (des.equalsIgnoreCase("java")) {
					option.click();

					break;

				}
			}

			driver.findElement(By.id("io.selendroid.testapp:id/input_adds")).click();

			driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();

			String name = driver.findElement(By.id("io.selendroid.testapp:id/label_name_data")).getText();

			System.out.println(name);

			((AppiumDriver)driver).closeApp();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}

	}

	@Test(enabled = false)
	public void chrome() {

		String userDir = System.getProperty("user.dir");

		DeviceDriverManager.config();

		AppiumDriver<?> driver = null;

		try {
			//DeviceDriverManager.createSession("browser");

			driver = (AppiumDriver<?>)DeviceDriverManager.getDriver();

			driver.get("https://www.amazon.in/");

			driver.findElement(MobileBy.id("nav-search-keywords")).sendKeys("Mobile");

			driver.findElement(MobileBy.xpath("//input[@type='submit'][@value='Go']")).click();

			// take screenshot

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
			DeviceDriverManager.stopAppiumServerGUI();
		}
	}

	@Test(enabled = false)
	public void hybrid() {

		DeviceDriverManager.config();

		AppiumDriver<?> driver = null;

		try {
		//	DeviceDriverManager.createSession("app");

			driver = (AppiumDriver<?>)DeviceDriverManager.getDriver();

			driver.findElement(MobileBy.id("io.selendroid.testapp:id/buttonStartWebview")).click();

			// driver.findElement(MobileBy.id("io.selendroid.testapp:id/spinner_webdriver_test_data")).click();

			// driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='formPage']")).click();

			Action.pause(5000);

			driver.findElement(MobileBy.id("name_input")).clear();

			Set<String> contextHandles = driver.getContextHandles();

			Iterator<String> iterator = contextHandles.iterator();
			while (iterator.hasNext()) {
				String context = iterator.next();
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + context);
				if (context.contains("WEBVIEW")) {
					driver.context(context);
					break;
				}
			}

			// driver.context("WEBVIEW_0");

			driver.findElement(By.id("email")).sendKeys("yogeshkumar.bathri@lntinfotech.com");

			WebElement eleDropDown = driver.findElement(MobileBy.xpath("//select[@name='selectomatic']"));

			Select select = new Select(eleDropDown);

			select.selectByVisibleText("Still learning how to count, apparently");

			driver.context("NATIVE_APP");

			driver.findElement(MobileBy.id("io.selendroid.testapp:id/goBack")).click();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.closeApp();
			DeviceDriverManager.stopAppiumServerGUI();
		}
	}

		
	@Test(enabled=true)
	public void app2() throws MalformedURLException {
		
		DeviceDriverManager.config();
		
		WebDriver driver = DeviceDriverManager.createAppSession("io.selendroid.testapp", ".HomeScreenActivity");
		
		driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("Android APP Test");
		
		/*clicked on progress bar button*/
		driver.findElement(By.id("io.selendroid.testapp:id/waitingButtonTest")).click();
		
		String percent = driver.findElement(By.id("android:id/progress_percent")).getText();
		
		try {
			while(!percent.contains("100")) {
				percent = driver.findElement(By.id("android:id/progress_percent")).getText();
				Action.pause(200);
			}
			
		}catch (Exception e) {
			
		}
		
		Action.pause(500);
		
		AndroidDriver<MobileElement> aDriver =  (AndroidDriver<MobileElement>)driver;
		aDriver.pressKey(new KeyEvent(AndroidKey.BACK));
		Action.pause(500);
		aDriver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		/*text verification*/
		driver.findElement(By.id("io.selendroid.testapp:id/visibleButtonTest")).click();
		String actual = driver.findElement(By.id("io.selendroid.testapp:id/visibleTextView")).getText();
		System.out.println(actual);
		
		/*display popup*/
		driver.findElement(By.id("io.selendroid.testapp:id/showPopupWindowButton")).click();
		
		driver.findElement(By.id("io.selendroid.testapp:id/showPopupWindowButton")).click();
		
		aDriver.closeApp();
		
	}
	
	
}
