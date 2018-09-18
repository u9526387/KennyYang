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
    private String valley;
    private String nong;
    private String housenumber;
    private String floor;
    private String livingroom;
    private String room;
    private String toilet;
    private String balcony;
    private String ping;

    public house(int id, String title, String address, int price, String image, String car, String gender, String pet, String valley, String nong, String housenumber, String floor, String livingroom, String room,String toilet, String balcony, String ping) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.price = price;
        this.image = image;
        this.car = car;
        this.gender = gender;
        this.pet = pet;
        this.valley = valley;
        this.nong = nong;
        this.housenumber = housenumber;
        this.floor = floor;
        this.livingroom = livingroom;
        this.room = room;
        this.toilet = toilet;
        this.balcony = balcony;
        this.ping = ping;
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

    public String getValley() {
        return valley;
    }

    public String getNong() {
        return nong;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public String getFloor() {
        return floor;
    }

    public String getLivingroom() {
        return livingroom;
    }

    public String getRoom() {
        return room;
    }

    public String getToilet() {
        return toilet;
    }

    public String getBalcony() {
        return balcony;
    }

    public String getPing() {
        return ping;
    }
}

