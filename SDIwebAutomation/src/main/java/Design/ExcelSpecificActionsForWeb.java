package Design;

import java.io.FileNotFoundException;

import java.io.IOException;

public interface ExcelSpecificActionsForWeb {

	/**
	 * This method is used to read the locator values
	 * 
	 * @param locatorpath - The locator path is used
	 * @throws IOException
	 * @author Aravindh Raja RA - Avasoft
	 */

	public void readLocator(String locatorfilepath, String sheetname) throws IOException;

	/**
	 * This method is used to load the data to the Hashmap
	 * 
	 * @param testscriptID - The testscriptID of the testdata sheet
	 * @param testdataname - The testdata name of the testdata sheet
	 * @author Aravindh Raja RA - Avasoft
	 * @throws IOException
	 */

	public String testdataload(String testscriptID, String testdataname) throws IOException;

}
