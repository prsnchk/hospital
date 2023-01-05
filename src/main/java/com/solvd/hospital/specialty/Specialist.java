package com.solvd.hospital.specialty;

import com.solvd.hospital.exception.AgeException;
import com.solvd.hospital.exception.FirstNameException;
import com.solvd.hospital.exception.LastNameException;
import com.solvd.hospital.model.IContact;
import com.solvd.hospital.exception.SalaryException;
import com.solvd.hospital.model.Patient;
import com.solvd.hospital.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Specialist extends Person implements IContact {

    Logger logger = LogManager.getLogger(Specialist.class);
    private int salary;
    private int yearsOfExperience;

    public Specialist(String firstName, String lastName, int age, int salary, int yearsOfExperience, String login, String password) throws FirstNameException, LastNameException, AgeException {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
        this.setPassword(password);
        this.setLogin(login);
        logger.info("Specialist created: " + this.toString());
    }

    public String getFullName(){
        return getFirstName() + " " + getLastName();
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) throws SalaryException{
        if (salary <= 0) {
            throw new SalaryException("Salary cant be negative");
        } else {
            this.salary = salary;
        }
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Specialist)) return false;
        Specialist that = (Specialist) o;
        if (getSalary() != that.getSalary()) return false;
        return getYearsOfExperience() == that.getYearsOfExperience();
    }

    @Override
    public int hashCode() {
        int result = getSalary();
        result = 31 * result + getYearsOfExperience();
        return result;
    }

    @Override
    public String toString(){
        return "Name: " + this.getFullName() + " Age: " + this.getAge()+ " Salary: " + this.getSalary() + " Years of experience: " + this.getYearsOfExperience();
    }

    @Override
    public String getMainContactByString (){
        return this.getFirstName() + " " + this.getLastName()+ " " + this.getAge();
    }

    @Override
    public String getFullContactByString(){
        return this.getFirstName() + " " + this.getLastName()+ " " + this.getAge() + " " + this.getSalary() + " " + this.getYearsOfExperience();
    }

}


