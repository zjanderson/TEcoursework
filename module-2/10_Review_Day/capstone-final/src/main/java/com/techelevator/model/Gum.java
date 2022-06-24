package com.techelevator.model;

public class Gum extends Snack {

    public Gum(String slotId, String name, double price) {
        super(slotId, name, price);
    }

    @Override
    String getSound() {
        return "Chew Chew, Yum!";
    }
}
