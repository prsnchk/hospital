package com.solvd.hospital.exception;

public class SalaryException extends Exception {
    public SalaryException() {
        super("Incorrect Salary");
    }

    public SalaryException(String message) {
        super(message);
    }

    public SalaryException(String message, Throwable cause) {
        super(message, cause);
    }

    public SalaryException(Throwable cause) {
        super(cause);
    }

    public SalaryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
