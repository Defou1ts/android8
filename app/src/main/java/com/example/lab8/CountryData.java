package com.example.lab8;

import java.util.ArrayList;
import java.util.List;

public class CountryData {
    public static List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("United States", "Washington D.C.", R.drawable.flag_usa, 331000000, "English"));
        countries.add(new Country("France", "Paris", R.drawable.flag_france, 67000000, "French"));
        countries.add(new Country("Japan", "Tokyo", R.drawable.flag_japan, 126000000, "Japanese"));
        return countries;
    }
}
