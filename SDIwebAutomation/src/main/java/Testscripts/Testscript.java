package Testscripts;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ProjectSpecificBase.iOSBase;
import pages.login;

public class Testscript extends iOSBase {

	@BeforeTest

	public void setValues() {

		testName = "Login and LoginOut";

		testDescription = "Login for Failure";

		category = "test";

		testAuthor = "aravindh";

	}

	@Test
	public void run_testscript() throws Exception {
		
		login log = new login(driver, node);
		log.allow_notifications().enterusername("test").enterpassword("tyest");
		

			

	}
}