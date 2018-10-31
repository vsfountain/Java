package com.javahomework.questions18;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcreteCity cc = new ConcreteCity();
		
		System.out.println(cc.checkCase("meow"));
		System.out.println(cc.checkCase("Meow"));
		System.out.println(cc.convertCase("MeOw"));
		System.out.println(cc.convertToInteger("10") + 10);
	}

}
