package Testscripts;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import pages.SDIlogin;

public class testclass {

@Test
public void loginscript() throws Exception{
	SDIlogin login = new SDIlogin(driver, node);
	login. URllunch();
}



}
