package com.solvd.hospital.registration;

import com.solvd.hospital.departament.Hospital;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppRegistration implements MedicalRegistrarService{

    Logger logger = LogManager.getLogger(AppRegistration.class);

    @Override
    public void deleteRegistration() { logger.info("The application deletes patient registration");

    }

    @Override
    public void createRegistration() { logger.info("The applications creates patient registration");

    }

    @Override
    public void editRegistration() { logger.info("The applications edit patient registration");

    }

    public void sendMessage() {
        logger.info("The application sends a message to the patient about the registration");
    }

    public void sendPushNotifications(){
        logger.info("The application sends a push notification to the user about the registration");
    }

}
