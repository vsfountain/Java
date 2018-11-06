package com.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class MyTest {
	//NOT using mockito, so this is not a unit test
	//	it is integration testing
	//ConversionService cserv= new ConversionService();
	
	//Let's use mockito instead
	ConversionService cserv= Mockito.mock(ConversionService.class);
	
	Converter conv;

	@Before
	public void setUp() throws Exception {
		conv=new Converter(cserv);
	}

	@Test
	public void test() {
		Mockito.when(cserv.findMilesToFeet()).thenReturn(5280);
		
		assertEquals(5280*2, conv.milestoFeet(2));
		
		//verifying your mock object was used
		Mockito.verify(cserv).findMilesToFeet();
	}

	@After
	public void tearDown() throws Exception {
	}

}
