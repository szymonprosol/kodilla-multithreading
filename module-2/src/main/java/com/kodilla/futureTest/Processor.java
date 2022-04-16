package com.kodilla.futureTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.kodilla.util.SleepUtil.sleep;

public class Processor {

    public Future<String> process(int sec, char[] array) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit(() -> {
            System.out.println("Start processing task");
            sleep(sec);
            return String.valueOf(array);
        });
    }
}