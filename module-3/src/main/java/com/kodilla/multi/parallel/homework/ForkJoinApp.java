package com.kodilla.multi.parallel.homework;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinApp {

    public static void main(String[] args) {
        List<Country> countries = Countries.randomCountries(100);

        ForkJoinPool thePool = new ForkJoinPool();

        Long result = thePool.invoke(new CountryProcessTask(countries));

        System.out.println("The population of the planet is " + result);
    }
}
