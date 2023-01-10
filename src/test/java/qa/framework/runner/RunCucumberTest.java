package qa.framework.runner;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import qa.framework.dbutils.SQLDriver;
import qa.framework.desktop.DesktopDriverManager;
import qa.framework.device.DeviceDriverManager;
import qa.framework.utils.Action;
import qa.framework.utils.GlobalVariables;
import qa.framework.utils.PropertyFileUtils;
import qa.framework.utils.Reporter;
import qa.framework.webui.browsers.WebDriverManager;

@CucumberOptions(
		
		plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",	
		"html:target/cucumber-html-report",
		"json:target/cucumber.json",
		"pretty:target/cucumber-pretty.txt",
		"usage:target/cucumber-usage.json",
		"junit:target/cucumber-results.xml" },
		features = {"src/test/resources" },
		glue = { 
				"qa/framework/runner",
				"qa/framework/api/common/stepdefs",
				"qa/framework/webui/common/stepdefs",
				"qa/framework/desktop/common/stepdefs",
				"qa/framework/device/common/stepdefs",
				
				"qa/biba/webui/setpdefs",
				"qa/petstore/api/stepdefs",
				"qa/amazon/webui/stepdefs",
				"qa/notepad/desktop/stepdefs",
				"qa/selenium/device/stepdefs",
				"qa/amazon/device/stepdefs",
				"qa/oneCS/webui/stepdefs",
				"qa/websiteRedesign/stepdefs",
				"qa/oneCSiOS/stepDefs",
				"qa/oneCSAndroid/stepdefs"
		},
		
		
		//tags = { "@td_PTS_API_Pet or @Amazon-Smoke or @NotePad or @AndroidDemo"}
		//tags = { "@Sprint1, @Sprint3, @Sprint4, @Sprint5, @Sprint6, @Sprint7, @Sprint8"}

		//tags = {"@Dashboard, @St47, @Pord50, @Pord153, @Pord48, @Pord51, @Pord52, @Pord67, @Pord469, @Pord41, @Pord361"}

//		tags = {"@HomePage, @Ind-WhatWeOffer, @Ind-AboutYou, @Ind-Insights, @Ind-HelpAndContact, @Ind-AboutCS, @FinancialAdvisers, @FA-WhatWeOffer, @FA-Insights, @FA-HelpAndContact, @FA-AboutCS, @ProfessionalsPage, @Prof-WhatWeOffer, @Prof-Insights, @Prof-HelpAndContactPage, @PROF-AboutCS, @CharitiesHomePage, @Charities-InvestManagement, @Charities-Insights, @Charities-HelpAndContactPage, @Charities-AboutCS, @PensionTrustees, @Pension-FiduciaryManagement, @Pension-Insights, @Pension-HelpAndContact, @Pension-AboutCS, @RequestACallBack"}
//		tags = {"@Test59"}

		tags = {"@9.06_Android"}

	)

 public class RunCucumberTest extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = false)

	public Object[][] scenarios() {
		return super.scenarios();

	}

	@BeforeSuite
	public void initialSetUp() throws IOException, InterruptedException {
		/* Initiating configuration properties file */
		GlobalVariables.configProp = new PropertyFileUtils("config.properties");

		/* Clean Report folder */
		Reporter.cleanReportFolder();

		/* config screenshot per action */
		Action.configScrCapPerAction();

		/* config web driver */
		WebDriverManager.configureDriver();

		/*
		 * config test data column as per client,environment and language are configured
		 * here
		 */
		SQLDriver.configSQL();

		/* 1st Step:config mainframe */
//		LaunchMainframeTerminal.configMainframe();
//
//		if (LaunchMainframeTerminal.mainframe.trim().equalsIgnoreCase("true")) {
//			/* This method is called to avoid Emulator(keyboard) popup to appear */
//			LaunchMainframeTerminal.updateDefaultKeyBoard_IBMPCOM_WS();
//			/* 2nd step:starting LeanFT */
//			Leanft.startEngine();
//			/* 3rd step:launch terminal is in before method */
//			/* 4th step:closing terminal is in after method */
//		}
		/* configuring jira update */
		// JiraAPI.configJiraUpdate();

		/* configuring and starting WinAppDriver server settings */
		// DesktopDriverManager.config();

		/* configuring and starting Appium server */
		 DeviceDriverManager.config();
		
		//Create browser session only once
//		WebDriverManager.startDriver();
//		WebDriverManager.setWebUIFlag(true);

	}

	@AfterSuite
	public void destroy() {
		/* killing browser process */
//		WebDriverManager.killDriverProcess();

//		if (LaunchMainframeTerminal.mainframe.trim().equalsIgnoreCase("true")) {
//			/* stopping leanft */
//			Leanft.stopEngine();
//		}
		/* creating a file to write jira field and values */
//		if (JiraAPI.enableJiraUpdate == true) {
//			JiraReport.write("ExecutionReport", ".txt");
//
//			if (JiraAPI.autoUpdateJiraRecords == true) {
//				JiraAPI.runJiraUpdate(JiraReport.filePath);
//			}
//		}
		/* Extent report customization */
		Reporter.reportCustomization();

		/* Killing WinAppDriver process */
		if (DesktopDriverManager.getDesktopSwitch() == true) {
			DesktopDriverManager.stopDriver();
		}

		/* Killing Appium server */
		if (DeviceDriverManager.getDeviceSwitch() == true && DeviceDriverManager.isAppiumServerCodeStarted() == true) {
			// DeviceDriverManager.stopAppiumServer();
			DeviceDriverManager.stopAppiumServerGUI();
		}
		
//		WebDriverManager.quitDriver();
//    	WebDriverManager.setWebUIFlag(false);

		/* creating a files to write jira field and values */
		/*
		 * if (JiraAPI.enableJiraUpdate == true) { JiraReport.write("ExecutionReport",
		 * ".txt");
		 * 
		 * if (JiraAPI.autoUpdateJiraRecords == true) {
		 * JiraAPI.runJiraUpdate(JiraReport.filePath); } JiraAPI.uploadZipReport(); } }
		 */
	}
}
