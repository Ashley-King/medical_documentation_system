/*
 * Progress Note enables creation of a new progress note that includes
 * a new goal for therapy.
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
 * The Class ProgressNote.
 */
public class ProgressNote implements Note
{
    
    /** The number of units. */
    private int units;
    
    /** The date. */
    private String date;
    
    /** The procedure code. */
    private int procedure;
    
    /** The goal. */
    private String goal;
    
    /** The patient. */
    private Patient patient;
    
    /** The patient id. */
    private int id;
    
    /** The recommendation. */
    private String recommendation;

    /** The clinic. */
    Clinic clinic = Clinic.getInstance();
    
    /**
     * Instantiates a new progress note.
     *
     * @param id the patient id
     * @param units the number of units
     * @param proc the procedure code
     * @param goal the goal
     * @param rec the therapy recommendations
     */
    public ProgressNote(int id, int units, int proc, String goal, String rec)
    {
        this.id = id;
        this.units = units;
        this.procedure = proc;
        this.goal = goal;
        this.recommendation = rec;
        this.date = getDateTime();
        this.patient = getPatient();
    }//end ProgressNote()
    
    /* (non-Javadoc)
     * @see edu.tridenttech.king.finalProject.model.Note#getDateTime()
     */
    @Override
    public String getDateTime()
    {
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }//end getDateTime();
    
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
            bw.write("*** BEGIN PROGRESS NOTE ***\n\n");
            bw.write("*** DATE/TIME ***\n");
            bw.write(this.date + "\n\n");
            bw.write("Units: " + this.units + "\n"
                    + "Procedure: " + this.procedure + "\n\n");
            bw.write("*** NEW GOAL ***\n");
            bw.write(this.goal + "\n\n");
            bw.write("*** THERAPY RECOMMENDATION ***\n");
            bw.write(this.recommendation + "\n\n");
            bw.write("*** END PROGRESS NOTE ***\n\n"); 
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

    }//end writeToFile()


}//end class ProgressNote
