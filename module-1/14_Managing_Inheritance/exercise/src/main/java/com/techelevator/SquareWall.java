package com.techelevator;

public class SquareWall extends RectangleWall{
    // Fields, Instance Variables
    private int sideLength; //need getter


    //Constructors
    public SquareWall(String name, String color, int sideLength) {
        super (name, color, sideLength, sideLength);
        this.sideLength = sideLength;
    }


    // Getters and Setters

    public int getSideLength() {
        return sideLength;
    }


    // Methods
    @Override
    public String toString() {
        return getName() + " (" + sideLength + "x" + sideLength + ") " +
                "square";
    }
    public int getArea() {
        return super.getArea();
    }
}
