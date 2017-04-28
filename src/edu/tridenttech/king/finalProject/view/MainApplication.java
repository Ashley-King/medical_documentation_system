/*
 * @author: Ashley King
 */
package edu.tridenttech.king.finalProject.view;

import java.io.FileNotFoundException;
import java.util.Collections;
import edu.tridenttech.king.finalProject.model.Clinic;
import javafx.application.Application;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class MainApplication.
 */
public class MainApplication extends Application
{
    
    /**
     * The main method.
     *
     * @param args the arguments
     * @throws FileNotFoundException the file not found exception
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        //load patients from list and launch application
        Clinic theClinic = Clinic.getInstance();
        theClinic.loadPatients("PatientList.csv");
        Application.launch(args);
    }//end main()
    
    /* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //sort id numbers and open record access window
        Clinic clinic = Clinic.getInstance();
        Collections.sort(clinic.getAllPatientIdNumbers());
        new RecordAccessWindow(primaryStage).show(clinic.getAllPatientIdNumbers());

    }//end start()
}//end class MainApplication
