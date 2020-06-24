package edu.ucr.rp.b83214.examen2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Diego Garita Abarca - B83214
 */
public class ActividadDeCaridad1 {

/*
Método main (parte 1)
*/
    public static void main(String[] args) {
        BlockingQueue<String> paquetes = new LinkedBlockingQueue<>();
        ExecutorService service = Executors.newCachedThreadPool();

        service.submit(new ClaseRecolectora("Kyle", paquetes)); //Agrega recolector
        service.submit(new ClaseReceptora("Beto", paquetes)); //Agrega receptor

        service.shutdown();

    }

}
