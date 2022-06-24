package com.techelevator.model;

public class Chip extends Snack {
    public Chip(String slotId, String name, double price) {
        super(slotId, name, price);
    }

    @Override
    String getSound() {
        return "Munch Munch, Yum!";
    }
}
