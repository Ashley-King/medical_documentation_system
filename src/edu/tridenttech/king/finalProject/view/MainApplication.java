package edu.tridenttech.king.finalProject.view;

import java.io.FileNotFoundException;

import edu.tridenttech.king.finalProject.model.Clinic;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Clinic theClinic = Clinic.getInstance();
        theClinic.loadPatients("PatientList.csv");
        

        //Application.launch(args);

    }//end main

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // TODO Auto-generated method stub
        
    }
}
