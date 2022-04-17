package com.kodilla.multi.barrier.homework;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class PartialStep implements Runnable {

    private final int number;
    private final CyclicBarrier barrier;
    private final Random random = new Random();
    private int sumaA;
    private int sumaB;

    public PartialStep(CyclicBarrier barrier, int number) {
        this.number = number;
        this.barrier = barrier;
        this.sumaA = 1000;
        this.sumaB = 0;
        new Thread(this).start();
    }

    @Override
    public void run() {
        int loopNumber = 0;

        while(sumaA > sumaB) {
            loopNumber++;
            sumaA += random.nextInt(10);
            sumaB += random.nextInt(50);
            System.out.println("Wątek numer: " + number + ", pętla numer: " + loopNumber + ", sumaA: " + sumaA + ", sumaB: " + sumaB);
        }

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}