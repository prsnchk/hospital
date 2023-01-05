package com.solvd.hospital.service;

import com.solvd.hospital.Main;
import com.solvd.hospital.departament.Record;
import com.solvd.hospital.exception.AgeException;
import com.solvd.hospital.exception.FirstNameException;
import com.solvd.hospital.exception.LastNameException;
import com.solvd.hospital.model.Patient;
import com.solvd.hospital.specialty.Neurologist;
import com.solvd.hospital.specialty.Specialist;
import com.solvd.hospital.specialty.Surgeon;
import com.solvd.hospital.specialty.Therapist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DataGenerateService {
    Logger logger = LogManager.getLogger(DataGenerateService.class);


    public ArrayList<Patient> dataGeneratePatients() throws LastNameException, FirstNameException, AgeException {
        ArrayList<Patient> patients = new ArrayList<>();

        Patient tokio = new Patient("Silena", "Olivera", 29, "08.12.2022", "tokio", "1111");
        Patient professor = new Patient("Serhio", "Martines", 32, "09.12.2022", "professor", "2222");
        Patient berlin = new Patient("Pablo", "Kalderon", 32, "10.12.2022", "berlin", "3333");

        patients.add(tokio);
        patients.add(professor);
        patients.add(berlin);
        logger.info(patients);

        return patients;

    }

    public HashMap<Patient, Record> dataGenerateRecords() throws LastNameException, FirstNameException, AgeException {
        HashMap<Patient, Record> recordHashMap = new HashMap<>();

        Patient tokio = new Patient("Silena","Olivera",29,"08.12.2022","tokio", "1111");
        Patient professor = new Patient("Serhio","Martines", 32, "09.12.2022", "professor", "2222");
        Patient berlin = new Patient("Pablo","Kalderon", 32,"10.12.2022", "berlin", "3333");

        Neurologist neurologist = new Neurologist("Monika","Gastambide",40, 1500, 10, "neurologist1", "4444");
        Therapist therapist = new Therapist("Arturito","Aroman", 45, 1500, 20,"therapist1", "5555");
        Surgeon surgeon = new Surgeon("Rokel", "Muril", 50, 2000, 30, "surgeon1", "6666");

        Record record1 = new Record("27.11.2022", neurologist.getFullName(), "Patient still alive...");
        Record record2 = new Record("28.11.2022", therapist.getFullName(), "Chikibomboni...");
        Record record3 = new Record("29.11.2022", surgeon.getFullName(), "Ya lomal steklo...");

        recordHashMap.put(tokio,record1);
        recordHashMap.put(professor,record2);
        recordHashMap.put(berlin,record3);
        logger.info(recordHashMap);

        return recordHashMap;

    }

    public HashSet<Specialist> dataGenerateSpecialists() throws LastNameException, FirstNameException, AgeException {
        HashSet<Specialist> specialists = new HashSet<>();

        Neurologist neurologist = new Neurologist("Monika","Gastambide",40, 1500, 10, "neurologist1", "4444");
        Therapist therapist = new Therapist("Arturito","Aroman", 45, 1500, 20,"therapist1", "5555");
        Surgeon surgeon = new Surgeon("Rokel", "Muril", 50, 2000, 30, "surgeon1", "6666");


        specialists.add(neurologist);
        specialists.add(therapist);
        specialists.add(surgeon);
        logger.info(specialists);

        return specialists;

    }


}
