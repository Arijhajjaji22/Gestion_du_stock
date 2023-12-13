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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Page6Controller implements Initializable {
     @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_abonné;
    @FXML
    private TextField txt_ligne;
    @FXML
    private TextField txt_date;
    @FXML
    private TextField txt_lieu;
    @FXML
    private TextField txt_id;
    @FXML
    private TextField txt_reference;
    @FXML
    private TextField txt_prenom;

    @FXML
    private TableView<fiche> table_fiche;
    @FXML
    private TableColumn<fiche, String> col_nom;
    @FXML
    private TableColumn<fiche, String> col_prenom;
    @FXML
    private TableColumn<fiche, String> col_ligne;
    @FXML
    private TableColumn<fiche, String> col_reference;
    @FXML
    private TableColumn<fiche, String> col_abonné;
    @FXML
    private TableColumn<fiche, String> col_lieu;
    @FXML
    private TableColumn<fiche, String> col_date;
    @FXML
    private TableColumn<fiche, Integer> col_id;
    @FXML
    private TextField filterField;
     ObservableList<fiche> listM;
    ObservableList<fiche> dataList;
    
   
    
    int index = -1;
    
    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdateTable();
        search_fiche();
        // TODO
    }    

    @FXML
    private void getSelected(MouseEvent event) {
       
         index = table_fiche.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
    txt_id.setText(col_id.getCellData(index).toString());
 //   txt_nom.setText(col_nom.getCellData(index).toString());
   // txt_prenom.setText(col_prenom.getCellData(index).toString());
     //txt_ligne.setText(col_ligne.getCellData(index).toString());
   
    //txt_reference.setText(col_reference.getCellData(index).toString());
    //txt_abonné.setText(col_abonné.getCellData(index).toString());
    //txt_lieu.setText(col_lieu.getCellData(index).toString());
    //txt_date.setText(col_date.getCellData(index).toString());
    }
      public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<fiche,Integer>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<fiche,String>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<fiche,String>("prenom"));
        col_ligne.setCellValueFactory(new PropertyValueFactory<fiche,String>("ligne"));
           col_reference.setCellValueFactory(new PropertyValueFactory<fiche,String>("reference"));
        col_abonné.setCellValueFactory(new PropertyValueFactory<fiche,String>("abonné"));
        col_lieu.setCellValueFactory(new PropertyValueFactory<fiche,String>("lieu"));
        col_date.setCellValueFactory(new PropertyValueFactory<fiche,String>("date"));
       
        
        listM = connect.getDatafiche();
        table_fiche.setItems(listM);
    }
       @FXML
    void search_fiche() {          
        col_id.setCellValueFactory(new PropertyValueFactory<fiche,Integer>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<fiche,String>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<fiche,String>("prenom"));
        col_ligne.setCellValueFactory(new PropertyValueFactory<fiche,String>("ligne"));
        col_reference.setCellValueFactory(new PropertyValueFactory<fiche,String>("reference"));
        col_abonné.setCellValueFactory(new PropertyValueFactory<fiche,String>("abonné"));
        col_lieu.setCellValueFactory(new PropertyValueFactory<fiche,String>("lieu"));
        col_date.setCellValueFactory(new PropertyValueFactory<fiche,String>("date"));
       
       
        
        dataList = connect.getDatafiche();
        table_fiche.setItems(dataList);
        FilteredList<fiche> filteredData = new FilteredList<>(dataList, b -> true);  
 filterField.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    } else if (person.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }
    if (person.getLigne().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; 
    }
    if (person.getReference().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; 
    }
      
    if (person.getAbonné().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; 
    }
      
    if (person.getLieu().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; 
    }
      if (person.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; 
    }
     
      
                                
         else  
          return false; // Does not match.
   });
           });  
  
  SortedList<fiche> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(table_fiche.comparatorProperty());  
  table_fiche.setItems(sortedData);      
         }
     @FXML
    private void Delete(ActionEvent event) {
        conn = connect.ConnectDb();
    String sql = "delete from fiche where id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            UpdateTable();
            search_fiche();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
         
         }
         
    
    

