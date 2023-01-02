package com.solvd.hospital.exception;

public class LastNameException extends Exception {
    public LastNameException() {
        super("Incorrect LastName");
    }

    public LastNameException(String message) {
        super(message);
    }

    public LastNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public LastNameException(Throwable cause) {
        super(cause);
    }

    public LastNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}