
package edu.ucr.rp.laboratorio6;

import java.util.concurrent.Semaphore;

public class Carniceria {
    
     private Semaphore semaphoreB;
    
    public Carniceria(int availableSlots) {
        semaphoreB = new Semaphore(availableSlots);
    }

    public void gettingInLineBucther() {
        try {
            semaphoreB.acquire();
        } catch (InterruptedException ignored) {
        }
    }

    public void leavingButcherShop() {
        semaphoreB.release();
    }
    
}
