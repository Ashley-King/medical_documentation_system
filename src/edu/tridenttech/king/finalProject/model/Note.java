package edu.tridenttech.king.finalProject.model;


public interface Note
{
    public Patient getPatient();
    public String getDateTime();
    public void writeNoteToFile();
    
}//end interface Note
