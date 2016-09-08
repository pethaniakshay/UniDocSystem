/*
    Splash Screen controller of the UniDoc
*/

package unidocregistration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SplashScreenController implements Initializable {
    
    /*@FXML
    private Button next;*/
    
    @FXML AnchorPane ap;
    
    class ShowSplashScreen extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(1500);
                
                Platform.runLater(() -> {
                    Stage stage = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("LogInScreen.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    ap.getScene().getWindow().hide();
                });                
            } catch (InterruptedException ex) {
                Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    /*@FXML
    private void goToLogIn(ActionEvent event)throws Exception{
        Stage stage;
        Parent root;
        
        stage = (Stage) next.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("LogInScreen.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();       
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new ShowSplashScreen().start();
    }       
}
