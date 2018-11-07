package com.project0;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.*;
import org.junit.Test;

public class bankingtests {
	@Test
	public void depositTest() {
		Transactions test = new Transactions(25.25);
		
		double output = test.deposit(0.0);
		assertEquals(25.25, output,0.005);
		System.out.println(output);
	}
	
	@Test
	public void withdrawTest() {
		Transactions test = new Transactions(25.25);
		
		double output = test.withdraw(25.25);
		assertEquals(0, output, 0.005);
		System.out.println(output);
	}
}
