package com.solvd.hospital.payment;

import com.solvd.hospital.registration.AppRegistration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PayCashAtTheCheckout implements Pay {

    Logger logger = LogManager.getLogger(PayCashAtTheCheckout.class);


    @Override
    public void createAPaymentCheck() {
        logger.info("The person creates patient check pay");
        Calculable operation1 = (int x, int y)-> x + y;
    }

    @Override
    public void canselPayment() {
        logger.info("The person did not accept the banknote for payment");
        Calculable operation1 = (int x, int y)-> x - y;
    }

    @Override
    public void editPayment() {
        logger.info("The person edite patient check pay");
        Calculable operation3 = (int x, int y)-> x * y;
    }
    public void checkMoney() {
        logger.info("The person checks money for payment");
    }
}
