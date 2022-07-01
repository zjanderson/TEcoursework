package com.techelevator.hotels.model;

public class Review {

    private int id;
    private int hotelId;
    private String title;
    private String author;
    private String description;
    private int stars;

    //Getters and Setters//

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getTitle() {
        return title;
    }
}