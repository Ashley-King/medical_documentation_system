package edu.tridenttech.king.finalProject.model;

import java.util.Comparator;



public class Patient implements Comparator<Patient>
{
    static public enum PatientType { EarlyIntervention, SchoolAge };
    private String name;
    private String dob;
    private PatientType type;
    private int id;
    
    public  Patient(String name, String dob, int id, PatientType type) 
    {
        this.name = name;
        this.dob = dob;
        this.type = type;
        this.id = id;
    }//end Patient()
        
    public String getName()
    {
        return this.name;
    }//end getName()
    
    public void setName(String name)
    {
        this.name = name;
    }//end setName()
    
    public String getDateOfBirth()
    {
        return this.dob;
    }//end getDateOfBirth()
    public PatientType getPatientType()
    {
        return this.type;
    }//end getPatientType()
    public int getPatientId()
    {
        return this.id;
    }//end getPatientId()
    
    public void setPatientId(int id)
    {
        this.id = id;
    }//end setPatientId()

    @Override
    public int compare(Patient patient1, Patient patient2)
    {
        return Integer.compare(patient1.getPatientId(), patient2.getPatientId());
    }

    
    
}//end class Patient
