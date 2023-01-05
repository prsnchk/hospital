package com.solvd.hospital.service;

import com.solvd.hospital.Main;
import com.solvd.hospital.exception.AgeException;
import com.solvd.hospital.exception.FirstNameException;
import com.solvd.hospital.exception.LastNameException;
import com.solvd.hospital.model.Patient;
import com.solvd.hospital.model.Person;
import com.solvd.hospital.specialty.Neurologist;
import com.solvd.hospital.specialty.Specialist;
import com.solvd.hospital.specialty.Surgeon;
import com.solvd.hospital.specialty.Therapist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

public class SpecialistService {
    Logger logger = LogManager.getLogger(SpecialistService.class);
    public void createVisit(Specialist specialist, Patient patient, String date){
        logger.info(patient.getFirstName() + " " + patient.getLastName() + " visited specialist " + specialist.getFirstName()+ " " + specialist.getLastName() + " at: " + date);
    }
}
