package com.kodilla.producerconsumer.homework;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Database {

    private final Queue<Customer> customers = new LinkedList<>();

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock writeLock = lock.writeLock();
    private final Lock readLock = lock.readLock();

    public void insert() throws InterruptedException {
        writeLock.lock();
        try {
            final Random theRandom = new Random();
            int value = theRandom.nextInt();
            Customer customer = new Customer("Firstname " + value, "Lastname " + value, value);
            customers.offer(customer);
            System.out.println("[PRODUCER] Dodano do bazy danych konsumenta o imieniu: " + customer.getFirstname());
        } finally {
            writeLock.unlock();
        }
    }

    public void select() throws InterruptedException {
        readLock.lock();
        try {
            System.out.println("Konsumenci w bazie danych: ");
            customers.forEach(customer ->
            System.out.println(customer.getFirstname() + ", " + customer.getLastname() + ", " + customer.getAge()));
            System.out.println("Łącznie jest ich: " + customers.size());
        } finally {
            readLock.unlock();
        }
    }
}
