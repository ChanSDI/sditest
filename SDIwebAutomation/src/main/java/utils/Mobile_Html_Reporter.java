package utils;

import java.io.File;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ImplementationBase.MobileImplementationBase;

public class Mobile_Html_Reporter extends MobileImplementationBase {
	public static ExtentReports extent;

	public String testName, testDescription, category, testAuthor, testNodes;
	public String executedBy = getConfigurations("executedBy");
	public ExtentTest test, node;

	public static String folderName = "";
	private String fileName = "result.html";

	@BeforeSuite
	public void startReport() throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		folderName = "reports/" + timeStamp;

		File folder = new File("./" + folderName);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		extent = new ExtentReports();

		ExtentSparkReporter reporter = new ExtentSparkReporter("./" + folderName + "/" + fileName);

		reporter.loadXMLConfig(getConfigurations("xmlconfigpath"));

		extent.attachReporter(reporter);

		readLocator(getConfigurations("locatorpath"), "Sheet1");

	}

	@BeforeMethod
	public void report() throws IOException {

		test = extent.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);
		test.assignCategory(category);
		test.assignCategory(executedBy);

	}

	public String takeSnap() throws IOException {

		int randomNum = (int) (Math.random() * 999999 + 999999);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./" + folderName + "/images/" + randomNum + ".jpg");
		FileUtils.copyFile(source, target);
		String absolutePath = target.getAbsolutePath();
		return absolutePath;

	}

	public void reportStep(String msg, String status) throws Exception {

		if (status.equalsIgnoreCase("pass")) {
			node.pass(msg, MediaEntityBuilder.createScreenCaptureFromPath(takeSnap()).build());

		} else if (status.equalsIgnoreCase("fail")) {
			node.fail(msg, MediaEntityBuilder.createScreenCaptureFromPath(takeSnap()).build());

		} else if (status.equalsIgnoreCase("info")) {
			node.info(msg, MediaEntityBuilder.createScreenCaptureFromPath(takeSnap()).build());

		}

	}

	@AfterSuite(alwaysRun = true)
	public void stopReport() throws Exception {

		extent.flush();

	}

}
