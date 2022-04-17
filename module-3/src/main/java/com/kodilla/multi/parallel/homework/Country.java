package com.kodilla.multi.parallel.homework;

public class Country {
    private final String name;
    private final long peopleQuantity;

    public Country(String name, int peopleQuantity) {
        this.name = name;
        this.peopleQuantity = peopleQuantity;
    }

    public String getName() {
        return name;
    }

    public long getPeopleQuantity() {
        return peopleQuantity;
    }
}
