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


        System.out.print("Enter the discount amount (w/out percentage): ");
        String userInput = scanner.nextLine(); //this will ask for input from the keyboard, and the String userInput will store it
        //System.out.println(userInput); //this will print the users input to the console

        double discountAmount = Double.parseDouble(userInput) / 100; //this creates the double called discountAmount, and parses the string from the keyboard into a double

        System.out.println(discountAmount);

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");

        userInput = scanner.nextLine(); //reassigns userInput since we don't need the prev value
        // " 1.00 50.00 25.50 6.25" -> [ "1.00", "50.00" etc]
        String[] prices = userInput.split( " "); //this takes the user input, splits it into a list of prices, and stores it in a new string called prices
        for (int i = 0; i < prices.length; i++) {

            String currentPrice = prices[i];

            double originalPrice = Double.parseDouble(currentPrice);

            double discountedPrice = originalPrice * (1 - discountAmount);

            System.out.println("Original price: $" + originalPrice  + " Discountedprice: $" + discountedPrice);
        }



    }

}