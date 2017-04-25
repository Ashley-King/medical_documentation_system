package edu.tridenttech.king.finalProject.model;

import java.util.Date;

public interface Note
{
    public void getPatient();
    public String getDateTime();
    public void writeDateToFile(Date date);
    public void writeToFile();
    public void getUnits();
    public void getProcedure();
    public void getNote();
    
}//end interface Note
