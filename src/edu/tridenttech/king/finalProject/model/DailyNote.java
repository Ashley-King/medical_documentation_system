package edu.tridenttech.king.finalProject.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyNote implements Note
{
    private int units;
    private String date;
    private int procedure;
    private String dailyNote;
    private Patient patient;
    private int id;
    
    Clinic clinic = Clinic.getInstance();
    public DailyNote(int id, int units, int proc, String daily)
    {
        this.id = id;
        this.units = units;
        this.procedure = proc;
        this.dailyNote = daily;
        this.date = getDateTime();
        this.patient = getPatient();
    }//end ProgressNote()
    @Override
    public Patient getPatient()
    {
        Patient thisPatient = clinic.findPatientById(this.id);
        return thisPatient; 
    }//end getPatient()

    @Override
    public String getDateTime()
    {
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }//end getDateTime()

    @Override
    public void writeNoteToFile()
    {
        BufferedWriter bw = null;
        FileWriter fw = null;
        int fileName = this.id;
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
            bw.write("*** BEGIN DAILY TREATMENT NOTE ***\n\n");
            bw.write("*** DATE/TIME ***\n");
            bw.write(this.date + "\n\n");
            bw.write("Units: " + this.units + "\n"
                    + "Procedure: " + this.procedure + "\n\n");
            bw.write("*** DAILY NOTE ***\n");
            bw.write(this.dailyNote + "\n\n");
            bw.write("*** END OF DAILY TREATMENT NOTE ***\n\n"); 
            bw.write("********************\n\n");
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

}
