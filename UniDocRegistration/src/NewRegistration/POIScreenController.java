package NewRegistration;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import unidocregistration.LogInScreenController;
import DataContainer.NewRegistationContainer;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class POIScreenController implements Initializable{
   
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
    @FXML private ComboBox state;
    @FXML private ComboBox district;
    @FXML private ComboBox city;
    
    List<String> slist = new LinkedList<>();
    List<String> dlist = new LinkedList<>();
    List<String> clist = new LinkedList<>();
    
    @FXML private TextField emailId;
    @FXML private TextField mobileNo;
    
    @FXML private ComboBox poi;
    @FXML private TextField poiId;
    @FXML private ComboBox poa;
    @FXML private TextField poaId;
    @FXML private ComboBox pob;
    @FXML private TextField pobId;
    
    NewRegistationContainer NRContainer = new NewRegistationContainer();
        
    //code for POIRegestraion
    @FXML
    private void POIRegestration(ActionEvent event) throws Exception{
        Stage stage;
        Parent root;
          
        if(event.getSource()==next){    
            stage = (Stage) next.getScene().getWindow();
           
            //root = FXMLLoader.load(getClass().getResource("POARegestrationScreen.fxml")); 
            FXMLLoader loader = new FXMLLoader();
            root = loader.load(getClass().getResource("POARegestrationScreen.fxml").openStream());
            
            POAScreenController poc = (POAScreenController) loader.getController();
            poc.getNRContainer(NRContainer);
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); 
        }
            
        if (event.getSource()==save){
               
              NRContainer.firstName = firstName.getText();
              NRContainer.middleName = middleName.getText();
              NRContainer.lastName = lastname.getText();
              NRContainer.fullName = fullName.getText();

              if(male.isSelected())NRContainer.gender = "Male"; 
              if(female.isSelected())NRContainer.gender = "Female";
              if(other.isSelected())NRContainer.gender = "Other";

              if(birthDateaKnown.isSelected()){
                  try{
                      NRContainer.birthdate  = Date.from(birthDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                  }
                  catch(Exception e){
                      System.out.println("Error: " + e + "   @#*");
                  }   
              }

              if(birthDateUnKnown.isSelected()){

                  int year = Integer.parseInt(estimatedYearOfBirth.getText());

                  Calendar cal = Calendar.getInstance();
                  Date today = cal.getTime();
                  cal.add(Calendar.YEAR,(-1*year));

                  NRContainer.birthdate = cal.getTime();
              }

              if(baseParents.isSelected()){
                  NRContainer.registrationBase = "Paretns";
                  NRContainer.uidMother = uidMother.getText();
                  NRContainer.uidFather = uidFather.getText();
              }

              if(baseHubWife.isSelected()){
                  if(male.isSelected())NRContainer.registrationBase = "Wife";
                  if(female.isSelected())NRContainer.registrationBase = "Husband";
                  NRContainer.uidPartner = uidPartner.getText();    
              }

              if(baseGaurdian.isSelected()){
                  NRContainer.registrationBase = "Gaurdian";
                  NRContainer.uidGaurdian = uidGaurdian.getText();
              }

              if(baseOther.isSelected()){
                  NRContainer.registrationBase = "Other";
                  NRContainer.uidOther = uidOther.getText();
              }

              if(msSingle.isSelected())NRContainer.martialStatus = "Single";
              if(msSeparated.isSelected())NRContainer.martialStatus = "Separated";
              if(msWidowed.isSelected())NRContainer.martialStatus = "Widowed";
              if(msMarried.isSelected())NRContainer.martialStatus = "Married";
              if(msUndefined.isSelected())NRContainer.martialStatus = "Undefined";

              NRContainer.uidPartner = uidPartner.getText();
          
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
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {  
        next.setDisable(true);
        estimatedYearOfBirth.setDisable(true);
        uidGaurdian.setDisable(true);
        uidOther.setDisable(true);
    }
}