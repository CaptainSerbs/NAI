package com.sadboys.inc.database;

public class Score {
    private int userID;
    private int score;
    private int datetime;

    public Score(int userID, int score, int datetime) {
        this.userID = userID;
        this.score = score;
        this.datetime = datetime;
}

    public int getUserID() {
        return userID;
    }

    public int getScore() {
        return score;
    }

    public int getDatetime() {
        return datetime;
    }
}