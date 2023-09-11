package Design;

import java.net.MalformedURLException;

public interface iOSSpecificActions {

	/**
	 * This method will launch the iOS application
	 * 
	 * @param platformversion - The version of iOs example : 15.5
	 * @param deviceName      - The name of the device
	 * @param automationName  - The name of automation
	 * @param udid            - The udid of the device to be automated
	 * @param appPath         - The path of the app or ipa file
	 * @param bundleID        - The bundleID of the Application to be launched
	 * @throws MalformedURLException
	 * @author AravindhRaja - Avasoft
	 */
	public void launchiOSApp(String platformversion, String deviceName, String automationName, String udid,
			String appPath, String bundleID) throws MalformedURLException;

	/**
	 * This method will click the button in the keyboard using the name attribute
	 * @param name - It specifies the name of the keyboard button
	 * @author AravindhRaja - Avasoft
	 */
	public void click_KeyBoardButtonByName(String name);

	/**
	 * This method will click the button in the keyboard using the xpath
	 * @param xpath - The xpath of the button in the keyboard
	 * @author AravindhRaja - Avasoft
	 */
	public void click_KeyBoardButtonByXpath(String xpath);

}
