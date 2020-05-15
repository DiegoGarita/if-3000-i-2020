
package edu.ucr.rp.lab;

import java.util.Random;

public class AddNumbersToBucket implements Runnable {
    private NumbersBucket bucket;

    public AddNumbersToBucket(NumbersBucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void run() {
        for (int count = 1000; count > 0; count--)
            bucket.add(new Random().nextInt(10));
    }
}