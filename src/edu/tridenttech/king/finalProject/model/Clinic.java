package edu.tridenttech.king.finalProject.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import edu.tridenttech.king.finalProject.model.Patient.PatientType;



public class Clinic
{
    private static Clinic instance = new Clinic();

    private ArrayList<Patient> patients = new ArrayList<>();
    private static final String FILEPATH = "/Users/ashleyking/Documents/eclipse_workspace/Final_Project_King/Files/";
    
    
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
            String patientId = fields[2];
            PatientType type = null;
            switch (fields[3].charAt(0))
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
            
            String tName = fields[4];
            String mDate = fields[5];
            createNewPatient(patientName, dob, patientId, type, tName, mDate);
        }//end while()
    }//end loadPatients
    
    public boolean createNewPatient(String patientName, String dob, String id, PatientType type, 
            String teacherName, String meetingDate)
    {
        if(type == Patient.PatientType.EarlyIntervention)
        {
            EIPatient newPatient = new EIPatient(patientName, dob, id, teacherName,
                    meetingDate);
            try
            {
                createPatientFile(newPatient);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
           
            return patients.add(newPatient);
        }
        else
        {
            SchoolAgePatient newPatient = new SchoolAgePatient(patientName, dob, id,
                    teacherName, meetingDate);
            try
            {
                createPatientFile(newPatient);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return patients.add(newPatient);          
        }
        
        
    }//end createNewPatient
    public void createPatientFile(Patient newPatient) throws IOException
    {
        String fileName = newPatient.getName() + " - " + newPatient.getPatientId();
        File newFile = new File(FILEPATH + fileName);
        if(!newFile.exists())
        {
            newFile.createNewFile();
        }
    }
    
    public void printPatientList()
    {
        System.out.println("******* PATIENT LIST *******");
        for(int i = 0; i < patients.size(); i++)
        {
            System.out.println("Name: " + patients.get(i).getName() + 
                    " DOB: " + patients.get(i).getDateOfBirth() + "\n");
        }
    }//end printPatientList()
    public Patient findPatientById(String id)
    {
        Patient patient = null;
        Optional<Patient> match = patients.stream().filter(e -> e.getPatientId().equals(id)).findFirst();
        if (match.isPresent()) {
            patient = match.get();
        }
        return patient;
    }//end findPatientById()


}//end class Clinic
