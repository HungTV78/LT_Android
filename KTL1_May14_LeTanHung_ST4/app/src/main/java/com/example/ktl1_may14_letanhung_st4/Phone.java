package com.example.ktl1_may14_letanhung_st4;

import java.io.Serializable;

public class Phone implements Serializable {
    private String name;
    private String manufacturer;
    private int year;
    private String price;
    private int imageResourceId;

    // Constructor
    public Phone(String name, String manufacturer, int year, String price,int imageResourceId) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.year = year;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    // Getter and setter methods for each field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
    public int setImageResourceId(int imageResourceId) {
        return imageResourceId;
    }
}
