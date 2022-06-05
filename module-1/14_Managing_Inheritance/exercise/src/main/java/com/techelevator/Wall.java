package com.techelevator;

public abstract class Wall {
    // Fields, Instance Variables
    private String name; //getter
    private String color; //getter


    //Constructors
    public Wall(String name, String color) {
        this.name = name;
        this.color = color;
    }


    // Getters and Setters

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }


    // Methods
    public abstract int getArea();

}
