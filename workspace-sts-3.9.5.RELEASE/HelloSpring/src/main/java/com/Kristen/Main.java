package com.Kristen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Kristen.service.CartoonService;

public class Main {

	// no dependency Injections
//	private static CartoonService cartServ = new CartoonServiceImpl();

	private static CartoonService cartServ;
	

	public static void main(String[] args) {
		
//		The ApplicationContext provides:
//
//			Bean factory methods for accessing application components.
//			The ability to load file resources in a generic fashion.
//			The ability to publish events to registered listeners.
//			The ability to resolve messages to support internationalization.
//			Inheritance from a parent context.


		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		cartServ = appContext.getBean("CartoonServ", CartoonService.class);

		System.out.println(cartServ.getAllCartoons());
	}
	
//	Lifecycle of a spring bean
//	I-Instantiate
//	P- Populate Properties
//	N-setName
//	F-setFactory
//	C-setAppplicationContext
//	B-BeforePostProcessing
//	A-AfterPostProcessing
//  I-customInit
//	U-Use
//	D-Destory
//	D-customDestroy
}