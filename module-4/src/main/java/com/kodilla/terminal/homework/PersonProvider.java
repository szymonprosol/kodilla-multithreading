package com.kodilla.terminal.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class PersonProvider {

    public CompletableFuture<List<Person>> providePersons() {
        System.out.println("Providing persons");
        return CompletableFuture.supplyAsync(() -> new ArrayList<>(List.of(
                new Person("Firstname1", "Lastname1", 21),
                new Person("Firstname2", "Lastname2", 22),
                new Person("Firstname3", "Lastname3", 23),
                new Person("Firstname4", "Lastname4", 24),
                new Person("Firstname5", "Lastname5", 25)
        )));
    }
}
