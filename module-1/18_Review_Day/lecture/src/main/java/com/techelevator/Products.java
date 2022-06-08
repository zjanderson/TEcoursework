package com.techelevator;

public class Products {
    // FIELDS
    private String slotLocation;
    private String productName;
    private double price;
    private String type;

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
