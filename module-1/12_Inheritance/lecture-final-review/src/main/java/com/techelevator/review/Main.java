package com.techelevator.review;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(50, 100);


        Rectangle rectangle = new Rectangle(10, 20);
        int rectanglePerimeter = rectangle.getPerimeter();

        Square square = new Square(30);
        int squarePerimeter = square.getPerimeter();

        System.out.println("Rectangle perimeter: " + rectanglePerimeter);
        System.out.println("Square perimeter: " + squarePerimeter);
    }
}
