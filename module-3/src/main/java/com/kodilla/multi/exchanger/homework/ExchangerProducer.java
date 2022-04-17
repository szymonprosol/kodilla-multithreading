package com.kodilla.multi.exchanger.homework;

import java.util.concurrent.Exchanger;

public class ExchangerProducer implements Runnable {

    private Exchanger<Book> exchanger;

    ExchangerProducer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int n = 0; n < 10; n++) {
            try {
                exchanger.exchange(new Book("Title number " + n, "Author number " + n));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}