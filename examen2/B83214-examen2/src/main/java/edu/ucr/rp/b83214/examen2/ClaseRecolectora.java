package edu.ucr.rp.b83214.examen2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Diego Garita Abarca - B83214
 */
public class ClaseRecolectora implements Runnable {//Kyle

    private BlockingQueue<String> paquetes;
    private int contador;
    private Random random = new Random();
    private String nombre;

    /**
     *
     * @param nombre recibe el nombre del recolector
     * @param paquete paquetes(BlockingQueue), utiliza el método .add
     */
    public ClaseRecolectora(String nombre, BlockingQueue<String> paquete) {
        this.paquetes = paquete;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            contador = 1 + random.nextInt(5);
            String paquete = contador + "";

            System.out.printf("%s recolecta paquete con %s regalo(s)\n", nombre, paquete);
            paquetes.add(paquete);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
