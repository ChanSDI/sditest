package ProjectSpecificBase;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import utils.Mobile_Html_Reporter;

public class AndroidBase extends Mobile_Html_Reporter {
	@BeforeMethod
	public void precondition() throws MalformedURLException {

		node = test.createNode(testName);

		launchAndroidApp(getConfigurations("DeviceName"), getConfigurations("AndroidAppPath"),
				getConfigurations("AppPackage"), getConfigurations("AppActivity"));

	}

	@AfterMethod(alwaysRun = true)
	public void postcondition() throws Exception {

		closeApp();

	}

}
