package com.techelevator.farm;

public class Pig extends FarmAnimal implements Sellable {
    private final int price;

    public Pig() {
        super("Pig", "oink!");
        price = 1000;
    }

    public int getPrice() {
        return price;
    }
}