package edu.tridenttech.king.finalProject.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProgressNote implements Note
{
    private int units;
    private Date date;
    private int procedure;
    private String note;
    @Override
    public String getDateTime()
    {
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); 
        return dateFormat.format(date);
    }

    @Override
    public void writeDateToFile(Date date)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void writeToFile()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getUnits()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getProcedure()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getNote()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void getPatient()
    {
        // TODO Auto-generated method stub
        
    }

}//end class ProgressNote
