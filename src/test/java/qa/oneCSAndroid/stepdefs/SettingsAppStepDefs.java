package qa.oneCSAndroid.stepdefs;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.framework.dbutils.SQLDriver;
import qa.framework.device.DeviceActions;
import qa.framework.device.DeviceDriverManager;
import qa.oneCSAndroid.pages.SettingsAppSettingsScreen;

public class SettingsAppStepDefs {
	
	DeviceActions action = new DeviceActions(SQLDriver.getEleObjData("SettingsApp_SettingsScreen"));
	SettingsAppSettingsScreen settings = new SettingsAppSettingsScreen();
	
	@When("user clicks on Sounds and Vibration option")
	public void user_clicks_on_Sounds_and_Vibration_option() throws InterruptedException {
		settings.clickSoundsAndVibration();	
		Thread.sleep(2000);
	}

	@Then("user switch the Sound mode to {string}")
	public void user_switch_the_Sound_mode_to_Vibrate(String mode) throws InterruptedException {
	  switch(mode) {
	  case "Vibrate":
		  DeviceActions.click((MobileElement) action.getElement("VIBRATE_BTN"));
		  break;
	
	  case "Mute":
		  DeviceActions.click((MobileElement) action.getElement("MUTE_BTN"));
		  break;
	  
	  case "Sound":
		  DeviceActions.click((MobileElement) action.getElement("SOUND_BTN"));
		  break;
	  }
	  Thread.sleep(2000);  
	}

	@Then("user enables Temporary mute option")
	public void user_enables_Temporary_mute_option() throws InterruptedException {
	    settings.clickTemporaryMute();
	    Thread.sleep(2000);
	}

	@Then("user enables Vibrate while ringing option")
	public void user_enables_Vibrate_while_ringing_option() throws InterruptedException {
		settings.clickTemporaryMute();
		Thread.sleep(2000);
	}
	
	@Then("user scroll through the screen to click {string} option")
	public void user_scroll_through_the_screen_to_click_About_Phone_option(String option) throws InterruptedException {
		Thread.sleep(2000);
		DeviceActions.scrollAndClick(option);		
	}

	@Then("user clicks {string} to view the details")
	public void user_clicks_to_view_the_details(String btnName) throws InterruptedException {
		settings.InformationBtnClick(btnName);
		Thread.sleep(2000);
		settings.backNavigation();
	}

}
