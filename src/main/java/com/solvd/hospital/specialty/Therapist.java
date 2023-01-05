package com.solvd.hospital.specialty;

import com.solvd.hospital.exception.AgeException;
import com.solvd.hospital.exception.FirstNameException;
import com.solvd.hospital.exception.LastNameException;

public class Therapist extends Specialist implements IMetting {
    public Therapist(String firstName, String lastName, int age, int salary, int yearsOfExperience, String login, String password) throws LastNameException, FirstNameException, AgeException {
        super(firstName, lastName, age, salary, yearsOfExperience, login, password);
    }

    @Override
    public String toString(){
        return "Speciality: Therapist Name: " + this.getFullName() + " Age: " + this.getAge() + " Salary: " + this.getSalary() + " Years of experience: " + this.getYearsOfExperience();
    }
    @Override
    public final void assembleMeeting () {
        System.out.println("Meeting created.");
    }

    @Override
    public final void addSpecialist () {
        System.out.println ("The specialist added to the meeting.");
    }

    @Override
    public final void addPatient () {
        System.out.println("The patient added to the meeting.");
    }
}
