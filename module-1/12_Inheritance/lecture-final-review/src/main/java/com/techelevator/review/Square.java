package com.techelevator.review;

public class Square extends Rectangle {
    private int length;

    public Square(int length) {
        super(-1, -1);
        this.length = length;
    }

    public int getPerimeter() {
        return length * 4;
    }
}
