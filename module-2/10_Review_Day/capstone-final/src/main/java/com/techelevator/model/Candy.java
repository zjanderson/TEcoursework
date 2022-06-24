package com.techelevator.model;

public class Candy extends Snack {
    public Candy(String slotId, String name, double price) {
        super(slotId, name, price);
    }

    @Override
    String getSound() {
        return "???, Yum!";
    }
}
