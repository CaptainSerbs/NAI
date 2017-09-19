package com.sadboys.inc.database;

public class Playerlogin {
		private int userID;
		public static String username;
		private String password;
		private String email;

	    public Playerlogin(int userID, String username, String password, String email) {
	    	this.userID = userID;
	    	this.username =username;
	    	this.password = password;
	    	this.email = email;
	}

		public int getUserID() {
	        return userID;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public String getEmail() {
	        return email;
	    }
	    
}
