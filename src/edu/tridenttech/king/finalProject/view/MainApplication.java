package edu.tridenttech.king.finalProject.view;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.tridenttech.king.finalProject.model.Clinic;
import edu.tridenttech.king.finalProject.model.Patient;
import edu.tridenttech.king.finalProject.model.ProgressNote;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Clinic theClinic = Clinic.getInstance();
        theClinic.loadPatients("PatientList.csv");
      Scanner input = new Scanner(System.in).useDelimiter("\\n");;
      System.out.println("Enter 6-digit patient ID number: \n");
      String id = input.next();
      System.out.println("Enter procedure code for this visit: \n");
      int procedure = input.nextInt();
      
      System.out.println("Enter number of units for this visit: \n");
      int units = input.nextInt();
      System.out.println("Enter new therapy goal: \n");
      String goal = input.next();
      System.out.println("Enter your current therapy recommendations: \n");
      String recommendation = input.next();
      
      input.close();
      ProgressNote newPN = new ProgressNote(id, units, procedure, goal, recommendation);
      newPN.writeNoteToFile();
        //Application.launch(args);

    }//end main()

//    @Override
//    public void start(Stage primaryStage) throws Exception
//    {
//        // TODO Auto-generated method stub
//        
//    }//end start()
}//end class MainApplication
