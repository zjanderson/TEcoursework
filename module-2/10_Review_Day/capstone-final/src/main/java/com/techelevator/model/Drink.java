package com.techelevator.model;

public class Drink extends Snack {
    public Drink(String slotId, String name, double price) {
        super(slotId, name, price);
    }

    @Override
    String getSound() {
        return "Glug Glug, Yum!";
    }
}
