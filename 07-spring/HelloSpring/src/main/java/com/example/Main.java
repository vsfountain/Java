package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.CartoonService;
import com.example.service.CartoonServiceImpl;
/*
 * What is spring?
 * Spring is a module based open source framework. It provides
 * 	support for enterprise level applications; it provides
 * 	infrastructure so you can focus on your application's business logic
 * 
 * What is a module?
 * 	A grouping of libraries that work together to acheive some goal using reusable
 * 	abstracted code.
 * 
 * What are some spring modules?
 * 	core, context, orm, aop, webmvc, security, test
 * 				NOT springboot. QC will hate you.
 * 
 * How does spring achieve its goals? AKA what features does spring have?
 * 	Inversion of Control(IoC),
 * 	Aspect Oriented Programming (AOP),
 * 	Model View Controller (MVC),
 * 	Abstraction API
 * 
 * What is a spring bean?
 * 	A spring bean is a bean managed by the IoC container.
 * 
 * What is bean wiring?
 * 	Creating an association between spring's IoC container and an
 * 	object you want spring to manage.
 * 
 * Scopes of a spring bean?
 * 	Singleton (default)
 * 	Prototype- it means you can have multiple instances of the bean
 * 	Request- exists within a Http request
 *  Session- exists within a Http session
 *  GlobalSession- all Http sessions
 *  
 *  Lifecyle of a spring bean-
 *  	I- Instantiate
 *  	P- Populate 		Properties  <--that space is to irritate Sean
 *  	N- setName
 *  	F- setFactory
 *  	C- setApplicationContext
 *  	B- BeforePostProcessing
 *  	A- AfterPopulateProperties
 *  	I- customInit
 *  	A- AfterPostProcessing
 *  	U- Use
 *  	D- Destroy
 *  	D- customDestroy
 *  
 *  
 *  what is applicationContext?
 *  	applicationContext is a child of BeanFactory.
 *   It adds more functionality; for example, text messaging and internalization. 
 */
public class Main {

	//This is the old way, without DI
	//private static CartoonService cartServ = new CartoonServiceImpl();
	
	private static CartoonService cartServ;
	
	public static void main(String[] args) {
		
		ApplicationContext appContext = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		cartServ = appContext.getBean("CartoonServ", CartoonService.class);
		//demostrating the scopes of a bean (specifically singleton and prototype)
		/*cartServ = appContext.getBean("CartoonServ", CartoonService.class);
		cartServ = appContext.getBean("CartoonServ", CartoonService.class);*/
		
		
		System.out.println(cartServ.getAllCartoons());

	}

}
