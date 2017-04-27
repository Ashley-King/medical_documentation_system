/*
 * Creates a type of patient: the early intervention patient.
 * The early intervention patient is between 0 and 3 years old.
 * @author: Ashley King
 */
package edu.tridenttech.king.finalProject.model;

/**
 * The Class EIPatient.
 */
public class EIPatient extends Patient
{
    
    /** The name of the early interventionist (case manager). */
    private String eiName;
    
    /** The IFSP (individualized family support plan) meeting date. */
    private String IFSPDate;

    /**
     * Instantiates a new EI patient.
     *
     * @param name the name
     * @param dob the dob
     * @param id the id
     * @param eiName the ei name
     * @param date the date
     */
    public EIPatient(String name, String dob, int id, String eiName,
            String date)
    {
        super(name, dob, id, Patient.PatientType.EarlyIntervention);
        this.eiName = eiName;
        this.IFSPDate = date;

    }//end EIPatient()

    /**
     * Gets the EI name.
     *
     * @return the EI name
     */
    public String getEIName()
    {
        return this.eiName;
    }//end getEIName()

    /**
     * Sets the EI name.
     *
     * @param name the new EI name
     */
    public void setEIName(String name)
    {
        this.eiName = name;
    }//end setEIName()

    /**
     * Gets the IFSP date.
     *
     * @return the IFSP date
     */
    public String getIFSPDate()
    {
        return this.IFSPDate;
    }//end getIFSPDate()

    /**
     * Sets the IFSP date.
     *
     * @param date the new IFSP date
     */
    public void setIFSPDate(String date)
    {
        this.IFSPDate = date;
    }//end setIFSPDate()



}//end class EIPatient
