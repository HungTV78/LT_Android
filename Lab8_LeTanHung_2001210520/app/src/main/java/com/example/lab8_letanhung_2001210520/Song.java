package com.example.lab8_letanhung_2001210520;

public class Song {
    private String name;
    private String singer;
    private int imageResource;
    private int year;

    public Song(String name, String singer, int imageResource, int year) {
        this.name = name;
        this.singer = singer;
        this.imageResource = imageResource;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getSinger() {
        return singer;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getYear() {
        return year;
    }
}
