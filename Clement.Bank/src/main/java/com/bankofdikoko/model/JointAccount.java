package com.bankofdikoko.model;

public class JointAccount{
	
		private User user1, user2 = null;

		public JointAccount(User user1, User user2) {
			this.user1=user1;
			this.user2=user2;
			
		}

		public User getUser1() {
			return user1;
		}

		public void setUser1(User user1) {
			this.user1 = user1;
		}

		public User getUser2() {
			return user2;
		}

		public void setUser2(User user2) {
			this.user2 = user2;
		}
		
		
}
