package com.Mobiquity.TestNG;


import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import appCode.SampleCode;

public class TestNG_SoftAsserts {
	
	@Test
	public void testSum() {
		SoftAssert sa = new SoftAssert();
		System.out.println("\nRunning Test -> testSum");
		SampleCode obj = new SampleCode();
		int result = obj.sumNumbers(1, 2);
		sa.assertEquals(result, 2);
		System.out.println("\nLine after assert 1");
		sa.assertEquals(result, 3);
		System.out.println("\nLine after assert 2");
		//sa.assertAll();
	}
}