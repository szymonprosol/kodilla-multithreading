package com.kodilla.threads.homework;

public class Application {

    public static void main(String[] args) {
        final Thread thread = new Thread(new ThreadCreator(1));
        thread.start();
    }
}