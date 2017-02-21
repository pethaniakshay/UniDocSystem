/*
    Controller of the following Screens:
    1. POIRegestraion
    2. POARegestraion
 */
package NewRegistration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DateCell;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import unidocregistration.LogInScreenController;
import java.util.Date;
import javafx.event.Event;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Registration implements Initializable {
    
    @FXML private AnchorPane poiL;
    @FXML private AnchorPane poaL;
    
    //Common declaraions for all screen
    @FXML private Button back;
    @FXML private Button reset;
    @FXML private Button save;
    @FXML private Button next;
    
    @FXML private TextField firstName;
    @FXML private TextField middleName;
    @FXML private TextField lastname;
    @FXML private TextField fullName;
    
    @FXML private RadioButton male;
    @FXML private RadioButton female;
    @FXML private RadioButton other;
    
    @FXML private RadioButton birthDateaKnown;
    @FXML private DatePicker birthDate;
    @FXML private RadioButton birthDateUnKnown;
    @FXML private TextField estimatedYearOfBirth;
    
    @FXML private RadioButton baseParents;
    @FXML private TextField uidMother;
    @FXML private TextField uidFather;
    
    @FXML private RadioButton baseHubWife;
    @FXML private TextField uidPartner;
    
    @FXML private RadioButton baseGaurdian;
    @FXML private TextField uidGaurdian;
    
    @FXML private RadioButton baseOther;
    @FXML private TextField uidOther;
    
    @FXML private RadioButton msSingle;
    @FXML private RadioButton msMarried;
    @FXML private RadioButton msWidowed;
    @FXML private RadioButton msDivorced;
    @FXML private RadioButton msSeparated;
    @FXML private RadioButton msUndefined;
   
    @FXML private ComboBox co;
    @FXML private TextField coV;
    @FXML private TextField uidTakeFrom;
    @FXML private TextField houseNo;
    @FXML private TextField street;
    @FXML private TextField area;
    @FXML private TextField village;
    @FXML private TextField pinCode;
    
    @FXML private ComboBox country;
    @FXML private ComboBox satate;
    @FXML private ComboBox district;
    @FXML private ComboBox city;
    
    @FXML private TextField emailId;
    @FXML private TextField mobileNo;
    
    @FXML private ComboBox poi;
    @FXML private TextField poiId;
    @FXML private ComboBox poa;
    @FXML private TextField poaId;
    @FXML private ComboBox pob;
    @FXML private TextField pobId;
    
    //code for POIRegestraion
    @FXML
    private void POIRegestration(ActionEvent event) throws Exception{
        Stage stage;
        Parent root;
          
        if(event.getSource()==next){    
            stage = (Stage) next.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("POARegestrationScreen.fxml")); 
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); 
        }
        if (event.getSource()==save){
            next.setDisable(false);   
        }
        if(event.getSource()==back){   
            stage = (Stage) back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/unidocregistration/SelectionScreen.fxml"));  
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); 
        }
    }
    
    @FXML
    private void birthRadioButtonManagement(ActionEvent event){
        if(event.getSource() == birthDateUnKnown){
            estimatedYearOfBirth.setDisable(false);
            birthDate.setDisable(true);
        }
        if(event.getSource() == birthDateaKnown){
            estimatedYearOfBirth.setDisable(true);
            birthDate.setDisable(false);
        }
    }
    
    @FXML
    private void registrationBaseRadioButtomManagement(ActionEvent event){
        if(event.getSource() == baseParents){
            uidOther.setDisable(true);
            uidGaurdian.setDisable(true);
            uidMother.setDisable(false);
            uidFather.setDisable(false);
        }
        if(event.getSource() == baseHubWife){
            uidOther.setDisable(true);
            uidGaurdian.setDisable(true);
            uidMother.setDisable(true);
            uidFather.setDisable(true);
        }
        if(event.getSource() == baseGaurdian){
            uidOther.setDisable(true);
            uidGaurdian.setDisable(false);
            uidMother.setDisable(true);
            uidFather.setDisable(true);
        }
        if(event.getSource() == baseOther){
            uidOther.setDisable(false);
            uidGaurdian.setDisable(true);
            uidMother.setDisable(true);
            uidFather.setDisable(true);
        }    
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
        
    //For Logout Button
    @FXML
    private void gotologOut(ActionEvent event){
        try{             
            Parent root = FXMLLoader.load(getClass().getResource("/unidocregistration/LogInScreen.fxml")); 
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();   
        } catch (IOException ex) {
            Logger.getLogger(LogInScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Invoc when POIRegisrtation screen starts. bind with the On Mouse Entered event of the Layout
    @FXML 
    private void POIScreenInitialization(MouseEvent event){
    
        next.setDisable(true);
        estimatedYearOfBirth.setDisable(true);
        uidGaurdian.setDisable(true);
        uidOther.setDisable(true);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}