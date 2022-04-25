package com.kodilla.terminal.homework;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PersonProvider2 {

    public CompletableFuture<List<Person>> providePersons() {
        System.out.println("Providing persons");
        return CompletableFuture.supplyAsync(() -> List.of(
                new Person("Firstname6", "Lastname6", 26),
                new Person("Firstname2", "Lastname2", 22),
                new Person("Firstname3", "Lastname3", 23),
                new Person("Firstname7", "Lastname7", 27),
                new Person("Firstname5", "Lastname5", 25)
        ));
    }
}