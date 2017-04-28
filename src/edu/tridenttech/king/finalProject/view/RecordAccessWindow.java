/*
 * RecordAccessWindow provides access to patient records and notes.
 * @author: Ashley King
 */
package edu.tridenttech.king.finalProject.view;

import java.util.List;
import edu.tridenttech.king.finalProject.model.Clinic;
import edu.tridenttech.king.finalProject.model.Patient;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * The Class RecordAccessWindow.
 */
public class RecordAccessWindow
{

    /** The my stage. */
    private Stage myStage;

    /** The patients. */
    protected static ComboBox<Integer> patients = new ComboBox<>();

    /**
     * Instantiates a new record entry window.
     *
     * @param stage the stage
     */
    public RecordAccessWindow(Stage stage)
    {
        //create grid, scene, stage, buttons
        myStage = stage;
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        Button newPatientBtn = new Button("Add New Patient");
        Button viewRecordBtn = new Button("View Patient Record");
        Button noteBtn = new Button("Enter Note");
        Button doneBtn = new Button("Quit");
        Text title = new Text("Choose A Patient By ID Number:");
        myStage.setTitle("PATIENT RECORD MENU");
        myStage.setScene(scene);

        //set button width
        newPatientBtn.setPrefWidth(330);
        viewRecordBtn.setPrefWidth(330);
        noteBtn.setPrefWidth(330);
        doneBtn.setPrefWidth(100);

        //patients
        patients.setMinWidth(330);
        patients.setVisibleRowCount(100);

        //Setting size for the pane  
        pane.setMaxSize(150, 150); 

        //Setting the padding  
        pane.setPadding(new Insets(10, 10, 10, 10)); 

        //Setting the vertical and horizontal gaps between the columns 
        pane.setVgap(5); 
        pane.setHgap(5);       

        //column constraints
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints();
        ColumnConstraints column4 = new ColumnConstraints();
        column1.setPercentWidth(25);
        column2.setPercentWidth(25);
        column3.setPercentWidth(25);
        column4.setPercentWidth(25);
        pane.getColumnConstraints().addAll( column1,column2,column3,
                column4);

        //Setting the Grid alignment 
        pane.setAlignment(Pos.CENTER); 
        pane.add(title, 0,0, 4, 1);
        pane.add(patients, 0, 1, 4, 1);
        pane.add(viewRecordBtn, 0,2, 4, 1);
        pane.add(newPatientBtn,0, 3, 4, 1);
        pane.add(noteBtn, 0, 4, 4, 1);
        pane.add(doneBtn, 0, 7);

        //actions

        //newPatientBtn action
        newPatientBtn.setOnAction(new EventHandler<ActionEvent>() {
            Stage newStage = new Stage();
            @Override
            public void handle(ActionEvent e) 
            {
                if(newStage.isShowing())
                {
                    newStage.toFront();
                }
                else
                {
                    //open NewPatientWindow
                    NewPatientWindow newPtWindow = new NewPatientWindow(newStage);
                    newPtWindow.show();
                }    
            }//end handle()
        }); // end newPatientBtn setOnAction   

        //noteBtn action
        noteBtn.setOnAction(new EventHandler<ActionEvent>() {
            Stage newStage = new Stage();
            @Override
            public void handle(ActionEvent e) 
            {
                Patient thisPatient;
                Clinic clinic = Clinic.getInstance();
                thisPatient = clinic.findPatientById(patients.getValue());
                if(newStage.isShowing())
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Record Error");
                    alert.setContentText("Please complete your original job"
                            + " before attempting a "
                            + " new job.");
                    alert.showAndWait();
                    newStage.toFront();
                }
                else
                {
                    //open NewPatientWindow
                    NoteWindow newNoteWindow = new NoteWindow(newStage, thisPatient );
                    newNoteWindow.show();
                } 
            }//end handle()
        }); // end noteBtn setOnAction 
        
        //viewRecordBtn action
        viewRecordBtn.setOnAction(new EventHandler<ActionEvent>() {
            Stage newStage = new Stage();
            @Override
            public void handle(ActionEvent e) 
            {
                Patient thisPatient;
                Clinic clinic = Clinic.getInstance();
                thisPatient = clinic.findPatientById(patients.getValue());
                if(newStage.isShowing())
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Record Error");
                    alert.setContentText("Please complete your original job"
                            + " before attempting a "
                            + " new job.");
                    alert.showAndWait();
                    newStage.toFront();
                }
                else
                {
                    //open RecordViewWindow
                    RecordViewWindow newRecord = new RecordViewWindow(newStage, thisPatient );
                    newRecord.show();
                } 

            }//end handle()
        }); // end noteBtn setOnAction 


        //doneBtn closes note entry window
        doneBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) 
            {

                myStage.close();

            }//end handle()

        }); // end doneBtn setOnAction

    }//end RecordAccessWindow()


    /**
     * Show.
     *Shows the record access window.
     * @param patientList the list of patient account numbers
     */
    public void show(List<Integer> patientList)
    {
        patients.getItems().setAll(patientList);
        patients.getSelectionModel().selectFirst();
        myStage.show();
    }//end show()

    /**
     * Update patients.
     * 
     * Updates patients with current id numbers from clinic.
     */
    public static void updatePatients()
    {
        Clinic clinic = Clinic.getInstance(); 
        patients.getItems().setAll(clinic.getAllPatientIdNumbers());
    }//end updatePatients()

}//end class RecordAccessWindow


