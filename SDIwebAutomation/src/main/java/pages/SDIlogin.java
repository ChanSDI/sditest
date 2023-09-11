package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import ProjectSpecificBase.WebBase;

public class SDIlogin extends WebBase {
	
	public SDIlogin(RemoteWebDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;		
	}	
	public SDIlogin URllunch()
	{
		try {
            driver.get(getConfigurations("url"));
            reportStep("The user has to launch the browser", "Pass");
        }
        catch (Exception e)
        {
             try {
                reportStep("The user has not able to login into the application", "fail");
            } catch (Exception e1) {
                e1.printStackTrace();
            }          
             throw new RuntimeException();
        }
        return this;
    }
}

