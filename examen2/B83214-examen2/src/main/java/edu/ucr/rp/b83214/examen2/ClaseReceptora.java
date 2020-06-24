package edu.ucr.rp.b83214.examen2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Diego Garita Abarca - B83214
 */
public class ClaseReceptora implements Runnable {//Beto

    private BlockingQueue<String> paquetes;
    private Random random = new Random();
    private String nombre;

    /**
     *
     * @param nombre nombre del receptor de los paquetes
     * @param paquetes paquetes(BlockingQueue), utiliza el método .take()
     */
    public ClaseReceptora(String nombre, BlockingQueue<String> paquetes) {
        this.nombre = nombre;
        this.paquetes = paquetes;
    }

    @Override
    public void run() {
        while (true) {
            try {

                String paquete = paquetes.take();

                System.out.printf("%s: recibe paquete con %s regalos. Paquetes pendientes de procesar(%d)\n", nombre, paquete, paquetes.size());
                Thread.sleep(random.nextInt(5000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
