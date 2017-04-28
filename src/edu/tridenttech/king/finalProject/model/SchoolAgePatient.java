/*
 * The SchoolAgePatient is a type of patient.
 * School aged patients are 3 years and older.
 * @author: Ashley King
 */
package edu.tridenttech.king.finalProject.model;

/**
 * The Class SchoolAgePatient.
 */
public class SchoolAgePatient extends Patient
{
    /** The teacher name. */
    private String teacherName;
    
    /** The IEP (individualized education plan) meeting date. */
    private String IEPDate;

    /**
     * Instantiates a new school age patient.
     *
     * @param name the name
     * @param dob the date of birth
     * @param id the patient id
     * @param teacherName the teacher name
     * @param date the date
     */
    public SchoolAgePatient(String name, String dob, int id, String teacherName,
            String date)
    {
        super(name, dob, id, Patient.PatientType.SchoolAge);
        this.teacherName = teacherName;
        this.IEPDate = date;

    }//end SchoolAgePatient()

    /**
     * Gets the teacher name.
     *
     * @return the teacher name
     */
    public String getTeacherName()
    {
        return this.teacherName;
    }//end getTeacherName()

    /**
     * Sets the teacher name.
     *
     * @param name the new teacher name
     */
    public void setTeacherName(String name)
    {
        this.teacherName = name;
    }//end setTeacherName()

    /**
     * Gets the IEP date.
     *
     * @return the IEP date
     */
    public String getIEPDate()
    {
        return this.IEPDate;
    }//end getIEPDate()

    /**
     * Sets the IEP date.
     *
     * @param date the new IEP date
     */
    public void setIEPDate(String date)
    {
        this.IEPDate = date;
    }//end setIEPDate()

}//end class SchoolAgePatient
