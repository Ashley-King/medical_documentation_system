package edu.tridenttech.king.finalProject.model;

public class EIPatient extends Patient
{
    private String eiName;
    private String IFSPDate;
    
    public EIPatient(String name, String dob, String eiName,
            String date)
    {
        super(name, dob, Patient.PatientType.EarlyIntervention);
        this.eiName = eiName;
        this.IFSPDate = date;
        
    }//end EIPatient()
    
    public String getEIName()
    {
        return this.eiName;
    }//end getEIName()
    
    public void setEIName(String name)
    {
        this.eiName = name;
    }//end setEIName()
    
    public String getIFSPDate()
    {
        return this.IFSPDate;
    }//end getIFSPDate()
    
    public void setIFSPDate(String date)
    {
        this.IFSPDate = date;
    }//end setIFSPDate()
    
    

}//end class EIPatient
