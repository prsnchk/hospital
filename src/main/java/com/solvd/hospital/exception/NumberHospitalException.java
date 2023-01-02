package com.solvd.hospital.exception;


public class NumberHospitalException extends Exception{
    public NumberHospitalException() {
        super("Incorrect Hospital Number");
    }

    public NumberHospitalException(String message) {
        super(message);
    }

    public NumberHospitalException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberHospitalException(Throwable cause) {
        super(cause);
    }

    public NumberHospitalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

