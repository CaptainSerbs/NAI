package com.sadboys.inc;

public class Shortcut {
    private static int playerID;

    public Shortcut() {
        initShort();
    }

    private void initShort() {

    }

    public static void Cut (int playerid){
        playerID = playerid;
    }

    public static int PID (){
        return playerID;
    }
}