package com.techelevator;

public class RectangleWall extends Wall{
    // Fields, Instance Variables
    private int length; //getter
    private int height; //getter

    //Constructors
    public RectangleWall(String name, String color, int length, int height) {
        name = getName();
        color = getColor();
        this.length = length;
        this.height = height;
    }
    public RectangleWall() {
        super(getName(), getColor());
        this.length = length;
        this.height = height;

    }


    // Getters and Setters

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }


    // Methods
    public int getArea() {
        return (length * height);
    }

    @Override
    public String toString() {
        return getName() + (length * height) +
                " retangle";
    }

}
