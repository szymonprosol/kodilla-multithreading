package com.kodilla.multi.semaphore.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int n = 0; n < 1000; n++) {
            executor.submit(new FileManager());
        }
        executor.shutdown();
    }
}
