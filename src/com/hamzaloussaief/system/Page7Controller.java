/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzaloussaief.system;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

/**
 * FXML Controller class
 *
 * @author hp
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

public class Page7Controller {

     @FXML
    private TableColumn<comptes, String> col_email;

    @FXML
    private TableColumn<comptes, Integer> col_id;

    @FXML
    private TableColumn<comptes, String> col_password;

    @FXML
    private TableColumn<comptes, String> col_username;
     @FXML
    private TextField txt_id;

    @FXML
    private TableView<comptes> table_comptes;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_password;
    @FXML
    private TextField filterField;

    @FXML
    private TextField txt_username;
    ObservableList<comptes> listM;
    ObservableList<comptes> dataList;
    
   
    
    int index = -1;
    
    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    void Add_comptes(ActionEvent event) {
         conn = mysqlconnect1.ConnectDb();
        String sql = "insert into comptes (username,password,email)values(?,?,? )";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_username.getText());
            pst.setString(2, txt_password.getText());
            pst.setString(3, txt_email.getText());
        //    pst.setString(4, txt_type.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "comptes Add succes");
            UpdateTable();
           
            search_comptes();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

     @FXML
    void getSelected (MouseEvent event){
    index = table_comptes.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    txt_id.setText(col_id.getCellData(index).toString());
    txt_username.setText(col_username.getCellData(index).toString());
    txt_password.setText(col_password.getCellData(index).toString());
    txt_email.setText(col_email.getCellData(index).toString());
    }

    @FXML 
    void Delete_comptes(ActionEvent event) {
    conn = mysqlconnect1.ConnectDb();
    String sql = "delete from comptes where id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            UpdateTable();
            search_comptes();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
     
    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<comptes,Integer>("id"));
        col_username.setCellValueFactory(new PropertyValueFactory<comptes,String>("username"));
        col_password.setCellValueFactory(new PropertyValueFactory<comptes,String>("password"));
        col_email.setCellValueFactory(new PropertyValueFactory<comptes,String>("email"));
       
        
        listM = mysqlconnect1.getDatacomptes();
        table_comptes.setItems(listM);
    }

        
 @FXML
    void search_comptes() {          
        col_id.setCellValueFactory(new PropertyValueFactory<comptes,Integer>("id"));
        col_username.setCellValueFactory(new PropertyValueFactory<comptes,String>("username"));
        col_password.setCellValueFactory(new PropertyValueFactory<comptes,String>("password"));
        col_email.setCellValueFactory(new PropertyValueFactory<comptes,String>("email"));
       
        
        dataList = mysqlconnect1.getDatacomptes();
        table_comptes.setItems(dataList);
        FilteredList<comptes> filteredData = new FilteredList<>(dataList, b -> true);  
 filterField.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getUsername().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    } else if (person.getPassword().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }else if (person.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }
                                
         else  
          return false; // Does not match.
   });
  });  
  SortedList<comptes> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(table_comptes.comparatorProperty());  
  table_comptes.setItems(sortedData);      
    }
public void Edit (){   
        try {
            conn = mysqlconnect1.ConnectDb();
            String value1 = txt_id.getText();
            String value2 = txt_username.getText();
           String value3 = txt_password.getText();
           String value4 = txt_email.getText();
           // String value5 = txt_type.getText();
            String sql = "update comptes set id= '"+value1+"',username= '"+value2+"',password='"+value3+"',email='"+value4+"' where id='"+value1+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
            UpdateTable();
            search_comptes();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */

    public void initialize(URL url, ResourceBundle rb) {
        UpdateTable();
        search_comptes();
    }
      /* col_id.setCellValueFactory(new PropertyValueFactory<comptes,Integer>("id"));
       col_username.setCellValueFactory(new PropertyValueFactory<comptes,String>("username"));
       col_password.setCellValueFactory(new PropertyValueFactory<comptes,String>("password"));
       col_email.setCellValueFactory(new PropertyValueFactory<comptes,String>("email"));
        listM = mysqlconnect1.getDatacomptes();
        table_comptes.setItems(listM);
    }    */
}
   