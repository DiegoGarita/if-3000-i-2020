
package edu.ucr.rp.laboratorio7.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientMain {

    public static void main(String[] args) {

                ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            Client.sendMessage("127.0.0.1", 5454, "¿Es necesario salir?");
        });
        executorService.submit(() -> {
            Client.sendMessage("127.0.0.1", 5454,"¿Necesitamos una conexión?");
        });
        
        
        
    }
    
}
