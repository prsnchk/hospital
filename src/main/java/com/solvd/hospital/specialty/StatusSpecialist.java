package com.solvd.hospital.specialty;

public enum StatusSpecialist {
    VACATION("Specialist on vacation."),
    WEEKENDS("Specialist on weekends."),
    WORK("Specialist at work.");

    private final String status;

    // private enum constructor
    private StatusSpecialist(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
