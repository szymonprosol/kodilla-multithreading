package com.kodilla.completable.homework;

import java.util.concurrent.CompletableFuture;

import static com.kodilla.util.SleepUtil.sleep;

public class BookCreator {

    public CompletableFuture<Book> create() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Waiting for book...");
            sleep(5);
            return new Book("Test", "Test", 2020);
        });
    }
}
