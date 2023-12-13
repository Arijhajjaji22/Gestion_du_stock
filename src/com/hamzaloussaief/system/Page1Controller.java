package com.hamzaloussaief.system;

import java.awt.HeadlessException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author amir
 */
public class Page1Controller implements Initializable {
    

    @FXML
    private TableView<page> table_page;
    
    
    @FXML
    private TableColumn<page, String> col_code;

    @FXML
    private TableColumn<page, String> col_description;
    
    @FXML
    private TableColumn<page, String> col_etat;
    
    @FXML
    private TableColumn<page, String> col_num;
    
    @FXML
    private TableColumn<page, String> col_lieu;
    
    @FXML
    private TableColumn<page, String> col_stock;
    
    @FXML
    private TableColumn<page, String> col_bmvt;
    
    @FXML
    private TableColumn<page, String> col_type;
    
    @FXML
    private TableColumn<page, String> col_nombre;
    
    @FXML
    private TableColumn<page, String> col_id;
    
    @FXML
    private TableColumn<page, String> col_ref;
    
    @FXML
    private TableColumn<page, String> col_affect;
    
    @FXML
    private TableColumn<page, String> col_zoneservice;
    
    @FXML
    private TableColumn<page, String> col_enservice;
    
    @FXML
    private TableColumn<page, String> col_observ;

    
    
    
    
    
    @FXML
    private TextField txt_affect;

    @FXML
    private TextField txt_bmvt;

    @FXML
    private TextField txt_code;

    @FXML
    private TextField txt_description;

    @FXML
    private TextField txt_enservice;

    @FXML
    private TextField txt_etat;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_lieu;

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_num;

    @FXML
    private TextField txt_observ;

    @FXML
    private TextField txt_ref;

    @FXML
    private TextField txt_stock;

    @FXML
    private TextField txt_type;

    @FXML
    private TextField txt_zoneservice;
    
    
    @FXML
    private TextField filterField;
    
       
    ObservableList<page> listM;
    ObservableList<page> dataList;
    
   
    
    int index = -1;
    
    Connection conn =null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
     
    public void Add_page (){    
        conn = connectbase.ConnectDb();
        String sql = "insert into users (code,description,etat,numero,lieu,stock,bmvt,type,nombre,id,reference,affect,zoneservice,enservice,observation)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_code.getText());
            pst.setString(2, txt_description.getText());
            pst.setString(3, txt_etat.getText());
            pst.setString(4, txt_num.getText());
            pst.setString(5, txt_lieu.getText());
            pst.setString(6, txt_stock.getText());
            pst.setString(7, txt_bmvt.getText());
            pst.setString(8, txt_type.getText());
            pst.setString(9, txt_nombre.getText());
            pst.setString(10, txt_id.getText());
            pst.setString(11, txt_ref.getText());
            pst.setString(12, txt_affect.getText());
            pst.setString(13, txt_zoneservice.getText());
            pst.setString(14, txt_enservice.getText());
            pst.setString(15, txt_observ.getText());
            
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, " Add succes");
            UpdateTable();
            search_page();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

    //////// methode select users ///////
    @FXML
    void getSelected (MouseEvent event){
    index = table_page.getSelectionModel().getSelectedIndex();
    if (index <= -1){
    
        return;
    }
                
            txt_code.setText(col_code.getCellData(index));
            txt_description.setText(col_description.getCellData(index));
            txt_etat.setText(col_etat.getCellData(index));
            txt_num.setText(col_num.getCellData(index));
            txt_lieu.setText(col_lieu.getCellData(index));
            txt_stock.setText(col_stock.getCellData(index));
            txt_bmvt.setText(col_bmvt.getCellData(index));
            txt_type.setText(col_type.getCellData(index));
            txt_nombre.setText(col_nombre.getCellData(index));
            txt_id.setText(col_id.getCellData(index));
            txt_ref.setText(col_ref.getCellData(index));
            txt_affect.setText(col_affect.getCellData(index));
            txt_zoneservice.setText(col_zoneservice.getCellData(index));
            txt_enservice.setText(col_enservice.getCellData(index));
            txt_observ.setText(col_observ.getCellData(index));
            
            
            
    
    }

    public void Edit (){   
        try {
            conn = connectbase.ConnectDb();
            String value1 = txt_code.getText();
            String value2 = txt_description.getText();
            String value3 = txt_etat.getText();
            String value4 = txt_num.getText();
            String value5 = txt_lieu.getText();
            String value6 = txt_stock.getText();
            String value7 = txt_bmvt.getText();
            String value8 = txt_type.getText();
            String value9 = txt_nombre.getText();
            String value10 = txt_id.getText();
            String value11 = txt_ref.getText();
            String value12 = txt_affect.getText();
            String value13 = txt_zoneservice.getText();
            String value14 = txt_enservice.getText();
            String value15 = txt_observ.getText();
            String sql = "update users set code= '"+value1+"',description= '"+value2+"',etat= '"+
                    value3+"',numero= '"+value4+"',lieu= '"+value5+"',stock= '"+value6+"',bmvt= '"+value7+
                    "',type= '"+value8+"',nombre= '"+value9+"',id= '"+value10+"',reference= '"+value11+"',affect= '"+
                    value12+"',zoneservice= '"+value13+"',enservice= '"+value14+"',observation= '"+value15+"' where reference='"+value11+"' ";
            pst= conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update");
            UpdateTable();
            search_page();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void Delete(){
    conn = connectbase.ConnectDb();
    String sql = "delete from users where reference = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_ref.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Delete");
            UpdateTable();
            search_page();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }


    
    public void UpdateTable(){
        col_code.setCellValueFactory(new PropertyValueFactory<page,String>("code"));
        col_description.setCellValueFactory(new PropertyValueFactory<page,String>("description"));
        col_etat.setCellValueFactory(new PropertyValueFactory<page,String>("etat"));
        col_num.setCellValueFactory(new PropertyValueFactory<page,String>("numero"));
        col_lieu.setCellValueFactory(new PropertyValueFactory<page,String>("lieu"));
        col_stock.setCellValueFactory(new PropertyValueFactory<page,String>("stock"));
        col_bmvt.setCellValueFactory(new PropertyValueFactory<page,String>("bmvt"));
        col_type.setCellValueFactory(new PropertyValueFactory<page,String>("type"));
        col_nombre.setCellValueFactory(new PropertyValueFactory<page,String>("nombre"));
        col_id.setCellValueFactory(new PropertyValueFactory<page,String>("id"));
        col_ref.setCellValueFactory(new PropertyValueFactory<page,String>("reference"));
        col_affect.setCellValueFactory(new PropertyValueFactory<page,String>("affect"));
        col_zoneservice.setCellValueFactory(new PropertyValueFactory<page,String>("zoneservice"));
        col_enservice.setCellValueFactory(new PropertyValueFactory<page,String>("enservice"));
        col_observ.setCellValueFactory(new PropertyValueFactory<page,String>("observation"));
        
        
        listM = connectbase.getDatapage();
        table_page.setItems(listM);
    }
    
    

    
 @FXML
    void search_page() {          
        col_num.setCellValueFactory(new PropertyValueFactory<page,String>("numero"));
        col_ref.setCellValueFactory(new PropertyValueFactory<page,String>("reference"));
//        col_code.setCellValueFactory(new PropertyValueFactory<users,String>("code"));
        
        dataList = connectbase.getDatapage();
        table_page.setItems(dataList);
        FilteredList<page> filteredData = new FilteredList<>(dataList, b -> true);  
 filterField.textProperty().addListener((observable, oldValue, newValue) -> {
 filteredData.setPredicate(person -> {
    if (newValue == null || newValue.isEmpty()) {
     return true;
    }    
    String lowerCaseFilter = newValue.toLowerCase();
    
    if (person.getNumero().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
     return true; // Filter matches username
    } else if (person.getReference().toLowerCase().indexOf(lowerCaseFilter) != -1) {
     return true; // Filter matches password
    }
                                
         else  
          return false; // Does not match.
   });
  });  
  SortedList<page> sortedData = new SortedList<>(filteredData);  
  sortedData.comparatorProperty().bind(table_page.comparatorProperty());  
  table_page.setItems(sortedData);      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    UpdateTable();
    search_page();
    // Code Source in description
    } 
}