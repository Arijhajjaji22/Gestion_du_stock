package com.hamzaloussaief.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String DB_NAME = "projet";
    
    public static Connection con;
    
    static {
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME, USERNAME, PASSWORD);
        } catch (SQLException ex) {
        }
        
    }
    
    public static int checkLogin(String username, String password) {
        Connection conn = DBConnection.con;
        if(con == null)
            return -1;
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        
        try {
            PreparedStatement prest = conn.prepareStatement(sql);
            prest.setString(1, username);
            prest.setString(2, password);
            
            ResultSet rs = prest.executeQuery();
            
            while(rs.next()) {
                return 0;
            }
            
            
            
            
        } catch (SQLException se) {
        }
        return 1;
        
        
        
    }

    /*public static ObservableList<article> getDataarticle() {
        try {
            Connection conn = DBConnection.con;
            ObservableList<article> List = FXCollections.observableArrayList();
            
            
            PreparedStatement ps = conn.prepareStatement("select * from article");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               
                
            
            }
        } catch (SQLException ex) {
          
        }
          return null ;
        
    }

    public static Connection con() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*
    */
}

    
    
    

