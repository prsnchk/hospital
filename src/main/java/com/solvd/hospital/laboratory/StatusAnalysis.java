package com.solvd.hospital.laboratory;

public enum StatusAnalysis {
    NEW("New."),
    IN_PROGRESS("In progress."),
    DONE("Done.");

    private final String status;

    // private enum constructor
    private StatusAnalysis(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
