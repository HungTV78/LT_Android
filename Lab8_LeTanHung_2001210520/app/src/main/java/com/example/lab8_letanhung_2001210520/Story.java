package com.example.lab8_letanhung_2001210520;

public class Story {
    private int imageId;
    private String title;
    private String content;

    public Story(int imageId, String title, String content) {
        this.imageId = imageId;
        this.title = title;
        this.content = content;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
