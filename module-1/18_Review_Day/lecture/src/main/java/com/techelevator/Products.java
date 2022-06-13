package com.techelevator;

import java.security.PrivateKey;

public class Products {
    // FIELDS
    private String slotLocation;
    private String productName;
    private double price;
    private String type;
    private String chipMsg = "Crunch Crunch, Yum!";
    private String candyMsg = "Munch Munch, Yum!";
    private String drinkMsg = "Glug Glug, Yum!";
    private String gumMsg = "Chew Chew, Yum!";

    // CONSTRUCTOR(S)
    public Products (String slotLocation, String productName, double price, String type) {
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.price = price;
        this.type = type;
    }


    // GETTERS & SETTERS

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }


    // METHODS


}
