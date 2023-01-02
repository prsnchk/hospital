package com.solvd.hospital.privateObject;

public class PrivateObject {

    private String privateString = null;

    public PrivateObject(String privateString) {
        this.privateString = privateString;
    }

    private String getPrivateString(){
        return this.privateString;
    }
}
