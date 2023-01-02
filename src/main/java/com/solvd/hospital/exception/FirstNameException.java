package com.solvd.hospital.exception;

public class FirstNameException extends Exception {
    public FirstNameException() {
        super("Incorrect FirstName");
    }

    public FirstNameException(String message) {
        super(message);
    }

    public FirstNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public FirstNameException(Throwable cause) {
        super(cause);
    }

    public FirstNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

