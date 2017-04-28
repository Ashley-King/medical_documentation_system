/*
 * Singleton Clinic holds a list of all patients associated with the clinic.
 * @author: Ashley King
 */
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

/**
 * The Class Clinic.
 */
public class Clinic 
{
    
    /** The clinic instance. */
    private static Clinic instance = new Clinic();

    /** The patients. */
    private ArrayList<Patient> patients = new ArrayList<>();
    
    /** MUST CHANGE THIS FOR FULL FUNCTIONALITY OF PROGRAM **/
    /** The Constant FILEPATH. */
    public static final String FILEPATH = "/Users/ashleyking/Documents/eclipse_workspace/Final_Project_King/Files/";

    /**
     * Gets the single instance of Clinic.
     *
     * @return single instance of Clinic
     */
    public static Clinic getInstance()
    {
        return instance;
    }//end getInstance()

    /**
     * Load patients.
     *
     * @param filePath the file path
     * @throws FileNotFoundException the file not found exception
     */
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
            int numPatientId = Integer.parseInt(patientId);
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
            createNewPatient(patientName, dob, numPatientId, type, tName, mDate);
        }//end while()
        input.close();
    }//end loadPatients

    /**
     * Creates the new patient.
     *
     * @param patientName the patient name
     * @param dob the date of birth
     * @param id the patient id
     * @param type the patient type
     * @param teacherName the teacher's/early interventionist's name
     * @param meetingDate the meeting date
     * @return true, if successful
     */
    public boolean createNewPatient(String patientName, String dob, int id, PatientType type, 
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
    
    /**
     * Creates the patient file.
     *
     * @param newPatient the new patient
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void createPatientFile(Patient newPatient) throws IOException
    {
        int fileId = newPatient.getPatientId();
        String fileName = newPatient.getName();
        File newFile = new File(FILEPATH + fileName + "_" + fileId + ".txt");
        if(!newFile.exists())
        {
            newFile.createNewFile();
        }
    }

    /**
     * Prints the patient list.
     */
    public void printPatientList()
    {
        System.out.println("******* PATIENT LIST *******");
        for(int i = 0; i < patients.size(); i++)
        {
            System.out.println("Name: " + patients.get(i).getName() + 
                    " DOB: " + patients.get(i).getDateOfBirth() + "\n");
        }
    }//end printPatientList()
    
    /**
     * Find patient by id.
     *
     * @param id the id
     * @return the patient
     */
    public Patient findPatientById(int id)
    {
        Patient patient = null;
        Optional<Patient> match = patients.stream().filter(e -> e.getPatientId() == id).findFirst();
        if (match.isPresent()) {
            patient = match.get();
        }
        return patient;
    }//end findPatientById()

    /**
     * Gets the all patient id numbers.
     *
     * @return the all patient id numbers
     */
    public List<Integer> getAllPatientIdNumbers()
    {
        ArrayList<Integer> patientIdNumbers = new ArrayList<>();
        patients.stream().forEach(e -> patientIdNumbers.add(e.getPatientId()));
        //sort id numbers in ascending order
        Collections.sort(patientIdNumbers);
        return patientIdNumbers;
    }//end getAllPatientIdNumbers()


}//end class Clinic
