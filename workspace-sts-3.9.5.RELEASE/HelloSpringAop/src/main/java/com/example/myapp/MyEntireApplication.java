/**
 * 
 */
package com.example.myapp;

import org.springframework.stereotype.Component;

/**
 * @author Kristen Kavanagh
 *
 */
@Component("appProxy")
public class MyEntireApplication {
	public int drawCartoon() {
		System.out.println("--drink coffee---");
		System.out.println("--drawing a Cartoon----");
	return 3;
	}
public int drawNature() {
	System.out.println("--drink coffee---");
	System.out.println("---throw post=0----");
	return 4;
}

public int drawAdditionalCartoon(int a) {
	System.out.println("--drink coffee---");
	System.out.println("--drawing twoCartoon----");
return 3;
}
public int drawManyCartoon(int a, int b) {
	System.out.println("--drink coffee---");
	System.out.println("--drawing a Cartoon----");
return 3;
}
}
