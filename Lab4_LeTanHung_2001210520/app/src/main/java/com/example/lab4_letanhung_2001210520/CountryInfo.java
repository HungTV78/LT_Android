package com.example.lab4_letanhung_2001210520;

public class CountryInfo {
    private String name;
    private String population;
    private String continent;
    private int imageResourceId;

    public CountryInfo(String name, String population, String continent, int imageResourceId) {
        this.name = name;
        this.population = population;
        this.continent = continent;
        this.imageResourceId = imageResourceId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
