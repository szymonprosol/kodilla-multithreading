package com.kodilla.multi.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int n = 0; n < 10; n++) {
            executorService.submit(new ProcessA());
            executorService.submit(new ProcessB());
        }
    }
}