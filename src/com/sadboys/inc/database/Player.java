
package com.sadboys.inc.database;

import java.util.Objects;


public class Player {
   private int userID;
   private String username;
   private String password;
   private String email;
   private int score;
   private int datetime;
   public static String loggeduser;
   private int loggedID;

    public Player(int userID, String username, String password, String email, 
    				int score, int datetime, String loggeduser, int loggedID) {
        this.userID = userID;
        this.username =username;
        this.password = password;
        this.email = email;
        this.score = score;
        this.datetime = datetime;
        this.loggeduser = loggeduser;
        this.loggedID = loggedID;
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
    
    public int getScore() {
        return score;
    }
    
    public int getDatetime() {
        return datetime;
    }
    public String getLoggeduser(){
    	return loggeduser;
    }
    public int getLoggedID(){
    	return loggedID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.userID;
        hash = 83 * hash + Objects.hashCode(this.username);
        hash = 83 * hash + Objects.hashCode(this.password);
        hash = 83 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.userID != other.userID) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (this.email != other.email) {
            return false;
        }
        return true;
    }
   
   
}
