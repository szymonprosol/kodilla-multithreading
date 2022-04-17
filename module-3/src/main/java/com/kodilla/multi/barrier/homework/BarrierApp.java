package com.kodilla.multi.barrier.homework;

import java.util.concurrent.CyclicBarrier;

public class BarrierApp {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5, new FinalStep());

        for (int n = 1; n < 6; n++)
            launchTheThread(barrier, n);
    }

    private static void launchTheThread(CyclicBarrier barrier, int number) {
        new PartialStep(barrier, number);
    }
}