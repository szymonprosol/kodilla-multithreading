package com.kodilla.multi.task;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        int[] anArray = new int[1000];
        for (int n = 0; n < anArray.length; n++) {
            anArray[n] = 1;
        }

        Reducer reducer = new Reducer(5);

        Thread t1 = new Thread(new PartialCalc(reducer, anArray, 0, 500));
        Thread t2 = new Thread(new PartialCalc(reducer, anArray, 500, anArray.length));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(reducer.getCounter());
    }
}
