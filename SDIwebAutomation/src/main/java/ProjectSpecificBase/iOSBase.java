package ProjectSpecificBase;

import java.lang.reflect.Method;

import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.Mobile_Html_Reporter;

public class iOSBase extends Mobile_Html_Reporter {

	@BeforeMethod
	public void precondition() throws MalformedURLException {

		node = test.createNode(testName);
		launchiOSApp(getConfigurations("Platformversion"), getConfigurations("DeviceName"),
				getConfigurations("AutomationName"), getConfigurations("Udid"), getConfigurations("iOSAppPath"),
				getConfigurations("BundleID"));

	}

	@AfterMethod(alwaysRun = true)
	public void postcondition() throws Exception {

		closeApp();

	}

}
