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
 * @author amir
 */
public class connectbase {
    
    Connection conn = null;
    public static Connection ConnectDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/telecom","root","");
           // JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
    }
    
    public static ObservableList<page> getDatapage(){
        Connection conn = ConnectDb();
        ObservableList<page> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new page(rs.getString("code"), rs.getString("description"), rs.getString("etat"), rs.getString("numero"), rs.getString("lieu"), rs.getString("stock"), rs.getString("bmvt"), rs.getString("type"), rs.getString("nombre") , rs.getString("id"), rs.getString("reference"), rs.getString("affect"), rs.getString("zoneservice"), rs.getString("enservice"), rs.getString("observation")));               
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}