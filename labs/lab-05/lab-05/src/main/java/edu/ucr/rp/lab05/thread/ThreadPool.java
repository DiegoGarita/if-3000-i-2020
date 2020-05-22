
package edu.ucr.rp.lab05.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    
    private static ExecutorService service;
    
    public static ExecutorService getPool(){
    if(service ==null){
    service = Executors.newCachedThreadPool();//dinamico, crea y reutiliza los que ya desocupó
    }
    return service;
    }
    
    
}
