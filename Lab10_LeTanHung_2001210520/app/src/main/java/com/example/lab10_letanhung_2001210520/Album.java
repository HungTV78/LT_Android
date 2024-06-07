package com.example.lab10_letanhung_2001210520;

public class Album {
    private String title;
    private String artist;
    private int numberOfTracks;
    private String picture;

    public Album() {

    }

    public Album(String title, String artist, int numberOfTracks, String picture) {
        this.title = title;
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(int numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
