package com.solvd.hospital.disease;

public abstract class Disease {

    private MethodOfTreatment methodOfTreatment;

    public void setMethodOfTreatment(MethodOfTreatment methodOfTreatment) {
        this.methodOfTreatment = methodOfTreatment;
    }

    public MethodOfTreatment getMethodOfTreatment() {
        return methodOfTreatment;
    }

    public void cure(){
        System.out.println("Patient cured");
    }
}
