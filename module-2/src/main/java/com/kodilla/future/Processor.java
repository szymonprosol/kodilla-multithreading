package com.kodilla.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.kodilla.util.SleepUtil.sleep;

public class Processor {

    public Future<Integer> process(int x) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit(() -> {
            System.out.println("Processor started processing");
            sleep(5);
            System.out.println("Processor ended processing");
            return x * 1000;
        });
    }
}
