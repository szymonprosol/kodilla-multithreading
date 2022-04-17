package com.kodilla.producerconsumer.homework;

public class ProducerConsumerApp {

    public static void main(String[] args) {
        final Database database = new Database();

        final Consumer consumer = new Consumer(database);
        final Producer producer = new Producer(database);

        consumer.start();
        producer.start();
    }
}