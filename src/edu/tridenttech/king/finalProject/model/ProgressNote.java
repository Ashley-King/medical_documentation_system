package edu.tridenttech.king.finalProject.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProgressNote implements Note
{
    private int units;
    private String date;
    private int procedure;
    private String goal;
    private Patient patient;
    private String id;
    private String recommendation;
    
    Clinic clinic = Clinic.getInstance();
    public ProgressNote(String id, int units, int proc, String goal, String rec)
    {
        this.id = id;
        this.units = units;
        this.procedure = proc;
        this.goal = goal;
        this.recommendation = rec;
        this.date = getDateTime();
        this.patient = getPatient();
    }//end ProgressNote()
    @Override
    public String getDateTime()
    {
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }//end getDateTime();
    @Override
    public Patient getPatient()
    {
        Patient thisPatient = clinic.findPatientById(this.id);
        return thisPatient;    
    }//end getPatient()

    @Override
    public void writeNoteToFile()
    {
        BufferedWriter bw = null;
        FileWriter fw = null;
        String fileName = this.id;
        File file = new File(clinic.FILEPATH + fileName);
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
            bw.write("*** END OF PROGRESS NOTE ***\n\n"); 
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
