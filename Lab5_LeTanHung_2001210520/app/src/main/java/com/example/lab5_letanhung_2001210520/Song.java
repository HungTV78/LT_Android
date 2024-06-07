package com.example.lab5_letanhung_2001210520;

public class Song {
    private String name;
    private int year;
    private int rank;
    private int imageResource;

    public Song(String name, int year, int rank, int imageResource) {
        this.name = name;
        this.year = year;
        this.rank = rank;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getRank() {
        return rank;
    }

    public int getImageResource() {
        return imageResource;
    }
}

