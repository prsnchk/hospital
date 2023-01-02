package com.solvd.hospital.specialty;

import com.solvd.hospital.exception.AgeException;
import com.solvd.hospital.exception.FirstNameException;
import com.solvd.hospital.exception.LastNameException;

public class Surgeon extends Specialist implements IMetting {

    public Surgeon(String firstName, String lastName, int age, int salary, int yearsOfExperience) throws LastNameException, FirstNameException, AgeException {
        super(firstName, lastName, age, salary, yearsOfExperience);
    }

    @Override
    public String toString(){
        return "Speciality: Surgeon Name: " + this.getFullName() + " Age: " + this.getAge() + " Salary: " + this.getSalary() + " Years of experience: " + this.getYearsOfExperience();
    }
    @Override
    public void assembleMeeting () {
        System.out.println("Meeting created.");
    }

    @Override
    public void addSpecialist () {
        System.out.println ("The specialist added to the meeting.");
    }

    @Override
    public void addPatient () {
        System.out.println("The patient added to the meeting.");
    }
}