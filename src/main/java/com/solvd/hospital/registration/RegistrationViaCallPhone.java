package com.solvd.hospital.registration;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationViaCallPhone implements MedicalRegistrarService{

    Logger logger = LogManager.getLogger(RegistrationViaCallPhone.class);

    @Override
    public void deleteRegistration() { logger.info("The call phone deletes patient registration");
    }

    @Override
    public void createRegistration() { logger.info("The call phone creates patient registration");
    }

    @Override
    public void editRegistration() { logger.info("The call phone edit patient registration");

    }

    public void confirmTheNumber() { logger.info("The call phone confirms the number");
    }

}
