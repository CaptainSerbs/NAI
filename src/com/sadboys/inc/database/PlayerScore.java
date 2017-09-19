package com.sadboys.inc.database;

public class PlayerScore {
    private final String score;

    public PlayerScore(String score) {
        this.score = score;

    }

    public String getScore() {
        return score;
    }
    
    @Override
    public String toString() {
        return score;
    }

}