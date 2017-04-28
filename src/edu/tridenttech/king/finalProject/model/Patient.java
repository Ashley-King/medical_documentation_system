/*
 * The Patient object
 * @author: Ashley King
 */
package edu.tridenttech.king.finalProject.model;

/**
 * The Class Patient.
 */
public class Patient 
{

    /**
     * The Enum PatientType.
     */
    static public enum PatientType 
    { 
        /** The Early intervention type. */
        EarlyIntervention, 
        
        /** The School age type . */
        SchoolAge 
    };

        /** The name. */
        private String name;

        /** The date of birth. */
        private String dob;

        /** The patient type. */
        private PatientType type;

        /** The patient id. */
        private int id;

        /**
         * Instantiates a new patient.
         *
         * @param name the name
         * @param dob the dob
         * @param id the id
         * @param type the type
         */
        public  Patient(String name, String dob, int id, PatientType type) 
        {
            this.name = name;
            this.dob = dob;
            this.type = type;
            this.id = id;
        }//end Patient()

        /**
         * Gets the name.
         *
         * @return the name
         */
        public String getName()
        {
            return this.name;
        }//end getName()

        /**
         * Sets the name.
         *
         * @param name the new name
         */
        public void setName(String name)
        {
            this.name = name;
        }//end setName()

        /**
         * Gets the date of birth.
         *
         * @return the date of birth
         */
        public String getDateOfBirth()
        {
            return this.dob;
        }//end getDateOfBirth()

        /**
         * Gets the patient type.
         *
         * @return the patient type
         */
        public PatientType getPatientType()
        {
            return this.type;
        }//end getPatientType()

        /**
         * Gets the patient id.
         *
         * @return the patient id
         */
        public int getPatientId()
        {
            return this.id;
        }//end getPatientId()

        /**
         * Sets the patient id.
         *
         * @param id the new patient id
         */
        public void setPatientId(int id)
        {
            this.id = id;
        }//end setPatientId()


}//end class Patient
