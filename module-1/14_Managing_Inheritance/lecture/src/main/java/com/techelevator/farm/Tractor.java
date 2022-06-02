package com.techelevator.farm;

public class Tractor implements Singable, Sellable {

    public String getName() {
        return "Tractor";
    }

    public String getSound() {
        return "vroom vroom!";
    }

    public int getPrice() {
        return 10000;
    }
}