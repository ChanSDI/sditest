package ImplementationBase;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Design.AndroidSpecificActions;
import Design.CommonMobileActions;
import Design.ExcelSpecificActionsForMobile;
import Design.iOSSpecificActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HasOnScreenKeyboard;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.connection.HasNetworkConnection;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.SupportsContextSwitching;

public class MobileImplementationBase
		implements AndroidSpecificActions, CommonMobileActions, iOSSpecificActions, ExcelSpecificActionsForMobile {

	public AppiumDriver driver;
	public WebDriverWait wait;

	public static HashMap<String, String> locator;

	public static final int MAXIMUM_SCROLL = 5;

	@Override
	public void launchiOSApp(String platformversion, String deviceName, String automationName, String udid,
			String appPath, String bundleID) throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("newCommandTimeout", "5000");

		dc.setCapability("platformName", "iOS");
		dc.setCapability("platformVersion", platformversion);
		dc.setCapability("deviceName", deviceName);
		dc.setCapability("automationName", automationName);
		dc.setCapability("udid", udid);
		dc.setCapability("app", appPath);
		dc.setCapability("bundleId", bundleID);
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5000);
		driver = new IOSDriver(new URL("http://0.0.0.0:4723/"), dc);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Override
	public void click_KeyBoardButtonByName(String name) {

		if (isKeyboardVisible()) {
			String name1 = name;
			clickElement(name1);

		}

	}

	@Override
	public void click_KeyBoardButtonByXpath(String xpath) {
		if (isKeyboardVisible()) {
			clickElement(xpath);

		}

	}

	@Override
	public WebElement locateElement(String locator) {
		String[] split = locator.split("=", 2);
		String locatortype = split[0];
		String lvalue = split[1];
		switch (locatortype) {
		case "id":
			return driver.findElement(By.id(lvalue));
		case "xpath":
			return driver.findElement(By.xpath(lvalue));
		case "accessibilityid":
			return driver.findElement(AppiumBy.accessibilityId(lvalue));
		case "name":
			return driver.findElement(By.name(lvalue));
		}
		return null;

	}

	@Override
	public boolean elementIsDisplayed(String locator) {
		try {
			boolean displayed = locateElement(locator).isDisplayed();
			return displayed;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean verifyElementtext(String locator, String expected) {
		boolean text = false;
		String name = locateElement(locator).getText();
		if (name.equals(expected)) {
			text = true;

		} else {
			text = false;
		}
		return text;
	}

	@Override
	public boolean verifyElementContainsText(String locator, String expected) {
		boolean text = false;
		String name = locateElement(locator).getText();
		if (name.contains(expected)) {
			text = true;

		} else {
			text = false;
		}
		return text;

	}

	@Override
	public boolean scroll(double d, double e, double f, double g) {
		int maxY = driver.manage().window().getSize().getHeight();
		int maxX = driver.manage().window().getSize().getWidth();
		PointerInput input = new PointerInput(Kind.TOUCH, "finger 1");
		Sequence finger1 = new Sequence(input, 1);
		finger1.addAction(
				input.createPointerMove(Duration.ofMillis(0), Origin.viewport(), (int) (maxX * d), (int) (maxY * e)));
		finger1.addAction(input.createPointerDown(MouseButton.LEFT.asArg()));
		finger1.addAction(
				input.createPointerMove(Duration.ofMillis(500), Origin.viewport(), (int) (maxX * f), (int) (maxY * g)));
		finger1.addAction(input.createPointerUp(MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(finger1));
		return true;

	}

	@Override
	public boolean swipeUp() {

		return scroll(0.5, 0.8, 0.5, 0.2);

	}

	@Override
	public boolean swipeDown() {

		return scroll(0.5, 0.2, 0.5, 0.8);

	}

	@Override
	public boolean swipeRight() {

		return scroll(0.2, 0.5, 0.8, 0.5);

	}

	@Override
	public boolean swipeLeft() {

		return scroll(0.8, 0.5, 0.2, 0.5);

	}

	@Override
	public void clickElement(String locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(locateElement(locator)));
		locateElement(locator).click();

	}

	@Override
	public void EnterInput(String locator, String text) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(locateElement(locator)));
		WebElement ele = locateElement(locator);
		ele.clear();
		ele.sendKeys(text);
		// hideKeyboard();

	}

	@Override
	public String getElementText(String locator) {

		String text = locateElement(locator).getText();
		return text;

	}

	@Override
	public void switchToAnotherApp(String bundleIDOrAppPackage) {
		((InteractsWithApps) driver).activateApp(bundleIDOrAppPackage);

	}

	@Override
	public void printAppContext() {
		Set<String> contextHandles = ((SupportsContextSwitching) driver).getContextHandles();
		for (String context : contextHandles) {
			System.out.println(context);
		}

	}

	@Override
	public boolean switchAppcontext(String context) {
		((SupportsContextSwitching) driver).context(context);
		return true;
	}

	@Override
	public boolean switchToNativeView() {
		Set<String> contextHandles = ((SupportsContextSwitching) driver).getContextHandles();
		for (String context : contextHandles) {
			if (context.contains("NATIVE_APP")) {
				((SupportsContextSwitching) driver).context(context);
			}

		}
		return true;

	}

	@Override
	public void pointerClick(int x, int y) {
		PointerInput input = new PointerInput(Kind.TOUCH, "finger1");
		Sequence finger1 = new Sequence(input, 1);
		finger1.addAction(input.createPointerMove(Duration.ofMillis(0), Origin.viewport(), x, y));
		finger1.addAction(input.createPointerDown(MouseButton.LEFT.asArg()));
		finger1.addAction(input.createPointerUp(MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(finger1));

	}

	@Override
	public boolean swipeUpTillElementVisible(String locator) {
		int i = 1;
		while (!elementIsDisplayed(locator)) {
			swipeUp();
			i++;
			if (i == MAXIMUM_SCROLL) {
				break;
			}

		}
		return true;
	}

	@Override
	public boolean swipeDownTillElementVisible(String locator) {
		int i = 1;
		while (!elementIsDisplayed(locator)) {
			swipeDown();
			i++;
			if (i == MAXIMUM_SCROLL) {
				break;
			}

		}
		return true;

	}

	@Override
	public boolean swipeLeftUntilElementVisible(String locator) {
		int i = 1;
		while (!elementIsDisplayed(locator)) {
			swipeLeft();
			i++;
			if (i == MAXIMUM_SCROLL) {
				break;
			}

		}
		return true;

	}

	@Override
	public boolean swipeRightUntilElementVisible(String locator) {
		int i = 1;
		while (!elementIsDisplayed(locator)) {
			swipeRight();
			i++;
			if (i == MAXIMUM_SCROLL) {
				break;
			}

		}
		return true;

	}

	@Override
	public void launchAndroidApp(String deviceName, String appPath, String appPackage, String appActivity)
			throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("newCommandTimeout", "30");
		dc.setCapability("platformName", "Android");
		dc.setCapability("deviceName", deviceName);
		if (appPath != "" || appPath != null) {
			dc.setCapability("app", appPath);
		}

		dc.setCapability("appPackage", appPackage);
		dc.setCapability("appActivity", appActivity);
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Override
	public boolean openAppUsingActivity(String appPackage, String Activity) {
		((StartsActivity) driver).startActivity(new Activity(appPackage, Activity));
		return true;

	}

	@Override
	public String getCurrentAppActivity() {
		return ((StartsActivity) driver).currentActivity();

	}

	@Override
	public String getCurrentAppPackage() {

		return ((StartsActivity) driver).getCurrentPackage();

	}

	@Override
	public boolean pressEnterKey() {
		((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		return true;

	}

	@Override
	public void pressBackKey() {
		((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));

	}

	@Override
	public void showNotifications() {
		((AndroidDriver) driver).openNotifications();
	}

	@Override
	public void hideNotifications() {
		pressBackKey();
	}

	@Override
	public void turnOnMobileData() {
		((HasNetworkConnection) driver).setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
		((HasNetworkConnection) driver).setConnection(new ConnectionStateBuilder().withDataEnabled().build());
	}

	@Override
	public void turnOffMobileData() {
		((HasNetworkConnection) driver).setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
		((HasNetworkConnection) driver).setConnection(new ConnectionStateBuilder().withDataDisabled().build());
	}

	@Override
	public void waitUntilElementIsDisplayed(int waittime, String locator) {
		String[] split = locator.split("=", 2);
		String locatortype = split[0];
		String lvalue = split[1];
		wait = new WebDriverWait(driver, Duration.ofSeconds(waittime));
		if (locatortype.toLowerCase().contains("xpath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lvalue)));
		}
		if (locatortype.toLowerCase().contains("name")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(lvalue)));
		}
		if (locatortype.toLowerCase().contains("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(lvalue)));
		}

	}

	@Override
	public boolean isKeyboardVisible() {
		return ((HasOnScreenKeyboard) driver).isKeyboardShown();
	}

	@Override
	public void hideKeyboard() {
		if (isKeyboardVisible()) {
			((HidesKeyboard) driver).hideKeyboard();
		}

	}

	@Override
	public void closeApp() {
		driver.quit();
	}

	@Override
	public void waitUntilInvisibilityOfElement(int waitime, String locator) {
		String[] split = locator.split("=", 2);
		String locatortype = split[0];
		String lvalue = split[1];
		wait = new WebDriverWait(driver, Duration.ofSeconds(waitime));
		if (locatortype.toLowerCase().contains("xpath")) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(lvalue)));
		}
		if (locatortype.toLowerCase().contains("name")) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(lvalue)));
		}
		if (locatortype.toLowerCase().contains("id")) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(lvalue)));
		}

	}

	@Override
	public void waitUntilElementIsClickable(int waitime, String locator) {
		String[] split = locator.split("=", 2);
		String locatortype = split[0];
		String lvalue = split[1];
		wait = new WebDriverWait(driver, Duration.ofSeconds(waitime));
		if (locatortype.toLowerCase().contains("xpath")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lvalue)));
		}
		if (locatortype.toLowerCase().contains("name")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(lvalue)));
		}
		if (locatortype.toLowerCase().contains("id")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(lvalue)));
		}

	}

	@Override
	public void readLocator(String locatorfilepath, String sheetname) throws IOException {
		locator = new HashMap<String, String>();
		XSSFWorkbook workbook = new XSSFWorkbook(locatorfilepath);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();

		for (int i = 1; i <= rowcount; i++) {
			String stringCellValue = sheet.getRow(i).getCell(2).getStringCellValue();
			String stringCellValue2 = sheet.getRow(i).getCell(3).getStringCellValue();
			locator.put(stringCellValue, stringCellValue2);
			workbook.close();
		}

	}

	@Override
	public Boolean isEnabled(String locator) {
		return locateElement(locator).isEnabled();

	}

	@Override
	public Boolean isSelected(String locator) {
		return locateElement(locator).isSelected();

	}

	@Override
	public void clearInput(String locator) {
		locateElement(locator).clear();

	}

	@Override
	public String testdataload(String testscriptID, String testdataname) throws IOException {
		HashMap<String, Integer> testdataID = new HashMap<String, Integer>();
		String key;
		int value;
		XSSFWorkbook workbook = new XSSFWorkbook(getConfigurations("testdatapath"));
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int lastCellNum = sheet.getLastRowNum();
		for (int i = 1; i <= lastCellNum; i++) {
			XSSFCell cell = sheet.getRow(i).getCell(0);
			try {
				switch (cell.getCellType()) {
				case NUMERIC:
					double temp = cell.getNumericCellValue();
					long val = (long) temp;
					key = String.valueOf(val);
					if (DateUtil.isCellDateFormatted(cell)) {
						DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
						Date date = cell.getDateCellValue();
						key = df.format(date);
					}
					break;
				case STRING:
					key = cell.getStringCellValue();
					break;
				case BOOLEAN:
					key = String.valueOf(cell.getBooleanCellValue());
					break;
				case FORMULA:
					key = cell.getCellFormula();
				default:
					key = "DEFAULT";
				}
			} catch (NullPointerException npe) {
				key = " ";

			}

			value = i;
			testdataID.put(key, value);

		}

		HashMap<String, Integer> testdatatitle = new HashMap<String, Integer>();
		int column = sheet.getRow(0).getLastCellNum();
		for (int i = 1; i < column; i++) {
			XSSFCell cell = sheet.getRow(0).getCell(i);
			try {
				switch (cell.getCellType()) {
				case NUMERIC:
					double temp = cell.getNumericCellValue();
					long val = (long) temp;
					key = String.valueOf(val);
					if (DateUtil.isCellDateFormatted(cell)) {
						DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
						Date date = cell.getDateCellValue();
						key = df.format(date);
					}
					break;
				case STRING:
					key = cell.getStringCellValue();
					break;
				case BOOLEAN:
					key = String.valueOf(cell.getBooleanCellValue());
					break;
				case FORMULA:
					key = cell.getCellFormula();
				default:
					key = "DEFAULT";
				}
			} catch (NullPointerException npe) {
				key = " ";

			}
			value = i;
			testdatatitle.put(key, value);

		}

		String expected_value = sheet.getRow(testdataID.get(testscriptID)).getCell(testdatatitle.get(testdataname))
				.getStringCellValue();
		return expected_value;

	}

	public String getConfigurations(String key) {

		String value = null;
		try {
			FileInputStream file = new FileInputStream("./src/main/resources/configurations/config.properties");
			Properties properties = new Properties();
			try {
				properties.load(file);
				value = properties.getProperty(key);

			} catch (Exception e) {
				System.out.println(e);

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}

	@Override
	public void clickElement(String locator, int waittime) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(waittime));
		wait.until(ExpectedConditions.elementToBeClickable(locateElement(locator)));
		locateElement(locator).click();

	}

	@Override
	public void EnterInput(String locator, String text, int waittime) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(waittime));
		wait.until(ExpectedConditions.elementToBeClickable(locateElement(locator)));
		locateElement(locator).sendKeys(text);

	}
	public String getLocator(String module, String key) {

		String value = null;
		try {
			FileInputStream file = new FileInputStream("./src/main/resources/LocatorRepositories/"+module+".properties");
			Properties properties = new Properties();
			try {
				properties.load(file);
				value = properties.getProperty(key);

			} catch (Exception e) {
				System.out.println(e);

			}
			

		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}
	

}
