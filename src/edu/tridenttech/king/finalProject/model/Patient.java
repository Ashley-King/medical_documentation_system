package edu.tridenttech.king.finalProject.model;

public class Patient
{
    static public enum PatientType { EarlyIntervention, SchoolAge };
    private String name;
    private String dob;
    private PatientType type;
    
    public  Patient(String name, String dob, PatientType type)
    {
        this.name = name;
        this.dob = dob;
        this.type = type;
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
}//end class Patient
