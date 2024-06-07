package com.example.lab5_letanhung_2001210520;

public class Country_Bai4 {
    private int imageResourceId;
    private String name;
    private String countryCode;
    private int population;

    public Country_Bai4(int imageResourceId, String name, String countryCode, int population) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.countryCode = countryCode;
        this.population = population;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return this.name + " (Population: " + this.population + ")";
    }
}
