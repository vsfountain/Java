package com.example.myapp;

import org.springframework.stereotype.Component;

@Component("appProxy")
public class MyEntireApplication {
	public int drawCartoon() {
		//System.out.println("\t--drink coffee--");
		System.out.println("--- drawing a cartoon! ^_^ ---");
		//System.out.println("\t-take 5 mortal-");
		return 3;
	}
	
	public int drawAdditionalCartoon(int a) {
		//System.out.println("\t--drink coffee--");
		System.out.println("--- drawing additional cartoons! ^_^ ---");
		//System.out.println("\t-take 5 mortal-");
		return 3;
	}
	
	public int drawManyCartoons(int a, int b) {
		//System.out.println("\t--drink coffee--");
		System.out.println("--- drawing lotsa cartoons! @-@ ---");
		//System.out.println("\t-take 5 mortal-");
		return 3;
	}
	
	public int drawNature() {
		//System.out.println("\t--drink coffee--");
		System.out.println("--- drawing some trees *-* ---");
		//System.out.println("\t-take 5 mortal-");
		return 4;
	}
	
	public void sculptPottery() {
		//System.out.println("\t--drink coffee--");
		System.out.println("--- throw pots =O ---");
		//System.out.println("\t-take 5 mortal-");
	}
}
