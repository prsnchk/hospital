package com.solvd.hospital.departament;

public class Record {
    private String date;
    private String specialistFullName;
    private String note;

    public Record (String date, String specialistFullName, String note) {
        this.date = date;
        this.specialistFullName = specialistFullName;
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSpecialistFullName() {
        return specialistFullName;
    }

    public void setSpecialistFullName(String specialistFullName) {
        this.specialistFullName = specialistFullName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString(){
        return "Date: " + this.date + " Specialist name: " + this.specialistFullName+ " Record: " + this.note;
    }
}
