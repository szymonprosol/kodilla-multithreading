package com.kodilla.counter;

public class CounterApp {

    private static volatile int counter = 0;

    public static void main(String[] args) {
        final Thread listener = createListener();
        final Thread changer = createChanger();

        listener.start();
        changer.start();
    }

    private static Thread createChanger() {
        return new Thread(() -> {
            int local_value = counter;
            while (counter < 5) {
                System.out.println("Incrementing counter to " + (counter + 1));
                counter = ++local_value;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static Thread createListener() {
        return new Thread(() -> {
            int local_value = counter;
            while (local_value < 5) {
                if (local_value != counter) {
                    System.out.println("Received counter change: " + counter);
                    local_value = counter;
                }
            }
        });
    }
}