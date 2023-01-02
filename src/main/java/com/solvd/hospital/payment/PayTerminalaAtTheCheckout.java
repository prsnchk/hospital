package com.solvd.hospital.payment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PayTerminalaAtTheCheckout implements Pay{

    Logger logger = LogManager.getLogger(PayTerminalaAtTheCheckout.class);

    @Override
    public void createAPaymentCheck() { logger.info("The terminal creates patient check pay");
    }

    @Override
    public void canselPayment() { logger.info("The terminal did not accept the banknote for payment");
    }

    @Override
    public void editPayment() { logger.info("The terminal edite patient check pay");

    }
    public void checkMoney() {
        logger.info("The terminal checks money for payment");
    }
}
