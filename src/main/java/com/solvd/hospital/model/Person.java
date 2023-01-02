package com.solvd.hospital.model;

import com.solvd.hospital.Main;
import com.solvd.hospital.exception.AgeException;
import com.solvd.hospital.exception.FirstNameException;
import com.solvd.hospital.exception.LastNameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws FirstNameException {
        if (firstName.length() > 20) {
            throw new FirstNameException("Max length of the name is 20 symbols!");
        } else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws LastNameException {
        if (lastName.length() > 20) {
            throw new LastNameException("Max length of the name is 20 symbols!");
        } else {
            this.lastName = lastName;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeException {
        if (age < 0 || age > 100) {
            throw new AgeException("Wrong patient age. Write age in a 0 - 100 range");
        } else {
            this.age = age;
        }
    }
}

