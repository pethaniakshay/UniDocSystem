package NewRegistration;

import DataContainer.NewRegistationContainer;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
    boolean isSubmit = false;
    
    
    
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
    private void newRegConScreen(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;
        
        if(event.getSource()==back){
            
            stage = (Stage) back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("POARegestrationScreen.fxml")); 
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        if(event.getSource()==next){
            
            stage = (Stage) next.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/unidocregistration/SelectionScreen.fxml")); 
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
    }
    
    @FXML
    private void submitDataToServer(ActionEvent event) throws ClassNotFoundException, SQLException{
        
        if(isSubmit==false){
            
            String SQLStatement = "insert into newregistereddata values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NULL);";
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unidocsystem","root","")) {
                PreparedStatement stmt = con.prepareStatement(SQLStatement);
                
                stmt.setString(1,NRContainer.firstName);
                stmt.setString(2,NRContainer.middleName);
                stmt.setString(3,NRContainer.lastName);
                stmt.setString(4,NRContainer.fullName);
                stmt.setString(5,NRContainer.gender);
                stmt.setDate(6,new java.sql.Date(NRContainer.birthdate.getTime()));
                stmt.setString(7,NRContainer.registrationBase);
                stmt.setString(8,NRContainer.uidMother);
                stmt.setString(9,NRContainer.uidFather);
                stmt.setString(10,NRContainer.uidGaurdian);
                stmt.setString(11,NRContainer.uidOther);
                stmt.setString(12,NRContainer.martialStatus);
                stmt.setString(13,NRContainer.uidPartner);
                stmt.setString(14,NRContainer.co);
                stmt.setString(15,NRContainer.uidTakeFrom);
                stmt.setString(16,NRContainer.houseNo);
                stmt.setString(17,NRContainer.street);
                stmt.setString(18,NRContainer.area);
                stmt.setString(19,NRContainer.village);
                stmt.setString(20,NRContainer.pincode);
                stmt.setString(21,NRContainer.city);
                stmt.setString(22,NRContainer.district);
                stmt.setString(23,NRContainer.state);
                stmt.setString(24,NRContainer.country);
                stmt.setString(25,NRContainer.emailid);
                stmt.setString(26,NRContainer.mobile);
                stmt.setString(27,NRContainer.poi);
                stmt.setString(28,NRContainer.poin);
                stmt.setString(29,NRContainer.pob);
                stmt.setString(30,NRContainer.pobn);
                stmt.setString(31,NRContainer.poa);
                stmt.setString(32,NRContainer.poan);
                stmt.setString(33,"no");
                //stmt.setInt(34, null);
              
                
                stmt.executeUpdate();
                
                submitConf.setText("Data Succefully Uploaded On ther server");
            }
           
            isSubmit = true;
        }
        else{
            submitConf.setText("Data Aleready Uploaded On ther server");
        }    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }      
}