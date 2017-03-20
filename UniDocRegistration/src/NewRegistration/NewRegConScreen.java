package NewRegistration;

import DataContainer.NewRegistationContainer;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import unidocregistration.LogInScreenController;

public class NewRegConScreen implements Initializable {
       
    @FXML private Label firstName;
    @FXML private Label middleName;
    @FXML private Label lastname;
    @FXML private Label fullName;
    
    @FXML private Label gender;
    
    @FXML private Label birthDate;
    
    @FXML private Label baseRelation;
    
    @FXML private Label uidMother;
    @FXML private Label uidBase;
    
    @FXML private Label maritialStatus;
    @FXML private Label uidPartner;
   
    @FXML private Label coV;
    @FXML private Label uidTakeFrom;
    @FXML private Label houseNo;
    @FXML private Label street;
    @FXML private Label area;
    @FXML private Label village;
    @FXML private Label pinCode;
   
    @FXML private Label country;
    @FXML private Label state;
    @FXML private Label city;
    @FXML private Label district;
    
    @FXML private Label email;
    @FXML private Label mobile;
    
    @FXML private Label poi;
    @FXML private Label poiId;
    @FXML private Label poa;
    @FXML private Label poaId;
    @FXML private Label pob;
    @FXML private Label pobId;
    
    @FXML private Label submitConf;
    
    @FXML private Button submit;
    @FXML private Button back;
    @FXML private Button next;
    
    NewRegistationContainer NRContainer = new NewRegistationContainer();
    
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
    
    public void getNRContainer(NewRegistationContainer container){
        NRContainer = container;
        
        firstName.setText(NRContainer.firstName);
        lastname.setText(NRContainer.lastName);
        middleName.setText(NRContainer.middleName);
        fullName.setText(NRContainer.fullName);
        
        gender.setText(NRContainer.gender);
        birthDate.setText(NRContainer.birthdate.toString());
        
        baseRelation.setText(NRContainer.registrationBase);
        uidBase.setText(NRContainer.uidGaurdian);
        maritialStatus.setText(NRContainer.martialStatus);
        uidPartner.setText(NRContainer.uidPartner);
        
        coV.setText(NRContainer.co);
        uidTakeFrom.setText(NRContainer.uidTakeFrom);
        houseNo.setText(NRContainer.houseNo);
        street.setText(NRContainer.street);
        area.setText(NRContainer.area);
        village.setText(NRContainer.village);
        pinCode.setText(NRContainer.pincode);
        country.setText("India");
        state.setText(NRContainer.state);
        district.setText(NRContainer.district);
        city.setText(NRContainer.city);
        
        email.setText(NRContainer.emailid);
        mobile.setText(NRContainer.mobile);
        
        poi.setText(NRContainer.poi);
        poiId.setText(NRContainer.poin);
        
        poa.setText(NRContainer.poa);
        poaId.setText(NRContainer.poan);
        
        pob.setText(NRContainer.pob);
        pobId.setText(NRContainer.pobn);
    }
    
    
    @FXML
    private void submitDataToServer(ActionEvent event){
        
     
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }      
}