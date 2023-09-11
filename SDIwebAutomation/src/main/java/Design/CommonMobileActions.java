package Design;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;

public interface CommonMobileActions {

	/**
	 * This method is used to get the webelements
	 * 
	 * @param locator - This is the locator type and value
	 * @author AravindhRaja RA - Avasoft
	 * @return webElement
	 */
	public WebElement locateElement(String locator);

	/**
	 * This method is used to find whether the element is displayed
	 * 
	 * @param locator  - This is the locator type and value of the web element
	 * @param locvalue - This is the Value of the locator.
	 * @author AravindhRaja RA - Avasoft
	 * @return boolean
	 */
	public boolean elementIsDisplayed(String locator);

	/**
	 * This method is used verify the text of a element
	 * 
	 * @param locator  - This is the locator type and value of the web element
	 * 
	 * @param element  - This is the webelement for which the text is to be verified
	 * @param expected - This is the Expected text of the element to be verified
	 * @author AravindhRaja RA - Avasoft
	 * @return boolean
	 */

	public boolean verifyElementtext(String locator, String expected);

	/**
	 * This method is used verify whether the text contains a part of the Expected
	 * text
	 * 
	 * @param locator  - This is the locator of the element which is displayed
	 * @param expected - This is the Expected text of the element to be verified
	 * @author AravindhRaja RA - Avasoft
	 * @return
	 */
	public boolean verifyElementContainsText(String locator, String expected);

	/**
	 * This method is used to scroll in the app
	 * 
	 * @param startX - This is the x coordinate start point of where the finger is
	 *               placed.
	 * @param startY - This is the y coordinate start point of where the finger is
	 *               placed.
	 * @param endX   - This is the x coordinate end point of where the finger is
	 *               placed.
	 * @param endY   - This is the y coordinate end point of where the finger is
	 *               placed.
	 * @return boolean
	 * @author AravindhRaja RA - Avasoft
	 */
	public boolean scroll(double startX, double startY, double endX, double endY);

	/**
	 * This method is used to swipeup in the screen
	 * 
	 * @return boolean
	 * @author AravindhRaja RA - Avasoft
	 */
	public boolean swipeUp();

	/**
	 * This method is used to swipedown in the screen
	 * 
	 * @author AravindhRaja RA - Avasoft
	 * @return
	 */
	public boolean swipeDown();

	/**
	 * This method is used to swiperight in the screen
	 * 
	 * @author AravindhRaja RA - Avasoft
	 * @return
	 */

	public boolean swipeRight();

	/**
	 * This method is used to swipeleft in the screen
	 * 
	 * @author AravindhRaja RA - Avasoft
	 * @return
	 */

	public boolean swipeLeft();

	/**
	 * This method is used to click the element
	 * @param locator  - The locator type and value of the Element to be clicked
	 * @param waittime - The time to wait until the element is clickable
	 * @author AravindhRaja RA - Avasoft
	 */
	public void clickElement(String locator, int waittime);

	/**
	 * This method is used to click the element
	 * 
	 * @param locator - The locator type and value of the Element to be clicked
	 * @author AravindhRaja RA - Avasoft
	 */
	public void clickElement(String locator);

	/**
	 * This method is used to enter the input in a field
	 * 
	 * @param locator - The locator type and the value of the Element to be Entered.
	 * 
	 * @param Text    - The Value of the text to be entered
	 */
	public void EnterInput(String locator, String text);
	/**
	 * This method is used to enter the input in a field
	 * 
	 * @param locator - The locator type and the value of the Element to be Entered.
	 * @param waittime - The time to wait until the element is displayed
	 * @param Text    - The Value of the text to be entered
	 */
	public void EnterInput(String locator, String text, int waittime);

	/**
	 * This method is used to get the text of the webelement
	 * 
	 * @param locator - The locator type and value of the Element to be retreived
	 * @return
	 */
	public String getElementText(String locator);

	/**
	 * This method is used to switch to another app
	 * 
	 * @param bundleIDOrApppackage - bundle ID in case of iOS and AppPackage in case
	 *                             of iOS and AppPackage in case of Android.
	 * @author AravindhRaja RA - Avasoft
	 */
	public void switchToAnotherApp(String bundleIDOrAppPackage);

	/**
	 * This method will print the current App context, the view availble like the
	 * Native view or webview
	 * 
	 * @author AravindhRaja RA - Avasoft
	 */
	public void printAppContext();

	/**
	 * This method will switch the App to the current context
	 * 
	 * @param context - This is the context of the current App,(Native or Web)
	 * @returns boolean
	 * @author AravindhRaja RA - Avasoft
	 * @return
	 */
	public boolean switchAppcontext(String context);

	/**
	 * This method will switch the context to Native view
	 * 
	 * @author AravindhRaja RA - Avasoft
	 * @return
	 */
	public boolean switchToNativeView();

	/**
	 * This method is used for clicking the App in a certain point
	 * 
	 * @param x - The x coordinate of where the user has to click
	 * @param y - The y coordinate of where the user has click
	 * @author AravindhRaja RA - Avasoft
	 */
	public void pointerClick(int x, int y);

	/**
	 * This method is used to swipe up in the screen until the particular element is
	 * visible
	 * 
	 * @param locator - The locator type and value of the Element to be scrolled to
	 * @author AravindhRaja RA - Avasoft
	 * @return
	 */
	public boolean swipeUpTillElementVisible(String locator);

	/**
	 * This method is used to swipe down in the screen until the particular element
	 * is visible
	 * 
	 * @param locator - The locator type and value of the Element to be scrolled to
	 * 
	 * @author AravindhRaja RA - Avasoft
	 * @return
	 */
	public boolean swipeDownTillElementVisible(String locator);

	/**
	 * This method is used to swipe left in the screen until the particular element
	 * is visible
	 * 
	 * @param locator - The locator type and value of the Element to be scrolled to
	 * @author AravindhRaja RA - Avasoft
	 * @return
	 */

	public boolean swipeLeftUntilElementVisible(String locator);

	/**
	 * This method is used to swipe right in the screen until the particular element
	 * is visible
	 * 
	 * @param locator - The locator type and value of the Element to be scrolled to
	 * @author AravindhRaja RA - Avasoft
	 * @return
	 */
	public boolean swipeRightUntilElementVisible(String locator);

	/**
	 * This method is used to wait till a element appear
	 * 
	 * @param waittime - The time to wait until the element appears
	 * @param locator  - The locator type of the element to wait for
	 * @author AravindhRaja RA - Avasoft
	 */
	public void waitUntilElementIsDisplayed(int waitime, String locator);

	/**
	 * This method will verify whether the keyboard is shown or not
	 * 
	 * @returns boolean
	 * @author AravindhRaja RA - Avasoft
	 */
	public boolean isKeyboardVisible();

	/**
	 * This method will hide the keyboard if it is visible
	 * 
	 * @author AravindhRaja RA - Avasoft
	 */
	public void hideKeyboard();

	/**
	 * This method will quit the session
	 * 
	 * @author AravindhRaja RA - Avasoft
	 */
	public void closeApp();

	/**
	 * This method will wait till element is invisible
	 * 
	 * @param waittime - The time to wait till a element disappears
	 * @param locator  - The locator type of the element to wait for
	 * @author AravindhRaja RA - Avasoft
	 */
	public void waitUntilInvisibilityOfElement(int waitime, String locator);

	/**
	 * This method will wait till element is clickable
	 * 
	 * @param waittime - The time to wait till a element is clickable
	 * @param locator  - The locator type of the element to wait for
	 * @author AravindhRaja RA - Avasoft
	 */
	public void waitUntilElementIsClickable(int waitime, String locator);

	/**
	 * This method is used to check whether the particular element is enabled
	 * 
	 * @param locator - The locator type and locator value of the element
	 * @author Aravindraja RA - Avasoft
	 */
	public Boolean isEnabled(String locator);

	/**
	 * This method is used to check whether the particular element is selected
	 * 
	 * @param locator - The locator type and locator value of the element
	 * @author Aravindraja RA - Avasoft
	 */
	public Boolean isSelected(String locator);

	/**
	 * This method is used to check whether the entered text in the field is cleared
	 * 
	 * @param locator - The locator type and value of the element
	 * 
	 * @author Aravindhraja RA- Avasoft
	 */
	public void clearInput(String locator);

	/**
	 * This method is used to get the configurations from the properties file
	 * 
	 * @param key - The key of the key value pair in the properties file
	 * @author Aravindhraja RA- Avasoft
	 */
	public String getConfigurations(String key);
	/**
	 * This method is used to get the configurations from the properties file
	 * @param module - The module name of the locator
	 * @param key - The key of the key value pair in the properties file
	 * @author Aravindhraja RA- Avasoft
	 */
	public String getLocator(String module, String key);


}
