package com.kodilla.futureTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.kodilla.util.SleepUtil.sleep;
import static com.kodilla.futureTest.Test.test;

public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final char[] arr1 ={'s','z','y','m','o','n'};
        final char[] arr2 ={'r','o','s','o','l'};
        final Processor processor = new Processor();
        final Future<String> futureResult1 = processor.process(5, arr1);
        final Future<String> futureResult2 = processor.process(10, arr2);

        while (!futureResult1.isDone() || !futureResult2.isDone()) {
            test(futureResult1.isDone(), futureResult2.isDone());
            sleep(1);
        }

        final String result1 = futureResult1.get();
        final String result2 = futureResult2.get();
        System.out.println("Result 1: " + result1 + " ,result 2: " + result2);
    }
}

