package com.example.lab8;

public class Country {
    private final String name;
    private final String capital;
    private final int flagResource;
    private final int population;
    private final String language;

    public Country(String name, String capital, int flagResource, int population, String language) {
        this.name = name;
        this.capital = capital;
        this.flagResource = flagResource;
        this.population = population;
        this.language = language;
    }

    public String getName() { return name; }
    public String getCapital() { return capital; }
    public int getFlagResource() { return flagResource; }
    public int getPopulation() { return population; }
    public String getLanguage() { return language; }
}
