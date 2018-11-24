package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class MyTest {

	Converter conv;
	//This is without Mockito, when you need to mock an object
	/*ConversionService cserv= new ConversionService() {
		public int findMilesToFeetMultiplier(){
			return 5280;
		}
	};*/
	
	//WITH Mockito, you can use the mock method
	ConversionService cserv= Mockito.mock(ConversionService.class);
	
	@Before
	public void setUp() {
		conv= new Converter(cserv);
	}
	
	@Test
	public void test1() {
		Mockito.when(cserv.findMilesToFeetMultiplier()).thenReturn(5280);
		
		Assert.assertEquals(5280*2, conv.milesToFeet(2));
		
		//verifying your mock object was used
		//Mockito.verify(cserv).findMilesToFeetMultiplier();
	}
}
