/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzaloussaief.system;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class Page5Controller implements Initializable {

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
        //UpdateTable();
    
        // TODO
    }    

   

   
    

    @FXML
    private void Add_fiche(ActionEvent event) {
        conn = connect.ConnectDb();
        String sql = "insert into fiche (nom,prenom,ligne,reference,abonné,lieu,date)values(?,?,?,?,?,?,? )";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_nom.getText());
            pst.setString(2, txt_prenom.getText());
          pst.setString(3, txt_ligne.getText());
            pst.setString(4, txt_reference.getText());
             pst.setString(5, txt_abonné.getText());
              pst.setString(6, txt_lieu.getText());
              pst.setString(7, txt_date.getText());
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "fiche Add succes");
            //UpdateTable();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     /* @FXML
    void envoyer(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hamzaloussaief/login/page6.fxml"));
            Parent root =(Parent) loader.load();
            Page5Controller controller =loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
           
        } catch (IOException e) {
            System.out.append("erreur d'affichage");
            e.printStackTrace();
        }*/

    }

    

   
    
    //txt_email.setText(col_email.getCellData(index).toString());
    //txt_type.setText(col_type.getCellData(index).toString());
    
    
    
     /*public void UpdateTable(){
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
    */
    

    
 
    
   






    

