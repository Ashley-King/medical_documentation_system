/*
 * NewPatientWindow allows the creation of a new patient and the patient's
 * initial file.
 * @author: Ashley King
 */
package edu.tridenttech.king.finalProject.view;

import edu.tridenttech.king.finalProject.model.Clinic;
import edu.tridenttech.king.finalProject.model.Patient;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * The Class NewPatientWindow.
 */
public class NewPatientWindow
{

    /** The my stage. */
    private Stage myStage;


    /**
     * Instantiates a new patient creation window.
     *
     * @param stage the stage
     */
    public NewPatientWindow(Stage stage)
    {
        //create grid, scene, stage, buttons
        myStage = stage;
        myStage.setTitle("ADD A NEW PATIENT");
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        myStage.setScene(scene);
        Button createBtn = new Button("Add New Patient");
        Button cancelBtn = new Button("Cancel");
        Text title = new Text("Choose A Patient Type:");
        Text ptNameText = new Text("Enter Patient's Name:");
        TextField ptName = new TextField();
        Text bdateText = new Text("Enter Birthdate:");
        TextField bdate = new TextField();
        Text idNumText = new Text("Enter 6-digit ID Number:");
        TextField idNum = new TextField();
        Text tNameText = new Text("Enter Name of teacher/EI:");
        TextField tName = new TextField();
        Text meetingText = new Text("Enter Meeting Date:");
        TextField meeting = new TextField();

        RadioButton eiBtn = new RadioButton("Early Intervention");
        RadioButton saBtn = new RadioButton("School Age");

        //set button width
        createBtn.setPrefWidth(175);
        cancelBtn.setPrefWidth(175);

        //set toggle group
        ToggleGroup group = new ToggleGroup();
        eiBtn.setToggleGroup(group);
        saBtn.setToggleGroup(group);

        //Setting size for the pane  
        pane.setMinSize(500, 200); 

        //Setting the padding  
        pane.setPadding(new Insets(10, 10, 10, 10)); 

        //Setting the vertical and horizontal gaps between the columns 
        pane.setVgap(5); 
        pane.setHgap(5);       

        //Setting the Grid alignment 

        pane.setAlignment(Pos.CENTER); 
        pane.add(title, 0,0, 4, 1);
        pane.add(eiBtn, 0, 1);
        pane.add(saBtn, 0, 2);
        pane.add(ptNameText, 0, 3);
        pane.add(ptName, 1, 3);
        pane.add(bdateText, 0, 5);
        pane.add(bdate, 1, 5);
        pane.add(idNumText, 0, 7);
        pane.add(idNum, 1, 7);
        pane.add(tNameText, 0, 9);
        pane.add(tName, 1, 9);
        pane.add(meetingText, 0, 11);
        pane.add(meeting, 1, 11);
        pane.add(createBtn, 0, 13);
        pane.add(cancelBtn, 1, 13);

        //actions

        //cancelBtn action
        cancelBtn.setOnAction(new EventHandler<ActionEvent>() 
        {

            @Override
            public void handle(ActionEvent e) 
            {
                myStage.close();
            }//end handle()
        }); // end cancelBtn setOnAction

        //createBtn action
        createBtn.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e)
            {

                if(!eiBtn.isSelected() && !saBtn.isSelected())
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Patient Creation Error");
                    alert.setContentText("Please Choose A Patient Type.");
                    alert.showAndWait();
                }
                else if(ptName.getText().equals("") || bdate.getText().equals("")
                        || idNum.getText().equals("")  || tName.getText().equals("")
                        || meeting.getText().equals(""))
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Patient Creation Error");
                    alert.setContentText("Please Enter All "
                            + "Required Patient Information");
                    alert.showAndWait();
                }
                else
                {
                    if(eiBtn.isSelected())
                    {
                        Clinic clinic = Clinic.getInstance();
                        int id = Integer.parseInt(idNum.getText());
                        boolean success = clinic.createNewPatient(ptName.getText(), 
                                bdate.getText(), id, Patient.PatientType.EarlyIntervention,
                                tName.getText(), meeting.getText());
                        if(!success)
                        {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Patient Creation Error");
                            alert.setContentText("Patient could not be created.");
                            alert.showAndWait();
                        }//end if not successful 
                        myStage.close();
                    }
                    else 
                    {

                        Clinic clinic = Clinic.getInstance();
                        int id = Integer.parseInt(idNum.getText());
                        boolean success = clinic.createNewPatient(ptName.getText(), 
                                bdate.getText(), id, Patient.PatientType.SchoolAge,
                                tName.getText(), meeting.getText());
                        if(!success)
                        {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Patient Creation Error");
                            alert.setContentText("Patient could not be created.");
                            alert.showAndWait();
                        }//end if not successful
                        myStage.close();
                    }//end create checking account
                    RecordAccessWindow.updatePatients();
                }//end create patient
            }//end handle()
        });//end createBtn setOnAction()

    }//end NewPatientWindow()


    /**
     * Show
     * 
     * Shows Patient Creation Window.
     */
    public void show()
    {
        myStage.show();
    }

}//end class NewPatientWindow

