package com.kodilla.multi.executor.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        Number number = new Number();
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);

        for (int n = 0; n < 100; n++) {
            executor.submit(new Calc(number, number.getNumbers1().get(n), number.getNumbers2().get(n)));
        }
        executor.shutdown();
    }
}
