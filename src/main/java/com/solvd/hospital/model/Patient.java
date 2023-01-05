package com.solvd.hospital.model;

import com.solvd.hospital.Main;
import com.solvd.hospital.disease.Disease;
import com.solvd.hospital.exception.AgeException;
import com.solvd.hospital.exception.FirstNameException;
import com.solvd.hospital.exception.LastNameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public final class Patient extends Person implements IContact {
    Logger logger = LogManager.getLogger(Patient.class);

    private String dateOfRegistration;

    public Patient(){}

    public Patient(String firstName, String lastName, int age, String dateOfRegistration, String login, String password) throws FirstNameException, LastNameException, AgeException {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setPassword(password);
        this.setLogin(login);
        this.dateOfRegistration = dateOfRegistration;
        logger.info("Patient created: " + this.toString());
    }



    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public void toCure(Disease disease) {
        System.out.println("Patient " + getFirstName() + " treatment of illness: " + disease.getClass().getSimpleName() + " by: " + disease.getMethodOfTreatment());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        if (getAge() != patient.getAge()) return false;
        if (getFirstName() != null ? !getFirstName().equals(patient.getFirstName()) : patient.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(patient.getLastName()) : patient.getLastName() != null)
            return false;
        return getDateOfRegistration() != null ? getDateOfRegistration().equals(patient.getDateOfRegistration()) : patient.getDateOfRegistration() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + dateOfRegistration.hashCode();
        return result;
    }

    @Override
    public String toString(){
        return "Login: " + this.getLogin() + " " + "Password: " + this.getHidePassword() + " " + "Name: " + this.getFirstName() + " " + this.getLastName()+ " Age: " + this.getAge() + " Date Of Registration: " + this.getDateOfRegistration();
    }

    @Override
    public String getMainContactByString (){
        return this.getFirstName() + " " + this.getLastName()+ " " + this.getAge();
    }

    @Override
    public String getFullContactByString(){
        return this.getFirstName() + " " + this.getLastName()+ " " + this.getAge() + " " + this.getDateOfRegistration();
    }


}


