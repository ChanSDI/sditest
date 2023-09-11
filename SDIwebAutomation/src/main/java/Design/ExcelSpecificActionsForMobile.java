package Design;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ExcelSpecificActionsForMobile {

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
	 * @param testname - The testname of the method to be used
	 * @author Aravindh Raja RA - Avasoft
	 * @throws IOException
	 */
	public String testdataload(String testdataID, String testname) throws IOException;

}
