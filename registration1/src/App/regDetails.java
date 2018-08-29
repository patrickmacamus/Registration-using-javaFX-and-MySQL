package App;

import java.time.LocalDate;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;


public class regDetails {
	
	  	private final StringProperty id;
	    private final StringProperty EngineNo;
	    private final StringProperty ChasisNo;
	    private final StringProperty Color;
	    private final StringProperty CompanyName;
	    private final StringProperty OR;
	    private final StringProperty Surname;
	    private final StringProperty Firstname;
	    private final StringProperty Middlename;
	    private final StringProperty SiNo;
	    private final StringProperty FileNo;
	    private final StringProperty Note;
	    private final StringProperty Status;
	    private final StringProperty PlateNo;
	    private final StringProperty Sticker;
	    private final StringProperty DateReleased;
	    private final StringProperty DateReceived;
	    private final StringProperty Date;
	    private final StringProperty MotoModel;
	    private final StringProperty Branch;

	 
//Default constructor
	public regDetails (String id, String EngineNo, String ChasisNo,String Color,
	    				String CompanyName,String OR,String Surname,String Firstname,
	    					String Middlename,String SiNo,String FileNo,String Note,
	    						String Status,String PlateNo,String Sticker,String DateReleased,
	    							String DateReceived,String Date ,String MotoModel,String Branch) 
		{
		
		
	        this.id = new SimpleStringProperty(id);
	        this.EngineNo = new SimpleStringProperty(EngineNo);
	        this.ChasisNo = new SimpleStringProperty(ChasisNo);
	        this.Color = new SimpleStringProperty(Color);
	        this.CompanyName = new SimpleStringProperty(CompanyName);
	        this.OR = new SimpleStringProperty(OR);
	        this.Surname = new SimpleStringProperty(Surname);
	        this.Firstname = new SimpleStringProperty(Firstname);
	        this.Middlename = new SimpleStringProperty(Middlename);
	        this.SiNo = new SimpleStringProperty(SiNo);
	        this.FileNo = new SimpleStringProperty(FileNo);
	        this.Note = new SimpleStringProperty(Note);
	        this.Status = new SimpleStringProperty(Status);
	        this.PlateNo = new SimpleStringProperty(PlateNo);
	        this.Sticker = new SimpleStringProperty(Sticker);
	        this.DateReleased = new SimpleStringProperty(DateReleased);
	        this.DateReceived = new SimpleStringProperty(DateReceived);
	        this.Date = new SimpleStringProperty(Date);
	        this.MotoModel = new SimpleStringProperty(MotoModel);
	        this.Branch = new SimpleStringProperty(Branch);
	    }

   
	 //Getters
    public String getID() {
        return id.get();
    }
    public String getMotoModel() {
        return MotoModel.get();
    }
    public String getBranch() {
        return Branch.get();
    }
    public String getEngineNo() {
        return EngineNo.get();
    }
    public String getChasisNo() {
        return ChasisNo.get();
    }
    public String getColor() {
        return Color.get();
    }
    public String getCompanyName() {
        return CompanyName.get();
    }
    public String getOR() {
        return OR.get();
    }
    public String getSurname() {
        return Surname.get();
    }
    public String getFirstname() {
        return Firstname.get();
    }
    public String getMiddlename() {
        return Middlename.get();
    }
    public String getSiNo() {
        return SiNo.get();
    }
    public String getFileNo() {
        return FileNo.get();
    }
    public String getNote() {
        return Note.get();
    }
    public String getStatus() {
        return Status.get();
    }
    public String getPlateNo() {
        return PlateNo.get();
    }
    public String getSticker() {
        return Sticker.get();
    }
    public String getDateReleased() {
        return DateReleased.get();
    }
    public String getDateReceived() {
        return DateReceived.get();
    }
    public String getDate() {
        return Date.get();
    }
    
    //Setters
    public void setID(String value) {
        id.set(value);
    }
    public void setMotoModel(String value) {
        MotoModel.set(value);
    }
    public void setBranch(String value) {
        Branch.set(value);
    }
    public void setEngineNo(String value) {
    	EngineNo.set(value);
    }
    public void setChasisNo(String value) {
    	ChasisNo.set(value);
    }
    public void setColor(String value) {
    	Color.set(value);
    }
    public void setCompanyName(String value) {
    	CompanyName.set(value);
    }
    public void setOR(String value) {
    	OR.set(value);
    }
    public void setSurname(String value) {
    	Surname.set(value);
    }
    public void setFirstname(String value) {
    	Firstname.set(value);
    }
    public void setMiddlename(String value) {
    	Middlename.set(value);
    }
    public void setSiNo(String value) {
    	SiNo.set(value);
    }
    public void setFileNo(String value) {
    	FileNo.set(value);
    }
    public void setNote(String value) {
    	Note.set(value);
    }
    public void setStatus(String value) {
    	Status.set(value);
    }
    public void setPlateNo(String value) {
    	PlateNo.set(value);
    }
    public void setSticker(String value) {
    	Sticker.set(value);
    }
    public void setDateReleased(String value) {
    	DateReleased.set(value);
    }
    public void setDateReceived(String value) {
    	DateReceived.set(value);
    }
    public void setDate(String value) {
    	Date.set(value);
    }
    
    //Property values
    public StringProperty nameProperty() {
        return id;
    }
    public StringProperty MotoModelProperty() {
        return MotoModel;
    }
    public StringProperty BranchProperty() {
        return Branch;
    }
    public StringProperty EngineNoProperty() {
        return EngineNo;
    }
    public StringProperty ChasisNo() {
        return ChasisNo;
    }
    public StringProperty ColorProperty() {
        return Color;
    }
    public StringProperty CompanyNameProperty() {
        return CompanyName;
    }
    public StringProperty ORProperty() {
        return OR;
    }
    public StringProperty SurnameProperty() {
        return Surname;
    }
    public StringProperty FirstnameProperty() {
        return Firstname;
    }
    public StringProperty Middlename() {
        return Middlename;
    }
    public StringProperty SiNoProperty() {
        return SiNo;
    }
    public StringProperty FileNoProperty() {
        return FileNo;
    }
    public StringProperty NoteProperty() {
        return Note;
    }
    public StringProperty StatusProperty() {
        return Status;
    }
    public StringProperty PlateNoProperty() {
        return PlateNo;
    }
    public StringProperty StickerProperty() {
        return Sticker;
    }
    public StringProperty DateReleasedProperty() {
        return DateReleased;
    }
    public StringProperty DateReceivedProperty() {
        return DateReceived;
    }
    public StringProperty DateProperty() {
        return Date;
    }

    
    
    
	

}

