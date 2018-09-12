package com.example.u9526.myapplication.recommend;

public class house {
    private int id;
    private String title;
    private String shortdesc;
    private double rating;
    private double price;
    private String image;

    public house(int id, String title, String shortdesc, double price, String image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}

