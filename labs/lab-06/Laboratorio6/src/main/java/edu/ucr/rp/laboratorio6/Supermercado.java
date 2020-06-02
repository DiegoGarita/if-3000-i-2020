
package edu.ucr.rp.laboratorio6;

import java.util.concurrent.Semaphore;


public class Supermercado {
    
    private Semaphore semaforo;
    
    public Supermercado(int disponibles){
    semaforo = new Semaphore(disponibles);
    }
    
    public void siguente(){
    try{
    semaforo.acquire();
    }catch(InterruptedException ignored){
    }
    }
    
    public void abandonaSupermercado(){
    semaforo.release();
    }
    
        public void filaCajas(double cajasDisponibles, int custo) {
        semaforo = new Semaphore((int) cajasDisponibles);
        System.out.println(custo + " Cancelando los productos adquiridos");
    }//end constructor

    
}
