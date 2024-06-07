package com.example.lab10_letanhung_2001210520;

public class Playlist {
    private String title;
    private String artist;
    private String album;
    private String picture;

    public Playlist() {
    }

    public Playlist(String title, String artist, String album, String picture) {
        this.title = title;
        this.artist = artist;
        this.album = album;
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
