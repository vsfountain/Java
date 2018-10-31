package com.example.q16;

public class q16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(args.length);
		
		
		//System.out.println(args[0] + " " + args[1]);
		
		
		int count = 0;
		
		
		for(int i = 0; i<args.length; i++) {
			
			for(int j = 0; j<args[i].length(); j++) {
				count++;
				
			}
			
			
		}
		
		System.out.println(count);
		
		
	}

}
