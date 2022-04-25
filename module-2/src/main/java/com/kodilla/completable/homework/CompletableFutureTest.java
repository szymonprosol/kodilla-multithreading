package com.kodilla.completable.homework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.kodilla.util.SleepUtil.sleep;

public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final BookCreator bookCreator = new BookCreator();
        /*final CompletableFuture<Void> futureBook = bookCreator.create()
                .thenCompose(book -> {

                })


        sleep(1);
        System.out.println("Doing something else");
        futureBook.get();*/
    }
}
