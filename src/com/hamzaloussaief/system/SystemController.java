//package com.hamzaloussaief.system;
//
//import javafx.application.Platform;
//import javafx.fxml.FXML;
//import javafx.scene.input.MouseEvent;
//
//
//public class SystemController {
//   
//    public void onClose() {
//        Platform.exit();
//    }
//
//    @FXML
//    private void home(MouseEvent event) {
//    }
//
//    @FXML
//    private void page1(MouseEvent event) {
//    }
//
//    @FXML
//    private void page2(MouseEvent event) {
//    }
//
//    @FXML
//    private void page3(MouseEvent event) {
//    }
//}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzaloussaief.system;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Hamza
 */
public class SystemController {
    
//    private Label label;
    @FXML
    private BorderPane bp;
//    @FXML
//    private AnchorPane ap;
    @FXML
    private Button home;
    @FXML
    private AnchorPane ap;
    
//    private void handleButtonAction(ActionEvent event) {
//        
//        label.setText("Hello World!");
//    }
    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    

//    @FXML
//    private void home(MouseEvent event) {
//        bp.setCenter(ap);
//    }

    @FXML
    private void page1(MouseEvent event) {
        loadPage("page1");
    }

    @FXML
    private void page2(MouseEvent event) {
        loadPage("page2");
    }

    @FXML
    private void page3(MouseEvent event) {
        loadPage("page3");
    }
    
    @FXML
    private void page4(MouseEvent event) {
        loadPage("page4");
    }
    
    @FXML
    private void page5(MouseEvent event) {
        loadPage("page5");
    }
    
    @FXML
    private void page6(MouseEvent event) {
        loadPage("page6");
    }
    
    @FXML
    private void page7(MouseEvent event) {
        loadPage("page7");
    }
    
    
    private void loadPage(String page){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(page+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(SystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        bp.setCenter(root);
    }

    @FXML
    private void home(MouseEvent event) {
        bp.setCenter(ap);
    }

    @FXML
    private void login(MouseEvent event) {
        bp.setCenter(ap);
        
    }
    
}
