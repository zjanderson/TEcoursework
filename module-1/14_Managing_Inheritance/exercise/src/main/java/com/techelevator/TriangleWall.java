package com.techelevator;

public class TriangleWall extends Wall{
    // Fields, Instance Variables
    private int base;

    private int height;

    //Constructors
    public TriangleWall(String name, String color, int base, int height) {
        super(name, color);
        this.base = base;
        this.height = height;
    }


    // Getters and Setters

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }


    // Methods


    @Override
    public int getArea() {
        return (base * height) / 2;
    }
    public String toString() {
        return getName() + " (" + base + "x" + height + ") " +
                "triangle";
    }
}
