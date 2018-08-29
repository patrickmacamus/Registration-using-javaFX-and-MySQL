package App;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Connection.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputEvent;
import javafx.stage.Stage;



public class MainController implements Initializable {
	
	PreparedStatement pst = null;
	ResultSet rs = null;
	private regDetails selectedDetails;
	
	  @FXML
	    private DatePicker dpTransDate;

	    @FXML
	    private TextField tfIDNumber;

	    @FXML
	    private TextField tfEngineNumber;

	    @FXML
	    private TextField tfChasisNumber;

	    @FXML
	    private TextField tfColor;

	    @FXML
	    private TextField tfCompanyName;

	    @FXML
	    private TextField tfOR;

	    @FXML
	    private TextField tfSINumber;

	    @FXML
	    private TextField tfSticker;

	    @FXML
	    private TextField tfSurname;

	    @FXML
	    private TextField tfFirstname;

	    @FXML
	    private TextField tfMiddlename;

	    @FXML
	    private TextField tfFileNumber;

	    @FXML
	    private TextField tfPlateNumber;

	    @FXML
	    private ComboBox cbBranch;

	    @FXML
	    private TextField tfMotoModel;

	    @FXML
	    private DatePicker dpReceived;

	    @FXML
	    private DatePicker dpReleased;

	    @FXML
	    private TextArea taNote;
	    
	    @FXML
	    private TextField tfStatus;
	
	
    @FXML
    private TableView<regDetails> tableReg;

    @FXML
    private TableColumn<regDetails, String> columnID;

    @FXML
    private TableColumn<regDetails, String> columnDate;

    @FXML
    private TableColumn<regDetails, String> columnEngineNumber;

    @FXML
    private TableColumn<regDetails, String> columnChasisNumber;

    @FXML
    private TableColumn<regDetails, String> columnColor;

    @FXML
    private TableColumn<regDetails, String> ColumnCompanyName;

    @FXML
    private TableColumn<regDetails, String> columnOR;

    @FXML
    private TableColumn<regDetails, String> columnSurname;

    @FXML
    private TableColumn<regDetails, String> columnFirstname;

    @FXML
    private TableColumn<regDetails, String> columnMiddlename;

    @FXML
    private TableColumn<regDetails, String> columnFileNumber;

    @FXML
    private TableColumn<regDetails, String> columnNote;

    @FXML
    private TableColumn<regDetails, String> columnStatus;

    @FXML
    private TableColumn<regDetails, String> columnPlateNumber;

    @FXML
    private TableColumn<regDetails, String> columnSticker;

    @FXML
    private TableColumn<regDetails, String> columnDateReleased;

    @FXML
    private TableColumn<regDetails, String> columnDateReceived;
    
    @FXML
    private TableColumn<regDetails, String> columnSI;
    
    @FXML
    private TableColumn<regDetails, String> columnMotoModel;
    
    @FXML
    private TableColumn<regDetails, String> columnBranch;
    
    
    
    @FXML
    private TextField dBranch;

    @FXML
    private TextField dID;

    @FXML
    private TextField dMoto;

    @FXML
    private TextField dEngine;

    @FXML
    private TextField dChasis;

    @FXML
    private TextField dColor;

    @FXML
    private TextField dDate;

    @FXML
    private TextField dReceived;

    @FXML
    private TextField dReleased;

    @FXML
    private TextField dCompany;

    @FXML
    private TextField dOR;

    @FXML
    private TextField dSI;

    @FXML
    private TextField dSticker;

    @FXML
    private TextField dSurname;

    @FXML
    private TextField dFirstname;

    @FXML
    private TextField dMiddlename;

    @FXML
    private TextField dFileNo;

    @FXML
    private TextField dStatus;

    @FXML
    private TextField dPlateNo;

    @FXML
    private TextArea dNote;
    
 
    private ObservableList<regDetails> data;
    private DBConnection dc;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dc = new DBConnection();
        tableReg.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        

    }

 
    
    
    public void Requery(ActionEvent event) throws Exception {
        try {
            Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();

            String query = "select * from registration1_2019;";
            pst = conn.prepareStatement(query);
            rs= pst.executeQuery();
            
            
            while (rs.next()) {
                //get string from db,whichever way 
                data.add(new regDetails(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                		rs.getString(6), rs.getString(7), rs.getString(8), 
                		rs.getString(9), rs.getString(10), rs.getString(11), 
                		rs.getString(12), rs.getString(13), rs.getString(14), 
                		rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(20), rs.getString(19)));
                System.out.println("Loading..");
            }
            
            

        } catch (SQLException ex) {
           
        	System.err.println("Error"+ex);
        	
        }
        
        columnID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("Date"));
        columnEngineNumber.setCellValueFactory(new PropertyValueFactory<>("EngineNo"));
        columnChasisNumber.setCellValueFactory(new PropertyValueFactory<>("ChasisNo"));
        columnColor.setCellValueFactory(new PropertyValueFactory<>("Color"));
        ColumnCompanyName.setCellValueFactory(new PropertyValueFactory<>("CompanyName"));
        columnSurname.setCellValueFactory(new PropertyValueFactory<>("Surname"));
        columnFirstname.setCellValueFactory(new PropertyValueFactory<>("Firstname"));
        columnMiddlename.setCellValueFactory(new PropertyValueFactory<>("Middlename"));
        columnFileNumber.setCellValueFactory(new PropertyValueFactory<>("FileNo"));
        columnNote.setCellValueFactory(new PropertyValueFactory<>("Note"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        columnPlateNumber.setCellValueFactory(new PropertyValueFactory<>("PlateNo"));
        columnSticker.setCellValueFactory(new PropertyValueFactory<>("Sticker"));
        columnDateReleased.setCellValueFactory(new PropertyValueFactory<>("DateReleased"));
        columnDateReceived.setCellValueFactory(new PropertyValueFactory<>("DateReceived"));
        columnOR.setCellValueFactory(new PropertyValueFactory<>("OR"));
        columnSI.setCellValueFactory(new PropertyValueFactory<>("SiNo"));
        columnBranch.setCellValueFactory(new PropertyValueFactory<>("Branch"));
        columnMotoModel.setCellValueFactory(new PropertyValueFactory<>("MotoModel"));
      
        
        
        
        tableReg.setItems(null);
        tableReg.setItems(data);
    }

	public void  Register(ActionEvent event) throws Exception  {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("register.fxml"));
	    Scene tableViewScene = new Scene(tableViewParent);
	    
	    //This line gets the Stage information
	    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    
	    window.setScene(tableViewScene);
	    window.show();
	    
	    System.out .println("Working!~");
		
	}
	
	
	public void  Settings(ActionEvent event) throws Exception  {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/App/settings.fxml"));
		Scene scene = new Scene (root,497,318);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		

		
	}
	
	
	public void  generateCsv(ActionEvent event) throws Exception  {
		
		try {
			
			
			String filename = "C:/files/generate.csv";
			FileWriter fw = new FileWriter(filename);
			Connection conn = dc.Connect();
	        String query = "select * from registration1_2019;";
	            pst = conn.prepareStatement(query);
	            rs= pst.executeQuery();
	            
	        while (rs.next()) {
	        	fw.append(rs.getString(1));
	        	fw.append(',');
	        		fw.append(rs.getString(2));
	        		fw.append(',');
	        			fw.append(rs.getString(3));
	        			fw.append(',');
	        				fw.append(rs.getString(4));
	        				fw.append(',');
	        					fw.append(rs.getString(5));
	        					fw.append(',');
	        						fw.append(rs.getString(6));
	        						fw.append(',');
	        							fw.append(rs.getString(7));
	        							fw.append(',');
	        						fw.append(rs.getString(8));
	        						fw.append(',');
	        					fw.append(rs.getString(9));
	        					fw.append(',');
	        				fw.append(rs.getString(10));
	        				fw.append(',');
	        			fw.append(rs.getString(11));
	        			fw.append(',');
	        		fw.append(rs.getString(12));
	        		fw.append(',');
	        	fw.append(rs.getString(13));
	        	fw.append(',');
	        		fw.append(rs.getString(14));
	        		fw.append(',');
	        			fw.append(rs.getString(15));
	        			fw.append(',');
	        				fw.append(rs.getString(16));
	        				fw.append(',');
	        					fw.append(rs.getString(17));
	        					fw.append(',');
	        				fw.append(rs.getString(18));
	        				fw.append(',');
	        			fw.append(rs.getString(19));
	        			fw.append(',');
	        		fw.append(rs.getString(20));
	        		fw.append('\n');
	        }
	        fw.flush();
	        fw.close();
	        
	        
	        Alert alert = new Alert(AlertType.INFORMATION);
			 alert.setTitle("Information Dialog");
			 alert.setHeaderText(null);
			 alert.setContentText("Successfully Generate File!");

			 alert.showAndWait();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.print("[ERROR:CREATING CSV FILE]");
		}
		
		
	}
	
	 public void changeSceneToDetailedRegistrationView(ActionEvent event) throws IOException
	    {
		 
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(getClass().getResource("Details.fxml"));
		        Parent tableViewParent = loader.load();
		        
		        Scene tableViewScene = new Scene(tableViewParent);
		        
		        //access the controller and call a method
		        detailsController controller = loader.getController();
		        controller.initData(tableReg.getSelectionModel().getSelectedItem());
		        
		        //This line gets the Stage information
		        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		        
		        window.setScene(tableViewScene);
		        window.show();
		    
	        
	    
	    }
	   
	    
	 
	 
	
	public void  Exit(ActionEvent evt)  {
		
		System.exit(0);
		
	}
	
	
	
	
}
