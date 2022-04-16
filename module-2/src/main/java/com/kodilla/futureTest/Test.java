package com.kodilla.futureTest;

public class Test {

    public static void test(boolean firstTask, boolean secondTask) {

        if (firstTask || secondTask) {
            System.out.println("One of tasks completed");
        } else {
            System.out.println("None of tasks completed");
        }
    }
}
