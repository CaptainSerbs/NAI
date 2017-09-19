package com.sadboys.inc.database;

public class TopUsers {
    private final String user;

    public TopUsers(String user) {
        this.user = user;

    }

    public String getUser() {
        return user;
    }
    
    @Override
    public String toString() {
        return user + ":";
    }

}