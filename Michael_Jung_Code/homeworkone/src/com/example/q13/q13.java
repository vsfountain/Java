package com.example.q13;

public class q13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String a = "";
		
		
		int lastVar = 0;
		
		for(int i = 0; i<4; i++) {
		
			a = "";
			if(i == 0) { 
				a = "0";
				lastVar = 0;
			} else {
				for(int j = 0; j<i + 1; j++) {
					
					if(lastVar == 0) {
						a = a + "1 ";
						lastVar = 1;
					} else {
						a = a + "0 ";
						lastVar = 0;
					}
					
				}
				
				
			}
			
			
			System.out.println(a);
			
			
		}
		
		
		
		
		
		
	}

}
