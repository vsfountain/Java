package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * An Aspect is a modularization of cross cutting concerns
 * 		The aspect takes the form of a java class. It's a class full of
 * 			advice. (A collection of advice)
 */
@Component("aspect")
@Aspect
public class AspectExample {

	/*types of Advice/Advice Timings
	 * 		@Before-   before the method
	 * 		@After-    after the method, regardless of success
	 * 		@AfterThrowing	after an object is thrown
	 * 		@AfterReturning-	after a successful return
	 * 		@Around-		around is......weird.....
	 * 				Around is the most powerful type of advice. It can perform
	 * 				logic before AND after the method...AND inside the method....
	 * 
	 * 	An advice is an action taken by the aspect. The aspect itself is the class.
	 * 
	 * Pointcut expressions
	 * 	"*" is our wildcard for return types and method naming
	 * 	".." is our wildcard for our parameter list
	 * 	"*" is also our wildcard for a SINGLE parameter in the parameter list
	 * 	
	 * 	and YES...you can specify an access modifier in your pointcut expression.
	 */
	
	
	//This method w/ the annotation is an advice.
	//@Before("execution(* *artoon*(int, ..))")
	@Before("execution(* *(..))")
	public void snackingHabit(JoinPoint jp) {
		System.out.println("\t--drink coffee--");
		//System.out.println(jp.getSignature());
		//System.out.println(jp.getClass());
		//System.out.println(jp.getArgs()[0]);
	}
	
	/*@After("execution(* s*u*p*P*t*e*y(..))")
	public void timeLimit(JoinPoint jp) {
		System.out.println("\t\t\t-take 5 mortal-");
	}*/
	
	//AROUND EXAMPLE
	/*
	 * around is the most powerful advice type. it can control variables inside
	 * 	the method. And choose how to act by what is happening inside of the
	 * 	method itself.
	 */
	@Around("execution(* scul*(..))")
	public void testAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("wetting the clay");
		pjp.proceed();
		System.out.println("cleaning up mess");
	}
}









