package com.kodilla.multi.latch.homework;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ExampleTask implements Runnable {

    private CountDownLatch theLatch;
    private Random random = new Random();

    public ExampleTask(CountDownLatch theLatch) {
        this.theLatch = theLatch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        int value = (random.nextInt(301) + 300) * (random.nextInt(6) + 1);
        random.ints(300,1500);
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Running the task");
        theLatch.countDown();
    }
}
