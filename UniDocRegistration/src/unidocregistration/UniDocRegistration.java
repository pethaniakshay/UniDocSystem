/*
    This is a main file of the UniDoc regestration module. Actual program starrs from here.
 */
package unidocregistration;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Angel
 */
public class UniDocRegistration extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Initialization of the Splash screen
        Parent root = FXMLLoader.load(getClass().getResource("SplashScreen.fxml")); 
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
