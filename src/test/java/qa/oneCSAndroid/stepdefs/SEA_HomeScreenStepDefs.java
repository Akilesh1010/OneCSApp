package qa.oneCSAndroid.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.framework.assertions.AssertLogger;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.utils.Reporter;
import qa.oneCSAndroid.pages.SEA_HomeScreen;

public class SEA_HomeScreenStepDefs {

	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("MobileApp_HomeScreen"));
	SEA_HomeScreen objHomeScreen = new SEA_HomeScreen();
	
	@When("^navigate to registration page on the app$")
    public void navigate_to_registration_page_on_the_app() throws InterruptedException {
		Thread.sleep(2000);
		objHomeScreen.clickRegisterUserFolderIcon();
    }
	
	@When("^user enter text \"([^\"]*)\" on the app$")
    public void user_enter_text_something_on_the_app(String value) throws InterruptedException  {
        objHomeScreen.enterText(value);
        Thread.sleep(2000);
    }

    @When("^user enable popup on the app$")
    public void user_enable_popup_on_the_app() throws InterruptedException  {
    	objHomeScreen.openPopup();
    	Reporter.addDeviceScreenshot(null, null);
    	Thread.sleep(2000);
    }

    @Then("^user verified display text as \"([^\"]*)\"$")
    public void user_verified_display_text_as_something(String expected) throws InterruptedException  {
    	String actual = objHomeScreen.getDispalyText();
    	Reporter.addDeviceScreenshot(null, null);
    	AssertLogger.assertEquals(actual, expected, "Text didn't matched!!");
    	Thread.sleep(2000);
    }

    @Then("^user should be able to disable the popup on the app$")
    public void user_should_be_able_to_disable_the_popup_on_the_app()  {
        objHomeScreen.closePopup();
    }

    @And("^user enabled progress bar$")
    public void user_enabled_progress_bar()  {
        objHomeScreen.enableProgressBar();
    }

    @And("^user enable dispaly text$")
    public void user_enable_dispaly_text()  {
    	objHomeScreen.enableDispalyText();
    	Reporter.addDeviceScreenshot(null, null);
    	
    }
	
}
