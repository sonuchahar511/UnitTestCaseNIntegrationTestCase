package com.chahar.junit.integ;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;

@Category(IntegrationTest.class)
public class IntegrationTestSampleTest {

	private JUnitAssertEqualsServiceExample junitAssertEqualsServiceSample;
	private ServiceObject serviceObject;
	@BeforeClass
	public void setData() {
		serviceObject = new ServiceObject();
		junitAssertEqualsServiceSample = new JUnitAssertEqualsServiceExample();
		junitAssertEqualsServiceSample.initiateMetaData(serviceObject);
	}

	@Test
	public void testAssertEqualsFalse() {
		//	processed the item
		ServiceObject newServiceObject = new ServiceObject();
		junitAssertEqualsServiceSample.initiateMetaData(newServiceObject);
		junitAssertEqualsServiceSample.processObject(serviceObject);
		assertEquals(serviceObject,serviceObject);
	}
	
	@Test
	public void testAssertEquals() {
		junitAssertEqualsServiceSample.processObject(serviceObject);
		assertEquals(serviceObject,this.serviceObject);
	}

	@Test
	public void testAssertEqualsWithMessage() {
		junitAssertEqualsServiceSample.processObject(serviceObject);
		assertEquals(
				"Same Object",
				serviceObject,serviceObject);
	}
	@Test
	public void testAssertEqualsFalseWithMessage() {
		ServiceObject newServiceObject = new ServiceObject();
		junitAssertEqualsServiceSample.postProcessing(serviceObject);
		assertEquals("Not the Same Object",
				serviceObject,serviceObject);
	}

}
