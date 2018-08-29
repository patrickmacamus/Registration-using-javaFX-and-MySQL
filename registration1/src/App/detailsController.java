package App;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class detailsController implements Initializable {
	
	
		private regDetails selectedReg;
	
	 
	    
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
	    
	
	   public void initData(regDetails RegDetails)
	    {
		   try {
		  
		        selectedReg = RegDetails;
		        dID.setText(selectedReg.getID());
		        dDate.setPromptText(selectedReg.getDate().toString());
		        dReleased.setPromptText(selectedReg.getDateReleased().toString());
		        dReceived.setPromptText(selectedReg.getDateReceived().toString());
		        dEngine.setText(selectedReg.getEngineNo());
		        dChasis.setText(selectedReg.getChasisNo());
		        dColor.setText(selectedReg.getColor());
		        dCompany.setText(selectedReg.getCompanyName());
		        dOR.setText(selectedReg.getOR());
		        dSI.setText(selectedReg.getSiNo());
		        dSticker.setText(selectedReg.getSticker());
		        dSurname.setText(selectedReg.getSurname());
		        dFirstname.setText(selectedReg.getFirstname());
		        dMiddlename.setText(selectedReg.getMiddlename());
		        dFileNo.setText(selectedReg.getFileNo());
		        dPlateNo.setText(selectedReg.getPlateNo());
		        dBranch.setPromptText(selectedReg.getBranch());
		        dMoto.setText(selectedReg.getMotoModel());
		        dNote.setText(selectedReg.getNote());
		        dStatus.setText(selectedReg.getStatus());
		        
dBranch.setEditable(false);
dID.setEditable(false);
dMoto.setEditable(false);
dEngine.setEditable(false);
dChasis.setEditable(false);
dColor.setEditable(false);
dDate.setEditable(false);
dReceived.setEditable(false);
dReleased.setEditable(false);
dCompany.setEditable(false);
dOR.setEditable(false);
dSI.setEditable(false);
dSticker.setEditable(false);
dSurname.setEditable(false);
dFirstname.setEditable(false);
dMiddlename.setEditable(false);
dFileNo.setEditable(false);
dStatus.setEditable(false);
dPlateNo.setEditable(false);
dNote.setEditable(false);



		   }catch(Exception e) {
			   Alert alert = new Alert(AlertType.INFORMATION);
				 alert.setTitle("Information Dialog");
				 alert.setHeaderText(null);
				 alert.setContentText("Select Item!");

				 alert.showAndWait();
		   }

	    }
	   
	   public void changeScreenButtonPushed(ActionEvent event) throws IOException
	    {
	        Parent tableViewParent = FXMLLoader.load(getClass().getResource("main.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(tableViewScene);
	        window.show();
	        
	        
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
