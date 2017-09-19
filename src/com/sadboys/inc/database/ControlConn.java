package com.sadboys.inc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ControlConn {
    
    public static Connection openConn(String driver, String url, 
                                        String user, String pass) {
        try{
            Class.forName(driver).newInstance();
            return DriverManager.getConnection(url,user, pass); 
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    
    public static void closeConn(Connection conn) {
        if(conn!=null) {
            try{
                conn.close();
            }
            catch(Exception e) {
                //Nothing to doings heres
            }
        }
    }
    public static void closeState(Statement statement) {
        if(statement!=null) {
            try{
                statement.close();
            }
            catch(Exception e) {
            }
        }
    }
    
    public static void closeResultSet(ResultSet resultset){
        if(resultset!=null) {
            try{
                resultset.close();
            }
            catch(Exception e) {
            }
        }
    }  
}
