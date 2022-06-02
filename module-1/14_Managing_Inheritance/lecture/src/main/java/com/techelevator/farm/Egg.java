package com.techelevator.farm;

public class Egg implements Sellable {
    private final String name;
    private final int price;

    public Egg() {
        name = "Egg";
        price = 1;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}