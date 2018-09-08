package com.Mobiquity.TestNG;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import appCode.SampleCode;

public class TestNG_Assert {
	
	@Test
	public void testSum() {
		System.out.println("\nRunning Test -> testSum");
		SampleCode obj = new SampleCode();
		int result = obj.sumNumbers(1, 2);
		Assert.assertEquals(result, 3);
	}
	
	@Test
	public void testStrings() {
		System.out.println("\nRunning Test -> testStrings");
		String expectedString = "Hello World";
		SampleCode obj = new SampleCode();
		String result = obj.addStrings("Hello", "World");
		Assert.assertEquals(result, expectedString);
		
	}
	
	@Test
	public void testcondition() {
		
		System.out.println("\nRunning Test -> testCondition");
		SampleCode obj = new SampleCode();
		//sassertTrue(obj.isEvenNumber(4));
		assertFalse(obj.isEvenNumber(5));
	}
	
	@Test
	public void testArrays() {
		System.out.println("\nRunning Test -> testArrays");
		int[] expectedArray = {1, 2, 3, 4};
		SampleCode obj = new SampleCode();
		int[] result = obj.getArray();
		Assert.assertEquals(result, expectedArray);
		System.out.println("\nEnd Test -> testArrays");
	}
	
}