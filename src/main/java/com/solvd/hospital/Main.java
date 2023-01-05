package com.solvd.hospital;


import com.solvd.hospital.departament.Hospital;

public class Main {
    public static void main(String[] args) throws Exception {
        Hospital hospital = new Hospital();
        hospital.start();
        hospital.menuAuthStart();
    }
}

