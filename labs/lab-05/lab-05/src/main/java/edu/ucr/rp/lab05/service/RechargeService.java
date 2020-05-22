package edu.ucr.rp.lab05.service;

import edu.ucr.rp.lab05.provider.SMSProviderAPIImpl;
import edu.ucr.rp.lab05.thread.ThreadPool;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RechargeService {

    private SMSProviderAPIImpl provider = new SMSProviderAPIImpl();

    public enum Status{IN_PROGRESS, COMPLETED, ERROR}
    private Map<String, Status> recharges = new HashMap<>();
   
    
    
    
    /**
     *
     * La responsabilidad de este metodo es hacer la recarga sí o sí
     *
     * @param service el numero telefonico
     * @param amount monto de la recarga
     * @return servicio al cual se le recargó
     */
    public String recharge(String service, Integer amount) {
        recharges.put(service, Status.IN_PROGRESS);
        ExecutorService exService = ThreadPool.getPool();
        exService.submit(() -> runRecharge(service, amount));
        return service;
    }
    
    public Status getStatus(String service){
    return recharges.get(service);
    
    }

    public void runRecharge(String service, Integer amount) {
        boolean success = false;
        int retries = 0;
        do {
            success = provider.Recharge(service, amount);
            retries++;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!success && retries < 10);
        recharges.put(service, success ? Status.COMPLETED: Status.ERROR);
    }

}
