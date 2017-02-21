/*
 The controller of Login Screen and Selection Screen
*/

package unidocregistration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LogInScreenController implements Initializable {
    
    //code for login screen
    @FXML
    private Button login;
     
    @FXML
    private void goToSelection(ActionEvent event) throws Exception{
        
        Stage stage;
        Parent root;
     
        stage = (Stage) login.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("SelectionScreen.fxml"));     
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    
    //code for selection screen
    
    @FXML
    private Button newregestraion;
    
    @FXML
    private void goToNewRegestraion(ActionEvent event) throws Exception{
        
        Stage stage;
        Parent root;
        
        stage = (Stage) newregestraion.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/NewRegistration/POIRegestrationScreen.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    //Log out button 
      
    @FXML
    private void gotologOut(ActionEvent event){
        try{             
            Parent root = FXMLLoader.load(getClass().getResource("LogInScreen.fxml")); 
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();   
        } catch (IOException ex) {
            Logger.getLogger(LogInScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
