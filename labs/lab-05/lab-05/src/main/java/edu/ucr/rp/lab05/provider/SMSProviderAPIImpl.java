package edu.ucr.rp.lab05.provider;

import java.util.Random;

public class SMSProviderAPIImpl {

    /**
     *
     * @param service número telefonico
     * @param amount monto de recarga
     * @return true si es exitosa
     */
        public boolean Recharge(String service, Integer amount) {//Recarga, dice si la recarga es exitosa o no
        boolean attempt = new Random().nextBoolean();
        if (attempt) {
            System.out.printf("Recarga exitosa al servicio %s de %d colones\n", service, amount);
        } else {
            System.out.println("Recarga fallida");

        }
        return attempt;
    }
}
