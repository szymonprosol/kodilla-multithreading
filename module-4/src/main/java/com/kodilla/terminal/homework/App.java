package com.kodilla.terminal.homework;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class App {

    private static final PersonProvider personProvider = new PersonProvider();
    private static final PersonProvider2 personProvider2 = new PersonProvider2();

    public static void main(String[] args) {
        personProvider.providePersons().thenCompose(persons -> {
            final List<CompletableFuture<Person>> updatedPersons = updatePersons(persons);
            return collectAllPersonsFutures(updatedPersons);
        }).thenAccept(App::printResult).join();
    }


    private static List<CompletableFuture<Person>> updatePersons(List<Person> persons) {
        List<CompletableFuture<Person>> x =  personProvider2.providePersons().thenApply(persons1 -> persons1)
    }

    private static CompletableFuture<List<Person>> collectAllPersonsFutures(List<CompletableFuture<Person>> updatedPersons) {
        return CompletableFuture.allOf(updatedPersons.toArray(new CompletableFuture[0]))
                .thenApply(v -> updatedPersons.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));
    }

    private static void printResult(List<Person> updatedPersons) {
        System.out.println("");
        System.out.println("----APP KODILLA----");
        System.out.println(updatedPersons);
    }
}