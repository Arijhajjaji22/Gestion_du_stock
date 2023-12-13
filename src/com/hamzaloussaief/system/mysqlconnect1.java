/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzaloussaief.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class mysqlconnect1 {
    Connection conn = null;
    public static Connection ConnectDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/app","root","");
           // JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
    }
    
    public static ObservableList<comptes> getDatacomptes(){
        Connection conn = ConnectDb();
        ObservableList<comptes> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from comptes");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new comptes(Integer.parseInt(rs.getString("id")), rs.getString("username"), rs.getString("password"),rs.getString("email")));               
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}

    

