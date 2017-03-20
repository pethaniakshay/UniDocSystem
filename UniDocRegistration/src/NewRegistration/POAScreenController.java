package NewRegistration;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class POAScreenController implements Initializable{
    
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
    List<String> colist  = new LinkedList<>();
    List<String> poalist  = new LinkedList<>();
    List<String> poilist  = new LinkedList<>();
    List<String> poblist  = new LinkedList<>();
    
    @FXML private TextField emailId;
    @FXML private TextField mobileNo;
    
    @FXML private ComboBox poi;
    @FXML private TextField poiId;
    @FXML private ComboBox poa;
    @FXML private TextField poaId;
    @FXML private ComboBox pob;
    @FXML private TextField pobId;
    
    NewRegistationContainer NRContainer = new NewRegistationContainer();
    
    //code for POARegestraion
    @FXML
    private void POARegestration(ActionEvent event) throws Exception{
        Stage stage;
        Parent root;
        
        if(event.getSource()==back){
            
            stage = (Stage) back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("POIRegestrationScreen.fxml")); 
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        if(event.getSource()==next){
            
            stage = (Stage) next.getScene().getWindow();
            
            //root = FXMLLoader.load(getClass().getResource("NewRegConScreen.fxml")); 
            FXMLLoader loader = new FXMLLoader();
            root = loader.load(getClass().getResource("NewRegConScreen.fxml").openStream());
            
            NewRegConScreen nrc = (NewRegConScreen) loader.getController();
            nrc.getNRContainer(NRContainer);
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
        if(event.getSource()==save){
            
            NRContainer.co = (String)co.getValue() + ": " + coV.getText();
            
            NRContainer.uidTakeFrom = uidTakeFrom.getText();
            
            NRContainer.houseNo = houseNo.getText();
            
            NRContainer.street = street.getText();
            
            NRContainer.area = area.getText();
            
            NRContainer.village = village.getText();
            
            NRContainer.pincode = pinCode.getText();
            
            NRContainer.emailid = emailId.getText();
            
            NRContainer.mobile = mobileNo.getText();
            
            NRContainer.country = (String) country.getValue();
            
            NRContainer.state = (String) state.getValue();
            
            NRContainer.district = (String) district.getValue();
            
            NRContainer.city = (String) city.getValue();
            
            NRContainer.poa = (String) poa.getValue();
            NRContainer.poan = poaId.getText();
            
            NRContainer.pob = (String) pob.getValue();
            NRContainer.pobn = pobId.getText();
            
            NRContainer.poi = (String) poi.getValue();
            NRContainer.poin = poiId.getText();
           
            next.setDisable(false); 
        }    
    }
      
    public void getNRContainer(NewRegistationContainer container){
        NRContainer = container;
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
     
   @FXML
   private void stateSelection(ActionEvent event) throws Exception{
          
       dlist.clear();
       
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unidocsystem","root","");
       Statement stmt = con.createStatement();
       
       //detecting the sr no of state
       String svalue = (String) state.getValue();
//       ResultSet getStateId = stmt.executeQuery("select sr from state where name = '"+ svalue +"';" );
//       int stateId =0;
//       
//       while(getStateId.next()){
//           stateId = getStateId.getInt(1);
//       }
      
       ResultSet rs = stmt.executeQuery("select district from district where state = '"+ svalue +"';");
                  
       while(rs.next())
       {
           dlist.add(rs.getString(1));
       }
       ObservableList<String> olist = FXCollections.observableList(dlist);
       district.setValue("District");
       district.setItems(olist);
   }
      
   @FXML
   private void districtSelection(ActionEvent event) throws Exception{
       clist.clear();
       
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unidocsystem","root","");
       Statement stmt = con.createStatement();
       
       //detecting the sr no of state
       String dvalue = (String) district.getValue();
//       ResultSet getDistrictId = stmt.executeQuery("select sr from district where name = '"+ dvalue +"';" );
//       int districtId =0;
//       
//       while(getDistrictId.next()){
//           districtId = getDistrictId.getInt(1);
//       }
      
       ResultSet rs = stmt.executeQuery("select city from city where district = '"+ dvalue +"';");
                  
       while(rs.next())
       {
           clist.add(rs.getString(1));
       }
       ObservableList<String> olist = FXCollections.observableList(clist);
       city.setValue("City");
       city.setItems(olist);
   }
           
    @Override
    public void initialize(URL location, ResourceBundle resources) {  
        
        next.setDisable(true);
        
        //For C/O combobox initialization
        colist.add("C/O");
        colist.add("S/O");
        colist.add("D/O");
        colist.add("H/O");
        
        ObservableList<String> coolist = FXCollections.observableList(colist);
        co.setValue("C/O");
        co.setItems(coolist);
               
        //For state combox initialization
        try {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unidocsystem","root","");
           Statement stmt = con.createStatement();
           
           //Initialization of combox of state list
           ResultSet rs = stmt.executeQuery("select state from state;");
           while(rs.next())
            {
                slist.add(rs.getString(1));
            }
           ObservableList<String> olist = FXCollections.observableList(slist);
           state.setValue("State");
           state.setItems(olist);
           
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        //FOR POA DOC combobox
        poalist.add("Doc 1");
        poalist.add("Doc 2");
        poalist.add("Doc 3");
        ObservableList<String> poaolist = FXCollections.observableList(poalist);
        poa.setValue("Proof of Address");
        poa.setItems(poaolist);
        
        //FOR POI DOC combobox
        poilist.add("Doc 1");
        poilist.add("Doc 2");
        poilist.add("Doc 3");
        ObservableList<String> poiolist = FXCollections.observableList(poilist);
        poi.setValue("Proof of Identity");
        poi.setItems(poiolist);
        
        //FOR POB DOC combobox
        poblist.add("Doc 1");
        poblist.add("Doc 2");
        poblist.add("Doc 3");
        ObservableList<String> pobolist = FXCollections.observableList(poblist);
        pob.setValue("Proof of birth");
        pob.setItems(pobolist);     
    }
}
