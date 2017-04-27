package edu.tridenttech.king.finalProject.view;

import java.awt.event.ActionListener;
import java.util.EventListener;

import edu.tridenttech.king.finalProject.model.Clinic;
import edu.tridenttech.king.finalProject.model.DailyNote;
import edu.tridenttech.king.finalProject.model.Patient;
import edu.tridenttech.king.finalProject.model.ProgressNote;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NoteWindow
{

    /** The my stage. */
    private Stage myStage;

    private Patient myPatient;


    /**
     * Instantiates a new patient creation window.
     *
     * @param stage the stage
     */
    public NoteWindow(Stage stage, Patient patient)
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
        Button createBtn = new Button("Create Note");
        Button cancelBtn = new Button("Cancel");

        Text title = new Text("Choose A Note Type:");
        Text procedureText = new Text("Enter The Procedure Code:");
        TextField procedure = new TextField();
        Text unitsText = new Text("Enter The Number Of Units:");
        TextField units = new TextField();
        Text goalText = new Text("Enter A New Therapy Goal:");
        TextArea goal = new TextArea();
        Text recText = new Text("Enter Your Therapy Recommendations:");
        TextArea rec = new TextArea();
        Text dailyText = new Text("Enter A Daily Treatment Note:");
        TextArea daily = new TextArea();
        //allow wrapping
        goal.setWrapText(true);
        rec.setWrapText(true);
        daily.setWrapText(true);

        RadioButton progressBtn = new RadioButton("Progress Note");
        RadioButton dailyBtn = new RadioButton("Daily Note");
        //daily is initially selected


        //set button width
        createBtn.setPrefWidth(175);
        cancelBtn.setPrefWidth(175);

        //set toggle group
        ToggleGroup group = new ToggleGroup();
        progressBtn.setToggleGroup(group);
        dailyBtn.setToggleGroup(group);
        //set up initial radio button state
        dailyBtn.setSelected(true);
        goal.setDisable(true);
        rec.setDisable(true);
        daily.setDisable(false); 



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
        pane.add(progressBtn, 0, 1);
        pane.add(dailyBtn, 0, 2);
        pane.add(procedureText, 0, 3);
        pane.add(procedure, 1, 3);
        pane.add(unitsText, 0, 5);
        pane.add(units, 1, 5);
        pane.add(goalText, 0, 7);
        pane.add(goal, 1, 7);
        pane.add(recText, 0, 9);
        pane.add(rec, 1, 9);
        pane.add(dailyText, 0, 11);
        pane.add(daily, 1, 11);
        pane.add(createBtn, 0, 13);
        pane.add(cancelBtn, 1, 13);

        //actions

        //actions for when radio buttons
        dailyBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                goal.setDisable(true);
                rec.setDisable(true);
                daily.setDisable(false);   
            }//end handle()
        });//end dailyBtn.setOnAction

        progressBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                goal.setDisable(false);
                rec.setDisable(false);
                daily.setDisable(true);   
            }//end handle()
        });//end progressBtn.setOnAction


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
                if(units.getText().equals("") || procedure.getText().equals(""))          
                {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Note Entry Error");
                    alert.setContentText("Please Enter Number of Units "
                            + "And The Procedure Code");
                    alert.showAndWait();
                }
                else
                {
                    if(progressBtn.isSelected())
                    {
                        if(goal.getText().equals("") || rec.getText().equals(""))
                        {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Note Entry Error");
                            alert.setContentText("Please Enter A Goal And "
                                    + "Your Current Therapy Recommendations.");
                            alert.showAndWait();
                        }
                        int ptId = myPatient.getPatientId();
                        int un = Integer.parseInt(units.getText());
                        int pro = Integer.parseInt(procedure.getText());
                        ProgressNote newPN = new ProgressNote(ptId, un,
                                pro, goal.getText(), rec.getText());
                        newPN.writeNoteToFile();
                        myStage.close();
                    }
                    else 
                    {

                        if(daily.getText().equals("") )
                        {
                            Alert alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Note Entry Error");
                            alert.setContentText("Please Enter A Daily "
                                    + "Treatment Note.");
                            alert.showAndWait();
                        }
                        int ptId = myPatient.getPatientId();
                        int un = Integer.parseInt(units.getText());
                        int pro = Integer.parseInt(procedure.getText());
                        DailyNote newDN = new DailyNote(ptId, un,
                                pro, daily.getText());
                        newDN.writeNoteToFile();
                        
                        myStage.close();
                    }
                    RecordAccessWindow.updatePatients();
                }//end create note
            }//end handle()
        });//end createBtn setOnAction()

    }//end NoteWindow()


    /**
     * Show
     * 
     * Shows Patient Creation Window.
     */
    public void show()
    {
        myStage.show();
    }

}//end class NoteWindow