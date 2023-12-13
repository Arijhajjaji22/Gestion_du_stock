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
public class connect {
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp
 */

    Connection conn = null;
    public static Connection ConnectDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/saise","root","");
           // JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
    }
    
    public static ObservableList<fiche> getDatafiche(){
        Connection conn = ConnectDb();
        ObservableList<fiche> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from fiche");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                   list.add(new fiche(Integer.parseInt(rs.getString("id")), rs.getString("nom"), rs.getString("prenom"),rs.getString("ligne"), rs.getString("reference"), rs.getString("abonné"), rs.getString("lieu"), rs.getString("date")));                   
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}

    

