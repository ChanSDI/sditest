package Testscripts;

import org.testng.annotations.Test;

import ImplementationBase.MobileImplementationBase;

public class test extends MobileImplementationBase {

	@Test
	public  void testtest() {
		
		
		System.out.println(getLocator("login", "not1"));
	}
}
