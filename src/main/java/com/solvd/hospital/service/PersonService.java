package com.solvd.hospital.service;

import com.solvd.hospital.departament.Hospital;
import com.solvd.hospital.exception.AgeException;
import com.solvd.hospital.exception.FirstNameException;
import com.solvd.hospital.exception.LastNameException;
import com.solvd.hospital.model.Patient;
import com.solvd.hospital.model.Person;
import com.solvd.hospital.specialty.Specialist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class PersonService {
    Scanner scanner = new Scanner(System.in);
    static Logger logger = LogManager.getLogger(Hospital.class);

    public ArrayList<Patient> hospitalPatients = new ArrayList<>();
    public HashSet<Specialist> hospitalSpecialists = new HashSet<>();

    public PersonService(ArrayList<Patient> hospitalPatients, HashSet<Specialist> hospitalSpecialists) {
        this.hospitalPatients = hospitalPatients;
        this.hospitalSpecialists = hospitalSpecialists;
    }

    public Patient selectPatientFromConsole(){
        System.out.println("Please select patient from list:");
        for(int n = 0; n < hospitalPatients.size(); n++) {
            System.out.println(n + " - " + hospitalPatients.get(n).getFullContactByString());
        }

        boolean isSelected = false;
        while (!isSelected) {
            System.out.println("Select number:");
            int menuNumber = 0;
            try {
                menuNumber = Integer.parseInt(scanner.nextLine());
                isSelected = true;
                return hospitalPatients.get(menuNumber);
            } catch (Exception e) {
                isSelected = false;
                System.out.println("Incorrect Menu number!");
                logger.error("Incorrect Menu number!" + e);
            }
        }
        return null;
    }

    public Specialist selectSpecialistFromConsole(){
        List<Specialist> listSpecialists = new ArrayList<>(hospitalSpecialists);
        System.out.println("Please select specialist from list:");
        int i = 0;
        for(int n = 0; n < listSpecialists.size(); n++) {
            System.out.println(n + " - " + listSpecialists.get(n).getFullContactByString());
        }

        boolean isSelected = false;
        while (!isSelected) {
            System.out.println("Select number:");
            int menuNumber = 0;
            try {
                menuNumber = Integer.parseInt(scanner.nextLine());
                isSelected = true;
                return listSpecialists.get(menuNumber);
            } catch (Exception e) {
                isSelected = false;
                System.out.println("Incorrect Menu number!");
                logger.error("Incorrect Menu number!" + e);
            }
        }
        return null;
    }

    public Patient createPatientFromConsole() throws FirstNameException, LastNameException {
        logger.info("Start reading from console: ");

        Patient consolePatient = new Patient();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter patients first name");
        consolePatient.setFirstName(scanner.nextLine());
        System.out.println("Enter patients last name");
        consolePatient.setLastName(scanner.nextLine());
        System.out.println("Enter age");
        try {
            consolePatient.setAge(Integer.parseInt(scanner.nextLine()));
        } catch (AgeException e) {
            System.out.println("Incorrect Age!");
            logger.error(e);
        }
        System.out.println("Enter date of registration");
        consolePatient.setDateOfRegistration(scanner.nextLine());

        return consolePatient;
    }

    public Person getPersonByLogin(String login){
        for(Person person : hospitalPatients){
            if (person.getLogin().equals(login)){
                return person;
            }
        }
        for(Person person : hospitalSpecialists){
            if (person.getLogin().equals(login)){
                return person;
            }

        }
        return null;
    }

    public boolean checkLogin(String login){
        for(Person person : hospitalPatients){
            if (person.getLogin().equals(login)){
                return true;
            }
        }
        for(Person person : hospitalSpecialists){
            if (person.getLogin().equals(login)){
                return true;
            }

        }
        return false;
    }

    public boolean authorization(String login, String password){
        for(Person person : hospitalPatients){
            if (person.getLogin().equals(login)){
                if (person.getPassword().equals(password))
                    return true;
            }
        }
        for(Person person : hospitalSpecialists){
            if (person.getLogin().equals(login)){
                if (person.getPassword().equals(password))
                    return true;
            }
        }
        return false;
    }
}
