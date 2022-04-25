package com.kodilla.threads.homework;

public class Application {

    public static void main(String[] args) {
        final Runnable thread = new Thread(new ThreadCreator(1));
        thread.run();
    }
}