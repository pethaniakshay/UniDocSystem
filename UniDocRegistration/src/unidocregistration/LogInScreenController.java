/*
 The controller of Login Screen and Selection Screen
*/

package unidocregistration;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
