/*
 * DailyNote enables the creation of a daily treatment note for each therapy
 * visit for a patient.
 * @author: Ashley King
 */
package edu.tridenttech.king.finalProject.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class DailyNote.
 */
public class DailyNote implements Note
{
    
    /** The number of units. */
    private int units;
    
    /** The date. */
    private String date;
    
    /** The procedure code. */
    private int procedure;
    
    /** The daily note string. */
    private String dailyNote;
    
    /** The patient. */
    private Patient patient;
    
    /** The patient id. */
    private int id;

    /** The clinic. */
    Clinic clinic = Clinic.getInstance();
    
    /**
     * Instantiates a new daily note.
     *
     * @param id the patient id
     * @param units the number of units
     * @param proc the procedure
     * @param daily the daily note string
     */
    public DailyNote(int id, int units, int proc, String daily)
    {
        this.id = id;
        this.units = units;
        this.procedure = proc;
        this.dailyNote = daily;
        this.date = getDateTime();
        this.patient = getPatient();
    }//end ProgressNote()
    
    /* (non-Javadoc)
     * @see edu.tridenttech.king.finalProject.model.Note#getPatient()
     */
    @Override
    public Patient getPatient()
    {
        Patient thisPatient = clinic.findPatientById(this.id);
        return thisPatient; 
    }//end getPatient()

    /* (non-Javadoc)
     * @see edu.tridenttech.king.finalProject.model.Note#getDateTime()
     */
    @Override
    public String getDateTime()
    {
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }//end getDateTime()

    /* (non-Javadoc)
     * @see edu.tridenttech.king.finalProject.model.Note#writeNoteToFile()
     */
    @Override
    public void writeNoteToFile()
    {
        BufferedWriter bw = null;
        FileWriter fw = null;
        int ptId = this.id;
        String ptName = this.patient.getName();
        File file = new File(Clinic.FILEPATH + ptName + " - " + ptId);
        try
        {
            fw = new FileWriter(file.getAbsoluteFile(), true);
        } 
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        bw = new BufferedWriter(fw);
        try
        {
            bw.write("*** BEGIN DAILY TREATMENT NOTE ***\n\n");
            bw.write("*** DATE/TIME ***\n");
            bw.write(this.date + "\n\n");
            bw.write("Units: " + this.units + "\n"
                    + "Procedure: " + this.procedure + "\n\n");
            bw.write("*** DAILY NOTE ***\n");
            bw.write(this.dailyNote + "\n\n");
            bw.write("*** END OF DAILY TREATMENT NOTE ***\n\n"); 
            bw.write("--------------------------------------\n\n");
        } 
        catch (IOException e)
        {

            e.printStackTrace();
        }
        finally 
        {
            try 
            {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();
            } 
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
        }

    }//end writeNoteToFile()

}//end class DailyNote
