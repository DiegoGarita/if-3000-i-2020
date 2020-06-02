
package edu.ucr.rp.laboratorio6;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pasillo {
    private Lock lock = new ReentrantLock();
    private Random random = new Random();
    private final Semaphore semaphoreH;
    
    public Pasillo(int availableSlots) {
        semaphoreH = new Semaphore(availableSlots);
    }

    public void gettingInLineHalls() {
        try {
            semaphoreH.acquire();
        } catch (InterruptedException ignored) {
            System.out.println("ERRORES ");
        }
    }

    public void leavingHall() {
        semaphoreH.release();
    }
 //------------------------------------------------------
    public void enterInHall(Cliente client) {
        try {
            lock.lock();
            System.out.printf("Puede entrar al pasillo, cliente %s\n", client.getNombre());
            gettingInLineHalls();
            Thread.sleep(random.nextInt(2000));
        }catch (InterruptedException ignored){

        }finally {
            System.out.println("Ya tiene todos los productos del pasillo, cliente "+ client.getNombre());
            leavingHall();
            lock.unlock();
        }
    }
    
    
}
   
