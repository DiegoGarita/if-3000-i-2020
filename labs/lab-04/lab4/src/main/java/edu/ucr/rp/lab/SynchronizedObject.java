
package edu.ucr.rp.lab;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedObject {

    public static void main(String[] args) throws InterruptedException {
        NumbersBucket bucket = new NumbersBucket();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new AddNumbersToBucket(bucket));
        service.execute(new AddNumbersToBucket(bucket));
        do {
            Thread.sleep(5000);
            System.out.println(bucket.size());
        }while (true);
    }
}
