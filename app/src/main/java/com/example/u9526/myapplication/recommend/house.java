package com.example.u9526.myapplication.recommend;

public class house {
    private int id;
    private String title;
    private String address;
    private int price;
    private String image;
    private String car;
    private String gender;
    private String pet;

    public house(int id, String title, String address, int price, String image, String car, String gender, String pet) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.price = price;
        this.image = image;
        this.car = car;
        this.gender = gender;
        this.pet = pet;
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

    public String getCar() {
        return car;
    }

    public String getGender() {
        return gender;
    }

    public String getPet() {
        return pet;
    }
}

