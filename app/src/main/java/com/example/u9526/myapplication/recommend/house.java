package com.example.u9526.myapplication.recommend;

public class house {
    private int id;
    private String title;
    private String address;
    private int price;
    private String image;

    public house(int id, String title, String address, int price, String image) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}

