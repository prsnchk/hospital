package com.solvd.hospital.payment;

public enum PayStatus {
    SELF_PAYMENT("Patient paying himself"),
    INSURANCE("Paying insurance company"),
    GOV("Paying by governmental insurance");

    private final String status;

    // private enum constructor
    private PayStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
