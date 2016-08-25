/*
    Splash Screen controller of the UniDoc
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

public class SplashScreenController implements Initializable {
    
    @FXML
    private Button next;
    
    @FXML
    private void goToLogIn(ActionEvent event)throws Exception{
        Stage stage;
        Parent root;
        
        stage = (Stage) next.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LogInScreen.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }       
}
