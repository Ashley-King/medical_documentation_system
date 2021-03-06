/*
 * Record View Window displays the patient's therapy record.
 * @author: Ashley King
 */
package edu.tridenttech.king.finalProject.view;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.tridenttech.king.finalProject.model.Clinic;
import edu.tridenttech.king.finalProject.model.Patient;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The Class RecordViewWindow.
 */
public class RecordViewWindow 
{
    /** The my stage. */
    private Stage myStage;

    /** The my patient. */
    private Patient myPatient;


    /**
     * Instantiates a new Record View window.
     *
     * @param stage the stage
     * @param patient the patient
     */
    public RecordViewWindow(Stage stage, Patient patient)
    {
        //pass in patient
        this.myPatient = patient;
        //create grid, scene, stage, buttons
        myStage = stage;
        String patientName = this.myPatient.getName();
        int patientId =  this.myPatient.getPatientId();
        myStage.setTitle(patientName + " - " + patientId);
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        myStage.setScene(scene);

        Button cancelBtn = new Button("Quit");

        Text title = new Text("PATIENT THERAPY RECORD");

        TextArea note = new TextArea();
        note.setEditable(false);
        note.setWrapText(true);
        note.setPrefHeight(500);

        //set button width
        cancelBtn.setPrefWidth(150);

        //Setting size for the pane  
        pane.setMinSize(500, 600); 

        //Setting the padding  
        pane.setPadding(new Insets(10, 10, 10, 10)); 

        //Setting the vertical and horizontal gaps between the columns 
        pane.setVgap(5); 
        pane.setHgap(5);       

        //Setting the Grid alignment 

        pane.setAlignment(Pos.CENTER); 
        pane.add(title, 0,0, 4, 1);
        pane.add(note, 0, 1, 4, 6);
        pane.add(cancelBtn, 0, 10);

        //actions

        //read file and put in textArea
        String filePath = Clinic.FILEPATH;
        int ptId = this.myPatient.getPatientId();
        String ptName = this.myPatient.getName();
        String thisFile = filePath + ptName + "_" + ptId + ".txt"; 
        File newFile = new File(thisFile);
        Scanner fileInput;
        try
        {
            fileInput = new Scanner(newFile);
            while(fileInput.hasNextLine())
            {
                String nextLine = fileInput.nextLine();
                note.appendText(nextLine + "\n");
            }
            fileInput.close();
        } 
        catch (FileNotFoundException ex)
        {

            ex.printStackTrace();
        }


        //cancelBtn action
        cancelBtn.setOnAction(new EventHandler<ActionEvent>() 
        {

            @Override
            public void handle(ActionEvent e) 
            {
                myStage.close();
            }//end handle()
        }); // end cancelBtn setOnAction


    }//end RecordViewWindow()


    /**
     * Show
     * 
     * Shows Record View Window.
     */
    public void show()
    {

        myStage.show();
    }//end show()

}//end class RecordViewWindow
