package com.kodilla.completable;

import java.util.concurrent.CompletableFuture;

import static com.kodilla.util.SleepUtil.sleep;

public class MessageReceiver {

    public CompletableFuture<String> receive() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Waiting for message...");
            sleep(5);
            return "Hello";
        });
    }
}
