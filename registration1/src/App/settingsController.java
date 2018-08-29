package App;

import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import Connection.DBConnection;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class settingsController implements Initializable {

	

    @FXML
    private TextField grFileName;

    @FXML
    private TextField grFilePath;

    @FXML
    private TextField fiFilePath;
    
    private DBConnection dc;

    PreparedStatement pst = null;
    PreparedStatement pst1 = null;
    PreparedStatement pst2 = null;
	ResultSet rs = null;
	int ps ;
	
	
	
	String genRefFN;
	String genRefFP;
	String fileImpFP;
	
	
	public void  Save(ActionEvent event) throws Exception  {

					try {
						  Connection conn = dc.Connect();
				            
						
						genRefFN=grFileName.getText();
						genRefFP=grFilePath.getText();
						fileImpFP=fiFilePath.getText();
						
	
						 String query = "INSERT INTO `registrationsettings` (`ReportDetails`,`ReportPath`,`FileImportPath`) VALUES ('"+genRefFN+"','"+genRefFP+"','"+fileImpFP+"');" ;          
				            
				            pst = conn.prepareStatement(query);
				            ps= pst.executeUpdate();
				            
				            Alert alert = new Alert(AlertType.INFORMATION);
							 alert.setTitle("Information Dialog");
							 alert.setHeaderText(null);
							 alert.setContentText("Successfully Saved");

							 alert.showAndWait();
				            
						}	catch(SQLException ex) {
							
							System.err.print("Error"+ex);
							Alert alert = new Alert(AlertType.INFORMATION);
							 alert.setTitle("Information Dialog");
							 alert.setHeaderText(null);
							 alert.setContentText("[eRROr]:"+ex);

							 alert.showAndWait();
							
	
												}
		
	}
	
	
	

	
	
	public void  importExcel(ActionEvent event) throws Exception  {

		try {
			
			
			   Connection conn = dc.Connect();
	            

	            conn.setAutoCommit(false);
	            PreparedStatement pstm = null;
	            FileInputStream input = new FileInputStream("C:/Users/Jason/Desktop/Registration Project/REGISTRATION 2014");
	            POIFSFileSystem fs = new POIFSFileSystem(input);
	            HSSFWorkbook wb = new HSSFWorkbook(fs);

	            HSSFSheet sheet = wb.getSheetAt(0);
	            Row row = null;
	           
	            
	           
				
	            
	            for (int i = 1; i <= sheet.getLastRowNum(); i++){

	            	//int id = (int) row.getCell(0).getNumericCellValue();
	                String Date = row.getCell(1).getStringCellValue();
	                String Model = row.getCell(1).getStringCellValue();
	                int Engine= (int) row.getCell(0).getNumericCellValue();
	                int Chasis= (int) row.getCell(0).getNumericCellValue();
	                int Color= (int) row.getCell(0).getNumericCellValue();
	                String Company = row.getCell(1).getStringCellValue();
	                String OR = row.getCell(1).getStringCellValue();
	            	String Surname = row.getCell(1).getStringCellValue();
	            	String Firstname = row.getCell(1).getStringCellValue();
	            	String Middlename = row.getCell(1).getStringCellValue();
	            	int SI= (int) row.getCell(0).getNumericCellValue();
	            	int FileNo= (int) row.getCell(0).getNumericCellValue();
	            	String Branch = row.getCell(1).getStringCellValue();
	            	String Note = row.getCell(1).getStringCellValue();
	            	String Status = row.getCell(1).getStringCellValue();
	            	int PlateNO= (int) row.getCell(0).getNumericCellValue();
	            	String Sticker = row.getCell(1).getStringCellValue();
	            	String Received= row.getCell(1).getStringCellValue();
	            	String Released= row.getCell(1).getStringCellValue();
	           
	            	
	            	System.out.println("Import rows "+i);
	            	
	            	 
	            	 String query = "INSERT INTO `registration1_2019` ( `Engine_No`, `Chasis_No`, `Color`, `Company_Name`, `&/or`, `SURNAME`, `FIRSTNAME`, `MIDDLENAME`, `SI_No`, `File_No`, `Note`, `Status`, `Plate_No`, `Sticker`, `Date_Released`, `Date_Received`, `Date`,`Branch`,`MotoModel`) VALUES ('"+Engine+"', '"+Chasis+"', '"+Color+"', '"+Company+"', '"+OR+"', '"+Surname+"', '"+Firstname+"', '"+Middlename+"', '"+SI+"', '"+FileNo+"', '"+Note+"', '"+Status+"', '"+PlateNO+"', '"+Sticker+"', '"+Released+"', '"+Received+"', '"+Date+"','"+Branch+"','"+Model+"');" ;
	                 
	 				pst = conn.prepareStatement(query);
	 				ps= pst.executeUpdate();
	              
	            }
	
	            Alert alert = new Alert(AlertType.INFORMATION);
				 alert.setTitle("Information Dialog");
				 alert.setHeaderText(null);
				 alert.setContentText("File Successfully Imported!");

				 alert.showAndWait();
	            

			
			
			}	catch(SQLException ex) {
				
				System.err.print("Error"+ex);
				
				 Alert alert = new Alert(AlertType.INFORMATION);
				 alert.setTitle("Information Dialog");
				 alert.setHeaderText(null);
				 alert.setContentText("[eRROr]:"+ex);

				 alert.showAndWait();
									}

}
	
	
	public void  DBSettingUp(ActionEvent event) throws Exception  {

		try {
			
			
			   Connection conn = dc.Connect();
	            

	            String query = "CREATE TABLE `registration1`.`registration1_2019` (`id` INT AUTO_INCREMENT ,`Engine_No` VARCHAR(45) , `Chasis_No` VARCHAR(45)  ,`Color` VARCHAR(45)  ,`Company_Name` VARCHAR(45)  , `&/or` VARCHAR(45)  ,`SURNAME` VARCHAR(45) NULL,`FIRSTNAME` VARCHAR(45)  , `MIDDLENAME` VARCHAR(45)  ,  `SI_No` INT  ,`File_No` INT  , `Note` VARCHAR(45)  ,`Status` VARCHAR(45)  ,`Plate_No` VARCHAR(45)  , `Sticker` VARCHAR(45)  , `Date_Released` DATE  ,`Date_Received` DATE  , `Date` DATE  , `Branch` VARCHAR(45)  ,`MotoModel` VARCHAR(45)  ,  PRIMARY KEY (`id`, `Engine_No`, `Chasis_No`));";
	           
	            String query1 = "CREATE TABLE `registration1`.`registrationSettings` (`ReportDetails` VARCHAR(45)  , `ReportPath` VARCHAR(45)  , `FileImportPath` VARCHAR(100)  )";            
	            
	            
	            pst = conn.prepareStatement(query);
	            pst1 = conn.prepareStatement(query1);
	            ps= pst.executeUpdate();
	            ps= pst1.executeUpdate();

	            Alert alert = new Alert(AlertType.INFORMATION);
				 alert.setTitle("Information Dialog");
				 alert.setHeaderText(null);
				 alert.setContentText("Successfully Created!");

				 alert.showAndWait();
	            

			
			
			}	catch(SQLException ex) {
				
				System.err.print("Error"+ex);
				
				 Alert alert = new Alert(AlertType.INFORMATION);
				 alert.setTitle("Information Dialog");
				 alert.setHeaderText(null);
				 alert.setContentText("[eRROr]:"+ex);

				 alert.showAndWait();
									}

}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	    dc = new DBConnection();
		
	}
	
}
