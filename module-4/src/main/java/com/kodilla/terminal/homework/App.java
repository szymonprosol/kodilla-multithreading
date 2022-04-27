package com.kodilla.terminal.homework;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class App {

    private static final PersonProvider personProvider = new PersonProvider();
    private static final PersonProvider2 personProvider2 = new PersonProvider2();

    public static void main(String[] args) {
        personProvider.providePersons().thenCompose(persons -> {
            final List<Person> updatedPersons = updatePersons(persons);
            return collectAllPersonsFutures(updatedPersons);
        }).thenAccept(App::printResult).join();
    }

    private static List<Person> updatePersons(List<Person> persons) {
        return personProvider2.providePersons().thenApply(per -> {
            for (Person person : persons) {
                if (!per.contains(person)) {
                    per.add(person);
                }
            }
            return per;
        }).join();
    }

    private static CompletableFuture<Person> service(Person person) {
        return CompletableFuture.supplyAsync(() -> person);
    }

    private static CompletableFuture<List<Person>> collectAllPersonsFutures(List<Person> updatedPersons) {
        List<CompletableFuture<Person>> c = updatedPersons.stream()
                .map(App::service)
                .collect(Collectors.toList());

        return CompletableFuture.allOf(c.toArray(new CompletableFuture[0]))
                .thenApply(v -> c.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));
    }

    private static void printResult(List<Person> updatedPersons) {
        System.out.println("");
        System.out.println("----APP KODILLA----");
        for (Person person : updatedPersons) {
            System.out.println(person);
        }
    }
}