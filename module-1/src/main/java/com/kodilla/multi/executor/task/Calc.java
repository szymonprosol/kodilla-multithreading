package com.kodilla.multi.executor.task;

public class Calc implements Runnable {

    private final Number number;
    private final int number1;
    private final int number2;

    public Calc(Number number, int number1, int number2) {
        this.number = number;
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public synchronized void run() {
        multiply();
    }

    private void multiply() {

        int value = number1 * number2;
        number.getNumbers().add(value);

        synchronized (Calc.class) {
            System.out.println(Thread.currentThread().getName() + " Result of the multiplication is " + value);
        }
    }
}
