package com.kodilla.threads.homework;

public class Application {

    public static void main(String[] args) {
        Runnable runnable = () ->
        {
            try
            {
                Thread thread = new Thread(new ThreadCreator(1));
                thread.start();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();
    }
}