package com.solvd.hospital.registration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsuranceRegistration implements MedicalRegistrarService{

    Logger logger = LogManager.getLogger(InsuranceRegistration.class);

    @Override
    public void deleteRegistration() {
        logger.info("The insurance deletes patient registration");
    }

    @Override
    public void createRegistration() {
        logger.info("The insurance creates patient registration");
    }

    @Override
    public void editRegistration() {
        logger.info("The insurance edit patient registration");
    }

    public void checkDocuments() {
        logger.info("The insurance checks documents for registration");
    }

    public void provideHealthInsurance () {
        logger.info(" The insurance provides health insurance for registration");
    }
}
