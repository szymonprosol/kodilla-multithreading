package com.kodilla.multi.exchanger.homework;

import java.util.concurrent.Exchanger;

public class ExchangerApp {

    public static void main(String[] args) {
        Exchanger<Book> exchanger = new Exchanger<>();

        new ExchangerConsumer(exchanger);
        new ExchangerProducer(exchanger);
    }
}