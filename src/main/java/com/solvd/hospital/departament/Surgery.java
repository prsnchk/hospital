package com.solvd.hospital.departament;

import com.solvd.hospital.model.Patient;

public class Surgery {

    public void cutOffLeg(Patient patient) {
        System.out.println(patient.getFirstName() + " " + patient.getLastName() + "cut off a leg");
    }
}
