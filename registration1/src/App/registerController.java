package App;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Optional;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



public class registerController implements Initializable {
	PreparedStatement pst = null;
	ResultSet rs = null;
	int ps ;
	//implements Initializable
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

	
    private DBConnection dc;
    
    
    
	  @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        // TODO
        dc = new DBConnection();
     
    	cbBranch.getItems().add("Caloocan Branch");
    	cbBranch.getItems().addAll("Taft Avenue Branch","West Avenue Branch","Fairview Branch");
    	cbBranch.setVisibleRowCount(3);
    	cbBranch.setEditable(true);
    	cbBranch.setPromptText("Choose Branch");
     
	    }

	  LocalDate TransDate;
	  LocalDate Received;
	  LocalDate Released;  

	String IDNumber,EngineNumber,ChasisNumber,
	  Color,CompanyName,OR,SINumber,Sticker,Surname,Firstname,
	  Middlename,FileNumber,PlateNumber,Branch,MotoModel,
	  Note,Status;

	
	
	
public void clear(ActionEvent event)throws Exception {
		
		try {
	        	tfEngineNumber.setText("");
	              tfChasisNumber.setText("");
	                tfColor.setText("");
	                	tfCompanyName.setText("");
	                		tfOR.setText("");
	                			tfSurname.setText("");
	                				tfFirstname.setText("");
	                					tfMiddlename.setText("");
	                				tfSINumber.setText("");
	                			tfSticker.setText("");
	                		tfFileNumber.setText("");
	                	tfPlateNumber.setText("");
	                cbBranch.setPromptText("");
	               tfMotoModel.setText("");
	            taNote.setText("");
	           tfStatus.setText("");
	           	
	           
	           // Pwede din gumamit ng .clear() method
	           		dpTransDate.setValue(null);
	           	    dpReceived.setValue(null);
	           		dpReleased.setValue(null);
 
			}catch(Exception ex) {
			System.err.println("Error"+ex);
			System.out.println("Nxt");
									
			
			}
		
	}

	public void Edit(ActionEvent event)throws Exception {
		
		try {
			tfIDNumber.setEditable(true);
			tfEngineNumber.setEditable(false);
				tfChasisNumber.setEditable(false);
				tfColor.setEditable(true);
				tfCompanyName.setEditable(true);
				tfOR.setEditable(true);
				tfSurname.setEditable(true);
				tfFirstname.setEditable(true);
				tfMiddlename.setEditable(true);
				tfSINumber.setEditable(true);
				tfSticker.setEditable(true);
				tfFileNumber.setEditable(true);
				tfPlateNumber.setEditable(true);
				cbBranch.setEditable(true);
				tfMotoModel.setEditable(true);
				taNote.setEditable(true);
				tfStatus.setEditable(true);
				dpTransDate.setEditable(true);
				dpReceived.setEditable(true);
				dpReleased.setEditable(true);		
		}catch(Exception ex) {
			System.err.println("Error"+ex);
			
			
		}
	}
	
	
public void Back(ActionEvent event)throws Exception {
		
	
	
	Parent tableViewParent = FXMLLoader.load(getClass().getResource("main.fxml"));
    Scene tableViewScene = new Scene(tableViewParent);
    
    //This line gets the Stage information
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    
    window.setScene(tableViewScene);
    window.show();
    
    System.out .println("Working!~");
    
		
	}
	

	
	public void Delete(ActionEvent event)throws Exception {
		
		try {
			 Connection conn = dc.Connect(); 
			
			 	
				
		        
		        Alert alert = new Alert(AlertType.CONFIRMATION);
		    	alert.setTitle("Confirmation Dialog");
		    	alert.setHeaderText("The Data wont be Recover!");
		    	alert.setContentText("Delete Selected Data?");
		        

		    	Optional<ButtonType> result = alert.showAndWait();
		    	if (result.get() == ButtonType.OK){
		    		String query = "DELETE FROM `registration1_2019` WHERE (`id` ="+IDNumber+");";
			        pst = conn.prepareStatement(query);
			        ps= pst.executeUpdate();
			        System.out.println("Deleted");
			        
			        
			        Alert alert1 = new Alert(AlertType.INFORMATION);
			        alert1.setTitle("Information Dialog");
			        alert1.setHeaderText(null);
			        alert1.setContentText("Deleted!");

			        alert1.showAndWait();
		    	} else {
		    		System.out.println("Cancelled");
		    	}

		}catch(SQLException ex) {
			System.err.println("Error"+ex);
			System.out.println("Not Deleted");
			
			 Alert alert1 = new Alert(AlertType.INFORMATION);
		        alert1.setTitle("Information Dialog");
		        alert1.setHeaderText(null);
		        alert1.setContentText("eRRor Deleting");

		        alert1.showAndWait();
		}
	}
	
public void Save(ActionEvent event)throws Exception {
		
		try {
			 Connection conn = dc.Connect();
			 
				String query = "UPDATE `registration1_2019` SET `Color` ='"+Color+"' , `Company_Name` = '"+CompanyName+"',`&/or` = '"+OR+"', `SURNAME` ='"+Surname+"',`FIRSTNAME` = '"+Firstname+"', `MIDDLENAME` = '"+Middlename+"',`SI_No` ='"
						+SINumber+"',`File_No` = '"+FileNumber+"',`Note` = '" +Note+"', `Status` = '"+Status+"', `Plate_No` = '"+PlateNumber+"', `Sticker` = '"+Sticker+"', `Date_Released` = '"+Released+"',`Date_Received` = '"+Received+"', `Date` = '"+TransDate+"', `Branch` = '"+Branch+"', `MotoModel` = '"+MotoModel+
						"'WHERE (`id` = '"+IDNumber+"') and (`Engine_No` = '"+EngineNumber+"') and (`Chasis_No` = '"+ChasisNumber+"');";

				pst = conn.prepareStatement(query);
		        ps= pst.executeUpdate();
		        System.out.println("Saved");
		        
		        Alert alert = new Alert(AlertType.INFORMATION);
				 alert.setTitle("Information Dialog");
				 alert.setHeaderText(null);
				 alert.setContentText("Data Saved!");

				 alert.showAndWait();

		}catch(SQLException ex) {
			System.err.println("Error"+ex);
			System.out.println("Error Saving");
			
			
			Alert alert = new Alert(AlertType.INFORMATION);
			 alert.setTitle("Information Dialog");
			 alert.setHeaderText(null);
			 alert.setContentText("Error Saving");

			 alert.showAndWait();
		}
	}

	public void Next(ActionEvent event)throws Exception {
		
		try {
			 Connection conn = dc.Connect(); 
			
		
			 IDNumber = tfIDNumber.getText();
			 int num = Integer.parseInt(IDNumber);
			 int nxt = num+1;
			 String nxtS= String.valueOf(nxt);
			 
			 
			String query = "Select `Engine_No`,`Chasis_No`,`color`,`Company_Name`,`&/or`,`SURNAME`,`FIRSTNAME`,`MIDDLENAME`,`SI_NO`,`File_No`,`Note`,`Status`,`Plate_No`,`Sticker`,`Date_Released`, `Date_Received`,`Date`,`Branch`,`MotoModel` from registration1_2019 where id ="+nxtS+"";
	        pst = conn.prepareStatement(query);
	        rs= pst.executeQuery();
	        
	        

	        
	        if(rs.next())
	        	//tfIDNumber.setText(rs.getString("id"));
	        	tfEngineNumber.setText(rs.getString("Engine_No"));
	              tfChasisNumber.setText(rs.getString("Chasis_No"));
	                tfColor.setText(rs.getString("Color"));
	                	tfCompanyName.setText(rs.getString("Company_Name"));
	                		tfOR.setText(rs.getString("&/or"));
	                			tfSurname.setText(rs.getString("SURNAME"));
	                				tfFirstname.setText(rs.getString("FIRSTNAME"));
	                					tfMiddlename.setText(rs.getString("MIDDLENAME"));
	                				tfSINumber.setText(rs.getString("SI_NO"));
	                			tfSticker.setText(rs.getString("Sticker"));
	                		tfFileNumber.setText(rs.getString("File_No"));
	                	tfPlateNumber.setText(rs.getString("Plate_No"));
	                cbBranch.setPromptText(rs.getString("Branch"));
	               tfMotoModel.setText(rs.getString("MotoModel"));
	            taNote.setText(rs.getString("Note"));
	           tfStatus.setText(rs.getString("Status"));
	           	java.sql.Date DatePrompt = rs.getDate("Date");
	           		dpTransDate.setValue(DatePrompt.toLocalDate());
	           			java.sql.Date DateReceivedPrompt = rs.getDate("Date_Received");
	           			dpReceived.setValue(DateReceivedPrompt.toLocalDate());
	           				java.sql.Date DateReleasedPrompt = rs.getDate("Date_Released");
	           					dpReleased.setValue(DateReleasedPrompt.toLocalDate());
 
			}catch(SQLException ex) {
			System.err.println("Error"+ex);
			System.out.println("Nxt");
									
			
			}
		
	}
	
	public void Previous(ActionEvent event)throws Exception {
		
		try {
			 Connection conn = dc.Connect(); 
			 IDNumber = tfIDNumber.getText();
			 int num = Integer.parseInt(IDNumber);
			 int prev = num-1;
			 //Conversion of Int to String
			 String prevS= String.valueOf(prev);
			 
			String query = "Select `Engine_No`,`Chasis_No`,`color`,`Company_Name`,`&/or`,`SURNAME`,`FIRSTNAME`,`MIDDLENAME`,`SI_NO`,`File_No`,`Note`,`Status`,`Plate_No`,`Sticker`,`Date_Released`, `Date_Received`,`Date`,`Branch`,`MotoModel` from registration1_2019 where id ="+prevS+"";
	        pst = conn.prepareStatement(query);
	        rs= pst.executeQuery();
	        	        
	        System.out.print(prevS);
	        if(rs.next())
	       
	        	tfEngineNumber.setText(rs.getString("Engine_No"));
	              tfChasisNumber.setText(rs.getString("Chasis_No"));
	                tfColor.setText(rs.getString("Color"));
	                	tfCompanyName.setText(rs.getString("Company_Name"));
	                		tfOR.setText(rs.getString("&/or"));
	                			tfSurname.setText(rs.getString("SURNAME"));
	                				tfFirstname.setText(rs.getString("FIRSTNAME"));
	                					tfMiddlename.setText(rs.getString("MIDDLENAME"));
	                				tfSINumber.setText(rs.getString("SI_NO"));
	                			tfSticker.setText(rs.getString("Sticker"));
	                		tfFileNumber.setText(rs.getString("File_No"));
	                	tfPlateNumber.setText(rs.getString("Plate_No"));
	                cbBranch.setPromptText(rs.getString("Branch"));
	               tfMotoModel.setText(rs.getString("MotoModel"));
	            taNote.setText(rs.getString("Note"));
	           tfStatus.setText(rs.getString("Status"));
	           	java.sql.Date DatePrompt = rs.getDate("Date");
	           		dpTransDate.setValue(DatePrompt.toLocalDate());
	           			java.sql.Date DateReceivedPrompt = rs.getDate("Date_Received");
	           			dpReceived.setValue(DateReceivedPrompt.toLocalDate());
	           				java.sql.Date DateReleasedPrompt = rs.getDate("Date_Released");
	           					dpReleased.setValue(DateReleasedPrompt.toLocalDate());

		}catch( SQLException ex) {
			System.err.println("Error"+ex);
			System.out.println("Prev");
									
			
			}
	}
	 
	
	
	
	public void search(ActionEvent event) throws Exception{
		try {
		 Connection conn = dc.Connect(); 
		
	
		 IDNumber = tfIDNumber.getText();
		 
		String query = "Select `Engine_No`,`Chasis_No`,`color`,`Company_Name`,`&/or`,`SURNAME`,`FIRSTNAME`,`MIDDLENAME`,`SI_NO`,`File_No`,`Note`,`Status`,`Plate_No`,`Sticker`,`Date_Released`, `Date_Received`,`Date`,`Branch`,`MotoModel` from registration1_2019 where id ="+IDNumber+"";
        pst = conn.prepareStatement(query);
        rs= pst.executeQuery();
        
        

        
        if(rs.next())
        	tfEngineNumber.setText(rs.getString("Engine_No"));
              tfChasisNumber.setText(rs.getString("Chasis_No"));
                tfColor.setText(rs.getString("Color"));
                	tfCompanyName.setText(rs.getString("Company_Name"));
                		tfOR.setText(rs.getString("&/or"));
                			tfSurname.setText(rs.getString("SURNAME"));
                				tfFirstname.setText(rs.getString("FIRSTNAME"));
                					tfMiddlename.setText(rs.getString("MIDDLENAME"));
                				tfSINumber.setText(rs.getString("SI_NO"));
                			tfSticker.setText(rs.getString("Sticker"));
                		tfFileNumber.setText(rs.getString("File_No"));
                	tfPlateNumber.setText(rs.getString("Plate_No"));
                cbBranch.setPromptText(rs.getString("Branch"));
               tfMotoModel.setText(rs.getString("MotoModel"));
            taNote.setText(rs.getString("Note"));
           tfStatus.setText(rs.getString("Status"));
           	java.sql.Date DatePrompt = rs.getDate("Date");
           		dpTransDate.setValue(DatePrompt.toLocalDate());
           			java.sql.Date DateReceivedPrompt = rs.getDate("Date_Received");
           			dpReceived.setValue(DateReceivedPrompt.toLocalDate());
           				java.sql.Date DateReleasedPrompt = rs.getDate("Date_Released");
           					dpReleased.setValue(DateReleasedPrompt.toLocalDate());
           					
           					
           					//disable the editing when it is in search mode
           					
           					tfEngineNumber.setEditable(false);
           					tfChasisNumber.setEditable(false);
           					tfColor.setEditable(false);
           					tfCompanyName.setEditable(false);
           					tfOR.setEditable(false);
           					tfSurname.setEditable(false);
           					tfFirstname.setEditable(false);
           					tfMiddlename.setEditable(false);
           					tfSINumber.setEditable(false);
           					tfSticker.setEditable(false);
           					tfFileNumber.setEditable(false);
           					tfPlateNumber.setEditable(false);
           					cbBranch.setEditable(false);
           					tfMotoModel.setEditable(false);
           					taNote.setEditable(false);
           					tfStatus.setEditable(false);
           					dpTransDate.setEditable(false);
           					dpReceived.setEditable(false);
           					dpReleased.setEditable(false);
           					
           					
           					
           					
           					
           					
           					
      
		}catch(SQLException ex) {
		System.err.println("Error"+ex);
		 Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle("Information Dialog");
		 alert.setHeaderText(null);
		 alert.setContentText("Search Error!");

		 alert.showAndWait();
	
								
		
		}
	}
	
	
	
	
	public void  Add(ActionEvent event) throws Exception  {
       
		try {

        	Status = tfStatus.getText();
        	IDNumber = tfIDNumber.getText();
        	TransDate = dpTransDate.getValue();
        	EngineNumber=tfEngineNumber.getText();
        	ChasisNumber = tfChasisNumber.getText();
       	    Color = tfColor.getText();
       	    CompanyName= tfCompanyName.getText();
      	    OR = tfOR.getText();
       	    SINumber = tfSINumber.getText();
       	    Sticker =  tfSticker.getText();
       	    Surname = tfSurname.getText();
       	    Firstname = tfFirstname.getText();
       	    Middlename = tfMiddlename.getText();
       	    FileNumber = tfFileNumber.getText();
       	    PlateNumber = tfPlateNumber.getText();
       	    Branch = cbBranch.getValue().toString();
      	    MotoModel = tfMotoModel.getText();
      	    Received = dpReceived.getValue();      
      	    Released = dpReleased.getValue();
      	    Note = taNote.getText();

      	    //db query
            Connection conn = dc.Connect();      

            String query = "INSERT INTO `registration1_2019` (`id`, `Engine_No`, `Chasis_No`, `Color`, `Company_Name`, `&/or`, `SURNAME`, `FIRSTNAME`, `MIDDLENAME`, `SI_No`, `File_No`, `Note`, `Status`, `Plate_No`, `Sticker`, `Date_Released`, `Date_Received`, `Date`,`Branch`,`MotoModel`) VALUES ('"+IDNumber+"', '"+EngineNumber+"', '"+ChasisNumber+"', '"+Color+"', '"+CompanyName+"', '"+OR+"', '"+Surname+"', '"+Firstname+"', '"+Middlename+"', '"+SINumber+"', '"+FileNumber+"', '"+Note+"', '"+Status+"', '"+PlateNumber+"', '"+Sticker+"', '"+Released+"', '"+Received+"', '"+TransDate+"','"+Branch+"','"+MotoModel+"');" ;
            pst = conn.prepareStatement(query);
            ps= pst.executeUpdate();

            System.out.print(TransDate);
            Alert alert = new Alert(AlertType.INFORMATION);
			 alert.setTitle("Information Dialog");
			 alert.setHeaderText(null);
			 alert.setContentText("Successfully Added");
			 alert.showAndWait();

        } catch (SQLException ex) {
            System.err.println("Error"+ex);
            
             Alert alert = new Alert(AlertType.INFORMATION);
			 alert.setTitle("Information Dialog");
			 alert.setHeaderText(null);
			 alert.setContentText("Failed to add!");

			 alert.showAndWait();
        }
		
	}

	
}
