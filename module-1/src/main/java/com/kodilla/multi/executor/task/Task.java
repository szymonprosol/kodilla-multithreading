package com.kodilla.multi.executor.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task implements Runnable {

    private static List<Integer> numbers1 = new ArrayList<>();
    private static List<Integer> numbers2 = new ArrayList<>();
    private static List<Long> numbers = new ArrayList<>();
    private Random random = new Random();

    @Override
    public void run() {
        taskBody();
    }

    private void taskBody() {
        numbers1 = numbers();
        numbers2 = numbers();

        for (int i = 0; i < numbers.size(); i++) {
            numbers.add((long)numbers1.get(i) * (long)numbers2.get(i));
            System.out.print("(long)numbers1.get(i) * (long)numbers2.get(i)");
        }

    }

    private List<Integer> numbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextInt(20));
        }
        return numbers;
    }
}
