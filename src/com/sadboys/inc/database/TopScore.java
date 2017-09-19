package com.sadboys.inc.database;

public class TopScore {
    private final int score;

    public TopScore(int score) {
        this.score = score;

    }

    public int getUser() {
        return score;
    }
    
    @Override
    public String toString() {
        return "" + score;
    }

}