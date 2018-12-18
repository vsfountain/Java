package com.example.aspect;

import org.springframework.stereotype.Component;

/**
 * An Aspect is a modularization of cross cutting concerns
 * The aspect takes the form of a java class. It's a class full of advice.(A 
 * collection of advice)
 * 
 * @author Kristen Kavanagh
 *
 */
@Component("Aspect")
@Aspect
public class AspectExample {
	
	@Before("excution(**(*..)")
	public void snackingHabit(JoinPoint jp) {
		System.out.println("\t--drink coffee--");
	}

	@After("excution(**(..))")
	public void timeLimit(JoinPoint jp) {
		System.out.println("\t--drink coffee--");
		System.out.println(---"\t-take 5 mortals"--);
	}
	
	@Before("excution(*raw*(*..)")
	public void snackingHabit(JoinPoint jp) {
		System.out.println("\t--drink coffee--");
	}
	@Before("excution(*scul*(*..)")
	public void snackingHabit(JoinPoint jp) {
		System.out.println("\t--drink coffee--");
	}
	@Before("excution(i*t*(*..)")
	public void snackingHabit(JoinPoint jp) {
		System.out.println("\t--drink coffee--");
	}
	
	\


}
