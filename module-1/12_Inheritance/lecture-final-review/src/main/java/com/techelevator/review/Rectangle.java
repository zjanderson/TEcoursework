package com.techelevator.review;

public class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        super();
        this.length = length;
        this.width = width;
    }

    public int getPerimeter() {
        return length + length + width + width;
    }
}
