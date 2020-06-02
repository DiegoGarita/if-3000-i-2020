//Diego Garita Abarca - B83214

package edu.ucr.rp.laboratorio6;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    
    static int num;
    static Random random = new Random();

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        Supermercado supermercado = new Supermercado(3);
    while(true){
        num++;
        service.submit(new Cliente(num, supermercado));
        try{
        Thread.sleep(random.nextInt(2000));
        }catch(InterruptedException e){
        e.printStackTrace();
        }
        
    }
    }
}
