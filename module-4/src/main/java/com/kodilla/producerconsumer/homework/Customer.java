package com.kodilla.producerconsumer.homework;

public class Customer {

    private final String firstname;
    private final String lastname;
    private final int age;

    public Customer(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
}
