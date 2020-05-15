package edu.ucr.rp.lab;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Race {

    private Racer racer1;
    private Racer racer2;
    private Racer racer3;

    public static void main(String[] args) {
        Race race = new Race();
        race.prepareRacer();
        race.startRace();

    }

    public void prepareRacer() {
        racer1 = new Racer("La Pulga");
        racer2 = new Racer("El Fenómeno");
        racer3 = new Racer("El Bicho");

    }

    public void startRace() {
        Thread oldRacer = new Thread(new Racer("O Rei"));
        oldRacer.start();

        ExecutorService threadExecutor = Executors.newCachedThreadPool(); //newFixedThreadPool (funciona para limitar la cantidad de hilos)
        threadExecutor.execute(racer1);
        threadExecutor.execute(racer2);
        threadExecutor.execute(racer3);
        threadExecutor.shutdown();
    }

}
