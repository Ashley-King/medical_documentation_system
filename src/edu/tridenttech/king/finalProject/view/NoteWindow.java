package edu.tridenttech.king.finalProject.view;

import java.awt.event.ActionListener;
import java.util.EventListener;

import edu.tridenttech.king.finalProject.model.Clinic;
import edu.tridenttech.king.finalProject.model.Patient;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
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


    /**
     * Instantiates a new patient creation window.
     *
     * @param stage the stage
     */
    public NoteWindow(Stage stage)
    {
        //create grid, scene, stage, buttons
        myStage = stage;
        myStage.setTitle("Enter A Note");
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
        TextField goal = new TextField();
        Text recText = new Text("Enter Your Therapy Recommendations:");
        TextField rec = new TextField();
        Text dailyText = new Text("Enter A Daily Treatment Note:");
        TextField daily = new TextField();

        RadioButton progressBtn = new RadioButton("Progress Note");
        RadioButton dailyBtn = new RadioButton("Daily Note");
        //daily is initially selected
        dailyBtn.setSelected(true);

        //set button width
        createBtn.setPrefWidth(175);
        cancelBtn.setPrefWidth(175);

        //set toggle group
        ToggleGroup group = new ToggleGroup();
        progressBtn.setToggleGroup(group);
        dailyBtn.setToggleGroup(group);
        
        dailyBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                goal.setDisable(false);
                rec.setDisable(false);
                daily.setDisable(true);   
            }//end handle()
        });//end dailyBtn.setOnAction
        progressBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                goal.setDisable(true);
                rec.setDisable(true);
                daily.setDisable(false);   
            }//end handle()
        });//end progressBtn.setOnAction

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
//        createBtn.setOnAction(new EventHandler<ActionEvent>()
//        {
//            @Override
//            public void handle(ActionEvent e)
//            {
//
//                if(!eiBtn.isSelected() && !saBtn.isSelected())
//                {
//                    Alert alert = new Alert(AlertType.ERROR);
//                    alert.setTitle("Patient Creation Error");
//                    alert.setContentText("Please Choose A Patient Type.");
//                    alert.showAndWait();
//                }
//                else if(ptName.getText().equals("") || bdate.getText().equals("")
//                        || idNum.getText().equals("")  || tName.getText().equals("")
//                        || meeting.getText().equals(""))
//                {
//                    Alert alert = new Alert(AlertType.ERROR);
//                    alert.setTitle("Patient Creation Error");
//                    alert.setContentText("Please Enter All "
//                            + "Required Patient Information");
//                    alert.showAndWait();
//                }
//                else
//                {
//                    if(eiBtn.isSelected())
//                    {
//                        Clinic clinic = Clinic.getInstance();
//                        int id = Integer.parseInt(idNum.getText());
//                        boolean success = clinic.createNewPatient(ptName.getText(), 
//                                bdate.getText(), id, Patient.PatientType.EarlyIntervention,
//                                tName.getText(), meeting.getText());
//                        if(!success)
//                        {
//                            Alert alert = new Alert(AlertType.ERROR);
//                            alert.setTitle("Patient Creation Error");
//                            alert.setContentText("Patient could not be created.");
//                            alert.showAndWait();
//                        }//end if not successful 
//                        myStage.close();
//                    }
//                    else 
//                    {
//
//                        Clinic clinic = Clinic.getInstance();
//                        int id = Integer.parseInt(idNum.getText());
//                        boolean success = clinic.createNewPatient(ptName.getText(), 
//                                bdate.getText(), id, Patient.PatientType.SchoolAge,
//                                tName.getText(), meeting.getText());
//                        if(!success)
//                        {
//                            Alert alert = new Alert(AlertType.ERROR);
//                            alert.setTitle("Patient Creation Error");
//                            alert.setContentText("Patient could not be created.");
//                            alert.showAndWait();
//                        }//end if not successful
//                        myStage.close();
//                    }//end create checking account
//                    RecordAccessWindow.updatePatients();
//                }//end create account
//            }//end handle()
//        });//end createBtn setOnAction()

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