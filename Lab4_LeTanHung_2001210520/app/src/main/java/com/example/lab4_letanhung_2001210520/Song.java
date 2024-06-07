package com.example.lab4_letanhung_2001210520;

public class Song {
    private String name;
    private String artistName;
    private int resourceId;
    private String duration;
    private int imageResourceId;

    public Song(String name, String artistName, int resourceId, String duration, int imageResourceId) {
        this.name = name;
        this.artistName = artistName;
        this.resourceId = resourceId;
        this.duration = duration;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getDuration() {
        return duration;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
