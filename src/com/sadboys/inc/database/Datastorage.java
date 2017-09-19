package com.sadboys.inc.database;

import com.sadboys.inc.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import java.sql.*;

public class Datastorage {

    private String driver;
    private String url;
    private String user;
    private String pass;

    public Datastorage(String driver, String url, String user, String pass) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public Datastorage() {
        this("com.mysql.jdbc.Driver", "jdbc:mysql://10.9.0.60:3306/s1500520?autoReconnect=true&useSSL=false",
                "s1500520", "71M4nhoc");
    }

    public List<PlayerScore> getPlayerScores() {
        List<PlayerScore> scores = new ArrayList<PlayerScore>();
        Connection conn = ControlConn.openConn(driver, url, user, pass);
        if (conn != null) {
            PreparedStatement prepstat = null;
            ResultSet resultset = null;
            try {
                String searchSql = "SELECT score "
                        + "FROM score "
                		+ "WHERE uid=? "
                        + "ORDER BY score DESC "
                		+ "LIMIT 1";
                prepstat = conn.prepareStatement(searchSql);
                prepstat.setInt(1, Shortcut.PID());
	            resultset = prepstat.executeQuery();
                scores.add(new PlayerScore("Highscore: "));

                while (resultset.next()) {
                    scores.add(new PlayerScore(resultset.getString(1)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ControlConn.closeResultSet(resultset);
                ControlConn.closeState(prepstat);
                ControlConn.closeConn(conn);
            }
        }
        Connection conn2 = ControlConn.openConn(driver, url, user, pass);
        if (conn2 != null) {
            PreparedStatement prepstat = null;
            ResultSet resultset = null;
            try {
                String searchSql = "SELECT score "
                        + "FROM score "
                		+ "WHERE uid=? "
                        + "ORDER BY date_time DESC "
                		+ "LIMIT 8";
                prepstat = conn2.prepareStatement(searchSql);
                prepstat.setInt(1, Shortcut.PID());
	            resultset = prepstat.executeQuery();
	            scores.add(new PlayerScore("Recent scores:"));

                while (resultset.next()) {
                    scores.add(new PlayerScore(resultset.getString(1)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ControlConn.closeResultSet(resultset);
                ControlConn.closeState(prepstat);
                ControlConn.closeConn(conn2);
            }
        }
        return scores;
    }
    
    public List<TopScore> getTopScores() {
        List<TopScore> scores = new ArrayList<TopScore>();
        Connection conn = ControlConn.openConn(driver, url, user, pass);
        if (conn != null) {
            PreparedStatement prepstat = null;
            ResultSet resultset = null;
            try {
                String searchSql = "SELECT score "
                        + "FROM score "
                        + "ORDER BY score DESC "
                		+ "LIMIT 10";
                prepstat = conn.prepareStatement(searchSql);
	            resultset = prepstat.executeQuery();

                while (resultset.next()) {
                    scores.add(new TopScore(resultset.getInt(1)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ControlConn.closeResultSet(resultset);
                ControlConn.closeState(prepstat);
                ControlConn.closeConn(conn);
            }
        }
        return scores;
    }
    
    public List<TopUsers> getTopUsers() {
        List<TopUsers> users = new ArrayList<TopUsers>();
    	ArrayList<String> uidlist = new ArrayList<String>();
        Connection conn = ControlConn.openConn(driver, url, user, pass);
        if (conn != null) {
            PreparedStatement prepstat = null;
            ResultSet resultset = null;
            try {
                String searchSql = "SELECT uid "
                        + "FROM score "
                        + "ORDER BY score DESC "
                		+ "LIMIT 10";
                prepstat = conn.prepareStatement(searchSql);
	            resultset = prepstat.executeQuery();

                while (resultset.next()) {
                	uidlist.add(resultset.getString(1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ControlConn.closeResultSet(resultset);
                ControlConn.closeState(prepstat);
                ControlConn.closeConn(conn);
            }
        }
        for(int i = 0; i < uidlist.size(); i++){
	        Connection conn2 = ControlConn.openConn(driver, url, user, pass);
	        if (conn2 != null) {
	            PreparedStatement prepstat = null;
	            ResultSet resultset = null;
	            try {
	                String searchSql = "SELECT username "
	                        + "FROM player "
	                		+ "WHERE user_ID=? "
	                		+ "LIMIT 1";
	                prepstat = conn2.prepareStatement(searchSql);
	                prepstat.setString(1, uidlist.get(i));
		            resultset = prepstat.executeQuery();
	
	                while (resultset.next()) {
	                	users.add(new TopUsers(resultset.getString(1)));
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                ControlConn.closeResultSet(resultset);
	                ControlConn.closeState(prepstat);
	                ControlConn.closeConn(conn2);
	            }
	        }
        }
        return users;
    }

    public void addScore(Score newScore) {
        Connection conn = ControlConn.openConn(driver, url, user, pass);
        if (conn == null) {
            return;
        }
        PreparedStatement prepstat = null;
        try {
            String addSql = "INSERT INTO score "
                    + "VALUES (?,?,CURRENT_TIMESTAMP())";
            prepstat = conn.prepareStatement(addSql);
            prepstat.setInt(1, Shortcut.PID());
            prepstat.setInt(2, newScore.getScore());
            prepstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ControlConn.closeState(prepstat);
            ControlConn.closeConn(conn);
        }
    }

    
    /* login */
    public Playerlogin logPlayer(String password, String email) {
    	Connection conn = ControlConn.openConn(driver, url, user, pass);
        if(conn==null) return null;
        PreparedStatement prepstat=null;
        ResultSet resultset=null;
        try{
            String searchSql="SELECT user_ID, username, password, email FROM player "
            + "WHERE email =? AND password =?";
            prepstat = conn.prepareStatement(searchSql); 
            prepstat.setString(1, email);
            prepstat.setString(2, password);
            resultset=prepstat.executeQuery();
            if(resultset.next()) {
                return new Playerlogin(resultset.getInt(1),
                				resultset.getString(2),
                				resultset.getString(3),
                				resultset.getString(4));
            }
            else {
                return null;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        finally{
            ControlConn.closeResultSet(resultset);
            ControlConn.closeState(prepstat);
            ControlConn.closeConn(conn);
        }
    }
}
