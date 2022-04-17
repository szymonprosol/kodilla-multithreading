package com.kodilla.multi.parallel.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Countries {

    public static List<Country> randomCountries(int number) {
        Random random = new Random();
        List<Country> countries = new ArrayList<>();
        for (int n = 0; n < number; n++) {
            countries.add(new Country("Country number " + n, random.nextInt(10000000)));
        }
        return countries;
    }

}
