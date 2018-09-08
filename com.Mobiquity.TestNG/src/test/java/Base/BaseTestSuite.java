package Base;


import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

public class BaseTestSuite {


	@BeforeSuite
	public void beforeSuite() {
		System.out.println("\nBaseTestSuite -> before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("\nBaseTestSuite -> after suite");
	}
}