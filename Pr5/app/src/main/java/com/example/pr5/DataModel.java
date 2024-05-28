package com.example.pr5;

public class DataModel
{
    private int imageResource;
    private String text;

    public DataModel(int imageResource, String text) {
        this.imageResource = imageResource;
        this.text = text;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText() {
        return text;
    }
}
