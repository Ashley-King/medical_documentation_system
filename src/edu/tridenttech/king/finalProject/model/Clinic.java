package edu.tridenttech.king.finalProject.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import edu.tridenttech.king.finalProject.model.Patient.PatientType;



public class Clinic
{
    private static Clinic instance = new Clinic();

    private ArrayList<Patient> patients = new ArrayList<>();
    
    
    public static Clinic getInstance()
    {
        return instance;
    }//end getInstance()
    
    public void loadPatients(String filePath) throws FileNotFoundException
    {
        Scanner input;
        input = new Scanner(new File(filePath));
        while(input.hasNext())
        {
            String line = input.nextLine();
            // creates an string array called fields and populates each item
            // splitting by comma.
            String[] fields = line.split(",");
            String patientName = fields[0];
            String dob = fields[1];
            PatientType type = null;
            switch (fields[2].charAt(0))
            {
                case 'E':
                case 'e':
                {
                    type = Patient.PatientType.EarlyIntervention;
                }
                break;
                case 'S':
                case 's':
                {
                    type = Patient.PatientType.SchoolAge;
                }
                break;
                default:
                {
                    System.out.println("Does not meet requirements");
                }        
            }//end switch
            
            String tName = fields[3];
            String mDate = fields[4];
            createNewPatient(patientName, dob, type, tName, mDate);
        }//end while()
    }//end loadPatients
    
    public boolean createNewPatient(String patientName, String dob, PatientType type, 
            String teacherName, String meetingDate)
    {
        if(type == Patient.PatientType.EarlyIntervention)
        {
            EIPatient newPatient = new EIPatient(patientName, dob, teacherName,
                    meetingDate);
            return patients.add(newPatient);
        }
        else
        {
            SchoolAgePatient newPatient = new SchoolAgePatient(patientName, dob,
                    teacherName, meetingDate);
            return patients.add(newPatient);          
        }
        
        
    }//end createNewPatient
    
    public void printPatientList()
    {
        System.out.println("******* PATIENT LIST *******");
        for(int i = 0; i < patients.size(); i++)
        {
            System.out.println("Name: " + patients.get(i).getName() + 
                    " DOB: " + patients.get(i).getDateOfBirth() + "\n");
        }
    }//end printPatientList()


}//end class Clinic
