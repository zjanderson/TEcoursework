package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        double discountAmount;
        do {
            System.out.print("Enter the discount amount (w/out percentage): ");
            String userInput = scanner.nextLine();
            discountAmount = Double.parseDouble(userInput) / 100;
        } while(discountAmount < 0);

        System.out.println(discountAmount);


        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");

        String userInput = scanner.nextLine();
        // "1.00 50.00 25.50 6.25" ->  [ "1.00", "50.00", "25.50", "6.25" ] -> 1.0, 50.0, 25.5, 6.25
        String[] prices = userInput.split(" ");

        for (int i = 0; i < prices.length; i++) {

            String currentPrice = prices[i];

            double originalPrice = Double.parseDouble(currentPrice);

            double discountedPrice = originalPrice * (1 - discountAmount);

            System.out.println("Original price: $" + originalPrice + " Discounted price: $" + discountedPrice);
        }

        for (String currentPrice : prices) {
            double originalPrice = Double.parseDouble(currentPrice);

            double discountedPrice = originalPrice * (1 - discountAmount);

            System.out.println("Original price: $" + originalPrice + " Discounted price: $" + discountedPrice);
        }


        String x = "1.0 50.1";

        if (x.equalsIgnoreCase(userInput)) {
            System.out.println("X is == userInput");
        } else {
            System.out.println("X is != userInput");
        }

        /*

            Stack                     Heap

            x = 1
            y = 2

            name = 0x1111 -------->    "Walt"
            anotherName = 0x2222 ----> "Walt"


         */

    }
}