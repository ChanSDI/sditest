package Design;

import java.net.MalformedURLException;

public interface AndroidSpecificActions {

	/**
	 * This method is used to launch Android Application This will open both the
	 * device based on the capabilities given
	 * 
	 * @param deviceName  - The name of the Android device
	 * @param appPath     - The location where the apk is stored
	 * @param appPackage  - The package name of the application
	 * @param appActivity - The activity of the app to be opened
	 * @author AravindhRaja - Avasoft
	 * @throws MalformedURLException
	 */
	public void launchAndroidApp(String deviceName, String appPath, String appPackage, String appActivity)
			throws MalformedURLException;

	/**
	 * This method will open the app using activity
	 * @param appPackage - The app package of the app to be opened
	 * @param Activity   - The app activity of the app to be opened
	 * @author AravindhRaja - Avasoft
	 * @returns boolean
	 */
	public boolean openAppUsingActivity(String appPackage, String Activity);

	/**
	 * This method will get the current activity of the app
	 * 
	 * @author AravindhRaja - Avasoft
	 * @returns String
	 */
	public String getCurrentAppActivity();

	/**
	 * This method will get the current app package
	 * 
	 * @author AravindhRaja - Avasoft
	 */
	public String getCurrentAppPackage();

	/**
	 * This method will click the Enter key in the Keyboard
	 * @author AravindhRaja - Avasoft
	 * @returns boolean
	 */
	public boolean pressEnterKey();

	/**
	 * This method will click the back key in the Keyboard
	 * 
	 * @author AravindhRaja - Avasoft
	 */
	public void pressBackKey();

	/**
	 * This method will open notifications
	 * 
	 * @author AravindhRaja - Avasoft
	 */
	public void showNotifications();

	/**
	 * This method will hide notifications
	 * 
	 * @author AravindhRaja - Avasoft
	 */
	public void hideNotifications();

	/**
	 * This method will turn on mobile data
	 * 
	 * @author AravindhRaja - Avasoft
	 */
	public void turnOnMobileData();

	/**
	 * This method will turn off mobile data
	 * 
	 * @author AravindhRaja - Avasoft
	 */

	public void turnOffMobileData();

}
