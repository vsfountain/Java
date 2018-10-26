package com.homework.problemeighteen;

public class Main {
	public static void main(String[] args) {

		ConcreteChild test = new ConcreteChild();
		System.out.println(test.anyUpCase("hElLo!"));
		System.out.println(test.anyUpCase("hello"));
		System.out.println(test.toUpCase("bye!"));
		System.out.println(test.stringToInt("h"));
	}
}
