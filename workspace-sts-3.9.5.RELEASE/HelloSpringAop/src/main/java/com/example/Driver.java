/**
 * 
 */
package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.myapp.MyEntireApplication;

/**
 * @author Kristen Kavanagh
 *
 */
public class Driver {

	/**
	 * 
	 */
	public Driver() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
ApplicationContext appCon= new ClassPathXmlApplicationContext("Kristen.xml");
	MyEntireApplication myapp = appCon.getBean("appProxy",MyEntireApplication.class);
	 myapp.drawCartoon();
	 myapp.drawNature();

	}

}
