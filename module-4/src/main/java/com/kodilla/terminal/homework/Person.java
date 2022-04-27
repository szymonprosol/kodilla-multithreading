package com.kodilla.terminal.homework;

import java.util.Objects;

public class Person {

    private final String firstname;
    private final String lastname;
    private final int age;

    public Person(String firstname, String lastname, int age) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && firstname.equals(person.firstname) && lastname.equals(person.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, age);
    }

    @Override
    public String toString() {
        return "Person{" + "firstname: " + firstname
                + ", lastname: " + lastname
                + ", age: " + age + '}';
    }
}
