/*
 * Note interface is the interface implemented by all specialized documentation
 * note types.
 * @author: Ashley King
 */
package edu.tridenttech.king.finalProject.model;

/**
 * The Interface Note.
 */
public interface Note
{
    
    /**
     * Gets the patient.
     *
     * @return the patient
     */
    public Patient getPatient();
    
    /**
     * Gets the date time.
     *
     * @return the date time
     */
    public String getDateTime();
    
    /**
     * Write note to file.
     */
    public void writeNoteToFile();

}//end interface Note
