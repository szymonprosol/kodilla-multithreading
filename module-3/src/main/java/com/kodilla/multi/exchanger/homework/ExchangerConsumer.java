package com.kodilla.multi.exchanger.homework;

import java.util.concurrent.Exchanger;

public class ExchangerConsumer implements Runnable {

    private Exchanger<Book> exchanger;

    ExchangerConsumer(Exchanger<Book> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int n = 0; n < 10; n++) {
            try {
                Book book = exchanger.exchange(new Book());
                System.out.println(book.getTitle() + ", " + book.getAuthor());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
