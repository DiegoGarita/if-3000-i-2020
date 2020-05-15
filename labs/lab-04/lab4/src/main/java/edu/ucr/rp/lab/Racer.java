
package edu.ucr.rp.lab;
import static java.lang.String.format;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Racer implements Runnable{
    private String name;
    public Racer(String name){
        this.name = name;
    }


    @Override
    public void run(){
        
        System.out.println(format("%s starts to run", name));
        
        try {
            Thread.sleep(new Random().nextInt(5000)); //para por 5 segundos
        } catch (InterruptedException ex) {
            Logger.getLogger(Racer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(format("%s ends to run", name));
    
    }
    
}
