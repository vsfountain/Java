package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.myapp.MyEntireApplication;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext appCon =
				new ClassPathXmlApplicationContext("enriko.xml");
		
		MyEntireApplication myapp = appCon.getBean("appProxy", MyEntireApplication.class);
		
		myapp.drawCartoon();
		myapp.drawNature();
		myapp.sculptPottery();
		//myapp.drawAdditionalCartoon(5);
		//myapp.drawManyCartoons(5, 10);

	}

}
