package pages;

import com.aventstack.extentreports.ExtentTest;

import ProjectSpecificBase.iOSBase;
import io.appium.java_client.AppiumDriver;

public class login extends iOSBase {

	public login(AppiumDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;

	}

	public login allow_notifications() throws Exception {

		try {
			
			waitUntilElementIsClickable(40, getLocator("login", "not1"));
			clickElement(getLocator("login", "not1"));
			reportStep("The user has clicked the notifications 1", "pass");

		} catch (Exception e) {
			reportStep("The user was not able to click notifications 1 because of the exception " + e + "", "pass");
		}

		try {
			waitUntilElementIsClickable(40, getLocator("login", "not2"));
			clickElement(getLocator("login", "not2"));
			reportStep("The user has clicked the notifications 2", "pass");

		} catch (Exception e) {
			reportStep("The user was not able to click notifications 2 because of the exception " + e + "", "pass");
		}
		try {
			waitUntilElementIsClickable(40, getLocator("login", "not3"));
			clickElement(getLocator("login", "not3"));
			reportStep("The user has clicked the notifications 3", "pass");

		} catch (Exception e) {
			reportStep("The user was not able to click notifications 3 because of the exception " + e + "", "pass");
		}

		try {
			waitUntilElementIsClickable(40, getLocator("login", "not4"));
			clickElement(getLocator("login", "not4"));
			reportStep("The user has clicked the notifications 4", "pass");
		} catch (Exception e) {
			reportStep("The user was not able to click notifications 4 because of the exception " + e + "", "pass");
		}
		try {
			waitUntilElementIsClickable(40, getLocator("login", "not5"));
			clickElement(getLocator("login", "not5"));
			reportStep("The user has clicked the notifications 5", "pass");

		} catch (Exception e) {
			reportStep("The user was not able to click notifications 5 because of the exception " + e + "", "pass");
		}
		return this;

	}

	public login enterusername(String username) throws Exception {
		try {

			waitUntilElementIsClickable(40, getLocator("login", "username"));
			EnterInput(username, getLocator("login", "username"));

			reportStep("The user has entered the user name " + username + "", "pass");

		} catch (Exception e) {

			reportStep("The user has  not entered the user name" + username + " and the exception is " + e + "",
					"fail");

		}
		return this;
	}

	public login enterpassword(String password) throws Exception {

		try {

			EnterInput(password, getLocator("login", "password"));

			reportStep("The user has entered the password", "pass");

		} catch (Exception e) {
			reportStep("The user has not entered the password and the exception is " + e + "", "fail");

		}
		return this;

	}

}
