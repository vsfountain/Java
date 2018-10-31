package com.example.access;

/*
 * Access Modifiers:
 * 		public-		accessed anywhere
 * 		protected-	accessed in class, in package, children
 * 		(default)-	accessed in class, in package
 * 		private-	accessed in class
 */
public class Clement {
		private String rev= "October";
	
		
		public String getRev() { //getter
			return rev;
		}
		public void setRev(String rev) {//setter
			this.rev=rev;
		}
}
