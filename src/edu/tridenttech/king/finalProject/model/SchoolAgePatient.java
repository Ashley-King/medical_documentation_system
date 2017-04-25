package edu.tridenttech.king.finalProject.model;

public class SchoolAgePatient extends Patient
{
    private String teacherName;
    private String IEPDate;
    
    public SchoolAgePatient(String name, String dob, String teacherName,
            String date)
    {
        super(name, dob, Patient.PatientType.SchoolAge);
        this.teacherName = teacherName;
        this.IEPDate = date;
        
    }//end EIPatient()
    
    public String getTeacherName()
    {
        return this.teacherName;
    }//end getTeacherName()
    
    public void setTeacherName(String name)
    {
        this.teacherName = name;
    }//end setTeacherName()
    
    public String getIEPDate()
    {
        return this.IEPDate;
    }//end getIEPDate()
    
    public void setIEPDate(String date)
    {
        this.IEPDate = date;
    }//end setIEPDate()
      
}//end class SchoolAgePatient
