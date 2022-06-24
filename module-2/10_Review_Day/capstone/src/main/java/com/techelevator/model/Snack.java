package com.techelevator.model;

public abstract class Snack {

    private final String slotId;
    private final String name;
    private final double price;

    public Snack(String slotId, String name, double price) {
        this.slotId = slotId;
        this.name = name;
        this.price = price;
    }

    abstract String getSound();
}
