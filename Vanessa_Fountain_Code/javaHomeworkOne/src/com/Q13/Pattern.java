package com.Q13;

public class Pattern {
/*
 * 
    0
    1 0
    1 0 1
    0 1 0 1
010101010

 */
	public static void main(String[] args) {
		int n=12,a=0;
		for(int i=1;i<=n;i++){
			for(int j=0;j<i;j++){
				a=n%2;
				System.out.print(a +" ");
				n--;
			}
			System.out.println();
			}
		}
		
//		String pattern = new String();
//		for (int i = 0; i <1;i++) {
//			for(int j = 0; j<1; j++) {
//				if (pattern.isEmpty()){
//					pattern += 0;
//					System.out.println(pattern);
//					//i+=1;
//				}
//				if(pattern.charAt(0)=='0'){
//					pattern = 1 + pattern;
//					System.out.println(pattern);
//					//i+=1;
//				}
//				if(pattern.charAt(0)=='1'){
//					pattern = 0  + pattern;
//					System.out.println(pattern);
//					//i+=1;
//				}
//			}
		
	
}
