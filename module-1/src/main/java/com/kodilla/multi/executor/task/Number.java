package com.kodilla.multi.executor.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Number {

    private Random random = new Random();
    private List<Integer> numbers = new ArrayList<>();
    private List<Integer> numbers1 = new ArrayList<>();
    private List<Integer> numbers2 = new ArrayList<>();

    public Number() {
        completeLists();
    }

    public void completeLists() {
        for (int i = 0; i < 100; i++) {
            numbers1.add(random.nextInt(20));
            numbers2.add(random.nextInt(20));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> getNumbers1() {
        return numbers1;
    }

    public List<Integer> getNumbers2() {
        return numbers2;
    }
}
