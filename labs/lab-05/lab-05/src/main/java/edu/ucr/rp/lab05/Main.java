package edu.ucr.rp.lab05;

import edu.ucr.rp.lab05.service.RechargeService;
import edu.ucr.rp.lab05.thread.ThreadPool;

public class Main {
    public static void main(String[] args) {
        RechargeService service = new RechargeService();
        service.recharge("8812345", 1000);

        ThreadPool.getPool().submit(() -> {
            RechargeService.Status status;
            do {
                status = service.getStatus("8812345");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            } while (status == RechargeService.Status.IN_PROGRESS);
            if(status == RechargeService.Status.COMPLETED){
            System.out.println("Recarga Exitosa!!!!!");
            }
            else{
            System.out.println("Recarga Fallida!!!!!");
            }
        });
    }
}
