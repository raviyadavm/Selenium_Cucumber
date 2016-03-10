package com.gale.knewton.StepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {


	@Before
	public static void classSetup() {
		DriverFactory.setUp("firefox");
		System.out.println("***********Before Class was called");
	}

	@After
	public static void classTeardown() {
		//Stepdefs_baseTest.tearDown();
		System.out.println("***********After Class was called");
	}
	
}
