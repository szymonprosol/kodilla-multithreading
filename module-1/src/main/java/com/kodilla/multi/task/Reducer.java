package com.kodilla.multi.task;

public class Reducer {
    private int number;
    private int counter;

    public Reducer(int number) {
        this.number = number;
    }

    public synchronized void multiply(int value) {
         counter += number * value;
    }

    public int getCounter() {
        return counter;
    }
}