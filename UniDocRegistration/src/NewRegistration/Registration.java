/*
    Controller of the following Screens:
    1. POIRegestraion
    2. POARegestraion
 */
package NewRegistration;

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


public class Registration implements Initializable {
    
    //Common declaraions for all screen
    @FXML
    private Button back;
    
    @FXML
    private Button reset;
    
    @FXML
    private Button save;
    
    @FXML
    private Button next;
    
    //code for POIRegestraion
    @FXML
    private void POIRegestration(ActionEvent event) throws Exception{
        Stage stage;
        Parent root;
        
        if(event.getSource()==back){
            
            stage = (Stage) next.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/unidocregistration/SelectionScreen.fxml"));    
        }
        else if(event.getSource()==next){
            
            stage = (Stage) next.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("POARegestrationScreen.fxml"));     
        }
        else{
            stage = (Stage) next.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("POARegestrationScreen.fxml"));     
        }
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
        
    }
    
    
    //code for POARegestraion
    @FXML
    private void POARegestration(ActionEvent event) throws Exception{
        Stage stage;
        Parent root;
        
        if(event.getSource()==back){
            
            stage = (Stage) next.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("POIRegestrationScreen.fxml"));    
        }
        else if(event.getSource()==next){
            
            stage = (Stage) next.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("DocVerificationScreen.fxml"));     
        }
        else{
            stage = (Stage) next.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("DocVerificationScreen.fxml"));     
        }
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
        
    }
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO   
    }
    
}
